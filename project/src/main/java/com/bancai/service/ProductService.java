package com.bancai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Product;
import com.bancai.dao.ProductDAO;
import com.bancai.dao.ProductPicture;
import com.bancai.dao.ProductPictureDAO;
import com.bancai.service.module.SearchService;
import com.bancai.utils.Pager;
import com.bancai.web.pcenter.PictureOperation;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

public class ProductService {
	private static final String ENTERPRISE_ID = "enterprise";
	ProductDAO productDAO = new ProductDAO();
	Logger logger = Logger.getLogger(ProductService.class);
	
	public List<Product> listSomeProducts(int size) {
		return new ProductDAO().findAll(0, size);
	}

	public List<Product> listProducts() {
		return new ProductDAO().findAll();
	}
	public List<Product> listProducts(String category,Pager p) {
		if(p.isNeedsTotal()){
			p.setTotal(new ProductDAO().countByProperty(ProductDAO.CATEGORY, category));
		}
		return new ProductDAO().findByProperty(ProductDAO.CATEGORY, category,p.getStart(),p.getPageSize());
	}
	public Product getProduct(int productId) {
		EntityManagerHelper.getEntityManager().clear();
		return new ProductDAO().findById(productId);
	}

	public void updateProduct(Product product) {
		new ProductDAO().update(product);
	}

	public void saveProduct(Product product) {
		new ProductDAO().save(product);
	}

	public List<Product> listProducts(String[] productTypes, int size) {
		List<Product> products = new ArrayList<Product>();
		for (String type : productTypes) {
			List<Product> returnProducts = new ProductDAO().findByProperty(
					ProductDAO.CATEGORY, type, 0, size);
			products.addAll(returnProducts);
			products.addAll(createEmptyProducts(size - returnProducts.size()));
		}
		return products;
	}

	private List<Product> createEmptyProducts(int size) {
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < size; i++) {
			Product product = new Product();
			product.setIcon(BancaiConstants.PRODUCT_DEFAULT_PATH);
			products.add(product);
		}
		return products;
	}

	/**
	 * 
	 * 获取某企业的所有产品
	 * 
	 * @param enterpriseId
	 *            企业ID
	 * @return 包含所有产品的链表
	 */
	public List<Product> getAllProductsByEnterpriseId(int enterpriseId) {
		return productDAO.findByProperty(ENTERPRISE_ID, enterpriseId);
	}
	
	/**
	 * 判断是否存储了product
	 * @param enterpriseId enterprise Id
	 * @return true: 存在； false:不存在
	 */
	public boolean isExistProducts(int enterpriseId) {
		try {
			getAllProductsByEnterpriseId(enterpriseId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 根据企业id删除所有产品; 有添加产品时才删除
	 * @param enterpriseId 企业id
	 */
	public void deleteProductsByEnterpriseIdNoTranscation(int enterpriseId) {
		if (true == isExistProducts(enterpriseId)) {
			productDAO.deleteByColumnNoTranscation(ENTERPRISE_ID, enterpriseId);
		}
	}
	
	/**
	 * 先根据productId删除productPicture相关记录，再删除product相关记录
	 */
	public void deleteProduct(int id)
	{
		ProductPictureDAO productPictureDAO = new ProductPictureDAO();
		List<ProductPicture> productPictures = productPictureDAO.findByProperty(ProductPictureDAO.PRODUCT_ID, id);
		for (ProductPicture productPicture : productPictures) {
			PictureOperation.deletePicture(productPicture.getPath());
		}
		try{
			EntityManagerHelper.beginTransaction();
			productPictureDAO.deleteProductPictureByProductIdNoTransaction(id);
			new ProductDAO().deleteByPrimaryKeyNoTranscation(id);
			EntityManagerHelper.commit();
		}catch (Exception e) {
			EntityManagerHelper.log(e.getMessage(), Level.SEVERE, e);
		}
	}
	
	/**
	 * 返回满足搜索条件的产品 
	 * @param content 用户输入的内容
	 * @param category 产品类别
	 * @param specification 产品特性
	 * @param province 省
	 * @param city 市
	 * @param county 县
	 * @return
	 */
	public List<Product> getProducts4ProductSearch(String content, 
			String category, String specification, Pager p)
	{
		SearchService searchService = new SearchService();
		ProductDAO productDao = new ProductDAO();
		String hql = "";
		EntityManager em = EntityManagerHelper.getEntityManager();
				
		/*拼装hql*/
		String contentSql = searchService.getSql4Product(content);
		if ("" != contentSql)
		{
			hql = searchService.getAndHql(hql) + contentSql;
		}
		
		String categorySql = searchService.getSql4ProductCategory(category);
		if ("" != categorySql)
		{
			hql = searchService.getAndHql(hql) + categorySql;
		}
		
		String specificationSql = searchService.getSql4ProductProperty(specification);
		if ("" != specificationSql)
		{
			hql = searchService.getAndHql(hql) + specificationSql;
		}
		
		if ("" != hql)
		{
			hql = " FROM Product p WHERE " + hql;
		}
		
		/* 设置HQL参数 */
		String queryHql = "SELECT p " + hql;
		Query query = em.createQuery(queryHql);
		String countHql = "SELECT COUNT(p) " + hql;
		Query countQuery = em.createQuery(countHql);
		
		if ("" != contentSql)
		{
			query.setParameter("content", "%" + content + "%");
			countQuery.setParameter("content", "%" + content + "%");
		}
		
		if (!categorySql.equals(""))
		{
			query.setParameter("category", "%" + category + "%");
			countQuery.setParameter("category", "%" + category + "%");
		}
		
		if (!specificationSql.equals(""))
		{
			query.setParameter("specification", "%" + specification + "%");
			countQuery.setParameter("specification", "%" + specification + "%");
		}
		
		p.setTotal(productDao.countByQuery(countQuery));
		
		return productDao.listByQuery(query, p.getStart(), p.getPageSize());
	}
	
	/**
	 * 返回满足搜索条件的产品 
	 * @param content 用户输入的内容
	 * @return
	 */
	public List<Product> getProducts4Search(String content, Pager p)
	{
		SearchService searchService = new SearchService();
		ProductDAO productDao = new ProductDAO();
		EntityManager em = EntityManagerHelper.getEntityManager();
		String contentSql = searchService.getSql4Product(content);
		String hql = " FROM Product p WHERE " + contentSql;
		
		
		String sql = "SELECT p " + hql;
		Query query = em.createQuery(sql);
		query.setParameter("content", "%" + content + "%");
		
		String countHql = "SELECT COUNT (p) " + hql;
		Query countQuery = em.createQuery(countHql);
        countQuery.setParameter("content", "%" + content + "%");
		
		p.setTotal(productDao.countByQuery(countQuery));
		return productDao.listByQuery(query, p.getStart(), p.getPageSize());
	}

	
	/**
	 * 
	 * @param product
	 */
	public void updateProductNoTransaction(Product product) {
		new ProductDAO().updateNoTransaction(product);
	}
}

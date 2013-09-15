package com.bancai.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bancai.dao.DisplayProductDAO;
import com.bancai.dao.Product;
import com.bancai.dao.ProductDAO;

public class DisplayProductService {
	private static final String PRODUCT_ID = "productId";

	public List<Product> getProducts(String[] categories, int size) {
		List<Product> productList = new ArrayList<Product>();
		for(String category:categories){
			productList.addAll(getProducts(category, size));
		}
		return productList;
	}

	public List<Product> getProducts(String category, int size) {
		// 购买套餐的产品
		List<Product> displayList = new DisplayProductDAO()
				.findAllByCategory(category);
		// size个产品
		List<Product> allProducts = new ProductDAO().findByProperty(
				ProductDAO.CATEGORY,category, 0, size);
		for (Product p : allProducts) {
			// 如果要返回的产品列表个数已到size个，则返回
			if (displayList.size() == size) {
				break;
			}
			boolean exists = false;
			// 如果e的id和displayList某个元素的id相同，表明列表已存在此元素
			for (Product Product : displayList) {
				if (Product.getId().equals(p.getId())) {
					exists = true;
				}
			}
			if(!exists){
				displayList.add(p);
			}
		}
		//如果个数还没够size个则添加默认的产品
		displayList.addAll(CommonService.createEmptyProducts(size
				- displayList.size()));
		return displayList;
	}

	/**
	 * 根据企业Id删除产品展示
	 * @param corpId 企业id
	 */
	public void deleteShowProductByCorpIdNoTranscation(int corpId) {
		ProductService productService = new ProductService();
		List<Product> products= productService.getAllProductsByEnterpriseId(corpId);
		Product product;
		DisplayProductDAO showProductDao = new DisplayProductDAO();
		
		Iterator<Product> it = products.iterator();  
        while (it.hasNext())  
        {  
        	product = it.next();
        	showProductDao.deleteByColumnNoTranscation(PRODUCT_ID, product.getId());
        }  
	}

}

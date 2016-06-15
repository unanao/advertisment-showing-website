package com.bancai.service;

import java.util.List;

import com.bancai.dao.Product;
import com.bancai.dao.ProductDAO;
import com.bancai.dao.UserEnterpriseFavourite;
import com.bancai.dao.UserProductFavourite;
import com.bancai.dao.UserProductFavouriteDAO;
import com.bancai.utils.Pager;
import com.bancai.utils.sql.entitymanager.EntityManagerHelper;

public class UserProductFavouriteService {
	private static final String PRODUCT_ID = "product";
	private static final String USER_ID = "user";
	UserProductFavouriteDAO favouriteProductDao = new UserProductFavouriteDAO();
	ProductDAO productDAO = new ProductDAO();
	
	/**
	 * 用户添加收藏的产品
	 * @param userId
	 * @param productId
	 */
	public void saveFavouriteProduct(int userId,int productId){
		Product product = productDAO.findById(productId);
		if(product == null){
			return;
		}
		EntityManagerHelper.beginTransaction();
		try
		{
			UserProductFavourite proFavourite = new UserProductFavourite();
			proFavourite.setProduct(productId);
			proFavourite.setUser(userId);
			new UserProductFavouriteDAO().saveNoTransaction(proFavourite);
			int countFavourite = product.getFavourite() + 1;
			product.setFavourite(countFavourite);
			productDAO.updateNoTransaction(product);
			EntityManagerHelper.commit();
		}catch (RuntimeException re)
		{
			EntityManagerHelper.rollback();
			throw re;
		}
	}
	
	public boolean isExistFavouriteProductByUserId(int userId) {
		try {
			UserProductFavouriteDAO userProductFavouriteDAO = new UserProductFavouriteDAO();
			
			long countFavouriteProducts = userProductFavouriteDAO.countByProperty(USER_ID, userId); 
			if (countFavouriteProducts <= 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 查找用户所有收藏的产品
	 * @param userId
	 * @return
	 */
	public List<Product> getFavouriteProductsByUserId(int userId,Pager p){
		UserProductFavouriteDAO userProductFavouriteDAO = new UserProductFavouriteDAO();
		if(p.isNeedsTotal()){
			long countFavouriteProducts = userProductFavouriteDAO.countByProperty(USER_ID, userId); 
			p.setTotal(countFavouriteProducts);
		}
		List<Product> products = new UserProductFavouriteDAO().findFavouriteProducts(userId,p);
		return products;
	}
	
	/**
	 * 用户添加收藏的产品
	 * @param userId
	 * @param productId
	 */
	public void deleteFavouriteProduct(int userId,int productId){
		Product product = productDAO.findById(productId);
		if(product == null){
			return;
		}
		
		EntityManagerHelper.beginTransaction();
		try
		{
			productDAO.deleteBy2ColumnNoTransaction(USER_ID, userId, PRODUCT_ID, productId);
			int countFavourite = product.getFavourite() - 1;
			product.setFavourite(countFavourite);
			productDAO.updateNoTransaction(product);
			EntityManagerHelper.commit();
		}catch (RuntimeException re)
		{
			EntityManagerHelper.rollback();
			throw re;
		}
	}
	
	/**
	 * 用户添加收藏的产品
	 * @param userId
	 * @param productId
	 */
	public void deleteFavouriteProductByUserIdNoTranscation(int userId){
		
		if (true != isExistFavouriteProductByUserId(userId)) {
			return;
		}
		
		EntityManagerHelper.beginTransaction();
		try
		{
			productDAO.deleteByColumnNoTranscation(USER_ID, userId);
			EntityManagerHelper.commit();
		}catch (RuntimeException re)
		{
			EntityManagerHelper.rollback();
			throw re;
		}
	}
	
	/**
	 * 获取所有产品的排行榜
	 * @param p
	 */
	public List<Product> getProductRankList(Pager p){
		return productDAO.getRankList(ProductDAO.FAVOURITE, p);
	}
	
	/**
	 * 获取某类产品的排行榜
	 * @param category
	 * @param p
	 * @return
	 */
	public List<Product> getProductRankListByCategory(String category, Pager p){
		return productDAO.getRankListByCategory(category, ProductDAO.FAVOURITE, p);
	}
	
}

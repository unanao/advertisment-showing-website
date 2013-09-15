package com.bancai.service;

import java.util.List;

import com.bancai.dao.UserProductFavouriteDAO;
import com.bancai.dao.UserProductFavourite;

public class UserProductFavouriteService {
	private static final String PRODUCT_ID = "product";
	private static final String USER_ID = "user";
	UserProductFavouriteDAO favouriteProductDao = new UserProductFavouriteDAO();
	
	/**
	 * 
	 * 获取收藏了指定产品的表项
	 * 
	 * @param productId
	 *            企业id
	 * @return 收藏了指定企业UserProductFavourite的链表
	 */
	public List<UserProductFavourite> getUserProductFavouriteByProductId(
			int productId) {
		try {
			return favouriteProductDao.findByProperty(PRODUCT_ID,
					productId);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * 获取用户收藏的企业
	 * 
	 * @param userId
	 *            用户id
	 * @return 指定用户收藏所有的UserEnterpriseFavourite的表项的链表
	 */
	public List<UserProductFavourite> getUserProductFavouriteByUserId(
			int userId) {
		try {
		return favouriteProductDao.findByProperty(USER_ID,
					userId);
		} catch (Exception e) {
			return null;
		}
		
	}
	
	/** 
	 * 判断用户是否收藏了产品
	 * @param userId 用户Id
	 * @return true:收藏；false:未收藏
	 */
	public boolean isExistFavouriteProductByUserId(int userId) {
		try {
			getUserProductFavouriteByUserId(userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除用户收藏的产品
	 * @param userId 用户id
	 */
	public void deleteFavouriteProductByUserIdNoTranscation(int userId) {
		if (true == isExistFavouriteProductByUserId(userId)) {
			new UserProductFavouriteDAO().deleteByColumnNoTranscation(USER_ID, userId);
		}
	}
}

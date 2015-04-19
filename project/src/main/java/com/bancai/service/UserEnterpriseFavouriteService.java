package com.bancai.service;

import java.util.List;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.UserEnterpriseFavourite;
import com.bancai.dao.UserEnterpriseFavouriteDAO;

public class UserEnterpriseFavouriteService implements CommonConstants {
	private static final String ENTERPRISE_ID = "enterprise";
	private static final String USER_ID = "user";
	UserEnterpriseFavouriteDAO favouriteEnterpriseDao = new UserEnterpriseFavouriteDAO();
	UserEnterpriseFavourite favouriteEnterprise = new UserEnterpriseFavourite();

	/**
	 * 
	 * 获取收藏了指定企业也的表项
	 * 
	 * @param enterpriseId
	 *            企业id
	 * @return 收藏了指定企业UserEnterpriseFavourite的链表
	 */
	public List<UserEnterpriseFavourite> getUserEnterpriseFavouriteByEnterpriseId(
			int enterpriseId) {
			return favouriteEnterpriseDao.findByProperty(ENTERPRISE_ID,
					enterpriseId);
	}
	
	/**
	 * 
	 * 获取用户收藏的企业
	 * 
	 * @param userId
	 *            用户id
	 * @return 指定用户收藏所有的UserEnterpriseFavourite的表项的链表
	 */
	public List<UserEnterpriseFavourite> getUserEnterpriseFavouriteByUserId(
			int userId) {
		return favouriteEnterpriseDao.findByProperty(USER_ID,
					userId);
	}
	
	/** 
	 * 判断用户是否收藏了企业
	 * @param userId 用户Id
	 * @return true:收藏；false:未收藏
	 */
	public boolean isExistFavouriteEnterpriseByUserId(int userId) {
		try {
			List<UserEnterpriseFavourite> lover = getUserEnterpriseFavouriteByUserId(userId);
			if (null == lover.get(0)) {
				return false;
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 删除用户收藏的企业
	 * @param userId 用户id
	 */
	public void deleteFavouriteEnterpriseByUserIdNoTranscation(int userId) {
		if (true == isExistFavouriteEnterpriseByUserId(userId)) {
			new UserEnterpriseFavouriteDAO().deleteByColumnNoTranscation(USER_ID, userId);
		}
	}
}

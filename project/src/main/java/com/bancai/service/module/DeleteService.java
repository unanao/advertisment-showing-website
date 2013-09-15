package com.bancai.service.module;

import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.User;
import com.bancai.service.AdvertiseEnterpriseService;
import com.bancai.service.AdvertiseProductService;
import com.bancai.service.DisplayEnterpriseService;
import com.bancai.service.DisplayProductService;
import com.bancai.service.EnterprisePictureService;
import com.bancai.service.EnterpriseService;
import com.bancai.service.PhoneService;
import com.bancai.service.ProductPictureService;
import com.bancai.service.ProductService;
import com.bancai.service.PurchaseService;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserEnterpriseFavouriteService;
import com.bancai.service.UserProductFavouriteService;
import com.bancai.service.UserService;
import com.bancai.utils.FileUtils;
import com.bancai.web.pcenter.PictureOperation;
import com.bancai.web.pkg.GetPackageInfoAction;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

public class DeleteService implements CommonConstants
{
	Logger logger = Logger.getLogger(GetPackageInfoAction.class);
	
	/**
	 * 删除用户的所有信息
	 * @param userName 用户名
	 * @throws Exception 删除失败
	 */
	public void deleteAllByUserName(String userName) throws Exception
	{
		UserService userService = new UserService();
		int userId;
		User user;

		/* 获取 user 的信息 */
		try
		{
			user = userService.getUserByUserName(userName);
			userId = user.getId();
		}
		catch (Exception ex)
		{
			/* 用户不存在，后面就不需要操作了 */
			logger.log(Level.FATAL, "delete user info error", ex);
			throw ex;
		}
		
		try
		{
			deleteAllUserFiles(userId);
			deleteDbInfoByUserName(userId);
		}
		catch (Exception ex)
		{
			throw ex;
		}
		
	}
	
	/**
	 * 删除用户的所有保存的文件
	 * @param userId 用户ID
	 * @throws IOException 删除目录失败
	 */
	private void deleteAllUserFiles(int userId) throws IOException
	{
		String path = PictureOperation.getUserPictureRootDir(userId);
		
		try 
		{
			FileUtils.deleteDir(path);
		}
		catch (IOException ex)
		{
			logger.log(Level.FATAL, "delete user files error", ex);
			throw ex;
		}
	}
	
	/**
	 * 原子的删除用户的所有的信息, 一条一条的删除。
	 * 
	 * @param userId
	 *            
	 * @throws Exception
	 */
	private void deleteDbInfoByUserName(int userId) throws Exception
	{
		UserService userService = new UserService();

		EntityManagerHelper.beginTransaction();
		try
		{
			/* user_activation */
			new UserActivationService().deleteByActivationIdNoTranscation(userId);

			/* phone -- user */
			new PhoneService().deletePhonesByUserIdNoTranscation(userId);

			deleteEnterpriseRelated(userId);

			/* user_enterprise_favourite 删除用户收藏的企业 */
			new UserEnterpriseFavouriteService().deleteFavouriteEnterpriseByUserIdNoTranscation(userId);

			/* user_product_favourite 删除用户收藏的产品 */
			new UserProductFavouriteService().deleteFavouriteProductByUserIdNoTranscation(userId);

			/* user */
			userService.deleteUserByUserIdNoTranscation(userId);

			EntityManagerHelper.commit();
		}
		catch (Exception e)
		{
			logger.log(Level.FATAL, "delete all user info error", e);
			EntityManagerHelper.rollback();
			throw e;
		}
	}

	/**
	 *根据用户id 删除对应企业id的信息和以企业id作为外键的表的信息。
	 * @param userId
	 */
	public void deleteEnterpriseRelated(int userId)
	{
		UserService userService = new UserService();
		
		int corpId = userService.getEnterpriseIdByUserId(userId);
		if (DB_INVALID_KEY != corpId)
		{
			/* phone -- enterprise */
			new PhoneService().deletePhonesByEnterpriseIdNoTranscation(corpId);

			deleteProductRelated(corpId);

			/* advertise_product */
			new AdvertiseProductService().deleteAdProductByCorpIdNoTranscation(corpId);

			/* advertise_enterprise */
			new AdvertiseEnterpriseService().deleteAdCorpByCorpIdNoTranscation(corpId);

			/* display_enterprise */
			new DisplayEnterpriseService().deleteShowCorpByCorpIdNoTranscation(corpId);

			/* display_product */
			new DisplayProductService().deleteShowProductByCorpIdNoTranscation(corpId);

			/* purchase */
			new PurchaseService().deletePurchasesByEnterpriseIdNoTranscation(corpId);

			/* enterprise_picture*/
			new EnterprisePictureService().deleteCorpPictureByCorpId(corpId);
			
			/* enterprise */
			new EnterpriseService().deleteEnterpriseNoTranscation(corpId);
		}
	}

	/**
	 * 根据企业id 删除 产品信息 以及使用product_id 最为外见的表中的内容
	 * @param corpId
	 */
	public void deleteProductRelated(int corpId)
	{
		/* product_picture */
		new ProductPictureService().deleteProductPictureByEnterpriseIdNoTranscation(corpId);
		
		/* product */
		new ProductService().deleteProductsByEnterpriseIdNoTranscation(corpId);
	}
}

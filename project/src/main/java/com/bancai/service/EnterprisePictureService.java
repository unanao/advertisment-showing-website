/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: EnterprisePicture.java					
 *			
 * Description:																
 */
package com.bancai.service;

import java.util.List;

import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterpriseDAO;
import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.EnterprisePictureDAO;

/**
 * @author unanao
 *
 */
public class EnterprisePictureService
{
	final String ENTERPRISE_ID = "enterpriseId";
	
	/**
	 * 是否存在产品图片的地址信息
	 * @param enterpriseId 企业id
	 * @return true 上传了; false 没有上传
	 */
	public boolean isExistPicture4Enterprise(int enterpriseId)
	{
		EnterprisePictureDAO pictureDao = new EnterprisePictureDAO();
		boolean ret = false;
		
		try 
		{
			if (null != pictureDao.findByProperty(ENTERPRISE_ID, enterpriseId))
			{
				ret = true;
			}
		}
		catch (Exception ex)
		{
			ret = false;
		}
		
		return ret;
	}
	
	/**
	 * 根据企业id删除企业存放的产品图片的地址信息
	 * @param enterpriseId 企业id
	 */
	public void deleteCorpPictureByCorpId(int enterpriseId)
	{
		EnterprisePictureDAO pictureDao = new EnterprisePictureDAO();
		
		if (true == isExistPicture4Enterprise(enterpriseId))
		{
			pictureDao.deleteByColumnNoTranscation(ENTERPRISE_ID, enterpriseId);
		}
	}

	public void save(EnterprisePicture enterprisePicture) {
		
		new EnterprisePictureDAO().save(enterprisePicture);
	}

	public List<EnterprisePicture> findAllByEnterpriseId(int enterpriseId) {
		return new EnterprisePictureDAO().findByProperty(ENTERPRISE_ID, enterpriseId);
	}

	/**
	 * 
	 * @param enterprisePicture
	 * @param enterpriseId
	 * @return 0 设封面成功
	 */
	public int pubEnterprisePicture(EnterprisePicture enterprisePicture, int enterpriseId) {
    	//是否是封面的标志
    	Integer status = enterprisePicture.getStatus();
    	if (status!=null && status == EnterprisePictureDAO.PUB_STATUS) {
			return 0;
		}
    	//设为封面
    	enterprisePicture.setStatus(EnterprisePictureDAO.PUB_STATUS);
    	//取消封面
    	EnterprisePicture preEnterprisePicture = new EnterprisePictureDAO().getPubEnterprisePicture(enterpriseId);
    	if(preEnterprisePicture != null){
    		preEnterprisePicture.setStatus(EnterprisePictureDAO.UNPUB_STATUS);
    		new EnterprisePictureDAO().update(preEnterprisePicture);
    	}
    	new EnterprisePictureDAO().update(enterprisePicture);
    	
    	//产品更改封面
    	Enterprise enterprise = new EnterpriseDAO().findById(enterpriseId);
		enterprise.setLogo(enterprisePicture.getPath());
		new EnterpriseDAO().update(enterprise);
		return 0;
	}

	public EnterprisePicture getEnterprisePicture(Integer pictureId) {
		return new EnterprisePictureDAO().findById(pictureId);
	}

	public void deleteByPrimaryKey(Integer pictureId) {
		new EnterprisePictureDAO().deleteByPrimaryKey(pictureId);
		
	}

	public void deleteEnterprisePictures(List<Integer> ids) {
		new EnterprisePictureDAO().deleteByIds(ids);
	}
}

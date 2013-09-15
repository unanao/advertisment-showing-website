/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: SaveProductPictureAction.java					
 *			
 * Description:										
 */

package com.bancai.web.pcenter;

import com.bancai.dao.ProductPicture;
import com.bancai.dao.ProductPictureDAO;
import com.bancai.web.base.BaseAction;

public class PubProductPictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private int id;
    private int status = 0;//0代表成功，1代表该编号不存在对应的实例，2代表数据库不存在此图片
    private String path;
   
	@Override
    public String execute()  {
		ProductPicture productPicture = getsProductPictureMap().get(id);
    	if(productPicture == null){
    		status = 1;
    		return SUCCESS;
    	}
    	productPicture.setStatus(ProductPictureDAO.PUB_STATUS);
    	ProductPicture prePubProductPicture = getPubProductPicture();
    	if(prePubProductPicture != null){
    		prePubProductPicture.setStatus(ProductPictureDAO.UNPUB_STATUS);
    	}
    	putPubProductPicture(productPicture);
    	if(status == 0){
    		path = productPicture.getPath();
    	}
    	return SUCCESS;
    }
	 
	public void setId(int id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public String getPath() {
		return path;
	}

}

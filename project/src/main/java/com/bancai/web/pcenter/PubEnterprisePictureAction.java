/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: SaveEnterprisePictureAction.java					
 *			
 * Description:										
 */

package com.bancai.web.pcenter;

import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.EnterprisePictureDAO;
import com.bancai.web.base.BaseAction;

public class PubEnterprisePictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private int id;
    private int status = 0;//0代表成功，1代表该编号不存在对应的实例
    private String path;
    
	@Override
    public String execute()  {
    	EnterprisePicture enterprisePicture = getsEnterprisePictureMap().get(id);
    	//如果id对应的picture不存在就返回
    	if(enterprisePicture == null){
    		status = 1;
    		return SUCCESS;
    	}
    	
    	//否则将此picture设为封面并将以前的封面设为无效
    	enterprisePicture.setStatus(EnterprisePictureDAO.PUB_STATUS);
    	EnterprisePicture prePubEnterprisePicture = getPubEnterprisePicture();
    	if(prePubEnterprisePicture != null){
    		prePubEnterprisePicture.setStatus(EnterprisePictureDAO.UNPUB_STATUS);
    	}
    	putPubEnterprisePicture(enterprisePicture);
    	if(status == 0){
    		path = enterprisePicture.getPath();
    	}
    	return SUCCESS;
    }
	public void setId(int id) {
		this.id = id;
	}

	public int getStatus(){
		return status;
	}

    public String getPath() {
		return path;
	}

}

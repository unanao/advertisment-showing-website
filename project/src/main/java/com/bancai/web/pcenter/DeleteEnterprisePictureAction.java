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

public class DeleteEnterprisePictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private int id;
    private int status = 0;
   
    @Override
    public String execute()  {
    	
    	EnterprisePicture enterprisePicture = getsEnterprisePictureMap().get(id);
    	if(enterprisePicture == null){
    		return SUCCESS;
    	}
    	//设为封面的图片不能删
    	if(enterprisePicture.getStatus() != null && enterprisePicture.getStatus().equals(EnterprisePictureDAO.PUB_STATUS)){
    		status = 1;
    		return SUCCESS;
    	}
		String path = enterprisePicture.getPath();
		PictureOperation.deletePicture(path);
		getsEnterprisePictureMap().remove(id);
        return SUCCESS;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getStatus(){
		return status;
	}
}

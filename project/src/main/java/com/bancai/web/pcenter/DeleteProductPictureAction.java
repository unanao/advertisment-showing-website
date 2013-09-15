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

public class DeleteProductPictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private int productId;
	private int id;
    private int status = 0;
   
    @Override
    public String execute()  {
    	ProductPicture productPicture = getsProductPictureMap().get(id);
    	if(productPicture==null){
    		return SUCCESS;
    	}
    	
    	//设为封面的图片不能删
    	if(productPicture.getStatus() != null && productPicture.getStatus().equals(ProductPictureDAO.PUB_STATUS)){
    		status = 1;
    		return SUCCESS;
    	}
		String path = productPicture.getPath();
		PictureOperation.deletePicture(path);
		getsProductPictureMap().remove(id);
        return SUCCESS;
    }
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getStatus(){
		return status;
	}
}

/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: SaveProductFavouriteAction.java					
 *			
 * Description:										
 */

package com.bancai.web.pcenter;

import com.bancai.service.UserProductFavouriteService;
import com.bancai.web.base.BaseAction;

public class DeleteFavouriteProductAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9108594200854030684L;
	
	private int productId;
	
	@Override
	public  String execute(){
		int userId = getUserId();
		if(userId == -1 || productId == -1){
			return ERROR;
		}
		new UserProductFavouriteService().deleteFavouriteProduct(userId, productId);
		return SUCCESS;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
}

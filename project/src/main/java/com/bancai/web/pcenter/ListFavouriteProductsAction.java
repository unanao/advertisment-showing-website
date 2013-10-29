/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: SaveProductFavouriteAction.java					
 *			
 * Description:										
 */

package com.bancai.web.pcenter;

import java.util.List;

import com.bancai.dao.Product;
import com.bancai.service.UserProductFavouriteService;
import com.bancai.utils.Pager;
import com.bancai.web.base.BaseAction;

public class ListFavouriteProductsAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9108594200854030684L;
	
	private List<Product> products;
	private Pager p;
	@Override
	public  String execute(){
		int userId = getUserId();
		if(userId == -1 ){
			return ERROR;
		}
		products = new UserProductFavouriteService().getFavouriteProductsByUserId(userId, p);
		return SUCCESS;
	}
	
	public void setP(Pager p){
		this.p = p;
	}
	public List<Product> getProducts(){
		return products;
	}
}

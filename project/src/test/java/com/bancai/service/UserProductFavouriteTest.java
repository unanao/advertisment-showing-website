/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: UserProductFavouriteTest.java					
 *			
 * Description:										
 */

package com.bancai.service;

import java.util.List;

import com.bancai.dao.Product;
import com.bancai.dao.ProductDAO;
import com.bancai.utils.Pager;

import junit.framework.TestCase;

public class UserProductFavouriteTest extends TestCase{

	/*
	public void testSaveFavouriteProduct(){
		UserProductFavouriteService service = new UserProductFavouriteService();
		service.saveFavouriteProduct(6, 1);
		service.saveFavouriteProduct(6, 5);
		service.saveFavouriteProduct(6, 3);
	}*/
	

	public void testGetFavouriteProductsByUserId(){
		UserProductFavouriteService service = new UserProductFavouriteService();
		Pager p = new Pager();
		p.setNeedsTotal(true);
		p.setPageNow(1);
		p.setPageSize(10);
		List<Product> products = service.getProductRankListByCategory("旋切机",p);
		for(Product product : products){
			System.out.println(product.getName() + "\t" +product.getFavourite() + "\t" + product.getCategory());
		}
	}/*
	public void testDeleteFavouriteProduct(){
		UserProductFavouriteService service = new UserProductFavouriteService();
		service.deleteFavouriteProduct(6, 5);
	}*/
	
	
}

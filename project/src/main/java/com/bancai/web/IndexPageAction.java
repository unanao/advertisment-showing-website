package com.bancai.web;

import java.util.List;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.Product;
import com.bancai.service.AdvertiseEnterpriseService;
import com.bancai.service.AdvertiseProductService;
import com.bancai.service.DisplayEnterpriseService;
import com.bancai.service.DisplayProductService;
import com.bancai.service.UserProductFavouriteService;
import com.bancai.utils.Pager;
import com.bancai.web.base.BaseAction;

public class IndexPageAction extends BaseAction{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5697187557593487604L;
	/**
	 * 
	 */
	private List<Product> advertiseProducts; 
	private List<Enterprise> advertiseEnterprises; 
	private List<Product> displayProducts; 
	private List<Enterprise> displayEnterprises;
	private List<Product> productRankList;
	public String execute(){
		advertiseProducts = new AdvertiseProductService().getProducts(BancaiConstants.ADVERTISE_PRODUCT_SIZE);
		changeProductPicture(advertiseProducts);
		
		advertiseEnterprises = new AdvertiseEnterpriseService().getEnterprises(BancaiConstants.ADVERTISE_ENTERPRISE_SIZE);
		changeEnterprisePicture(advertiseEnterprises);
		
		displayProducts = new DisplayProductService().getProducts(BancaiConstants.PRODUCT_TYPES,BancaiConstants.DISPLAY_PRODUCT_SIZE);
		changeProductPicture(displayProducts);
		
		displayEnterprises = new DisplayEnterpriseService().getEnterprises(BancaiConstants.ENTERPRISE_AREA, BancaiConstants.DISPLAY_ENTERPRISE_SIZE);
		changeEnterprisePicture(displayEnterprises);
		
		Pager pager = new Pager();
		pager.setPageNow(1);
		pager.setPageSize(BancaiConstants.DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE);
		productRankList = new UserProductFavouriteService().getProductRankList(pager);
		return SUCCESS;
	}
	public List<Product> getDisplayProducts(){
		return displayProducts;
	}
	public List<Enterprise> getDisplayEnterprises(){
		return displayEnterprises;
	}
	public List<Product> getAdvertiseProducts() {
		return advertiseProducts;
	}
	public List<Enterprise> getAdvertiseEnterprises() {
		return advertiseEnterprises;
	}
	public List<Product> getProductRankList() {
		return productRankList;
	}
	
}

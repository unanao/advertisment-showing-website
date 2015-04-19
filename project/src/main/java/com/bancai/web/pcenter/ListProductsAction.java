package com.bancai.web.pcenter;

import java.util.List;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Product;
import com.bancai.service.ProductService;
import com.bancai.web.base.BaseAction;

public class ListProductsAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4749786136088574102L;
	private List<Product> products;
	
	public String execute(){
		Integer enterpriseId = getEnterpriseId();
		if(enterpriseId == null || enterpriseId == BancaiConstants.DEFAULT_ID){
			return SUCCESS;
		}
		
		products = new ProductService().getAllProductsByEnterpriseId(enterpriseId);
		return SUCCESS;
	}
	public List<Product> getProducts() {
		return products;
	}
}

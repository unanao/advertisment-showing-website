package com.bancai.service;

import java.util.ArrayList;
import java.util.List;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.Product;

public class CommonService {
	public static List<Enterprise> createEmptyEnterprises(int size) {
		List<Enterprise> enterprises = new ArrayList<Enterprise>();
		for (int i = 0; i < size; i++) {
			Enterprise enterprise = new Enterprise();
			enterprise.setId(Integer.valueOf(BancaiConstants.DEFAULT_ID));
			enterprise.setName(BancaiConstants.DEFAULT_NAME);
			enterprise.setLogo(BancaiConstants.PRODUCT_DEFAULT_PATH);
			enterprises.add(enterprise);
		}
		return enterprises;
	}

	
	public static List<Product> createEmptyProducts(int size) {
		List<Product> Products = new ArrayList<Product>();
		for (int i = 0; i < size; i++) {
			Product Product = new Product();
			Product.setId(Integer.valueOf(BancaiConstants.DEFAULT_ID));
			Product.setName(BancaiConstants.DEFAULT_NAME);
			Product.setIcon(BancaiConstants.PRODUCT_DEFAULT_PATH);
			Products.add(Product);
		}
		return Products;
	}
}

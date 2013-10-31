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
		List<Product> products = new ArrayList<Product>();
		for (int i = 0; i < size; i++) {
			Product p = new Product();
			p.setId(Integer.valueOf(BancaiConstants.DEFAULT_ID));
			p.setName(BancaiConstants.DEFAULT_NAME);
			p.setEnterprise(BancaiConstants.DEFAULT_ID);
			p.setDetail("");
			p.setFavourite(BancaiConstants.DEFAULT_PRODUCT_FAVOURITES);
			p.setHits(BancaiConstants.DEFAULT_PRODUCT_HINTS);
			p.setIcon(BancaiConstants.PRODUCT_DEFAULT_PATH);
			p.setIntroduction("");
			p.setScore(BancaiConstants.DEFAULT_PRODUCT_SCORE);
			products.add(p);
		}
		return products;
	}
}

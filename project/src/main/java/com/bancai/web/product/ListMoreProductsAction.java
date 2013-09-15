package com.bancai.web.product;

import java.util.List;

import com.bancai.dao.Product;
import com.bancai.service.ProductService;
import com.bancai.utils.Pager;
import com.bancai.web.base.BaseAction;

public class ListMoreProductsAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4749786136088574102L;
	private List<Product> products;
	private String category;
	private Pager p = new Pager();
	public String execute(){
		products = new ProductService().listProducts(category,p);
		changeProductPicture(products);
		return SUCCESS;
	}
	public List<Product> getProducts() {
		return products;
	}
	
	public String getCategory(){
		return category;
	}
	public void setCategory(String category){
		this.category = category;
	}
	 public Pager getP() {
	        return p;
	    }

	    public void setP(Pager p) {
	        this.p = p;
	    }
}

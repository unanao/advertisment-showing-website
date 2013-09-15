package com.bancai.web.product;

import java.util.ArrayList;
import java.util.List;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.Product;
import com.bancai.dao.ProductPicture;
import com.bancai.service.EnterpriseService;
import com.bancai.service.ProductPictureService;
import com.bancai.service.ProductService;
import com.bancai.web.base.BaseAction;

public class ShowProductAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7383669041504798483L;
	private int productId;
	private Product product;
	private Enterprise enterprise;
	private List<ProductPicture> productPictures;
	public String execute(){
		if(productId == Integer.valueOf(BancaiConstants.DEFAULT_ID)){
			return INPUT;
		}
		ProductService service = new ProductService();
		product = service.getProduct(productId);
		List<Product> products = new ArrayList<Product>();
		products.add(product);
		changeProductPicture(products);
		enterprise = new EnterpriseService().getEnterprise(product.getEnterprise());
		List<Enterprise> enterprises = new ArrayList<Enterprise>();
		enterprises.add(enterprise);
		productPictures = new ProductPictureService().findAllByProductId(productId);
		return SUCCESS;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public Product getProduct() {
		return product;
	}
	public Enterprise getEnterprise(){
		return enterprise;
	}
	public List<ProductPicture> getProductPictures(){
		return productPictures;
	}
}

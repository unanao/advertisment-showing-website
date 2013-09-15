package com.bancai.web.pcenter;

import com.bancai.service.ProductService;
import com.bancai.web.base.BaseAction;

public class DeleteProductAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1976514987076291500L;
	private int productId;
	/*
	 *目录结构 /picture/用户id/product/图片文件 
	 */
	public String execute(){
		ProductService service = new ProductService();
		service.deleteProduct(productId);
		return SUCCESS;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
}

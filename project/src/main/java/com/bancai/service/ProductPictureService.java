/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: ProductPicture.java					
 *			
 * Description:																
 */
package com.bancai.service;

import java.util.Iterator;
import java.util.List;

import com.bancai.dao.Product;
import com.bancai.dao.ProductDAO;
import com.bancai.dao.ProductPicture;
import com.bancai.dao.ProductPictureDAO;

/**
 * @author unanao
 *
 */
public class ProductPictureService
{
	private static final String PRODUCT_ID = "productId";

	/**
	 * 根据企业id删除产品图片的地址信息
	 * @param enterpriseId
	 */
	public void deleteProductPictureByEnterpriseIdNoTranscation(int enterpriseId)
	{
		ProductPictureDAO pictureDao = new ProductPictureDAO();
		ProductService productService = new ProductService();
		List<Product> products = productService.getAllProductsByEnterpriseId(enterpriseId);
		Product product;
		
		Iterator<Product> it = products.iterator();  
        while (it.hasNext())  
        {  
        	product = it.next();
        	pictureDao.deleteByColumnNoTranscation(PRODUCT_ID, product.getId());
        }  
	}
	
	public List<ProductPicture> findAllByProductId(int productId){
		return new ProductPictureDAO().findByProperty(PRODUCT_ID, productId);
	}
	
	public void save(ProductPicture picture){
		new ProductPictureDAO().save(picture);
	}
	
	public void deleteByPrimaryKey(int id){
		new ProductPictureDAO().deleteByPrimaryKey(id);
	}

	/**
	 * 奖图片设为封面
	 * @param pictureId
	 * @param productId
	 * @return
	 *   返回0代表成功，1代表该编号不存在对应的实例，2代表数据库不存在此图片
	 */
	public int pubProductPicture(Integer pictureId, int productId) {
		if(pictureId==null){
    		return 1;
    	}
    	
    	ProductPicture productPicture = new ProductPictureDAO().findById(pictureId);
    	if(productPicture == null){
    		return 2;
    	}
    	
    	//是否是封面的标志
    	Integer status = productPicture.getStatus();
    	if (status!=null && status == ProductPictureDAO.PUB_STATUS) {
			return 0;
		}
    	//设为封面
    	productPicture.setStatus(ProductPictureDAO.PUB_STATUS);
    	//取消封面
    	ProductPicture preProductPicture = new ProductPictureDAO().getPubProductPicture(productId);
    	if(preProductPicture != null){
    		preProductPicture.setStatus(ProductPictureDAO.UNPUB_STATUS);
    		new ProductPictureDAO().update(preProductPicture);
    	}
    	new ProductPictureDAO().update(productPicture);
    	
    	//产品更改封面
    	Product product = new ProductDAO().findById(productId);
		product.setIcon(productPicture.getPath());
		new ProductDAO().update(product);
		return 0;
	}

	public ProductPicture getProductPicture(Integer pictureId) {
		ProductPicture productPicture = new ProductPictureDAO().findById(pictureId);
		return productPicture;
	}

	public void deleteProductPictures(List<Integer> pictureIdList) {
		new ProductPictureDAO().deleteByIds(pictureIdList);
		
	}

	public long countProductPicture(int productId) {
		
		return new ProductPictureDAO().countByProperty(ProductPictureDAO.PRODUCT_ID, productId);
	}
}

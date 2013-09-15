package com.bancai.dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

/**
 * 
 * @author jiangge(zhyanjiang@126.com)
 */
public class ProductPictureDAO extends AbstractDAO<ProductPicture> {
	public final static Integer PUB_STATUS = 1;
	public final static Integer UNPUB_STATUS = 0;
	public final static String PRODUCT_ID = "productId";
    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<ProductPicture> getEntityClass() {
        return ProductPicture.class;
    }
    public static final String PU_NAME = "BancaiPU";
	private static final String PRODUCT_PICTURE_ID = "id";

    public String getPUName() {
        return PU_NAME;
    }

    public ProductPicture getPubProductPicture(Integer productId){
    	 log("finding all" + getClassName() + " instances", Level.INFO, null);
         try {
             final String queryString = "select e from ProductPicture e"
            		 				+ " where e.status = :status and"
            		                + " e.productId = :productId";
             Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
             query.setParameter("status", PUB_STATUS);
             query.setParameter("productId", productId);
             @SuppressWarnings("unchecked")
             List<ProductPicture> results = query.getResultList();
             if(results != null && results.size()>0){
            	 return  results.get(0);
             }else{
            	 return null;
             }
         } catch (RuntimeException re) {
             log("finding all" + getClassName() + " instances failed",
                     Level.SEVERE, re);
             throw re;
         }
    }
    /**
     * 根据productID删除对应的图片
     * @param productId
     */
    public void deleteProductPictureByProductIdNoTransaction(int productId) {
    	deleteByColumnNoTranscation(PRODUCT_ID, productId);
    }
    /**
     * 根据存在的product id的list删除不存在的图片
     * @param ids
     */
	public void deleteByIds(List<Integer> ids) 
	{
    	//之所以多加一个无用项，是因为如果ids为空，有可能出现args为空的情况
		ids.add(-1);
		
        deleteByPropertyNotIn(PRODUCT_PICTURE_ID, ids);
	}
}


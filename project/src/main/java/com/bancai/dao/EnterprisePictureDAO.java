package com.bancai.dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.logging.Level;

import javax.persistence.Query;

import com.bancai.utils.sql.AbstractDAO;
import com.bancai.utils.sql.entitymanager.EntityManagerHelper;

/**
 *
 * @author jiangge(zhyanjiang@126.com)
 */
public class EnterprisePictureDAO extends AbstractDAO<EnterprisePicture> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<EnterprisePicture> getEntityClass() {
        return EnterprisePicture.class;
    }
    public static final String PU_NAME = "BancaiPU";
	public static final int PUB_STATUS = 1;
	public static final int UNPUB_STATUS = 0;
	public static final String ENTERPRISE_ID = "enterpriseId";
	private static final String ENTERPRISE_PICTURE_ID = "id";

    public String getPUName() {
        return PU_NAME;
    }

	public EnterprisePicture getPubEnterprisePicture(Integer enterpriseId){
    	 log("finding all" + getClassName() + " instances", Level.INFO, null);
         try {
             final String queryString = "select e from EnterprisePicture e"
            		 				+ " where e.status = :status and"
            		                + " e.enterpriseId = :enterpriseId";
             Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
             query.setParameter("status", PUB_STATUS);
             query.setParameter("enterpriseId", enterpriseId);
             @SuppressWarnings("unchecked")
             List<EnterprisePicture> results = query.getResultList();
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

	public void deleteByIds(List<Integer> ids)
	{
    	 //之所以多加一个无用项，是因为如果ids为空，有可能出现args为空的情况
    	 ids.add(-1);
    	 
         deleteByPropertyNotIn(ENTERPRISE_PICTURE_ID, ids);
	}
}


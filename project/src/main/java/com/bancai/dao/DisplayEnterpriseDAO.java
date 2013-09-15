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
public class DisplayEnterpriseDAO extends AbstractDAO<DisplayProduct> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<DisplayEnterprise> getEntityClass() {
        return DisplayEnterprise.class;
    }
    public static final String PU_NAME = "BancaiPU";

    public String getPUName() {
        return PU_NAME;
    }

    
    @SuppressWarnings("unchecked")
	public List<Enterprise> findAllByArea(String area){
    	 log("finding all" + getClassName() + " instances", Level.INFO, null);
         try {
             final String queryString = "select e from DisplayEnterprise d,Enterprise e"
            		 				+ " where d.enterpriseId = e.id and"
            		                + " d.area = :area";
             Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
             query.setParameter("area", area);
             return query.getResultList();
         } catch (RuntimeException re) {
             log("finding all" + getClassName() + " instances failed",
                     Level.SEVERE, re);
             throw re;
         }
    }
}


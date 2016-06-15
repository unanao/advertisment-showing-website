package com.bancai.dao;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bancai.utils.Pager;
import com.bancai.utils.sql.AbstractDAO;
import com.bancai.utils.sql.entitymanager.EntityManagerHelper;

/**
 *
 * @author jiangge(zhyanjiang@126.com)
 */
public class UserProductFavouriteDAO extends AbstractDAO<UserProductFavourite> {

    public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<UserProductFavourite> getEntityClass() {
        return UserProductFavourite.class;
    }
    public static final String PU_NAME = "BancaiPU";

    public String getPUName() {
        return PU_NAME;
    }
    
    /**
     * 根据userId查找收藏的产品
     * @param userId
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<Product> findFavouriteProducts(int userId,Pager p){
    	EntityManager em = EntityManagerHelper.getEntityManager();

		log("finding" + getClassName() + "user id" + userId , Level.INFO, null);

		try {
			final String queryStr = "SELECT p FROM Product p,UserProductFavourite u WHERE u.user= :userId AND u.product= p.id";
			Query query = em.createQuery(queryStr);
			query.setParameter("userId", userId);
			query.setFirstResult(p.getStart());
			query.setMaxResults(p.getPageSize());
			return query.getResultList();
		} catch (RuntimeException re) {
			log("finding favourite product by userId failed", Level.SEVERE, re);
			throw re;
		}
    }
}


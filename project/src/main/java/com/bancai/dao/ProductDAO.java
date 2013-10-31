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
import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

/**
 *
 * @author jiangge(zhyanjiang@126.com)
 */
public class ProductDAO extends AbstractDAO<Product> {

    public static final String CATEGORY = "category";
    public static final String FAVOURITE = "favourite";
	public String getClassName() {
        return getEntityClass().getName();
    }

    public Class<Product> getEntityClass() {
        return Product.class;
    }
    public static final String PU_NAME = "BancaiPU";

    public String getPUName() {
        return PU_NAME;
    }    
    
    /**
     * 获取总排行榜
     * @param condition
     * 		排行条件
     * @param p
     * @return
     */
    @SuppressWarnings("unchecked")
	public List<Product> getRankList(String condition,Pager p){
    	EntityManager em = EntityManagerHelper.getEntityManager();

		log("get product rank list order by " +  condition, Level.INFO, null);

		try {
			final String queryStr = "SELECT p FROM Product p order by " + condition +" desc";
			Query query = em.createQuery(queryStr);
			query.setFirstResult(p.getStart());
			query.setMaxResults(p.getPageSize());
			return query.getResultList();
		} catch (RuntimeException re) {
			log("get product rank list order by " + condition +" failed", Level.SEVERE, re);
			throw re;
		}
    }
    
    /**
     * 获取某类产品的排行榜
     * @param condition
     * 		排行条件
     * @param p
     * @return
     */
    @SuppressWarnings("unchecked")
  	public List<Product> getRankListByCategory(String category,String condition,Pager p){
      	EntityManager em = EntityManagerHelper.getEntityManager();

  		log("get " + category + " rank list order by " + condition , Level.INFO, null);

  		try {
  			final String queryStr = "SELECT p FROM Product p where p.category = :category order by :condition desc";
  			Query query = em.createQuery(queryStr);
  			query.setParameter("category", category);
  			query.setParameter("condition", condition);
  			query.setFirstResult(p.getStart());
  			query.setMaxResults(p.getPageSize());
  			return query.getResultList();
  		} catch (RuntimeException re) {
  			log("get " + category + " rank list order by " + condition +" failed", Level.SEVERE, re);
  			throw re;
  		}
      }
    
}


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
public class AdvertiseProductDAO extends AbstractDAO<AdvertiseProduct> {

	public String getClassName() {
		return getEntityClass().getName();
	}

	public Class<AdvertiseProduct> getEntityClass() {
		return AdvertiseProduct.class;
	}

	public static final String PU_NAME = "BancaiPU";

	public String getPUName() {
		return PU_NAME;
	}


	@SuppressWarnings("unchecked")
	public List<Product> findAllProducts() {
		log("finding all" + getClassName() + " instances", Level.INFO, null);
		try {
			final String queryString = "select p from AdvertiseProduct d,Product p"
					+ " where d.productId = p.id";
			Query query = EntityManagerHelper.getEntityManager().createQuery(queryString);
			return query.getResultList();
		} catch (RuntimeException re) {
			log("finding all" + getClassName() + " instances failed",
					Level.SEVERE, re);
			throw re;
		}
	}
}

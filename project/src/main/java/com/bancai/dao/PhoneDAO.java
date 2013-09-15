package com.bancai.dao;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.free4lab.utils.sql.AbstractDAO;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

/**
 * 
 * @author jiangge(zhyanjiang@126.com)
 */
public class PhoneDAO extends AbstractDAO<Phone> {

	public static final String ENTERPRISE = "enterprise";

	public String getClassName() {
		return getEntityClass().getName();
	}

	public Class<Phone> getEntityClass() {
		return Phone.class;
	}

	public static final String PU_NAME = "BancaiPU";

	public String getPUName() {
		return PU_NAME;
	}


	/**
	 * 根据userId和type获取phone的所有表项
	 * 
	 * @param userId
	 *            用户id
	 * @param type
	 *            电话类型
	 * @return 满足条件phone的所有表项
	 */
	@SuppressWarnings("unchecked")
	public List<Phone> findByUserIdType(int userId, String type) {

		EntityManager em = EntityManagerHelper.getEntityManager();

		log("finding" + getClassName() + "user id" + userId + "phone type"
				+ type, Level.INFO, null);

		try {
			final String queryStr = "SELECT p FROM Phone p WHERE p.user= :userId AND p.type= :type";
			Query query = em.createQuery(queryStr);
			query.setParameter("userId", userId);
			query.setParameter("type", type);

			return query.getResultList();
		} catch (RuntimeException re) {
			log("finding phone by userId  and type failed", Level.SEVERE, re);
			throw re;
		}
	}
}

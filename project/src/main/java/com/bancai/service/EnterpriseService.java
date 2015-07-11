package com.bancai.service;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterpriseDAO;
import com.bancai.dao.Phone;
import com.bancai.dao.PhoneDAO;
import com.bancai.dao.User;
import com.bancai.service.module.SearchService;
import com.bancai.utils.Pager;
import com.free4lab.utils.sql.entitymanager.EntityManagerHelper;

public class EnterpriseService implements CommonConstants
{
	EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
	Logger logger = Logger.getLogger(EnterpriseService.class);

	public void saveEnterpriseAndPhone(Enterprise enterprise, Phone phone,
			Integer userId)
	{
		enterprise.setTime(new Timestamp(System.currentTimeMillis()));
		phone.setEnterprise(enterprise.getId());
		UserService userService = new UserService();
		User user = userService.getUserByUserId(userId);

		EntityManagerHelper.beginTransaction();
		try
		{
			new EnterpriseDAO().saveNoTransaction(enterprise);

			phone.setEnterprise(enterprise.getId());
			new PhoneService().addPhoneNoTransaction(phone);

			user.setEnterprise(enterprise.getId());
			userService.updateUserNoTransaction(user);

			EntityManagerHelper.commit();
		}
		catch (RuntimeException re)
		{
			EntityManagerHelper.rollback();
			logger.log(Level.FATAL, "update error", re);
			throw re;
		}
	}

	public void updateEnterpriseAndPhone(Enterprise enterprise, Phone phone)
	{
		EntityManagerHelper.beginTransaction();
		try
		{
			EntityManagerHelper.getEntityManager().flush();
			updateEnterpriseNoTransaction(enterprise);
			new PhoneService().updatePhoneNoTransaction(phone);
			
			EntityManagerHelper.commit();
		}
		catch (RuntimeException re)
		{
			EntityManagerHelper.rollback();
			throw re;
		}

	}

	public Enterprise getEnterprise(int enterpriseId)
	{
		EntityManagerHelper.getEntityManager().clear();
		return new EnterpriseDAO().findById(enterpriseId);
	}

	public List<Enterprise> listEnterprises()
	{
		return new EnterpriseDAO().findAll();
	}

	public List<Enterprise> listEnterprises(String county, Pager p)
	{
		if (p.isNeedsTotal())
		{
			p.setTotal(new EnterpriseDAO().countByProperty(
					EnterpriseDAO.COUNTY, county));
		}
		return new EnterpriseDAO().findByProperty(EnterpriseDAO.COUNTY, county,
				p.getStart(), p.getPageSize());
	}

	public Phone getPhone(int phoneId)
	{
		return new PhoneDAO().findById(phoneId);
	}

	public void updateEnterprise(Enterprise enterprise)
	{
		new EnterpriseDAO().update(enterprise);
	}

	public void updateEnterpriseNoTransaction(Enterprise enterprise)
	{
		new EnterpriseDAO().updateNoTransaction(enterprise);
	}

	public void updatePhone(Phone phone)
	{
		new PhoneDAO().update(phone);
	}

	public List<Enterprise> listSomeEnterprises(int size)
	{
		return new EnterpriseDAO().findAll(0, size);
	}

	/**
	 * 根据企业id删除企业信息
	 * 
	 * @param enterpriseId
	 *            企业id
	 */
	public void deleteEnterpriseNoTranscation(int enterpriseId)
	{
		new EnterpriseDAO().deleteByPrimaryKeyNoTranscation(enterpriseId);
	}

	public void deleteEnterprise(int enterpriseId) {
		new EnterpriseDAO().deleteByPrimaryKey(enterpriseId);
	}
	
	/**
	 * 返回搜索的企业信息
	 * 
	 * @param content
	 *            用户输入的内容
	 * @param province
	 *            省
	 * @param city
	 *            市
	 * @param county
	 *            县
	 * @param p
	 *            分页信息
	 * @return
	 */
	public List<Enterprise> getEnterprises4EnterpriseSearch(String content,
			String province, String city, String county, Pager p)
	{
		SearchService searchService = new SearchService();
		EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
		EntityManager em = EntityManagerHelper.getEntityManager();
		String hql = "";
		String countHql = "";
		String queryHql = "";

		String contentSql = searchService.getSql4Enterprise(content);
		if (!contentSql.equals(""))
		{
			hql = contentSql;
		}

		String areaSql = searchService.getsql4EnterpriseAera(province, city,
				county);
		if (!areaSql.equals(""))
		{
			hql = searchService.getAndHql(hql) + areaSql;
		}

		if (!hql.equals(""))
		{
			hql = " FROM Enterprise e WHERE " + hql;
			countHql = "SELECT COUNT(e) " + hql;
			queryHql = "SELECT e " + hql;
		}

		/* hql 参数设置 */
		Query query = em.createQuery(queryHql);
		Query countQuery = em.createQuery(countHql);
		if (!contentSql.equals(""))
		{
			query.setParameter("content", content);
			countQuery.setParameter("content", content);
		}
		searchService.setPara4EnterpriseAera(query, countQuery, province, city,
				county);

		p.setTotal(enterpriseDAO.countByQuery(countQuery));

		return enterpriseDAO.listByQuery(query, p.getStart(), p.getPageSize());
	}

	/**
	 * 返回搜索的企业信息
	 * 
	 * @param content
	 *            用户输入的内容
	 * @param p
	 *            用于分页
	 * @return
	 */
	public List<Enterprise> getEnterprises4Search(String content, Pager p)
	{
		SearchService searchService = new SearchService();
		EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
		EntityManager em = EntityManagerHelper.getEntityManager();

		String contentSql = searchService.getSql4Enterprise(content);

		String hql = " FROM Enterprise e WHERE " + contentSql;

		String countHql = "SELECT COUNT(e) " + hql;
		Query countQuery = em.createQuery(countHql);
		countQuery.setParameter("content", "%" + content + "%");

		String queryHql = "SELECT e " + hql;
		Query query = em.createQuery(queryHql);
		query.setParameter("content", "%" + content + "%");

		p.setTotal(enterpriseDAO.countByQuery(countQuery));

		return enterpriseDAO.listByQuery(query, p.getStart(), p.getPageSize());
	}

	/**
	 * 用户允许上传的最大图片数目
	 * 
	 * @param enterpriseId
	 * @return
	 */
	public int getMaxPictureNumber(int enterpriseId)
	{
		Enterprise enterprise = new EnterpriseDAO().findById(enterpriseId);
		if (enterprise != null && enterprise.getPicNum() != null)
		{
			return enterprise.getPicNum();
		}
		else
		{
			return -1;
		}
	}
}

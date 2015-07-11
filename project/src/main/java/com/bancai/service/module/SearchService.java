/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: SearchCommon.java					
 *			
 * Description:																
 */
package com.bancai.service.module;

import javax.persistence.Query;

import com.bancai.constants.SearchConstants;

/**
 * @author unanao
 *
 */
public class SearchService
{
	/**
	 * 根据用户输入的内容获取查询的企业的sql语句
	 * @param content 用户输入的搜索内容
	 * @return
	 */
	public String getSql4Enterprise(String content)
	{
		String sql = "";
		
		if ((null != content) && (0 != content.length()))
		{
			sql = "(" + "e.name LIKE :content" + 
						 " OR e.address LIKE :content" + 
						 " OR e.introduction LIKE :content" + ")";
		}
	
		return sql;
	}
	
	/**
	 * 根据用户输入的内容获取查询的产品的sql语句
	 * @param content 用户输入的查询内容
	 * @return
	 */
	public String getSql4Product(String content)
	{
		String sql = "";
		
		if ((null != content) && (0 != content.length()))
		{
			sql = "p.name LIKE :content" +
					" OR p.introduction LIKE :content" + 	
					" OR p.category LIKE :content" + 
					" OR p.detail LIKE :content" + 
					" OR p.property1 LIKE :content" + 
					" OR p.property2 LIKE :content" + 
					" OR p.property3 LIKE :content" + 
					" OR p.property4 LIKE :content" + 
					" OR p.property5 LIKE :content";
		}
		
		return sql;
	}
	
	/**
	 * 根据产品类别生成sql语句
	 * @param category 产品类别
	 * @return
	 */
	public String getSql4ProductCategory(String category)
	{
		String sql = "";
		
		if ((null != category) && 
			(!category.equals(SearchConstants.SEARCH_DEFAULT_VALUE)))
		{
			sql = " p.category LIKE :category ";
			
			sql = "(" + sql + ")";
		}
		
		return sql;
	}
	
	public boolean isDefaultValue(String value)
	{
		if ((null != value)  && 
			(!value.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) && 
			(!value.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			return false;
		}
		
		return true;
	}
	
	/**
	 * 根据属性获取生成sql语句
	 * @param property 属性
	 * @return
	 */
	public String getSql4ProductProperty(String property)
	{
		String sql = "";
		
		if (true != isDefaultValue(property))
		{
			sql = "p.detail LIKE :property " + " OR " +
					" p.property1 LIKE :property " + " OR " +
				 	" p.property2 LIKE :property " + " OR " +
				 	" p.property3 LIKE :property " + " OR " +
				 	" p.property4 LIKE :property " + " OR " +
				 	" p.property5 LIKE :property ";
			
			sql = "(" + sql + ")";
		}
		
		return sql;
	}
	
	/**
	 * 根据地区生成sql语句
	 * @param province 省/直辖市
	 * @param city	市/区
	 * @param county 县
	 * @return
	 */
	public String getsql4EnterpriseAera(String province, String city, String county)
	{
		String hql = "";
		
		if ((null != province) && 
			(!province.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) &&
			(!province.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			hql = " e.province LIKE :province " ;
		}
		
		if ((null != city) && 
			(!city.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) && 
			(!city.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			if ("" != hql)
			{
				hql += "AND";
			}
			
			hql += " e.city LIKE :city ";
		}
		
		if ((null != county) && (!county.equals("")) &&
		    (!county.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) &&
		    (!county.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			if (!hql.equals(""))
			{
				hql += "AND";
			}
			
			hql += " e.county LIKE :county ";
		}
		
		return hql;
	}
	
	/**
	 * 根据地区设置sql语句的参数
	 * @param province 省/直辖市
	 * @param city	市/区
	 * @param county 县
	 * @return
	 */
	public void setPara4EnterpriseAera(Query query, Query countQuery, 
				String province, String city, String county)
	{
		if ((null != province) && 
			(!province.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) &&
			(!province.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			query.setParameter("province", "%" + province + "%");
			countQuery.setParameter("province", "%" + province + "province");
		}
		
		if ((null != city) && 
			(!city.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) && 
			(!city.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			query.setParameter("city", "%" + city + "%");
			countQuery.setParameter("city", "%" + city + "%");
		}
		
		if ((null != county) && (!county.equals("")) &&
		    (!county.equals(SearchConstants.SEARCH_DEFAULT_VALUE)) &&
		    (!county.equals(SearchConstants.SEARCH_DEFAULT_VALUE2)))
		{
			query.setParameter("county", "%" + county + "%");
			countQuery.setParameter("county", "%" + county + "%" );
		}
	}
	
	/**
	 * 根据content获取查询product 和 enterprise的 sql语句
	 * @param content
	 * @return
	 */
	public String getSql4Content(String content)
	{
		String enterpriseSql = getSql4Enterprise(content);
		String productSql = getSql4Product(content);
		String sql = "";
		
		if ((!enterpriseSql.equals("")) && (!productSql.equals("")))
		{
			sql = "(" + enterpriseSql + " OR " + productSql + ")";
		}
		
		return sql;
	}
	
	/**
	 * 给指定的hql语句增加 AND
	 * @param hql
	 * @return
	 */
	public String getAndHql(String hql)
	{
		if (!hql.equals(""))
		{
			hql = hql + " AND ";
		}
		
		return hql;
	}
}

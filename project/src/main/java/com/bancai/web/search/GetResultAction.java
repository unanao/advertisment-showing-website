/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: GetResultAction.java					
 *			
 * Description:																
 */
package com.bancai.web.search;

import java.util.List;

import com.bancai.constants.SearchConstants;
import com.bancai.dao.Product;
import com.bancai.dao.Enterprise;
import com.bancai.service.EnterpriseService;
import com.bancai.service.ProductService;
import com.bancai.service.module.SearchService;
import com.bancai.utils.Pager;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao
 *
 */
public class GetResultAction extends ActionSupport 
{
	private static final long serialVersionUID = 4449869643112326474L;

	private static final int NR_PER_PAGE = 24;

	String content;		//用户输入的搜索内容
	
	String category;
	String specification; //规格
	
	String province;
	String city;
	String county;
	
	List<Product> products;			//返回的内容
	List<Enterprise> enterprises;	//返回的内容
	
	private Pager p = new Pager(); //分页显示
	
	@Override
	public String execute() throws Exception 
	{
		ProductService productService = new ProductService();
		EnterpriseService enterpriseService = new EnterpriseService();
		SearchService searchService = new SearchService();
		
		p.setPageSize(NR_PER_PAGE);
		
		/*为了简单, 只处理第一个关键字*/
		content = content.trim();
		String[] contentArray = content.split(" ");
		content = contentArray[0];
		
		/*
		 * 什么都不选择，只输入关键字进行搜索：返回企业和产品
		 * 选择产品类别或规格：只返回产品
		 * 选择了地区，但是没有选择产品列别和规格：只返回企业
		 */
		
		/* Select other must select category or Province, therefore only check the two */
		if (true != searchService.isDefaultValue(category))
		{
			products = productService.getProducts4ProductSearch(content, category, 
					specification, province, city, county, p);
		}
		else if (true != searchService.isDefaultValue(province))
		{
			enterprises = enterpriseService.getEnterprises4EnterpriseSearch(content, 
					province, city, county, p);
		}
		else
		{
			/*
			 * 为了实现简单，如果既有企业也有产品信息，每页上面显示产品
			 * 下边显示企业。所以总数放回最大那个就可以了。
			 */
			
			Integer total;
			
			products = productService.getProducts4Search(content, p);
			
			total = (int) p.getTotal(); 
			
			enterprises = enterpriseService.getEnterprises4Search(content, p);
			if (total > p.getTotal())
			{
				p.setTotal(total);
			}
		}
		
		return SUCCESS;
	}

	public String getContent()
	{
		return new HTMLInputFilter().filter(content);
	}

	public void setContent(String content)
	{
		this.content = new HTMLInputFilter().filter(content);
	}

	public String getCategory()
	{
		return new HTMLInputFilter().filter(category);
	}

	public void setCategory(String category)
	{
		this.category = new HTMLInputFilter().filter(category);
	}

	public String getSpecification()
	{
		return new HTMLInputFilter().filter(specification);
	}

	public void setSpecification(String specification)
	{
		this.specification = new HTMLInputFilter().filter(specification);
	}

	public String getProvince()
	{
		return new HTMLInputFilter().filter(province);
	}

	public void setProvince(String province)
	{
		this.province = new HTMLInputFilter().filter(province);
	}

	public String getCity()
	{
		return new HTMLInputFilter().filter(city);
	}

	public void setCity(String city)
	{
		this.city = new HTMLInputFilter().filter(city);
	}

	public String getCounty()
	{
		return new HTMLInputFilter().filter(county);
	}

	public void setCounty(String county)
	{
		this.county = new HTMLInputFilter().filter(county);
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public void setProducts(List<Product> products)
	{
		this.products = products;
	}

	public List<Enterprise> getEnterprises()
	{
		return enterprises;
	}

	public void setEnterprises(List<Enterprise> enterprises)
	{
		this.enterprises = enterprises;
	}

	public Pager getP()
	{
		return p;
	}

	public void setP(Pager p)
	{
		this.p = p;
	}
}

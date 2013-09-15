/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: GetAllPackages.java					
 *			
 * Description:																
 */
package com.bancai.web.pkg;

import java.util.List;

import com.bancai.dao.Package;
import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao
 *
 */
public class GetAllPackagesAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4725928069119313409L;
	List<Package> packages;
	
	@Override
	public String execute() throws Exception
	{
		PackageService pkgService = new PackageService();
		
		packages = pkgService.getAllPackages();
		
		return SUCCESS;
	}

	public List<Package> getPackages()
	{
		return packages;
	}

	public void setPackages(List<Package> packages)
	{
		this.packages = packages;
	}
}

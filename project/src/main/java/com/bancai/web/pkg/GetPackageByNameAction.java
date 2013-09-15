/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: GetPackageByName.java					
 *			
 * Description:																
 */
package com.bancai.web.pkg;

import com.bancai.dao.Package;
import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao
 *
 */
public class GetPackageByNameAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7395854067522914271L;
	Package packageInfo = new Package();
	String pkgName;
	
	@Override
	public String execute() throws Exception 
	{
		PackageService pkgService = new PackageService();
		
		try 
		{
			packageInfo = pkgService.getPackageByName(pkgName);
		}
		catch(Exception ex)
		{
			return INPUT;
		}
		
		return SUCCESS;
	}

	public Package getPackageInfo()
	{
		return packageInfo;
	}

	public void setPackageInfo(Package packageInfo)
	{
		this.packageInfo = packageInfo;
	}

	public String getPkgName()
	{
		return pkgName;
	}

	public void setPkgName(String pkgName)
	{
		this.pkgName = pkgName;
	}
}

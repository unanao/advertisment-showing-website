/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: DeletePkgByNameAction.java					
 *			
 * Description:	根据包名删除对应套餐															
 */
package com.bancai.web.admin.pkg;

import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao
 *
 */
public class DeletePkgByNameAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3323748177425198580L;
	String pkgName;
	
	@Override
	public String execute() throws Exception
	{
		PackageService pkgService = new PackageService();
		
		pkgService.deletePkgByName(pkgName);
		
		return SUCCESS;
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

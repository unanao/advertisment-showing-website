package com.bancai.web.pkg;

import java.util.List;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.Package;
import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionSupport;

public class GetPurchaseAndPackageByNameAction extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = 6646592450546672374L;
	List<Package> packages;
	List<Package> purchasePackages;
	String userName;

	@Override
	public String execute() throws Exception {
		PackageService pkgService = new PackageService();
		Logger logger = Logger.getLogger(GetPurchaseAndPackageByNameAction.class);
		
		try {
			packages = pkgService.getAllPackages();
			purchasePackages = pkgService.getPackagesByName(userName);
			
			return SUCCESS;
		} catch (Exception ex) {
			logger.log(Level.FATAL, "get package info by pkgId error", ex);
			addActionError("我们遇到了技术问题，请截图把信息发给我们，帮我们完善服务");
			return ERROR;
		}
	}
	
	public List<Package> getPackages() {
		return packages;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public List<Package> getPurchasePackages()
	{
		return purchasePackages;
	}
}

package com.bancai.web.pkg;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.Package;
import com.bancai.service.PackageService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetPackageInfoAction extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = 6646592450546672374L;
	List<Package> packages; 

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		int enterpriseId = (Integer) session.get(SESSION_ENTERPRISE_ID);
		PackageService pkgService = new PackageService();
		Logger logger = Logger.getLogger(GetPackageInfoAction.class);
		
		try {
			packages = pkgService.getPackagesByEnterpriseId(enterpriseId);
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
}

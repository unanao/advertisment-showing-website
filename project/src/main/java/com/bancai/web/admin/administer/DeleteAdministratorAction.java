package com.bancai.web.admin.administer;

import com.bancai.service.AdministratorService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteAdministratorAction extends ActionSupport {
	private static final long serialVersionUID = 4677628242031235325L;
	private String adminName;
 
	@Override
	public String execute() throws Exception {
		String ret = INPUT;
		AdministratorService administratorService = new AdministratorService();
		
		administratorService.deleteByAdminName(adminName);
		
		return ret;
	}

	public void setUserName(String adminName) {
		this.adminName = adminName;
	}
	
	public String getUserName() {
		return adminName;
	}
}

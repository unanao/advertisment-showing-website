package com.bancai.web.admin.administer;

import com.bancai.constants.AdminConstants;
import com.bancai.constants.CommonConstants;
import com.bancai.service.AdministratorService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao <jianjiaosun@163.com>
 * 
 */
public class AddAdministraorAction extends ActionSupport implements AdminConstants, CommonConstants {
	private static final long serialVersionUID = 1L;
	private String adminName;
	private String password;
	private String passwordConfirm;

	@Override
	public String execute() throws Exception {
		String ret = INPUT;
		AdministratorService adminService = new AdministratorService();
	
		if ((true == adminService.isAdminNameAvaliable(adminName))) {
			adminService.addAdministrator(adminName, password, ADMIN_GROUP_SUPER);
			ret = SUCCESS;
		} else {
			ret = INPUT;
			addActionError("管理员的用户名不可用");
		}
		

		return ret;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}
}

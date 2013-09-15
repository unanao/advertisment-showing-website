package com.bancai.web.admin.administer;

import java.util.Map;

import com.bancai.constants.AdminConstants;
import com.bancai.service.AdministratorService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangeAdminPasswordAction extends ActionSupport implements AdminConstants {
	private static final long serialVersionUID = 4677628242031235325L;
	Integer id;
	String code;
	private String newPassword;
	private String passwordConfirm;
	private String oldPassword;

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		AdministratorService adminService = new AdministratorService();
		String adminName = (String) session.get(SESSION_ADMIN_NAME);
		
		
		if (true != adminService.adminAuth(adminName, oldPassword)) {
			addActionError("原始密码错误");
			return INPUT;
		}
		
		if (true == newPassword.equals(passwordConfirm)) {
			adminService.changePasswordByAdminName(adminName, newPassword);
			return SUCCESS;
		} else {
			addActionError("两次输入密码不匹配");
			return INPUT;
		}
			

	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}
}

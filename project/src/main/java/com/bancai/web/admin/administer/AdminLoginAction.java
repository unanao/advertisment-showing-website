package com.bancai.web.admin.administer;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bancai.constants.AdminConstants;
import com.bancai.constants.CommonConstants;
import com.bancai.service.AdministratorService;
import com.bancai.dao.Administrator;

/**
 * 管理员登录
 */
public class AdminLoginAction extends ActionSupport implements AdminConstants, CommonConstants {
	private static final long serialVersionUID = 1L;

	private String name;
	private String password;
	private String verifyCode;
	AdministratorService administratorService = new AdministratorService();
	Administrator admin = new Administrator();

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String expectVerifyCode = (String) session.get(SESSION_AUTH);
		Integer adminId;

		session.put(SESSION_AUTH, null);

		/*
		 * 对于管理员，用户体验重要性没有安全性重要，每次都输入验证码
		 */
		if ((null != expectVerifyCode)
				&& (!verifyCode.equalsIgnoreCase(expectVerifyCode))) {
			addActionError("请输入正确的验证码!");
			return INPUT;
		}

		/**
		 * 用户名和密码不匹配
		 */
		if (true != administratorService.adminAuth(name, password)) {
			addActionError("不要尝试登陆了");

			return INPUT;
		}

		adminId = administratorService.getAdministratorByName(name).getId();
		
		session.put(SESSION_ADMIN_ID, adminId);
		session.put(SESSION_ADMIN_NAME, name);
		return SUCCESS;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}
}

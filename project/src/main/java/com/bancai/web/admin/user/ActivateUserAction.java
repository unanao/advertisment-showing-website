package com.bancai.web.admin.user;

import com.opensymphony.xwork2.ActionSupport;

import com.bancai.service.UserService;
import com.bancai.constants.AccountsContants;

public class ActivateUserAction extends ActionSupport implements AccountsContants {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2836702246131034066L;
	String userName;

	@Override
	public String execute() throws Exception {
		Integer primaryKey;
		UserService userService = new UserService();

		try {
			primaryKey = userService.getUserIdByUserName(userName);
			userService.changeAccountsStatus(primaryKey, ACTIVATED);
			return SUCCESS;

		} catch (Exception e) {
			return NONE;
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUsername() {
		return userName;
	}
}

package com.bancai.web.admin.user;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.UserActivation;
import com.bancai.dao.UserActivationDAO;
import com.bancai.service.UserService;
import com.bancai.utils.email.SendEmailUtils;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
	private String userName;
	String password;
	String passwordConfirm;
	SendEmailUtils sendEmailUtil = new SendEmailUtils();
	UserActivation userActivation = new UserActivation();
	UserActivationDAO userActivationDao = new UserActivationDAO();
 
	/**
	 * 首先判断邮箱是否被注册 邮箱没有被注册 发送激活邮件 用户激活后完成整个注册过程 邮箱已经被注册
	 * 激活邮件已经失效，直接修改已注册用户的密码为新注册的密码 激活邮件还没有失效 提示：该邮箱以被注册，但未激活，请到验证邮件中激活
	 */
	@Override
	public String execute() throws Exception {
		String ret = INPUT;
		UserService accountsService = new UserService();
		
		if (true != password.equals(passwordConfirm)) {
			addActionError("您两次输入的密码不一致，请重新输入");
			return INPUT;
		}
		
		accountsService.changePasswordByUserName(userName, password);
		
				

		return ret;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
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

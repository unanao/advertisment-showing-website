package com.bancai.web.pcenter;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.service.UserService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
	Integer id;
	String code;
	private String newPassword;
	private String passwordConfirm;
	private String oldPassword;

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserService accountsService = new UserService();
		Integer userId = (Integer) session.get(SESSION_USER_ID);
		
		if (null == userId) {
			addActionError("您还没有登陆");
			return INPUT;
		}
		
		try {
			if (true == accountsService.userAuthentication(userId, oldPassword)) {
				if (true == newPassword.equals(passwordConfirm)) {
					accountsService.changePassword(userId, newPassword);
					addActionError("修改密码成功");
					return SUCCESS;
				} else {
					addActionError("两次输入密码不匹配");
					return INPUT;
				}
			}
			else {
				addActionError("原始密码错误");
				return INPUT;
			}
		} catch (RuntimeException re) {
			addActionError("账户不存在");
			return INPUT;
		}
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = new HTMLInputFilter().filter(newPassword);
	}

	public String getNewPassword() {
		return new HTMLInputFilter().filter(newPassword);
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = new HTMLInputFilter().filter(passwordConfirm);
	}

	public String getPasswordConfirm() {
		return new HTMLInputFilter().filter(passwordConfirm);
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = new HTMLInputFilter().filter(oldPassword);
	}

	public String getOldPassword() {
		return new HTMLInputFilter().filter(oldPassword);
	}
}

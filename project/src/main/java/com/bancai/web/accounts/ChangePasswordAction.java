package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.UserActivation;
import com.bancai.dao.UserActivationDAO;
import com.bancai.service.UserService;
import com.bancai.service.UserActivationService;
import com.bancai.utils.email.SendEmailUtils;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
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
		Map<String, Object> session = ActionContext.getContext().getSession();
		String ret = INPUT;
		String code = (String) session.get(SESSION_CERTIFICATION_CODE);
		Integer id = (Integer) session.get(SESSION_CERTIFICATION_ID);
		UserService accountsService = new UserService();
		UserActivationService userActivationService = new UserActivationService();
		
		if (null == code || null == id) {
			addActionError("您没有权限修改密码，修改密码的链接已经失效");
			return NONE; 
		}

		if (true != password.equals(passwordConfirm)) {
			addActionError("您两次输入的密码不一致，请重新输入");
			return INPUT;
		}
		
		/**
		 * 用户输入的密码一致，不需要用户重新到达此页面，立即清空session
		 */
		session.put(SESSION_CERTIFICATION_CODE, null);
		session.put(SESSION_CERTIFICATION_ID, null);
		
		try {
			userActivation = userActivationService
					.getUserActivationByUserId(id);
			if (true == code.equals(userActivation.getCode())) {
				if (true != userActivationService.isActivateEmailOutdate(id)) {
					accountsService.changePassword(id, password);
					ret = SUCCESS;
				} else {
					addActionError("您的链接已经过期");
					ret = ERROR;
				}
			} else {
				addActionError("您由于修改密码的验证码已经过期");
				ret = ERROR;
			}
			
			/**
			 * 链接只可以使用一次，使用后，立即删除对应的行
			 */
			userActivationService.deleteByForeignKey(id);
			
		} catch (RuntimeException e) {
			addActionError("没有执行找回密码操作之前，不能进行此操作");
			ret = NONE;
		}

		return ret;
	}

	public void setPassword(String password) {
		this.password = new HTMLInputFilter().filter(password);
	}

	public String getPassword() {
		return new HTMLInputFilter().filter(password);
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = new HTMLInputFilter().filter(passwordConfirm);
	}

	public String getPasswordConfirm() {
		return new HTMLInputFilter().filter(passwordConfirm);
	}
}

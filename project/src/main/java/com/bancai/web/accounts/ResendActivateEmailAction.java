package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserService;
import com.bancai.utils.email.SendEmailUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao <jianjiaosun@163.com>
 * 
 */
public class ResendActivateEmailAction extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = 1L;
	SendEmailUtils sendEmailUtil = new SendEmailUtils();
	UserService userService = new UserService();
	AccountsCommon accountsCommon = new AccountsCommon();
	Integer primaryKey;
	UserActivationService userActivationService = new UserActivationService();


	/**
	 * 首先判断邮箱是否被注册 邮箱没有被注册 发送激活邮件 用户激活后完成整个注册过程 邮箱已经被注册
	 * 激活邮件已经失效，直接修改已注册用户的密码为新注册的密码 激活邮件还没有失效 提示：该邮箱以被注册，但未激活，请到验证邮件中激活
	 */
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String email = (String) session.get(SESSION_UNACTIVE_EMAIL);
		String ret;
		
		if (true == userService.isEmailActivatedByUserName(email)) {
			addActionError("您的用户已经激活, 请直接登陆");
			return ERROR;
		}

		ret = accountsCommon.sendSaveActivateCode(email);
		if (INPUT == ret) {
			addActionError("您今天激活邮件的发送次数已经达到最大次数，请明天再试");
		}

		return ret;
	}
}

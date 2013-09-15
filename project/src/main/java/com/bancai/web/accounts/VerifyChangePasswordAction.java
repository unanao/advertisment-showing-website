package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.dao.UserActivation;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserService;
import com.bancai.utils.email.SendEmailUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class VerifyChangePasswordAction extends ActionSupport implements
		AccountsContants, CommonConstants {
	private static final long serialVersionUID = 4677628242031235325L;
	Integer id;
	String code;
	SendEmailUtils sendEmailUtil = new SendEmailUtils();
	UserActivation userActivation = new UserActivation();
	UserService userService = new UserService();

	/**
	 * 首先判断邮箱是否被注册 邮箱没有被注册 发送激活邮件 用户激活后完成整个注册过程 邮箱已经被注册
	 * 激活邮件已经失效，直接修改已注册用户的密码为新注册的密码 激活邮件还没有失效 提示：该邮箱以被注册，但未激活，请到验证邮件中激活
	 */
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String ret = INPUT;
		UserActivationService userActivationService = new UserActivationService();
		
		try {
			userActivation = userActivationService.getUserActivationByUserId(id);
			if (true != userActivationService.isActivateEmailOutdate(id)) {
				if (true == code.equals(userActivation.getCode())) {
					session.put(SESSION_CERTIFICATION_CODE, code);
					session.put(SESSION_CERTIFICATION_ID, id);
					ret = SUCCESS;
				} else {
					ret = ERROR;
				}
			} else {
				ret = INPUT;
			}
		} catch (RuntimeException e) {
			ret = NONE;
		}

		return ret;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}
}

package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.service.UserService;
import com.bancai.service.UserActivationService;
import com.bancai.utils.email.SendEmailUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EmailActivationAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
	Integer id;
	String code;
	SendEmailUtils sendEmailUtil = new SendEmailUtils();
	UserActivationService userActivationService = new UserActivationService();

	/**
	 * 首先判断邮箱是否被注册 邮箱没有被注册 发送激活邮件 用户激活后完成整个注册过程 邮箱已经被注册
	 * 激活邮件已经失效，直接修改已注册用户的密码为新注册的密码 激活邮件还没有失效 提示：该邮箱以被注册，但未激活，请到验证邮件中激活
	 */
	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		UserService accountsService = new UserService();
		String ret;

		try {
			if (true != userActivationService.isActivateEmailOutdate(id)) {
				if (true == code.equals(userActivationService.getActivateCodeByforeignKey(id))) {
					accountsService.changeAccountsStatus(id, ACTIVATED);
					
					/**
					 * 用户激活成功后，不再需要此id对应的行，删除
					 */
					userActivationService.deleteByForeignKey(id);
					
					session.put(SESSION_USER_ID, id);
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

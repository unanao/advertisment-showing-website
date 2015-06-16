package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.constants.EmailConstants;
import com.bancai.dao.User;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserService;
import com.bancai.utils.email.SendEmailUtils;
import com.bancai.utils.xss.HTMLInputFilter;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport implements
		AccountsContants, CommonConstants {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String verifyCode;
	SendEmailUtils sendEmailUtil = new SendEmailUtils();
	UserService accountsService = new UserService();
	AccountsCommon accountsCommon = new AccountsCommon();
	UserActivationService userActivationService = new UserActivationService();
	User user = new User();

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		String expectVerifyCode = (String) session.get(SESSION_AUTH);
		String content;
		String activateCode;
		long curTime = System.currentTimeMillis();
		Integer primaryKey;
		Integer status;

		/*
		 * 清空验证码
		 */
		session.put(SESSION_AUTH, null);

		if ((null != expectVerifyCode)
				&& (expectVerifyCode.equalsIgnoreCase(verifyCode))) {
			
			/**
			 * 首先要保证用户存在
			 */
			try {
				user = accountsService.getUserByUserName(userName);
				primaryKey = user.getId();
				status = user.getStatus();
				
				session.put(SESSION_UNACTIVE_EMAIL, userName);
			} catch (Exception e) {
				addActionError("用户不存在");
				return NONE;
			}

			/**
			 * 对用户状态进行判断,只有激活了才可以找回密码
			 */
			if (UNACTIVATED == status) {
				if (true == userActivationService.isActivateEmailOutdate(primaryKey)) {
					addActionError("用户名激活时间已经过期， 请重新注册");
					return INPUT;
				} else {
					return ACTION_UNACTIVATED;
				}
			} else if (FREEZED == status) {
				addActionError("您的用户已经被冻结");
				return ACTION_FREEZED;
			}
				
			try {
				activateCode = accountsCommon.getCertificationCode();
			} catch (Exception e) {
				return ERROR;
			}

			content = accountsCommon.getPasswordEmailContent(userName, primaryKey,
					activateCode, curTime);
			if (null == content) {
				addActionError("用户名不存在");
				return INPUT;
			}

			try {
				String subject = EmailConstants.SITE_NAME_QUOTA + EmailConstants.GETPASSWD_SUBJECT;
				
				if (ERROR == accountsCommon.sendSaveCertificationCode(primaryKey, userName,
						                                                           activateCode, subject, content, curTime))
				{
					addActionError("您已经超过尝试找回密码的次数，请明天再试！");
					return ERROR;
				}
			} catch (Exception e) {
				e.printStackTrace();
				addActionError("发送获取密码邮件失败");
				return ERROR;
			}

			return SUCCESS;

		} else {
			addActionError("验证码不匹配，请重新输入");
			return INPUT;
		}
	}

	/**
	 * get set 方法
	 */
	public String getUserName() {
		return new HTMLInputFilter().filter(userName);
	}

	public void setUserName(String userName) {
		this.userName = new HTMLInputFilter().filter(userName);
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
}

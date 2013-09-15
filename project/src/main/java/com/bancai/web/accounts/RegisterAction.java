package com.bancai.web.accounts;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao <jianjiaosun@163.com>
 * 
 */
public class RegisterAction extends ActionSupport implements AccountsContants,
		CommonConstants
{
	private static final long serialVersionUID = 1L;
	private static final String AGREEMENT_STR = "agreement";
	private String userName;
	private String password;
	private String passwordConfirm;
	private String verifyCode;
	private String agreement;

	/**
	 * @param userName
	 *            用户注册的登陆名
	 * @param password
	 *            用户注册的密码
	 * @return
	 */
	private String addAccount(String userName, String password)
	{
		UserService userService = new UserService();
		AccountsCommon accountsCommon = new AccountsCommon();
		Map<String, Object> session = ActionContext.getContext().getSession();

		userService.addAccount(userName, password);

		session.put(SESSION_UNACTIVE_EMAIL, userName);
		try
		{
			accountsCommon.sendSaveActivateCode(userName);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	/**
	 * 首先判断邮箱是否被注册 邮箱没有被注册 发送激活邮件 用户激活后完成整个注册过程 邮箱已经被注册
	 * 激活邮件已经失效，直接修改已注册用户的密码为新注册的密码 激活邮件还没有失效 提示：该邮箱以被注册，但未激活，请到验证邮件中激活
	 */
	@Override
	public String execute() throws Exception
	{
		String ret;
		UserService userService = new UserService();
		Integer userId;
		UserActivationService userActivationService = new UserActivationService();
		AccountsCommon common = new AccountsCommon();
		Map<String, Object> session = ActionContext.getContext().getSession();

		if (true == common.isVerifyCodeValidate(verifyCode))
		{
			session.put(CommonConstants.SESSION_AUTH, null);
			
			if ((null == agreement)
					|| (!agreement.equalsIgnoreCase(AGREEMENT_STR)))
			{
				addActionError("您必须同意服务条款");
				return INPUT;
			}

			if ((true == userService.isUserNameAvailable(userName)))
			{
				ret = addAccount(userName, password);
			}
			else
			{
				userId = userService.getUserIdByUserName(userName);

				if (true == userService.isEmailActivatedByUserId(userId))
				{
					addActionError(userName + "已经被注册");
					ret = INPUT;
				}
				else if (true == userActivationService
						.isActivateEmailOutdate(userId))
				{
					userService.deleteUserByUserId(userId);
					ret = addAccount(userName, password);
				}
				else
				{
					addActionError("该邮箱已被注册，但未激活，请到验证邮件中激活");
					ret = INPUT;
				}
			}
		}
		else
		{
			addActionError("验证码不匹配，请重新输入");
			ret = INPUT;
		}

		return ret;
	}

	public void setUserName(String userName)
	{
		this.userName = new HTMLInputFilter().filter(userName);
	}

	public String getUserName()
	{
		return new HTMLInputFilter().filter(userName);
	}

	public void setPassword(String password)
	{
		this.password = new HTMLInputFilter().filter(password);
	}

	public String getPassword()
	{
		return new HTMLInputFilter().filter(password);
	}

	public void setPasswordConfirm(String passwordConfirm)
	{
		this.passwordConfirm = new HTMLInputFilter().filter(passwordConfirm);
	}

	public String getPasswordConfirm()
	{
		return new HTMLInputFilter().filter(passwordConfirm);
	}

	public void setVerifyCode(String verifyCode)
	{
		this.verifyCode = verifyCode;
	}

	public String getVerifyCode()
	{
		return verifyCode;
	}

	public String getAgreement()
	{
		return agreement;
	}

	public void setAgreement(String agreement)
	{
		this.agreement = agreement;
	}
}

package com.bancai.web.accounts;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.constants.EmailConstants;
import com.bancai.constants.SessionConstants;
import com.bancai.dao.UserActivation;
import com.bancai.service.UserActivationService;
import com.bancai.service.UserService;
import com.bancai.utils.CharStringUtils;
import com.bancai.utils.TimeDateUtils;
import com.bancai.utils.email.SendEmailUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AccountsCommon extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = 2326027282479987929L;
	UserActivationService userActivationService = new UserActivationService();
	SendEmailUtils sendEmailUtils = new SendEmailUtils();
	UserActivation userActivation = new UserActivation();
	UserService userService = new UserService();
	Logger logger = Logger.getLogger(AccountsCommon.class);

	/**
	 * @return 获取发送邮件激活和修改密码是验证码
	 */
	public String getCertificationCode() {
		CharStringUtils charString = new CharStringUtils();

		return DigestUtils.md5Hex(charString.getRandStrByLen(EMAIL_CERTIFICATION_CODE_LEN)
				+ System.currentTimeMillis());
	}

	/**
	 * @param curTime
	 *            发送验证邮件的时间
	 * @return 过期的时间
	 */
	public String getOutdateTimeTips(long curTime) {
		TimeDateUtils timeDateUtils = new TimeDateUtils();
		
		return timeDateUtils.convertTime2DateFormat(curTime + CERTIFICATION_OVERDUE_MILLISECONDS);
	}

	/**
	 * @param userId
	 *            user表主键
	 * @param activateCode
	 *            激活验证码
	 * @return 激活邮件正文
	 */
	public String getActivateContent(Integer userId, String activateCode,
			long curTime) {		
		String bancaiWelcome = EmailConstants.ACTIVATION_WELCOME + EmailConstants.SITE_NAME_QUOTA + "<br>";

		String click4Activate = EmailConstants.ACTIVATION_CONTENT_CLICK
				+ "<br>";

		String activationUrl = EmailConstants.SITE_URL + EmailConstants.ACCOUNTS_URI
				+ EmailConstants.ACTIVATION_URI + "id=" + userId + "&code="
				+ activateCode;
		String activationLink = "<a href =" + activationUrl + ">"
				+ activationUrl + "</a>" + "<br>";

		String copy2Activate = EmailConstants.ACTIVATION_CONTENT_COPY + 
				EmailConstants.SITE_NAME_QUOTA + EmailConstants.ACTIVATION_CONTENT_COPY_END + "<br>";

		String onceTips = EmailConstants.EMAIL_CLICK_ONCE + "<br>";

		String outdate = getOutdateTimeTips(curTime);
		String outdateTips = EmailConstants.EMAIL_OUTDATE_FRONT + outdate
				+ EmailConstants.EMAIL_OUTDATE_BEHIND
				+ EmailConstants.SITE_NAME_QUOTA 
				+ EmailConstants.EMAIL_RECOVER_ACCOUNT + "<br>";

		String ignore = EmailConstants.ACTIVATION_CONTENT_IGNORE + "<br>";

		String auto = EmailConstants.EMAIL_AUTO + "<br>";


		String content = bancaiWelcome + click4Activate + activationLink
				+ copy2Activate + onceTips + outdateTips + ignore + auto;

		return content;
	}

	/**
	 * @param userName
	 *            用户名
	 * @param activateCode
	 *            激活验证码
	 * @return 激活邮件正文
	 */
	public String getPasswordEmailContent(String userName, Integer primaryKey,
			String activateCode, long curTime) {
		String url;
		String link;
		String bancai = EmailConstants.SITE_NAME + "<br>";

		String clickTips = EmailConstants.GETPASSWD_CONTENT_CLICK + "<br>";

		url = EmailConstants.SITE_URL + EmailConstants.ACCOUNTS_URI + EmailConstants.GETPASSWD_URL
				+ "id=" + primaryKey + "&code=" + activateCode;
		link = "<a href =" + url + ">" + url + "</a>" + "<br>";

		String copy2Activate = EmailConstants.ACTIVATION_CONTENT_COPY + "<br>";

		String onceTips = EmailConstants.EMAIL_CLICK_ONCE + "<br>";

		String outdate = getOutdateTimeTips(curTime);
		String outdateTips = EmailConstants.EMAIL_OUTDATE_FRONT + outdate
				+ EmailConstants.EMAIL_OUTDATE_BEHIND + "<br>";

		String auto = EmailConstants.EMAIL_AUTO + "<br>";

		String content = bancai + clickTips + link + copy2Activate + onceTips
				+ outdateTips + auto;

		return content;
	}

	/**
	 * 
	 * 如果用户验证信息在数据库中，需要先进行判断是否达到用户每天发送验证邮件的个数的上线，如果没有达到上线修改时间和激活码；
	 * 如果用户的验证信息不在数据库中，新增验证的内容
	 * 
	 * @param userId
	 *            User id
	 * @param email
	 *            注册邮箱(用户名)
	 * @throws IOExceptiouserNamen
	 * @throws MessagingException
	 */
	public String sendSaveCertificationCode(Integer userId, String email,
			String activateCode, String subject, String content, long time)
			throws IOException, MessagingException {
		Map<String, Object> session = ActionContext.getContext().getSession();
		TimeDateUtils timeDateUtils = new TimeDateUtils();
		long sendTime;
		long curTime;
		int counts;

		try {
			userActivation = userActivationService
					.getUserActivationByUserId(userId);

			sendTime = userActivationService.getTimeByUserId(userId);
			curTime = System.currentTimeMillis();

			if (true == timeDateUtils.isInSameDay(sendTime, curTime)) {
				counts = userActivation.getCounts();
				if (counts > CERTIFICATION_BEYOND_COUNTS) {
					return INPUT;
				} else {
					counts++;
				}
			} else {
				counts = 0;
			}

			userActivationService.changeActivateCode(userId, activateCode,
					time, counts);

		} catch (Exception e) {
			// 将激活码存入数据库
			userActivationService.addActivateCode(userId, activateCode, time);
		}

		// 发送激活邮件
		sendEmailUtils.send2SpecifiedEmail(email, subject, content);

		// 用于验证邮件发送后打印用户的邮箱
		session.put(SESSION_EMAIL, email);

		return SUCCESS;
	}

	/**
	 * @param userName
	 *            用户名
	 * @return
	 */
	public String sendSaveActivateCode(String userName) {
		try {
			Integer primaryKey = userService.getUserIdByUserName(userName);
			String activateCode = getCertificationCode();
			long time = System.currentTimeMillis();
			String subject = EmailConstants.ACTIVATION_WELCOME  + 
					EmailConstants.SITE_NAME_QUOTA + EmailConstants.ACTIVATION_VERIFY_MAIL;

			String content = getActivateContent(primaryKey, activateCode, time);
			return sendSaveCertificationCode(primaryKey, userName, activateCode,
															      subject, content, time);

		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	/**
	 * 添加用户登录后的session
	 * @param userId 
	 */
	public void addLoginSessions(Integer userId)
	{
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		addLoginSessions(session, userId);
	}

	/**
	 * 添加用户登录后的session
	 * @param userId
	 */
	public void addLoginSessions(HttpSession session, Integer userId) {
		
		UserService userService = new UserService();
		
		try {
			Integer enterpriseId = userService.getEnterpriseIdByUserId(userId);
			String userName = userService.getNameByUserId(userId);
		
			session.setAttribute(SessionConstants.SESSION_USER_ID, userId);
			session.setAttribute(SessionConstants.SESSION_ENTERPRISE_ID, enterpriseId);
			session.setAttribute(SessionConstants.SESSION_LOGIN_NAME, userName);
		} catch(Exception e) {
			logger.log(Level.FATAL, "put login session error ", e);
		}
	}
	
	public boolean isVerifyCodeValidate(String verifyCode)
	{
		Map<String, Object> session = ActionContext.getContext().getSession();
		String expectVerifyCode = (String) session.get(CommonConstants.SESSION_AUTH);
		
		if ((null != expectVerifyCode) && (expectVerifyCode.equalsIgnoreCase(verifyCode))) 
		{
			return true;
		}
		
		return false;
	}

}

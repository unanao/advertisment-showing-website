package com.bancai.constants;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.bancai.utils.ConfigurationUtil;

/**
 * 
 * @author zhangyanjiang(zhyanjiang@126.com)
 * 
 */
public final class EmailConstants {
	public final static String SITE_NAME_QUOTA;
	public final static String SITE_NAME;
	
	// email activation
	public final static String ACTIVATION_URI;
	public final static String SERVER_MAIL;
	public final static String SERVER_MAIL_PASSWD;
	public final static String SERVER_MAIL_SMTP_HOST;
	public final static String SITE_URL;
	public final static String ACCOUNTS_URI;
	public final static String REGISTER_URI;
	public final static String EMAIL_AUTO;
	public final static String EMAIL_CLICK_ONCE;
	public final static String EMAIL_OUTDATE_FRONT;
	public final static String EMAIL_OUTDATE_BEHIND;
	public final static String EMAIL_RECOVER_ACCOUNT;

	public final static String ACTIVATION_WELCOME;
	public final static String ACTIVATION_VERIFY_MAIL;
	public final static String ACTIVATION_CONTENT_CLICK;
	public final static String ACTIVATION_CONTENT_COPY;
	public final static String ACTIVATION_CONTENT_COPY_END;
	public final static String ACTIVATION_CONTENT_IGNORE;

	// email getpasswd
	public final static String GETPASSWD_SUBJECT;
	public final static String GETPASSWD_URL;
	public final static String GETPASSWD_CONTENT_CLICK;

	static {
		final Logger logger = Logger.getLogger("Email configuration");
		logger.info("++++++++++++Email configuration information++++++++++++");
		try {

			Properties p = new ConfigurationUtil()
					.getPropertyFileConfiguration("email.properties");
			SERVER_MAIL = p.getProperty("SERVER_MAIL",
					"invitation@free4lab.com");
			SERVER_MAIL_PASSWD = p
					.getProperty("SERVER_MAIL_PASSWD", "telestar");
			SERVER_MAIL_SMTP_HOST = p.getProperty("SERVER_MAIL_SMTP_HOST",
					"smtp.exmail.qq.com");
			SITE_URL = p.getProperty("SITE_URL", "http://localhost:8080/bancai");
			ACCOUNTS_URI = p.getProperty("ACCOUNTS_URI",
					"/accounts/");
			
			SITE_NAME_QUOTA=p.getProperty("SITE_NAME_QUOTA", "我发板材网:");
			SITE_NAME  = p.getProperty("SITE_NAME", "我发板材网:");
					
			EMAIL_AUTO = p.getProperty("EMAIL_AUTO");
			EMAIL_CLICK_ONCE = p.getProperty("EMAIL_CLICK_ONCE");
			EMAIL_OUTDATE_FRONT = p.getProperty("EMAIL_OUTDATE_FRONT");
			EMAIL_OUTDATE_BEHIND = p.getProperty("EMAIL_OUTDATE_BEHIND");
			EMAIL_RECOVER_ACCOUNT = p.getProperty("EMAIL_RECOVER_ACCOUNT");

			/*
			 * 激活邮件
			 */
			ACTIVATION_URI = p.getProperty("ACTIVATION_URI",
					"RegisterActivation.jsp?");
			ACTIVATION_WELCOME=p.getProperty("ACTIVATION_WELCOME", "欢迎注册我发板材网");
			ACTIVATION_VERIFY_MAIL = p.getProperty("ACTIVATION_VERIFY_MAIL");
			ACTIVATION_CONTENT_CLICK = p.getProperty("ACTIVATION_CONTENT_CLICK");
			ACTIVATION_CONTENT_COPY = p.getProperty("ACTIVATION_CONTENT_COPY");
			ACTIVATION_CONTENT_COPY_END = p.getProperty("ACTIVATION_CONTENT_COPY_END");
			ACTIVATION_CONTENT_IGNORE = p.getProperty("ACTIVATION_CONTENT_IGNORE");
			REGISTER_URI = p.getProperty("REGISTER_URI");

			/*
			 * 修改密码
			 */
			GETPASSWD_SUBJECT = p.getProperty("GETPASSWD_SUBJECT", "58板材网密码找回");
			GETPASSWD_URL = p.getProperty("GETPASSWD_URL", "verifyChangePassword?");
			GETPASSWD_CONTENT_CLICK = p.getProperty("GETPASSWD_CONTENT_CLICK",
					"点击下面的链接找回您的密码：");

		} catch (IOException e) {
			logger.fatal("Failed to init email configuration", e);
			throw new RuntimeException("Failed to init email configuration", e);
		}
		logger.info("----------Email configuration successfully----------");
	}
}

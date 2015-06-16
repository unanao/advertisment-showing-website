package com.bancai.utils.email;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import com.bancai.utils.CharStringUtils;
import com.bancai.constants.AccountsContants;
import com.bancai.constants.EmailConstants;
import com.bancai.service.UserService;
import com.bancai.service.UserActivationService;

/**
 * @author unanao 发送电子邮件的函数
 */
public class SendEmailUtils implements AccountsContants {
	UserService accountsService = new UserService();
	CharStringUtils charStringUtils = new CharStringUtils();
	UserActivationService userActivationService = new UserActivationService();
	Integer id;

	/**
	 * @param email
	 *            注册邮箱
	 * @param content
	 *            发送内容
	 * @throws IOException
	 * @throws MessagingException
	 */
	public void send2SpecifiedEmail(String email, String subject, String content)
			throws IOException, MessagingException {
		Properties props = new Properties();
		props.put("mail.smtp.host", EmailConstants.SERVER_MAIL_SMTP_HOST);
		props.put("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(EmailConstants.SERVER_MAIL,
						EmailConstants.SERVER_MAIL_PASSWD);
			}
		};
		Session session = Session.getDefaultInstance(props, auth);

		EmailUtils mailUtil = new EmailUtils();
		mailUtil.setMailFrom(EmailConstants.SERVER_MAIL);
		mailUtil.setNickName(EmailConstants.SITE_NAME); //昵称
		mailUtil.setMailTo(email);
		mailUtil.setMsgContent(content);
		mailUtil.setSubject(subject);
		MimeMessage message = mailUtil.getMessage(session);
		Transport.send(message);
	}
}

package com.bancai.utils.email;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.log4j.Logger;

public class EmailUtils {
	final static Logger logger = Logger.getLogger(EmailUtils.class);
	// 要发送Mail地址
	private String mailTo = null;
	// Mail发送的起始地址
	private String mailFrom = null;
	private String nickName = "";
	
	private String messageBasePath = null;
	// Mail主题
	private String subject;
	// Mail内容
	private String msgContent;

	private Vector<String> attachedFileList;
	private String messageContentMimeType = "text/html; charset=gb2312";

	private String mailbccTo = null;
	private String mailccTo = null;
	

	/**
	 * SendMailService 构造子注解。
	 */
	public EmailUtils() {
	}
	
	private String getEncodeNickName(String nick) {
		String nickName  = "";
		
		if ("" != nick)
		{
			try {  
				nickName=javax.mail.internet.MimeUtility.encodeText(nick);  
			} catch (UnsupportedEncodingException e) {  
				e.printStackTrace(); 
			}
		}
		
		return nickName;
	}
	
	public MimeMessage getMessage(Session session) throws IOException,
			MessagingException {
		MimeMessage msg = new MimeMessage(session);
		String fileName = null;
		Multipart mPart = new MimeMultipart();
		if (mailFrom != null) {
			msg.setFrom(new InternetAddress(getEncodeNickName(nickName) + "<" + mailFrom + ">"));
			logger.info("发送人Mail地址：" + mailFrom);
		} else {
			logger.error("没有指定发送人邮件地址！");
			return null;
		}
		if (mailTo != null) {
			InternetAddress[] address = InternetAddress.parse(mailTo);
			msg.setRecipients(Message.RecipientType.TO, address);
			logger.info("收件人Mail地址：" + mailTo);
		} else {
			logger.error("没有指定收件人邮件地址");
			return null;
		}

		if (mailccTo != null) {
			InternetAddress[] ccaddress = InternetAddress.parse(mailccTo);
			logger.info("CCMail地址：" + mailccTo);
			msg.setRecipients(Message.RecipientType.CC, ccaddress);
		}
		if (mailbccTo != null) {
			InternetAddress[] bccaddress = InternetAddress.parse(mailbccTo);
			logger.info("BCCMail地址：" + mailbccTo);
			msg.setRecipients(Message.RecipientType.BCC, bccaddress);
		}
		msg.setSubject(subject);
		InternetAddress[] replyAddress = { new InternetAddress(mailFrom) };
		msg.setReplyTo(replyAddress);
		// create and fill the first message part
		MimeBodyPart mBodyContent = new MimeBodyPart();
		if (msgContent != null)
			mBodyContent.setContent(msgContent, messageContentMimeType);
		else
			mBodyContent.setContent("", messageContentMimeType);
		mPart.addBodyPart(mBodyContent);
		// attach the file to the message
		if (attachedFileList != null) {
			for (Enumeration<String> fileList = attachedFileList.elements(); fileList
					.hasMoreElements();) {
				fileName =  fileList.nextElement();
				MimeBodyPart mBodyPart = new MimeBodyPart();

				// attach the file to the message
				FileDataSource fds = new FileDataSource(messageBasePath
						+ fileName);
				mBodyPart.setDataHandler(new DataHandler(fds));
				mBodyPart.setFileName(MimeUtility.encodeText(fileName));
				mPart.addBodyPart(mBodyPart);
			}
		}
		msg.setContent(mPart);
		msg.setSentDate(new Date());
		return msg;
	}

	public void setAttachedFileList(java.util.Vector<String> filelist) {
		attachedFileList = filelist;
	}


	public void setMailbccTo(String bccto) {
		mailbccTo = bccto;
	}

	public void setMailccTo(String ccto) {
		mailccTo = ccto;
	}

	public void setMailFrom(String from) {
		mailFrom = from;
	}


	public void setMailTo(String to) {
		mailTo = to;
	}

	public void setMessageBasePath(String basePath) {
		messageBasePath = basePath;
	}

	public void setMessageContentMimeType(String mimeType) {
		messageContentMimeType = mimeType;
	}

	public void setMsgContent(String content) {
		msgContent = content;
	}

	public void setSubject(String sub) {
		subject = sub;
	}
	
	public void setNickName(String nick) {
		nickName = nick;
	}
}

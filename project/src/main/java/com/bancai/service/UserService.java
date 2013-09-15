package com.bancai.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.apache.commons.codec.digest.DigestUtils;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.constants.EmailConstants;
import com.bancai.dao.User;
import com.bancai.dao.UserDAO;
import com.bancai.utils.email.EmailUtils;

/**
 * @author unanao <jianjiaosun@163.com>
 * 
 */
/**
 * @author unanao
 *
 */
public class UserService implements AccountsContants, CommonConstants {
	private static final String LOGIN_NAME = "email";
	private static final String STATUS_COLUMN = "status";
	UserDAO userDao = new UserDAO();

	/**
	 * @param UserName
	 *            用户名
	 * @return userInfo : 用户信息 null ：用户信息不存在
	 */
	public User getUserByUserName(String UserName) {		
		try {
			List<User> userInfo = userDao.findByProperty(LOGIN_NAME, UserName);
			
			return userInfo.get(LIST_FIRST_MEMBER);
		} catch (RuntimeException re) {
			return null;
		}
	}

	/**
	 * 检查用户名是否已经被注册
	 * 
	 * @param loginName
	 *            用户登陆时输入的用户名
	 * @return true 用户名可用 false 用户已经被注册，不可用
	 */
	public boolean isUserNameAvailable(String loginName) {
		boolean ret = false;
		UserActivationService active = new UserActivationService();
		Integer userId;

		if (null == getUserByUserName(loginName)) {
			ret = true;
		}
		else
		{
			userId = getUserIdByUserName(loginName);
			if (true == active.isActivateEmailOutdate(userId))
			{
				deleteUserByUserId(userId);
				ret = true;
			}
		}

		return ret;
	}

	/**
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 */
	public void addAccount(String userName, String password) {
		String encryptionPassword = DigestUtils.md5Hex(password);
		long curTime = System.currentTimeMillis();
		Timestamp registerTime = new Timestamp(curTime);
		User user = new User();
		
		user.setEmail(userName);
		user.setPassword(encryptionPassword);
		user.setTime(registerTime);
		user.setEnterprise(DB_INVALID_KEY);
		user.setLoginTimes(0);
		user.setLastLogin(curTime);
		user.setStatus(AccountsContants.UNACTIVATED);

		userDao.save(user);
	}

	/**
	 * @param id
	 *            User表主键
	 * @param password
	 *            密码
	 */
	public void changePassword(Integer id, String password) {
		String encryptionPassword = DigestUtils.md5Hex(password);
		User user = new User();

		user = userDao.findByPrimaryKey(id);
		user.setPassword(encryptionPassword);

		userDao.update(user);
	}
	
	/**
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 */
	public void changePasswordByUserName(String userName, String password) {
		String encryptionPassword = DigestUtils.md5Hex(password);
		User user = new User();

		user = getUserByUserName(userName);
		user.setPassword(encryptionPassword);

		userDao.update(user);
	}

	/**
	 * @param id
	 *            User表主键
	 * @param state
	 *            账户状态
	 */
	public void changeAccountsStatus(Integer id, Integer state) {
		User user = new User();

		user = userDao.findByPrimaryKey(id);
		user.setStatus(state);

		userDao.update(user);
	}

	/**
	 * 
	 * 修改用户基本信息
	 * 由于用户注册时基本信息肯定存在，所以只update就可以了。
	 * 
	 * @param id
	 *            User表主键
	 * @param passwd
	 *            密码
	 */
	public void editPersonalInfo(Integer primaryKey, String nickName, String name,
			String gender, String qq) {
		User user = new User();
		
		/*全部为空时返回*/
		if ((0 != nickName.length()) &&  (0 == gender.length()) && 
			 (0 == qq.length()) && (0 == name.length())) {
			return;
		}
		
		try {
			user = userDao.findByPrimaryKey(primaryKey);
			
			if (0 != nickName.length()) {
				user.setNickname(nickName);
			}
			
			if (0 != gender.length()) {
				user.setGender(gender);
			}
			
			if (0 != qq.length()) {
				user.setQq(qq);
			}
			
			if (0 != name.length()) {
				user.setName(name);
			}

			userDao.updateNoTransaction(user);
		} catch (Exception e) {
			return ;
		}
	}

	/**
	 * @param userId
	 *            user 表主键
	 * @return true 已激活; false
	 */
	public boolean isEmailActivatedByUserId(Integer userId) {
		boolean ret = false;
		User userInfo = userDao.findByPrimaryKey(userId);

		if (null != userInfo && (ACTIVATED == userInfo.getStatus())) {
			ret = true;
		}

		return ret;
	}
		
	/**
	 * @param loginName
	 *            用户名
	 * @return true 已激活; false
	 */
	public boolean isEmailActivatedByUserName(String loginName) {
		boolean ret = false;
		User userInfo = getUserByUserName(loginName);

		if (null != userInfo && (ACTIVATED == userInfo.getStatus())) {
			ret = true;
		}

		return ret;
	}

	/**
	 * @param loginName
	 *            用户登陆名
	 * @return user表对应loginName的主键
	 */
	public Integer getUserIdByUserName(String loginName) {
		User userInfo = getUserByUserName(loginName);

		return userInfo.getId();
	}
	
	
	/**
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId){
		return new UserDAO().findByPrimaryKey(userId);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void updateUser(User user){
		new UserDAO().update(user);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void updateUserNoTransaction(User user){
		new UserDAO().updateNoTransaction(user);
	}
	
	/**
	 * Caution ：只删除了 user 行本身
	 * 通过 User 表的id （primaryKey）删除用户的所有信息
	 * @param userId
	 */
	public void deleteUserByUserId(Integer userId) {
		userDao.deleteByPrimaryKey(userId);
	}
	
	/**
	 * Caution ：只删除了 user 行本身; 无事务保护
	 * 通过 User 表的id （primaryKey）删除用户的所有信息
	 * @param userId
	 */
	public void deleteUserByUserIdNoTranscation(Integer userId) {
		userDao.deleteByPrimaryKeyNoTranscation(userId);
	}
	
	/**
	 * 对用户输入的用户名和密码进行验证
	 * 
	 * @param userId
	 *            user表主键
	 * @param loginPasswd
	 *            用户输入的密码
	 * @return true 用户验证成功 false 验证失败
	 */
	public boolean userAuthentication(Integer userId, String password)
			throws RuntimeException {
		boolean ret;
		String encryptionLoginPassword = DigestUtils.md5Hex(password);

		try {
			User userInfo = userDao.findByPrimaryKey(userId);
			String expectPassword = userInfo.getPassword();

			ret = encryptionLoginPassword.equals(expectPassword);

		} catch (RuntimeException re) {
			ret = false;
		}

		return ret;
	}
	
	/**
	 * 对用户输入的用户ID和密码进行验证
	 * 
	 * @param userId
	 *            user表主键
	 * @param encryptPasswd
	 *            用户输入的密码
	 * @return true 用户验证成功 false 验证失败
	 */
	public boolean encrptPasswdAuthentication(Integer userId, String encryptPasswd)
			throws RuntimeException {
		try {
			User userInfo = userDao.findByPrimaryKey(userId);
			String expectPassword = userInfo.getPassword();

			return encryptPasswd.equals(expectPassword);

		} catch (RuntimeException re) {
			return false;
		}
	}
	
	/**
	 * 通过 userId 获取企业表的enterpriseId
	 * @param userId
	 * @return 企业表的主键
	 */
	public Integer getEnterpriseIdByUserId(Integer userId) {
		User user = getUserByUserId(userId);
		
		return user.getEnterprise();
	}
	
	/**
	 * 通过 userId 获取企业表的enterpriseId
	 * @param userName
	 * @return 企业表的主键
	 */
	public Integer getEnterpriseIdByUserName(String userName) {
		User user = getUserByUserName(userName);
		if (null != user) {
			return user.getEnterprise();
		} else {
			return DB_INVALID_KEY;
		}
	}
	
	/**
	 * @return 获取注册用户的个数
	 */
	public Long registerUserNr() {
		return userDao.count4Table();
	}
	
	/**
	 * 根据用户状态获取此状态的数目
	 * @param status 用户状态
	 * @return 用户状态的数目
	 */
	public Long statusUserNr(int status) {
		return userDao.countByProperty(STATUS_COLUMN, status);
	}
	
	/**
	 * 获取最后一次的登陆时间
	 * @param userId 用户Id
	 * @return 最后一次登陆时间
	 * @throws Exception
	 */
	public Integer getLoginTimesByUserId(int userId) throws Exception {
		User user = new User();
		
		user = getUserByUserId(userId);
		
		return user.getLoginTimes();	
	}
	
	/**
	 * 更新用户注册信息
	 * @param user User
	 */
	public void updateLoginInfo(User user) throws Exception {
		long curTime = System.currentTimeMillis();
		int loginTimes = user.getLoginTimes() + 1;
		
		user.setLoginTimes(loginTimes);
		user.setLastLogin(curTime);
		
		userDao.update(user);
	}
	
	/**
	 * 根据用户Id获取用户名字：如果用户填写了姓名（nickname字段),获取姓名；如果没有则获取登陆名
	 * @param userId 用户id
	 * @return 名字
	 */
	public String getNameByUserId(int userId) {
		User user = new User();
		user = getUserByUserId(userId);
		String nickName;
		
		nickName = user.getNickname();
		if (null != nickName && (0 != nickName.length())) {
			return nickName;
		}
		else {
			return user.getEmail();
		}
	}

	/**
	 * @param email
	 *            注册邮箱
	 * @param subject TODO
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
		mailUtil.setMailTo(email);
		mailUtil.setMsgContent(content);
		mailUtil.setSubject(subject);
		MimeMessage message = mailUtil.getMessage(session);
		Transport.send(message);
	}
}

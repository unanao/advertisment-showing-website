package com.bancai.service;

import java.util.List;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.dao.UserActivation;
import com.bancai.dao.UserActivationDAO;

public class UserActivationService implements AccountsContants, CommonConstants {
	private static final String FOREIGN_KEY_FIELD_NAME = "userId";
	UserActivationDAO userActivationDao = new UserActivationDAO();
	UserActivation userActivation = new UserActivation();

	/**
	 * 通过user_activation表的外键获取 user_activation对应的行
	 * 
	 * @param userId
	 *            user_activation 外键
	 * @return user_activation 外键对应的行
	 * @throws RuntimeException
	 */
	public UserActivation getUserActivationByUserId(Integer userId)
			throws RuntimeException {
		List<UserActivation> userActivation;
		try {
			userActivation = userActivationDao.findByProperty(
					FOREIGN_KEY_FIELD_NAME, userId);

			return userActivation.get(LIST_FIRST_MEMBER);
		} catch (RuntimeException e) {
			return null;
		}
	}

	/**
	 * @param foreignKey
	 *            user_activation表的外键
	 * @return user_activation表外键对应的行
	 */
	private Integer getPrimaryKeyByforeignKey(Integer foreignKey)
			throws RuntimeException {
		userActivation = getUserActivationByUserId(foreignKey);

		return userActivation.getId();
	}

	/**
	 * @param id
	 *            user_acitivation 表的外键
	 * @param activateCode
	 *            激活码
	 */
	public void addActivateCode(Integer id, String activateCode,
			long outdateTime) {
		UserActivation userActivation = new UserActivation(id, activateCode,
				outdateTime, 0);

		userActivationDao.save(userActivation);
	}

	/**
	 * @param userId
	 *            user_activation表的外键
	 * @param activateCode
	 *            激活码
	 * @param time
	 *            发送验证邮件的时间
	 * @param counts
	 *            当天发送验证邮件的次数
	 * @throws RuntimeException
	 */
	public void changeActivateCode(Integer userId, String activateCode,
			long time, int counts) throws RuntimeException {
		userActivation = getUserActivationByUserId(userId);

		userActivation.setCode(activateCode);
		userActivation.setTime(time);
		userActivation.setCounts(counts);

		userActivationDao.update(userActivation);
	}

	/**
	 * @param userId
	 *            user_activation表的外键(User 表的主键id)
	 * @return 发送激活邮件的时间
	 */
	public long getTimeByUserId(Integer userId) throws RuntimeException {
		userActivation = getUserActivationByUserId(userId);
		if (null == userActivation)
		{
			return 0;
		}
		else
		{
			return userActivation.getTime();
		}
	}

	/**
	 * @param foreignKey
	 *            user_activation表的外键(User 表的主键)
	 * @return 用户找回密码和激活的验证码
	 */
	public String getActivateCodeByforeignKey(Integer foreignKey)
			throws RuntimeException {
		userActivation = getUserActivationByUserId(foreignKey);

		return userActivation.getCode();
	}

	/**
	 * @param foreignKey
	 *            user_activation表的外键
	 * @throws RuntimeException
	 */
	public void deleteByForeignKey(Integer foreignKey) throws RuntimeException {
		Integer primaryKey = getPrimaryKeyByforeignKey(foreignKey);

		userActivationDao.deleteByPrimaryKey(primaryKey);
	}

	/**
	 * @param userId
	 *            user_activation表的外键
	 * @throws RuntimeException
	 */
	public void deleteByActivationIdNoTranscation(Integer userId)
			throws RuntimeException {
		if (true == isActivateCodeExist(userId)) {
			Integer activationId = getPrimaryKeyByforeignKey(userId);
			
			userActivationDao.deleteByPrimaryKeyNoTranscation(activationId);
		}
	}

	/**
	 * @param foreignKey
	 *            user_activation表的外键 (User 表的主键)
	 * @return true 激活邮件已经过期; false 还没有过期
	 */
	public boolean isActivateEmailOutdate(Integer foreignKey)
			throws RuntimeException {

		long currentTime = System.currentTimeMillis();
		long outDateTime = getTimeByUserId(foreignKey)
				+ CERTIFICATION_OVERDUE_MILLISECONDS;

		if (currentTime > outDateTime) {
			return true;
		}

		return false;
	}

	/**
	 * @param foreignKey
	 *            user_activation表的外键 (User 表的主键)
	 * @return true 存在; false 不存在
	 */
	public boolean isActivateCodeExist(Integer userId) {
		try {
			getUserActivationByUserId(userId);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * 
	 * 通过userId获取验证信息
	 * 
	 * @param userId
	 *            用户表的主键
	 * @return 验证信息
	 */
	public Integer getUserActivationIdByUserId(Integer userId) {
		try {
			userActivation = getUserActivationByUserId(userId);
			return userActivation.getId();
		} catch (RuntimeException e) {
			return DB_INVALID_KEY;
		}
	}
}

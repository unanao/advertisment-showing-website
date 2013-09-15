package com.bancai.service;

import java.util.List;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.Phone;
import com.bancai.dao.PhoneDAO;

public class PhoneService implements CommonConstants {
	private static final String USER_ID = "user";
	private static final String ENTERPRISE_ID = "enterprise";
	Phone phone = new Phone();
	PhoneDAO phoneDao = new PhoneDAO();

	/**
	 * caution: 对于普通用户不支持联系人姓名，联系人的姓名即为Nick Name
	 * 			  为了保证一致性，不将nickname存入contractor,使用时去
	 *          user表取
	 * 
	 * 根据User外键获取相应的行
	 * 
	 * @param userId
	 *            Phone表的User外键
	 * @return
	 */
	private Phone getPhoneByUserId(Integer userId) {
		try {
			List<Phone> phone = phoneDao.findByProperty(USER_ID, userId);

			return phone.get(LIST_FIRST_MEMBER);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * caution: 对于普通用户不支持联系人姓名，联系人的姓名即为Nick Name
	 * 			  为了保证一致性，不将nickname存入contractor,使用时去
	 *          user表取
	 * 
	 * @param userId 用户ID
	 * @param type   电话号码类型：固话还是手机
	 * @return 
	 * 
	 * BUG：只支持存放一个固话和手机的存放
	 */
	public Phone getPhoneByUserIdType(int userId, String type) {
		try {
			List<Phone> phoneList = phoneDao.findByUserIdType(userId, type);
			
			return phoneList.get(LIST_FIRST_MEMBER); 
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 增加手机号码
	 * 编辑手机信息时，可能是新创建的手机号，也可能是更新，所以需要判断：创建的时候使用save， 更新update
	 * 
	 * @param contracter 联系人姓名
	 * @param phoneNo 手机号码
	 * @param userId Phone表外键--User   --非user时填DB_INVALID_KEY
	 * @param enterpriseId  外键          --非enterprise 填DB_INVALID_KEY
	 */
	private void editPhoneNoTransaction(String contracter, String type, String phoneNo, int userId, int enterpriseId) {		
		/* 电话号码为空不需要往数据空中存放数据*/
		if (0 == phoneNo.length()) {
			return ;
		}
			
		Phone phoneUpdate = getPhoneByUserIdType(userId, type);		
		if (null != phoneUpdate) {
			
			/*如果没有设置联系人 不进行更新，防止覆盖掉有用的信息*/
			if ((null != contracter) && (0 != contracter.length())) {
				phoneUpdate.setContacter(contracter);
			}
			
			phoneUpdate.setType(type);
			phoneUpdate.setNumber(phoneNo);
			phoneUpdate.setUser(userId);
			phoneUpdate.setEnterprise(enterpriseId);
			
			updatePhoneNoTransaction(phoneUpdate);
		} else {
			phone = new Phone();
			
			phone.setContacter(contracter);
			phone.setType(type);
			phone.setNumber(phoneNo);
			phone.setUser(userId);
			phone.setEnterprise(enterpriseId);
			
			addPhoneNoTransaction(phone);
		}
	}
	
	/**
	 * caution: 对于普通用户不支持联系人姓名，联系人的姓名即为Nick Name
	 * 			  为了保证一致性，不将nickname存入contractor,使用时去
	 *          user表取
	 * 
	 * 增加手机号码
	 * 编辑手机信息时，可能是新创建的手机号，也可能是更新
	 * 
	 * 
	 * @param phoneNo 手机号码
	 * @param userId Phone表外键--User
	 * 
	 */
	public void editMobileByUserIdNoTransaction(String phoneNo, Integer userId) {
		editPhoneNoTransaction(null, "mobile", phoneNo, userId, DB_INVALID_KEY);
	}
	
	/**
	 * caution: 对于普通用户不支持联系人姓名，联系人的姓名即为Nick Name
	 * 			  为了保证一致性，不将nickname存入contractor,使用时去
	 *          user表取
	 * 
	 * @param phoneNo 固定电话
	 * @param userId Phone表外键--User
	 */
	public void editOfficePhoneByUserIdNoTransaction(String phoneNo, Integer userId) {
		editPhoneNoTransaction(null, "office", phoneNo, userId, DB_INVALID_KEY);
		
	}
	
	/**
	 * 增加电话
	 * @param phone
	 */
	public void addPhone(Phone phone){
		new PhoneDAO().save(phone);
	}
	
	/**
	 * caution : 用于同时更新多个表，并且要保证原子性的情况
	 *              只更新一个表需要使用addPhone
	 * 增加电话  --没有事物保护
	 * @param phone
	 */
	public void addPhoneNoTransaction(Phone phone){
		new PhoneDAO().saveNoTransaction(phone);
	}
	
	/**
	 * 
	 * @param enterpriseId
	 * @return
	 */
	public List<Phone> getPhonesByEnterpriseId(int enterpriseId) {
		return new PhoneDAO().findByProperty(PhoneDAO.ENTERPRISE, enterpriseId);
	}
	
	public void updatePhone(Phone phone){
		new PhoneDAO().update(phone);
	}
	
	public void updatePhoneNoTransaction(Phone phone){
		new PhoneDAO().updateNoTransaction(phone);
	}
	
	public Phone getPhoneById(int phoneId){
		return new PhoneDAO().findById(phoneId);
	}
	
	/**
	 * 通过userId 获取phone表的主键
	 * @param userId 用户Id
	 * @return phone的主键
	 */
	public Integer getPhoneIdByUserId(Integer userId) {
		try {
			phone = getPhoneByUserId(userId);
			return phone.getId();
		} catch (Exception e) {
			return DB_INVALID_KEY;
		}
	}
	
	/**
	 * 企业是否存放了企业电话号码
	 * @param enterpriseId 企业id
	 * @return true : 存在； false：不存在
	 */
	public boolean isExistEnterprisePhone(int enterpriseId) {
		try {
			getPhonesByEnterpriseId(enterpriseId);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	/**
	 * 用户是否存放了企业电话号码
	 * @param userId 企业id
	 * @return true : 存在； false：不存在
	 */
	public boolean isExistUserPhone(int userId) {
		try { 
			getPhonesByEnterpriseId(userId);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 无事务保护， 删除userId电话记录
	 * @param userId User Id
	 */
	public void deletePhonesByUserIdNoTranscation(int userId) {
		if (true == isExistUserPhone(userId)) {
			phoneDao.deleteByColumnNoTranscation(USER_ID, userId);
		}
	}
	
	/**
	 * 无事务保护， 删除enterpriseId电话记录
	 * @param enterpriseId Enterprise Id
	 */
	public void deletePhonesByEnterpriseIdNoTranscation(int enterpriseId) {
		if (true == isExistEnterprisePhone(enterpriseId)) {
			phoneDao.deleteByColumnNoTranscation(ENTERPRISE_ID, enterpriseId);
		}
	}
}

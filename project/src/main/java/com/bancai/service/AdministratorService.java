package com.bancai.service;

import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.Administrator;
import com.bancai.dao.AdministratorDAO;

/**
 * @author unanao
 *
 */
public class AdministratorService implements CommonConstants {
	private static final String NAME = "name";
	AdministratorDAO adminDAO = new AdministratorDAO();
	Administrator admin = new Administrator();
	
	/**
	 * 通过登陆获取对应的对象
	 * 
	 * @param name adminitor的登陆名
	 * @return 对应的对象
	 */
	public Administrator getAdministratorByName(String name) {
		try {
			List<Administrator> administrator = adminDAO.findByProperty(NAME, name);

			return administrator.get(LIST_FIRST_MEMBER);
		} catch (RuntimeException re) {
			return null;
		}
	}
	
	/**
	 * @param adminId administrator标主键
	 * @return administrator表主键获取对应的行
	 */
	public Administrator getAdministratorByAdminId(Integer adminId) {
		try {
			return adminDAO.findByPrimaryKey(adminId);
		} catch (RuntimeException re) {
			return null;
		}
	}
	
	/**
	 * 
	 * 根据管理员的名字获取主键
	 * 
	 * @param adminName 管理员的名字
	 * @return
	 */
	public int getAdminIdByAdminName(String adminName) {
		admin = getAdministratorByName(adminName);
		
		if (null != admin) {
			return admin.getId();
		} else {
			return DB_INVALID_KEY;
		}
	}
	
	/**
	 * 对用户输入的用户名和密码进行验证
	 * 
	 * @param name
	 *            登陆名
	 * @param loginPasswd
	 *            用户输入的密码
	 * @return true 用户验证成功 false 验证失败
	 */
	public boolean adminAuth(String name, String password)
			throws RuntimeException {
		boolean ret = false;
		String encryptionLoginPassword = DigestUtils.md5Hex(password);
		String expectPassword;
		

		admin = getAdministratorByName(name);
		if (null != admin) {
			expectPassword = admin.getPassword();

			ret = encryptionLoginPassword.equals(expectPassword);
		}

		return ret;
	}
	
	/**
	 * @param userName
	 *            用户名
	 * @param password
	 *            密码
	 */
	public void changePasswordByAdminName(String adminName, String password) {
		String encryptionPassword = DigestUtils.md5Hex(password);

		admin = getAdministratorByName(adminName);
		admin.setPassword(encryptionPassword);

		adminDAO.update(admin);
	}
	
	/**
	 * @param adminName
	 *            管理员的登陆名
	 * @param password
	 *            密码
	 */
	public void addAdministrator(String adminName, String password, Integer group) {
		String encryptionPassword = DigestUtils.md5Hex(password);
		Administrator admin = new Administrator();
		
		admin.setName(adminName);
		admin.setPassword(encryptionPassword);
		admin.setGroup(group);

		adminDAO.save(admin);
	}
	
	/**
	 * 管理员的用户名是否可用
	 * 
	 * @param adminName
	 * @return
	 */
	public boolean isAdminNameAvaliable(String adminName) {
		boolean ret = false;

		if (null == getAdministratorByName(adminName)) {
			ret = true;
		}

		return ret;
	}
	
	
	/**
	 * 根据管理员的删除管理员
	 * 
	 * @param adminName 管理员的名字
	 */
	public void deleteByAdminName(String adminName) {
		int adminId = getAdminIdByAdminName(adminName);
		
		if (DB_INVALID_KEY != adminId) {
			adminDAO.deleteByPrimaryKey(adminId);
		}
	}
}

package com.bancai.service;

import java.util.List;

import com.bancai.constants.CommonConstants;
import com.bancai.dao.Package;
import com.bancai.dao.PackageDAO;

/**
 * @author unanao
 *
 */
public class PackageService implements CommonConstants {
	private static String PACKAGE_NAME = "name";
	
	Package pkg = new Package();
	PackageDAO pkgDao = new PackageDAO();
	
	/**
	 * 根据套餐名称获取套餐内容
	 * 
	 * @param name 套餐名称
	 * @return  套餐存在返回套餐类；否则null 
	 */
	public Package getPackageByName(String name) {
		try {
			List<Package> pkgList= pkgDao.findByProperty(PACKAGE_NAME, name);
			return pkgList.get(LIST_FIRST_MEMBER);
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * 根据套餐名称获取套餐内容
	 * 
	 * @param name 套餐名称
	 * @return  套餐存在返回套餐类；否则null 
	 */
	public Package getPackageByPkgId(int pkgId) {
			return pkgDao.findByPrimaryKey(pkgId);
	}
	
	/**
	 * 套餐名称是否存在
	 * 
	 * @param name 套餐名称
	 * @return true : 存在； false: 不存在
	 */
	public boolean isPakageNameExist(String name) {
		if (null != getPackageByName(name)) {
			return true;
		}
		
		return false;
	}
	
	/**
	 *  更新套餐
	 * 
	 * @param pkg 套餐信息对象
	 */
	public void updateNewPackage(Package pkg) {
		pkgDao.update(pkg);
	}
	
	/**
	 * 增加新套餐
	 * 
	 * @param pkg 套餐信息对象
	 */
	public void addNewPackage(Package pkg) {
		pkgDao.save(pkg);
	}
	
	public int getPackageIdByPackageName(String name) {
		pkg = getPackageByName(name);
		
		if (null != pkg) {
			return pkg.getId(); 
		}
		else {
			return DB_INVALID_KEY;
		}
	}
	
	/**
	 * 根据enterprise Id 获取所有企业购买的套餐信息
	 * 
	 * @param enterpriseId 企业id
	 * @return 企业购买套餐的链表 
	 */
	public List<Package> getPackagesByEnterpriseId(int enterpriseId) {
		return pkgDao.findPackagesByEnterpriseId(enterpriseId);
	}
	
	/**
	 * 根据userName获取所有企业购买的套餐
	 * 
	 * @param enterpriseId 企业id
	 * @return 企业购买套餐的链表 
	 */
	public List<Package> getPackagesByName(String userName) 
	{
		UserService userService = new UserService();
		int enterpriseId = userService.getEnterpriseIdByUserName(userName);
		
		return pkgDao.findPackagesByEnterpriseId(enterpriseId);
	}
	
	/**
	 * 获取目前所有套餐的信息
	 * @return 所有的套餐信息
	 */
	public List<Package> getAllPackages()
	{
		return pkgDao.findAll();
	}
	
	/**
	 * 根据套餐名称删除对应套餐信息
	 * @param name 套餐名称
	 */
	public void deletePkgByName(String name)
	{
		PackageDAO pkgDao = new PackageDAO();
		int pkgId = getPackageIdByPackageName(name);
		
		pkgDao.deleteByPrimaryKey(pkgId);
	}
}

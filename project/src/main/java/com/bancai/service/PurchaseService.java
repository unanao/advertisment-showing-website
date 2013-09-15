package com.bancai.service;

import java.util.List;

import com.bancai.dao.Purchase;
import com.bancai.dao.PurchaseDAO;

/**
 * @author unanao
 * 
 */
public class PurchaseService {
	private static final String ENTERPRISE_ID = "enterprise";
	private static final String PACKAGE_ID = "package_";
	PurchaseDAO purchaseDAO = new PurchaseDAO();

	/**
	 * 
	 * 获取某企业的所有套餐
	 * 
	 * @param enterpriseId
	 *            企业ID
	 * @return 包含所有套餐的链表
	 */
	public List<Purchase> getAllOrdersByEnterpriseId(int enterpriseId) {
		return purchaseDAO.findByProperty(ENTERPRISE_ID, enterpriseId);
	}
	
	public List<Purchase> getAllPurchasesByName(String name) {
		UserService userService = new UserService();
		int enterpriseId = userService.getEnterpriseIdByUserName(name);
		
		return purchaseDAO.findByProperty(ENTERPRISE_ID, enterpriseId);
	}

	/**
	 * 更新order信息
	 * 
	 * @param order
	 *            order对象
	 */
	public void modifyOrderInfo(Purchase order) {
		purchaseDAO.update(order);
	}

	/**
	 * 新增用户购买的order信息
	 * 
	 * @param order
	 *            order对象
	 */
	public void addBuyOrderInfo(Purchase order) {
		purchaseDAO.save(order);
	}

	/**
	 * 根据企业企业名称和套餐名称删除对应的order表项
	 * 
	 * @param userName
	 *            用户名
	 * @param packageName
	 *            套餐名
	 */
	public void deleteOrder(String userName, String packageName) {
		UserService userService = new UserService();
		PackageService pkgService = new PackageService();
		int enterpriseId = userService.getEnterpriseIdByUserName(userName);
		int pkgId = pkgService.getPackageIdByPackageName(packageName);

		purchaseDAO.deleteBy2Column(ENTERPRISE_ID, enterpriseId, PACKAGE_ID, pkgId);
	}
	
	/**
	 * 企业是否购买了套餐
	 * @param enterpriseId 企业id
	 * @return true:存在； false : 不存在
	 */
	public boolean isExistPurchasesByEnterpriseId(int enterpriseId) {
		try {
			getAllOrdersByEnterpriseId(enterpriseId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 根据企业id删除企业购买的套餐; 有数据的时候才删除
	 * @param enterpriseId
	 */
	public void deletePurchasesByEnterpriseIdNoTranscation(int enterpriseId) {
		PurchaseDAO purchaseDAO = new PurchaseDAO();
		
		purchaseDAO.deleteByColumnNoTranscation(ENTERPRISE_ID, enterpriseId);
	}
}
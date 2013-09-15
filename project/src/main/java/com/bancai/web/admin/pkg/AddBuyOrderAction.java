package com.bancai.web.admin.pkg;

import java.sql.Timestamp;
import com.bancai.constants.CommonConstants;
import com.bancai.constants.PurchaseConstants;
import com.bancai.dao.Purchase;
import com.bancai.service.PurchaseService;
import com.bancai.service.PackageService;
import com.bancai.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 添加用户购买的套餐
 * 
 * @author unanao
 *
 */
public class AddBuyOrderAction extends ActionSupport{
	private static final long serialVersionUID = -2387376201274559728L;
	String userName;
	String packageName;
	double amount;
	Timestamp startTime;
	Timestamp endTime;
	
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		Purchase order = new Purchase();
		PackageService packageService = new PackageService();
		PurchaseService orderService = new PurchaseService();
		Timestamp chargeTime = new Timestamp(System.currentTimeMillis());
		int enterpriseId = userService.getEnterpriseIdByUserName(userName);
		int packageId = packageService.getPackageIdByPackageName(packageName);
		
		if (enterpriseId == CommonConstants.DB_INVALID_KEY)
		{
			addActionError("没有添加企业信息，不能购买套餐");
			return INPUT;
		}
		
		if (0.0 == amount)
		{
			amount = PurchaseConstants.DEFAULT_AMOUNT;
		}
		
		order.setEnterprise(enterpriseId);
		order.setPackage_(packageId);
		order.setTime(chargeTime);
		order.setStartTime(startTime);
		order.setEndTime(endTime);
		order.setAmount(amount);
		order.setValid(PurchaseConstants.VALID);
		orderService.addBuyOrderInfo(order);
		
		return SUCCESS;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPackageName() {
		return packageName;
	}


	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public Timestamp getStartTime() {
		return startTime;
	}


	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}


	public Timestamp getEndTime() {
		return endTime;
	}


	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
}

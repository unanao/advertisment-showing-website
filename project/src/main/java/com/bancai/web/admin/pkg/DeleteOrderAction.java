package com.bancai.web.admin.pkg;

import com.bancai.service.PurchaseService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteOrderAction extends ActionSupport {
	private static final long serialVersionUID = 8201639518973723804L;
	String userName;
	String packageName;
	
	@Override
	public String execute() throws Exception {
		PurchaseService orderService = new PurchaseService();

		orderService.deleteOrder(userName, packageName);
		
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

	
}

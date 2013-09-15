package com.bancai.web.order;

import java.util.List;

import com.bancai.dao.Purchase;
import com.bancai.service.PurchaseService;
import com.opensymphony.xwork2.ActionSupport;

public class GetOrderListAction extends ActionSupport{
	private static final long serialVersionUID = -9076670067951160890L;
	int enterpriseId;
	List<Purchase> orderList;

	@Override
	public String execute() throws Exception {
		PurchaseService orderService = new PurchaseService();
		
		orderList = orderService.getAllOrdersByEnterpriseId(enterpriseId);
		
		return SUCCESS;
	}
	
	public int getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public List<Purchase> getOrderList() {
		return orderList;
	}
}

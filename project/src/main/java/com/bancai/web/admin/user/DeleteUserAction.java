package com.bancai.web.admin.user;

import com.bancai.constants.AccountsContants;
import com.bancai.service.module.DeleteService;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteUserAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
	private String userName;
 
	@Override
	public String execute() throws Exception {
		DeleteService commonService = new DeleteService();
		
		try {
			commonService.deleteAllByUserName(userName);
			
			return SUCCESS;
		} catch (Exception e) {
			addActionError("删除用户失败");
			return INPUT;
		}
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
}

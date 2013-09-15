package com.bancai.web.pcenter;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.PhoneConstants;
import com.bancai.dao.Phone;
import com.bancai.dao.User;
import com.bancai.service.PhoneService;
import com.bancai.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class GetPersonalInfoAction extends ActionSupport implements
		AccountsContants, PhoneConstants {
	private static final long serialVersionUID = 4677628242031235325L;
	Integer userId;
	User user = new User();
	Phone mobile = new Phone();
	Phone officePhone = new Phone();

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userId = (Integer) session.get(SESSION_USER_ID);
		UserService userService = new UserService();
		PhoneService phoneService = new PhoneService();
		
		if (null == userId) {
			addActionError("您没有登陆");
			return INPUT;
		}
		
		try {
			user = userService.getUserByUserId(userId);
			mobile = phoneService.getPhoneByUserIdType(userId, PHONE_TYPE_MOBILE);
			officePhone = phoneService.getPhoneByUserIdType(userId, PHONE_TYPE_OFFICE);
			
			return SUCCESS;
		} catch (Exception ex) {
			addActionError("我们遇到了技术问题，请联系我们");
			return ERROR;
		} 
		
	}
	
	public User getUser() {
		return user;
	}
	
	public Phone getMobile() {
		return mobile;
	}
	
	public Phone getOfficePhone() {
		return officePhone;
	}
}

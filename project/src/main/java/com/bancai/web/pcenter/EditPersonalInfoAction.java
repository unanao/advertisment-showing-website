package com.bancai.web.pcenter;

import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.User;
import com.bancai.service.UserService;
import com.bancai.service.module.PersonalCenterService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class EditPersonalInfoAction extends ActionSupport implements
		AccountsContants {
	private static final long serialVersionUID = 4677628242031235325L;
	private String nickName = null;
	private String name;
	private String gender = null;
	private String qq = null;
	private String mobile = null;
	private String officePhone = null;
	Integer userId;
	User user = new User();

	@Override
	public String execute() throws Exception {
		Map<String, Object> session = ActionContext.getContext().getSession();
		userId = (Integer) session.get(SESSION_USER_ID);
		PersonalCenterService personalCenter = new PersonalCenterService();
		UserService userService = new UserService();
		nickName = nickName.trim();
		name = name.trim();
		qq = qq.trim();
		mobile = mobile.trim();
		officePhone = officePhone.trim();
		
		if (null == userId) {
			addActionError("您没有登陆");
			return INPUT;
		}
		
		try {
			personalCenter.editPersonalInfo(userId, nickName, name, gender, qq, mobile, officePhone );
			
			user = userService.getUserByUserId(userId);
			
			return SUCCESS;
		} catch (Exception ex) {
			addActionError("修改用户信息失败");
			return INPUT;
		} 
		
	}

	public void setNickName(String nickName) {
		this.nickName = new HTMLInputFilter().filter(nickName);
	}

	public String getNickName() {
		return new HTMLInputFilter().filter(nickName);
	}

	public void setGender(String gender) {
		this.gender = new HTMLInputFilter().filter(gender);
	}

	public String getGender() {
		return new HTMLInputFilter().filter(gender);
	}

	public void setQq(String qq) {
		this.qq = new HTMLInputFilter().filter(qq);
	}

	public String getQq() {
		return new HTMLInputFilter().filter(qq);
	}
	
	public void setMobile(String mobile) {
		this.mobile = new HTMLInputFilter().filter(mobile);
	}
	
	public String getMobile() {
		return new HTMLInputFilter().filter(mobile);
	}
	
	public void setOfficePhone(String officePhone) {
		this.officePhone = new HTMLInputFilter().filter(officePhone);
	}
	
	public String getOfficePhone() {
		return new HTMLInputFilter().filter(officePhone);
	}
	
	public User getUser() {
		return user;
	}

	public String getName() {
		return new HTMLInputFilter().filter(name);
	}

	public void setName(String name) {
		this.name = new HTMLInputFilter().filter(name);
	}
}

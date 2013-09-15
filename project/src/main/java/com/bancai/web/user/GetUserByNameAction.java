/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: getUserByName.java					
 *			
 * Description: 通过用户名获取用户信息														
 */
package com.bancai.web.user;

import com.bancai.dao.User;
import com.bancai.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao
 *
 */
public class GetUserByNameAction extends ActionSupport
{
	private static final long serialVersionUID = -7801472720660132022L;
	private String userName;
	private User user;
	
	@Override
	public String execute() throws Exception 
	{
		UserService userService = new UserService();
		
		user = userService.getUserByUserName(userName);
		
		return SUCCESS;
	}
	
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	
}

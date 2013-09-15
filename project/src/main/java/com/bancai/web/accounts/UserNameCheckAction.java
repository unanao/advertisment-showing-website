package com.bancai.web.accounts;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.bancai.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author unanao <jianjiaosun@163.com>
 */
public class UserNameCheckAction extends ActionSupport
{
	private static final long serialVersionUID = -5393027371643123742L;
	private String userName;
	Logger logger = Logger.getLogger(UserNameCheckAction.class);

	/**
	 * 检查用户名是否可用
	 * 
	 * @return SUCCESS 可用 ERROR 不可用，已经被注册
	 */
	public String execute()
	{
		HttpServletResponse response = ServletActionContext.getResponse();
		boolean bIsAvailable;
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("text/plain");
		bIsAvailable = new UserService().isUserNameAvailable(userName);

		try
		{
			response.getWriter().println(true == bIsAvailable ? '1' : '0');
		}
		catch (Exception e)
		{
			logger.debug("response available of username");
		}

		return SUCCESS;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}
}

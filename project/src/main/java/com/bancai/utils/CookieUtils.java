package com.bancai.utils;

import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bancai.service.UserService;
import com.bancai.web.accounts.AccountsCommon;

/**
 * @author unanao
 *
 */
public class CookieUtils {
	private final String AUTH_COOKIE_NAME = "AUTH_COOKIE_NAME";
	private final int COOKIE_AGE_SECS = 60 * 60 * 24 * 14;    //two weeks
	
	/*
	 * 经测试：不能使用 "," 和 "*"
	 */
	private final String SPLIT_STR = "=";

	/**
	 * 增加cookie
	 * @param userId			用户id  -- 不用userName，就算知道了id和密码还是不能登录
	 * @param encrytPasswd		加密后的密码
	 */
	public void addCookie(Integer userId, String encrytPasswd) {
		Cookie cookie = new Cookie(AUTH_COOKIE_NAME, 
				String.valueOf(userId) + SPLIT_STR + encrytPasswd);
		
		cookie.setPath("/");
		cookie.setMaxAge(COOKIE_AGE_SECS);
		
		ServletActionContext.getResponse().addCookie(cookie);
	}
	
	
	/**
	 * @param req request
	 * @return true 	验证成功
	 * 			 false	验证失败
	 */
	public void cookieVerifyProc(ServletRequest req) {
		HttpServletRequest request = (HttpServletRequest) req;
		int userId;
		String encryptPasswd;
		UserService userService = new UserService();
		
		Cookie cookies[] = request.getCookies();
		if (cookies == null) {
			return;
		}
		
		for (Cookie cookie : cookies) {
			if (AUTH_COOKIE_NAME.equals(cookie.getName())) {
				String value = cookie.getValue();
				if ((null != value) && (0 != value.trim().length())) {
					String split[] = value.split(SPLIT_STR);
					if (2 == split.length) {
						userId = Integer.parseInt(split[0]);
						encryptPasswd = split[1];
					
						if (true ==userService.encrptPasswdAuthentication(userId, encryptPasswd))
						{
							AccountsCommon accountsCommon = new AccountsCommon();
							HttpSession  session = request.getSession();
							
							accountsCommon.addLoginSessions(session, userId);
							break;
						}
					}
				}
			}
		}
	}


	/**
	 * @param request
	 * @return cookie
	 */
	public void clearCookie() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie cookies[] = request.getCookies();
		
		if (cookies == null) {
			return ;
		}
		
		for (Cookie cookie : cookies) {
			if (AUTH_COOKIE_NAME.equals(cookie.getName())) {
				cookie.setValue("");
				cookie.setMaxAge(0);
				cookie.setPath("/");
				
				ServletActionContext.getResponse().addCookie(cookie);
				break;
			}
		}
	}
}

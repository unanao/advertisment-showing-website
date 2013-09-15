package com.bancai.web.accounts;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.bancai.constants.SessionConstants;
import com.bancai.utils.CookieUtils;


/**
 * 检查用户的登录cookie，如果用户选择记住登录状态，将登录状态写入session
 * @author hubaiyu
 *
 */
public class LoginCookieFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		CookieUtils cookieUtils = new CookieUtils();
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getSession().getAttribute(SessionConstants.SESSION_LOGIN_NAME) == null) {
			cookieUtils.cookieVerifyProc(req);
		}
		
		chain.doFilter(req, resp);
	}
	@Override
	public void destroy() {
	}

}

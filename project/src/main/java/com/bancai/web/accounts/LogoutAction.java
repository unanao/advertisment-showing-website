package com.bancai.web.accounts;

import java.util.Map;

import org.apache.log4j.Logger;

import com.bancai.constants.AccountsContants;
import com.bancai.utils.CookieUtils;
import com.bancai.web.base.BaseAction;
import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends BaseAction implements AccountsContants {
	final static Logger logger = Logger.getLogger(LogoutAction.class);
	private static final long serialVersionUID = -8118105201207267532L;

	@Override
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		CookieUtils cookieUtils = new CookieUtils();
		clearUnpersistentEnterprisePicture();
		clearUnpersistentProductPicture();
		session.clear();//清除全部内容，由于session里面放着很多key为productId的Map对象
//		session.remove(SESSION_ENTERPRISE_ID); 
//		session.remove(SESSION_USER_ID);
//		session.remove(SESSION_LOGIN_NAME);
//		session.remove(PICTURE_MAP);
		cookieUtils.clearCookie();
		return SUCCESS;
	}

}

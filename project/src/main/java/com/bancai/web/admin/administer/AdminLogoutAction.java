package com.bancai.web.admin.administer;

import java.util.Map;

import org.apache.log4j.Logger;

import com.bancai.constants.AdminConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogoutAction extends ActionSupport implements AdminConstants {
	final static Logger logger = Logger.getLogger(AdminLogoutAction.class);
	private static final long serialVersionUID = -8118105201207267532L;

	@Override
	public String execute() {
		Map<String, Object> session = ActionContext.getContext().getSession();
		session.remove(SESSION_ADMIN_NAME);
		session.remove(SESSION_ADMIN_ID);

		return SUCCESS;
	}

}

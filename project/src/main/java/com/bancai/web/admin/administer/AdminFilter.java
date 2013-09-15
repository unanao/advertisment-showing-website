package com.bancai.web.admin.administer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bancai.constants.AdminConstants;
import com.bancai.web.base.PermissionFilter;

/**
 * 检查是否登录
 * 
 * @author zhangyanjiang
 * 
 */
public class AdminFilter extends PermissionFilter {
	/**
	 * 检查Session或Cookie[Constants.DEV_ID_KEY]是否存在
	 */
	@Override
	protected boolean checkPermission(HttpServletRequest request,
			HttpServletResponse response) {
		return request.getSession().getAttribute(AdminConstants.SESSION_ADMIN_ID) != null; 
	}

}

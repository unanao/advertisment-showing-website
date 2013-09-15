package com.bancai.constants;

public interface AccountsContants extends SessionConstants {
	final String SESSION_CERTIFICATION_CODE = "certificationCode";
	/*通过邮件激活和修改密码时用于生成字符的随即字符的个数*/
	final int EMAIL_CERTIFICATION_CODE_LEN = 10; //激活码的位数
	
	/* 账户状态定义 */
	final int	UNACTIVATED = 0;		// 未激活
	final int	ACTIVATED   = 1;		// 激活
	final int	FREEZED     = 2;		//冻结
	
	/*用户接色定义*/
	final int ADMIN	= 0	;	//管理员
	final int USER = 1;		//普通用户
	
	final int CERTIFICATION_OVERDUE_MILLISECONDS = 24 * 2 * 60 * 60 * 1000; //通过邮件验证失效时间为48小时
	final int CERTIFICATION_BEYOND_COUNTS = 3;//每天发送验证邮件的次数
	
	final String LOGIN_PAGE = "login_page";
	
	final String PICTURE_MAP = "picture_map";
}

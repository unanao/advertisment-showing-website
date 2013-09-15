<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/personal.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
</head>
<body>
		<%@ include file="../includefiles/navigate.jsp" %>		
	<div id="ou0" style="position: absolute; left: 14%; top: 91px; width: 72%; 
			height: 400px; bgcolor: #E4E4E4; align: center; border: 1px; border-style: solid;">
		<div id="common_div_frame" style="position: absolute; left: 20%; top: 20px;">
			<h3><b>请激活您的账号：</b></h3>
		
			<p class="common_font">
				您的账号为：<s:property value="#session.SESSION_UNACTIVE_EMAIL" />
			</p>

			<p class="common_font">
				请登录您的邮箱，找到我们给您发的验证邮件，点击邮件中的链接，即可完成注册
			</p>
		</div>
		
		<p style="position: absolute; left: 20%; top: 300px;">				
			<label class="common_font">重新获取激活邮件：</label>
			<a href="accounts/resendActivateEmailAction">
				<span class="common_link">激活</span>
			</a>
		</p>
	</div>
</body>
</html>
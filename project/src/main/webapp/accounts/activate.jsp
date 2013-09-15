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
	<div id="ou0" class="zhuti" style="position: absolute; left:14%; top: 91px;">
		<div style="position: absolute; left: 10%; top: 5%;">
			<h4>请激活您的账号：</h4>
		</div>
		
		<div id="common_div_frame" style="position: absolute; left: 20%; top: 20%;">
				<p class="common_font">您的账号为：
					<s:property value="#session.SESSION_EMAIL" />
				</p>
				<p class="common_font">
					请登录您的邮箱，找到我们给您发的验证邮件，点击邮件中的链接，即可完成注册
				</p>
		</div>

		<div id="help_div" style="position: absolute; left:30%; top:50%;">
			<p>看看Email地址有没有写错</p> 
			<p>看看是否在垃圾邮件或广告邮件里</p> 
			<p>稍等几分钟再看看</p>
			<p>若10分钟内没收到验证邮件，请点
				<a href="accounts/resendActivateEmailAction">
					<span class="common_link"> 重发 </span>
				</a>
			</p> 
				
			<p>如果上面的方法都是过了，点击
				<a href="aboutus/contactus.jsp">
					<span class="common_link">联系我们</span>
				</a>，
				联系我们帮助您完成注册
			</p>
		</div>
	</div>
</body>
</html>
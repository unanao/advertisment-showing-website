<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<title>58板材网用户手册</title>
	<link rel="stylesheet" type="text/css" href="css_files/contactus.css" />	
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>
	<div id="main_board">
	<h1>用户手册</h1>
	<h2>1、新用户注册</h2>
	<p>
		<h3> 1.1 注册新用户 </h3>
		点击首页的“注册”链接， 填写注册邮箱、密码和验证码即可完成。
		<h3> 1.2 新用户激活 </h3>
		为了保证您账户的安全，注册成功后，58板材网会给您的注册邮箱发送激活邮件，
		您登录注册邮箱，点击邮件中的激活链接即可。
	</p>
	<h2>2、用户登录</h2>
		<h3> 2.1 登录 </h3>
		点击首页的“登录”链接， 填写注册邮箱、密码，点击登录按钮就成功登录啦。
		
		<h3> 2.2 忘记密码 </h3>
		点击首页的“登录”链接， 点击“忘记密码”的链接，输入您的注册邮箱。登
		录您的注册邮箱， 点击邮件中修改密码的链接就可以修改您的密码了。
		
		<h3> 2.3 未激活 </h3>
		如果登录时，提示您的账户未激活， 您需要按照1.2中的步骤激活您的账户。
		
	<h2> 3、个人中心 </h2>
		“个人中心”是您的个人的空间，您在个人中心中可以方便的修改密码， 
		发布修改个人信息、企业信息和产品信息。
	 
	 	<h3> 3.1 进入个人中心 </h3>
			<p>登录后，点击“个人中心” 进入 </p>
			<p> 
				或者， 先点击“个人中心”， 网站会自动跳转到登录页面， 
				登录后会跳转到个人中心
			</p>
		<h3> 3.2 发布企业信息 </h3>
			进入“个人中心”后， 点击“管理企业信息”， 添加您的企业信息即可。
		
		<h3> 3.2 发布产品信息 </h3>
			<p> 进入“个人中心”后， 点击“管理产品信息”， 添加您的企业信息即可。</p>
			<p>
			您必须首先添加企业信息，如果没有添加企业信息，网站会跳转到管理
			企业信息的页面，您添加企业信息后，就可以发布您的产品信息了。
			</p>
	</div>
	<hr>
	
	<%@ include file="../js/js_common.inc"%>
	
	<%@ include file="../includefiles/footer.jsp" %>
</body>
</html>
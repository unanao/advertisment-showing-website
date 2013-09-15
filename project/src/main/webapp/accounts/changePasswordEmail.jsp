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
	
	<div id="ou0" style="position: absolute; left: 14%; top: 91px; width:72%; height: 460px; 
			border: 1px; border-style: solid;">

		<div style="position: absolute; left: 20%; top: 50px;bgcolor: #EEFFEE; border: 1px; border-style: solid;">
		
			<p class="common_font"> 
				您的账号为： <s:property value="#session.SESSION_UNACTIVE_EMAIL" /> 
			</p>
			<p class="common_font">			
				请登录您的邮箱，找到我们给您发的修改密码的邮件，按照提示，即可找回密码
			</p>
		</div>

		<div style="position: absolute; left: 30px; top: 120px; width: 800px; height: 100px; font-size: 13px;">
			<div style="position: absolute; left: 30%; top: 60px;">
				<h4><b>没有收到修改密码的邮件怎么办？</b></h4>
				<li>看看Email地址有没有写错</li> 
				<li>看看是否在垃圾邮件或广告邮件里</li> 
				<li>稍等几分钟再看看</li>
				<li>若10分钟内没收到修改密码的邮件，再获取一次，请点
					<a href="accounts/forgetPassword.jsp">
						<span class="common_link"> 重新获取密码 </span>
					</a>
				</li>
				
				<li>如果上面的方法都是过了，点击
					<a href="aboutus/contactus.jsp">
						<span class="common_link">联系我们</span>
					</a>，联系我们帮助您完成注册
				</li>
			</div>
		</div>
	</div>
</body>
</html>
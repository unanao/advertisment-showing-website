<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<script language="javascript" src='js/verify_code.js'></script>
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>

	<form action="accounts/forgetPassword" method="post">
			<div style="position:relative; left: 30%">
				<h3><b>找回58板材密码：</b></h3>
				
				<%-- s:actionerror用于输出系统的Action Error提示  --%>
				<div class="common_error">  <s:actionerror /> </div>
				
				<p>
					<label class="common_font">请输入注册邮箱：</label>
					<input type="text" name="userName" style="width: 180px; height: 25px;">
				</p>
	
				<p>
					<label class="common_font">请输入验证码：</label> 
					<input type="text" name="verifyCode"	
							style="width: 100px; height: 25px;">
					<img width="120" height="30" src="accounts/verifyCodeImg", id="AuthImgAction"
							class="vcode_img" alt="验证码图片" onclick="changeValidateCode(this)">
					<a href="javascript:reloadImg();">
						<span class="common_link"> 看不清？换一张 </span>
					</a>
				</p>
				<p>
					<INPUT class="common_button" type="submit" value="提交">
				</p>
			</div>
	</form>
</body>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/form.css" />
	<link rel="stylesheet" type="text/css" href="css_files/personal.css" />

	<script type="text/javascript" src="js/jquery/jquery.js"></script>
	<script type="text/javascript" src="js/pcenter/change_passwd.js"></script>
</head>
<body style="overflow:scroll;overflow-y:hidden;overflow-x:hidden">
	<s:form action="changePersonalPassword">
	<div style="position: absolute; left: 0%; top: 0%; width: 100%; height: 100%;">
		
		<DIV class="rightbt" style="position: absolute; left: 0%; top: 15%;">
			
		
		<h3 id="pcenter_title" align="center">修改密码</h3>
		
		<!-- 输出系统的Action Error提示 -->
		<p>
		<div class="common_error">
			<s:actionerror />
		</div>
		</p>
		
		<p>
		<span id="eoldPassword" class="common_error">
			<s:fielderror> <s:param> oldPassword </s:param> </s:fielderror>
		</span>
		</p>
		<p>
			<label class="form_label"> 原密码 </label>
			<input id="oldPassword" name="oldPassword" class="form_input" type="password">
		</p>
		
		
		<span id="enewPassword" class="common_error">
			<s:fielderror> <s:param> newPassword </s:param> </s:fielderror>
		</span>
		<p>
			<label class="form_label">	新密码</label>
			<input id="newPassword" name = "newPassword" class="form_input" type="password">
		</p>

		
		<span id="epasswordConfirm" class="common_error">
			<s:fielderror> <s:param> passwordConfirm </s:param> </s:fielderror>
		</span>
		<p>
			<label class="form_label">	重复新密码</label>
			<input id="passwordConfirm" name="passwordConfirm" class="form_input" type="password">
		</p>
		<p>
			<input id="submit" class="rightbutton" type="submit" value="确定"
					style="position: absolute; left: 35%;;"> 
			
			<input class="rightbutton" type="reset" value="取消"
					style="position: absolute; left: 55%;">
		</p>
		</DIV>
	</div>
	</s:form>
</body>
</html>

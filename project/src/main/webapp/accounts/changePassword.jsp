<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">	
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/home_cat.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>
	<form action="accounts/changePassword" method="post">
		<div style="position: absolute; left: 14%; top: 91px; width:72%; height: 460px; 
				border: 1px; border-style: solid;">
			<div style="position: absolute; left: 30%;">
			<!-- 输出系统的Action Error提示 -->
			<div class="common_error"> <p> <s:actionerror /> </p> </div>		

			<label class="common_error">
				<s:fielderror> <s:param> password </s:param> </s:fielderror>
			</label>
			<p>
				<label class="common_font"> 请输入新密码 </label>
				<input type="password" name="password" value="" style=" 
						width: 180px; height: 25px;">
			</p>

			<label class="common_error">
				<s:fielderror> <s:param> passwordConfirm </s:param> </s:fielderror>
			</label>
			<p>
				<label class="common_font"> 请确认新密码</label> 
				<input type="password" name="passwordConfirm" value=""
						style="width: 180px; height: 25px;">
			</p>
			
			<p>
				<INPUT id=f_submit class="common_button" type=submit value="提交">
				<INPUT id=cannel class="common_button" type=submit value="取消" 
						style="position: absolute; left: 55%;">
			</p>
			
			</div>
		</div>
	</form>
</body>
</html>

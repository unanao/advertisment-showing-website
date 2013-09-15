<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/accounts/register.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/form.css" />
	
	<script type="text/javascript" src="js/jquery/jquery.js"></script>
	<script type="text/javascript" src="js/accounts/register.js"></script>
	<script type="text/javascript" src="js/verify_code.js"></script>
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>
	<form action="accounts/register" style="margin:0;" method="post">
		<div id=zhuti class="zhuti">	
			<div class="reg_left_layout">	
				<!-- 输出系统的Action Error提示 -->
				<p>
					<div class="common_error"> <s:actionerror /> </div>
				</p>
			
				<%--注册邮箱 --%>
				<p>
					<label class="common_font"> 注册邮箱 </label> 
					<INPUT id="userName"  name="userName" type="text">
					
					<span id="euserName" class="common_error"> 
						<s:fielderror> <s:param> userName </s:param> </s:fielderror> 
					</span>
				</p>
			
				<%--注册密码 --%>
				<p>
					<label class="common_font"> 用户密码 </label>
					<INPUT id="password" name="password" type="password">
					
					<span id="epassword" class="common_error">
						<s:fielderror> <s:param> password </s:param> </s:fielderror>
					</span>
				</p>

				<%--确认密码 --%>
				<p>
					<label class="common_font"> 确认密码 </label>
					<input id="passwordConfirm" name="passwordConfirm" type=password >
					<span id="epasswordConfirm" class="common_error">
						<s:fielderror> <s:param> passwordConfirm </s:param> </s:fielderror>
					</span>
				</p>
			
				<%-- 验证码 --%>
				<p>
					<label class="common_font">验证码</label>
					<INPUT id="verifyCode" name="verifyCode" type="text" value=""> 
					
					<img width="120" height="30" src="accounts/verifyCodeImg" id="AuthImgAction"
							alt="验证码图片" onclick="changeValidateCode(this)">
					<a href="javascript:reloadImg()"> 
						<span class="common_link"> 看不清?换一张 </span>
					</a>
					
					<span id="everifyCode" class="common_error">
						<s:fielderror> <s:param> verifyCode </s:param> </s:fielderror>
					</span>
				</p>

				<%-- 接受协议 --%>
				<p>
					<input id="agreement" name="agreement" type="checkbox" value="agreement" checked>
					<label class="common_font"> 我已阅读并接受 </label>
					<a href="aboutus/protocol.jsp" target="_blank">
						<span class="common_link">《58板材服务协议》</span>
					</a>
					
					<span id="eagreement" class="common_error">
						<s:fielderror> <s:param> agreement </s:param> </s:fielderror>
					</span>
				</p>
			
				<input id="submit" class="reg_input_att" type="submit" value="注册">
			
			</div>
			
		</div>
	</form>
</BODY>
</HTML>
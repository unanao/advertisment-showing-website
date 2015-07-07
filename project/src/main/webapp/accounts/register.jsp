<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
			
	<%@ include file="../css_files/css_common.inc" %>
	<link rel="stylesheet" type="text/css" href="css_files/accounts/register.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/form.css" />
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>
		
	<div class="container">			
		<div class="offset1" id="top-form">
		
			<!-- 输出系统的Action Error提示 -->
			<div class="row form_error"> <s:actionerror /> </div>
	
			<form   class="form-horizontal" action="accounts/register" style="margin:0;" method="post">
				<div class="control-group">
    				<label class="control-label" for="userName" >注册邮箱</label>
    				<div class="controls">
      					<input class="span5" type="text"  id="userName"  name="userName" placeholder="邮箱">
      					<span class="help-inline form_error" id="euserName"> <s:fielderror> <s:param> userName </s:param> </s:fielderror> </span>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="password">密码</label>
    				<div class="controls">
      					<input class="span5" type="password"  id="password"  name="password" placeholder="密码">
      					<span class="help-inline form_error" id="epassword"><s:fielderror> <s:param> password </s:param> </s:fielderror></span>
    				</div>
  				</div>
				
				<div class="control-group">
    				<label class="control-label" for="passwordConfirm"> 确认密码</label>
    				<div class="controls">
      					<input class="span5" type="password"  id="passwordConfirm"  name="passwordConfirm" placeholder="确认密码">
    					<span class="help-inline form_error" id="epasswordConfirm"> <s:fielderror> <s:param> passwordConfirm </s:param> </s:fielderror> </span>
    				</div>
  				</div>
				
				<div class="control-group">
    				<label class="control-label" for="verifyCode">验证码</label>
    				<div class="controls">
      					<input class="span3" type="text"  id="verifyCode"  name="verifyCode" placeholder="验证码">
      					
      					<img width="120" height="30" src="accounts/verifyCodeImg" id="AuthImgAction"
							alt="验证码图片" onclick="changeValidateCode(this)">
						<a href="javascript:reloadImg()"> <span class="common_link"> 换一张 </span></a>
      					
      					<span class="help-inline form_error" id="everifyCode">	<s:fielderror> <s:param> verifyCode </s:param> </s:fielderror></span>
    				</div>
    			</div>
    		
    			<div class="control-group">
    				<div class="controls">
    				 	<label class="checkbox">
      						<input id="agreement" name="agreement" type="checkbox" value="agreement" checked>
      						<span> 我已阅读并接受 </span>
							<a href="aboutus/protocol.jsp" target="_blank" > <span>《58板材服务协议》</span> </a>
      						<span class="help-inline form_error" id="eagreement"> 	<s:fielderror>	<s:param> agreement </s:param> </s:fielderror> </span>
    					</label>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<div class="controls">
      					<input id="submit" class="btn btn-large  btn-primary span5" type="submit" value="注册">
    				</div>
  				</div>
			</form>
		</div>
	
  		<div class="row" id="bottom">
  			 <hr/>
  			<%@ include file="../includefiles/footer.jsp" %>
 		</div>
 	</div>
	
	<%@ include file="../js/js_common.inc"%>
	<script type="text/javascript" src="js/accounts/register.js"></script>
	<script type="text/javascript" src="js/verify_code.js"></script>
	
</BODY>
</HTML>
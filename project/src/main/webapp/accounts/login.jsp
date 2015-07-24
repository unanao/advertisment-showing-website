<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/accounts/login.css" />
	<%@ include file="../css_files/css_common.inc" %>
</head>
<body>
    <div class="w" id="header-2013">
      <div id="logo-2013" class="ld">
        <a href="http://www.58bancai.com/" hidefocus="true">
          <img src="images/logo.png" width="180" height="90" alt="58板材">
        </a>
      </div>
    </div>
	
	<div id="ou0" style="position:relative; width:100%; height: 460px; border:0px; border-style: solid;">
        <div style="position:relative; left: 1%; top: 20px; width:50%; height: 300px;">
            <div>
            	<h1 class="introduction_head">
                58板材特色服务介绍
                </h1>
                <ul>
                    <li>
                        <label class="introduction_big">专注板材服务</label> 
                        <label class="introduct_small"> 国内第一家专业的板材名片网 </label>
                    </li>
                    <li>
                        <label class="introduction_big">企业宣传的平台</label>
                        <label class="introduct_small"> 方便快捷发布企业和产品信息</label>
                    </li>
                    <li>
                        <label class="introduction_big">用户快速定位产品的平台</label>
                        <label class="introduct_small"> 按照地区和产品方便查找</label>
                    </li>
                </ul>
            </div>
        </div>

    <div style="position: absolute; left: 65%; top: 40px; width: 30%;">
 			<form   class="form-horizontal">
 				<fieldset>  
 					<p align="center"> <span class="common_font"> 登录 </span></p>
				<div class="control-group">
    				<label class="control-label" for="userName" >用户名</label>
    				<div class="controls">
      					<input class="span3" type="text"  id="userName"  name="userName" placeholder="注册邮箱">
      					<span class="help-inline form_error" id="euserName"> <s:fielderror> <s:param> userName </s:param> </s:fielderror> </span>
    				</div>
  				</div>
  				
  				<div class="control-group">
    				<label class="control-label" for="password">密码</label>
    				<div class="controls">
      					<input class="span3" type="password"  id="password"  name="password" placeholder="密码">
      					<span class="help-inline form_error" id="epassword"><s:fielderror> <s:param> password </s:param> </s:fielderror></span>
    				</div>
  				</div>
                
                <div class="control-group">
    				<div class="controls">
    				 	<label class="checkbox">
    				 		<input name="rememberme"  type="checkbox" value="rememberme">
      						<span> 两周内自动登录 </span>
      						<a target="_blank" href="accounts/forgetPassword.jsp">
    							<span class="common_link common_prompt padding_left">忘记密码了?</span>
                    		</a>
    					</label>
    				</div>
  				</div>

               <div class="control-group">
    				<div class="controls">
      					 <input id="submit" class="btn btn-primary span3" type="button"  onclick="accountsLogin.loginAuth()" value="登 录"/>
    				</div>
  				</div>
  				 
  				  <div class="control-group">
    				<div class="controls">
      					<span class="common_prompt"> 还没有帐号?</span>
                    	<a target="_blank" href="accounts/register.jsp"> <span class="common_link common_prompt">立即注册 </span> </a>
    				</div>
  				</div>
  				         </fieldset>
            </form>
        </div>
    </div>
	
		<%@ include file="../js/js_common.inc"%>
		<script type="text/javascript" src='js/accounts/login.js'></script>
</body>
</html>
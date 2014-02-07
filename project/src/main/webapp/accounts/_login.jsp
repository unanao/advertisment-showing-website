<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<hr>
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
        <fieldset>  
        
            <form action="accounts/login?retPage=<%=request.getParameter("retPage")%>" 
                method="post">
                
                <p align="center"> <span class="common_font"> 登录 </span></p>
                
                <%-- error message --%>     
                <p>
                    <div class="common_error"> <s:actionerror /> </div>
                    
                    <p id="euserName" class="common_error">
                        <s:fielderror> <s:param> userName </s:param> </s:fielderror>
                    </p>
                    
                    <p id="epassword" class="common_error">
                        <s:fielderror> <s:param> password </s:param> </s:fielderror>
                    </p>
                </p>
                
                <p>
                    <label>
                        <span class="input_description"> 邮箱 </span>
                        <input id="userName" name = "userName" type="text">
                    </label>
                </p>    
                
                <p>
                    <label> 
                        <span class="input_description"> 密码 </span> 
                        <input id="password" type="password" name="password">
                    </label>
                </p>
                    
                <p>
                    <label class="common_prompt">
                    <input name="rememberme"  type="checkbox" value="rememberme">
                     两周内自动登录 </label>
                    
                    <a target="_blank" href="accounts/forgetPassword.jsp">
                        <span class="common_link common_prompt padding_left">忘记密码了?</span>
                    </a>
                </p>

                <p>
                    <input id="submit" class="input_submit" type="submit" value="登 录"/>
                    
                    <span class="common_prompt"> 还没有帐号?</span>
                    <a target="_blank" href="accounts/register.jsp"> 
                        <span class="common_link common_prompt">立即注册 </span>
                    </a>
                </p>
            </form>
         </fieldset>
        </div>
    </div>
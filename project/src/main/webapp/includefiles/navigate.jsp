<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="navigate">
	<div style="position:absolute;padding-left:5px; ">
		<img style="height:90px;" src="images/logo.gif">
	</div>
    <div style="position:relative; height:90px; border:solid 1px;">
        <div id="navigate_login">
            <%-- 用户登陆了现实用户名和退出，用户没有登陆显示登陆和注册 --%>
            <% String loginName = (String)session.getAttribute("SESSION_LOGIN_NAME");
            if (null == loginName)
            { %>
            <a href="accounts/login.jsp">登陆</a>|<a href="accounts/register.jsp">注册</a>
            <% } else { %>
            <a href="pcenter/pcenter.jsp"><%= loginName %></a>|<a href="accounts/logout">退出</a>
            <% } %>
        </div>
        <div id="navigate_menu">
            <a href=".">首页</a>
            <% if (null == loginName){ %>
            <a href="accounts/login.jsp?retPage=pcenter">个人中心 </a>
            <% } else { %>
            <a href="pcenter/pcenter.jsp">个人中心</a>
            <% } %>
            <a href="aboutus/user_manual.jsp">帮助手册</a>
            <a href="aboutus/contactus.jsp">联系我们</a>
        </div>
    </div>
</div>
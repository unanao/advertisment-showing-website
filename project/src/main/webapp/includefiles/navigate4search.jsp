<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <div id="shortcut-2013">
      <div class="w">
        <ul class="fl lh">
          <li class="fore1 ld">
          <a href="javascript:HomepageFavorite.Homepage()"  >
            设为首页
          </a>
          <a href="javascript:HomepageFavorite.Favorite(window.location.href, document.title)"  >
            加入收藏
          </a>
        </li>
      </ul>
      <ul class="fr lh">
        <li class="fore1" id="loginbar">
        您好，欢迎来到58板材！
        <span>
          <%-- 用户登陆了现实用户名和退出，用户没有登陆显示登陆和注册 --%>
          <%
          String loginName = (String)session.getAttribute("SESSION_LOGIN_NAME");
          if (null == loginName)
          {
            %>
            <a href="accounts/login.jsp">
              登陆
            </a>
            |
            <a href="accounts/register.jsp">
              免费注册
            </a>
            <%
          } else {
            %>
            <a href="pcenter/pcenter.jsp">
              <%= loginName %>
            </a>
            |
            <a href="accounts/logout">
              退出
            </a>
            <%
          }
          %>
        </span>
      </li>
    </ul>
    <span class="clr">
    </span>
    </div>
    </div>
    <!--shortcut end-->
    
    <div class="w" id="header-2013">
      <div id="logo-2013" class="ld">
        <a href="http://www.58bancai.com/" hidefocus="true">
          <img src="images/logo.png" width="180" height="90" alt="58板材">
        </a>
      </div>
      <!--logo end-->
      <div id="search-2013" >
        <div class="i-search ld">
          <div class="form">
            <s:form action="search_get_result" style="margin:0;">
              <input type="text" name="content"  class="text" accesskey="s" id="key" autocomplete="off" style="color: rgb(153, 153, 153);">
              <input type="submit" value="搜索" class="button">
            </s:form>
          </div>
        </div>
      </div>
      <!--search end-->
    
    </div>
    <!--header end-->
    <div class="w">
      <div id="nav-2013">
        <ul id="navitems-2013">
          <li class="fore1" id="nav-home">
          <a href=".">
            首页
          </a>
        </li>
        <li class="fore2" id="nav-fashion">
        <%
        if (null == loginName){
          %>
          <a href="accounts/login.jsp?retPage=pcenter">
            我的58板材
          </a>
          <%
        } else {
          %>
          <a href="pcenter/pcenter.jsp">
            我的58板材
          </a>
          <%
        }
        %>
      </li>
      <li class="fore3" id="nav-chaoshi">
      <a href="aboutus/user_manual.jsp">
        帮助手册
      </a>
    </li>
    <li class="fore4" id="nav-tuan">
    <a href=".">
      网站促销
    </a>
    </li>
    <li class="fore5" id="nav-auction">
    <a href="aboutus/contactus.jsp">
      联系我们
    </a>
    </li>
    </ul>
    </div>
    </div>
    
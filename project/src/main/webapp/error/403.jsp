<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% response.setStatus(403); %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>访问被拒绝</title>
</head>
<body>
	<s:actionerror /> <br />
	<center>对不起，您没有权限浏览该内容！请联系我们的管理员</center>

</body>
</html>
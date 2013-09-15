<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% response.setStatus(406); %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>输入错误</title>
</head>
<body>
<div id="container">
	
	<div id="inner">
		<div class="content"><s:property value="exceptionStack"/>
			<center><h1>对不起，您输入的数据有误，请检查！</h1></center>
		</div><!-- #content -->
	</div><!-- #inner -->
	
</div><!--#container-->
</body>
</html>
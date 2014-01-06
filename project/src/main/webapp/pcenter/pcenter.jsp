<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
		<link rel="stylesheet" type="text/css" href="css_files/bootstrap.css" />
		<link rel="stylesheet" type="text/css" href="css_files/common.css" />
		<link rel="stylesheet" type="text/css" href="css_files/personal.css" />
	</head>
	<body>	
		<%@ include file="../includefiles/navigate.jsp" %>
		<div style="position:relative; width:20%;  border-right:0; float:left; margin-right:-2px;">
			<iframe width="100%" height="550px" frameborder=0 scrolling=no src="pcenter/left.jsp"></iframe>
		</div>
		<%--右侧是主页面内容  --%>
		<div style="position:relative;width:80%;float:left;margin-left:-2px;">
			<iframe name="contentpage" width="100%" height="550px" frameborder=0 scrolling=auto src="pcenter/personalSummary">
			</iframe>
		</div>
		<script src="js/bootstrap.js"></script>
	</body>
</html>

 

 
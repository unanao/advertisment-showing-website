<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
		<link rel="stylesheet" type="text/css" href="css_files/bootstrap.css" />		
		<link rel="stylesheet" type="text/css" href="../css_files/personal.css" />
	</head>
	<body>
			<ul class="nav nav-list">
				<li class="nav-header">
					用户信息
				</li>
				<li class="active">
					<a href="#">修改密码</a>
				</li>
				<li>
					<a href="#">修改基本信息</a>
				</li>
				<li class="nav-header">
					企业信息
				</li>
				<li>
					<a href="#">管理企业信息</a>
				</li>
				<li>
					<a href="#">管理产品信息</a>
				</li>
				<li class="nav-header">
					账户信息
				</li>
				<li>
					<a href="#">当前套餐信息</a>
				</li>
				<li>
					<a href="#">购买套餐</a>
				</li>
				<li class="divider">
				</li>
				<li>
					<a href="#">帮助</a>
				</li>
			</ul>
		<script src="js/bootstrap.js"></script>			
	</body>
</html>
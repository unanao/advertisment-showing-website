<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
	</head>
	<body>
			<ul id="nav-list" class="nav nav-list">
				<li id="pnav_userinfo" class="nav-header">
					用户信息
				</li>
				<li id="pnav_change_pw">
					<a>修改密码</a>
				</li>
				<li id="pnav_change_basic">
					<a>修改基本信息</a>
				</li>
				<li class="nav-header">
					企业信息
				</li>
				<li id="pnav_manage_enterprise">
					<a>管理企业信息</a>
				</li>
				<li id="pnav_manage_product">
					<a>管理产品信息</a>
				</li>
				<li class="nav-header">
					账户信息
				</li>
				<li id="pnav_current_service">
					<a>当前套餐信息</a>
				</li>
				<li id="pnav_buy_service">
					<a>购买套餐</a>
				</li>
				<li class="divider">
				</li>
				<li id="pnav_help_info">
					<a>帮助</a>
				</li>
			</ul>
		<script src="js/bootstrap.js"></script>			
	</body>
</html>
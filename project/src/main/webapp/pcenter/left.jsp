<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv=Content-Type content=texthtml; charset=utf-8 >
		<link rel="stylesheet" type="text/css" href="../css_files/personal.css" />
	</head>
	<body>
		<DIV id=u211 class="leftbt" style="position:absolute; left:0%; top:10%;"><b>用户信息</b></DIV>
		<DIV id=u212 class="leftsub"  style="position:absolute; left:0%; top:16%; "><a href="change_passwd.jsp"  target=contentpage>修改密码</a></DIV>
		<DIV id=u213 class="leftsub" style="position:absolute; left:0%; top:20%; "><a href="showPersonalInfo"  target=contentpage>管理基本信息</a></DIV>
		<DIV id=u214 class="leftbt"  style="position:absolute; left:0%; top:26%; "><b>我的企业信息</b></DIV>
		<DIV id=u215 class="leftsub" style="position:absolute; left:0%; top:32%; "><a href="showEnterprise"  target=contentpage>管理企业信息</a></DIV>
		<DIV id=u216 class="leftsub" style="position:absolute; left:0%; top:36%; "><a href="listProducts" target=contentpage>管理产品信息</a></DIV>
		<DIV id=u217 class="leftbt"  style="position:absolute; left:0%; top:42%; "><b>账户信息</b></DIV>
		<DIV id=u218 class="leftsub" style="position:absolute; left:0%; top:48%; "><a href="getPackagesByEnterprise" target=contentpage>账户充值信息</a></DIV>
		<DIV id=u219 class="leftsub" style="position:absolute; left:0%; top:52%; "><a href="do_charge.jsp" target=contentpage>账户充值服务</a></DIV>
	</body>
</html>
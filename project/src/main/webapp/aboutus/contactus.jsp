<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<title>联系58板材网</title>
	<link rel="stylesheet" type="text/css" href="css_files/contactus.css" />	
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
</head>
<body>
	<%@ include file="../includefiles/navigate.jsp" %>
	<div id="main_board">
	<h1>联系我们</h1>
	<h2>1、关于58板材</h2>
	<p>58板材是面向临沂地区的第一家板材行业推广网站，其宗旨是在临沂地区的板材企业和四面八方的潜在客户间建立起
	一座沟通的桥梁，	帮助临沂地区板材相关企业（板材机械生产、板材加工销售等）方便快捷的向全国乃至全球客户发布
	推广自己的产品，为企业的销售渠道注入新的活力!</p>
	<h2>2、服务内容</h2>
	在我们的网站上，所有的企业用户都可以免费注册一个属于自己的账户，通过完善自己账户的企业信息和产品信息，
	可以让世界各地的朋友通过网络了解到你的企业和产品。其具有以下特点：<br>
	<b>一、内容丰富</b>
	对于您的企业和产品，您都可以自己上传丰富的图文内容，浏览者可以直接访问您的企业或产品信息，
	也可以通过关联信息访问。
	<br>
	<b>二、发布产品数目没有限制</b>
	无论您企业中有多少种产品，都可以无限制的发布到58板材网上，每个产品将以一个单独的产品页面的形式存在。
	<br>
	<b>三、免费策略</b>	
	目前网站所有用户均免费，包括首页广告栏投放和在首页推广。
	<h2>3、服务费用</h2>
	目前网站将服务划分为三级：首页广告栏投放、首页推广以及普通服务。
	对于首页广告栏投放和首页推广服务目前采取先注册先得的策略。对于普通推广服务，将终身免费。
	<h2>4、联系我们</h2>
    	<table id="connact_info">
    		<tr>
    			<td>客服群</td>
    			<td>47552873</td> 		
    			<td>邮箱</td>
    			<td>service@58bancai.com</td>
			</tr>
			<tr>
    			<td>联系电话</td>
    			<td>
  				 13716082191 15801192273  18612259320 15201394870 
    			</td>
		
    		</tr>
    	</table>
	</div>
	<hr>
	<%@ include file="../includefiles/footer.jsp" %>
</body>
</html>
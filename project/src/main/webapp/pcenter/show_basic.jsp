<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/personal.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
</head>
<body>
		<div
			style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;">

			<DIV class="rightbt" style="position: absolute; left: 0; top: 15%;">
				<b>基本信息</b>
			</DIV>		
			
			<table id="basic_table" style="position: absolute; left: 23%; top: 23%; width:50%;">																																										
				<tr>
					<th>昵称</th>																																																																																																																										
					<td><s:property value="user.nickname"/></td>
				</tr>
				<tr>
					<th>姓名</th>
					<td><s:property value="user.name"/></td>
				</tr>																																			
				<tr>
					<th>性别</th>
					<td><s:property value="user.gender"/></td>
				</tr>
				<tr>
					<th>办公电话</th>
					<td> <s:property value="officePhone.number"/></td>
				</tr>
				<tr>
					<th>手机</th>
					<td><s:property value="mobile.number"/></td>
				</tr>
				<tr>
					<th>QQ</th>
					<td> <s:property value="user.qq"/></td>
				</tr>
				<tr>
					<th></th>
					<td></td>
				</tr>
			</table>
	
			<INPUT id=u28 class="rightbutton" type=submit value="修改" 
				style="position: absolute; left: 35%; top: 65%;"
				onclick="location.href='pcenter/getPersonalInfo'">
				
			<INPUT id=u29 class="rightbutton" type=submit value="取消"
				style="position: absolute; left: 55%; top: 65%;">
		</div>

</body>
</html>
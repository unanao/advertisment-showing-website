<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css_files/admin.css" />
		 <base href="<%= request.getScheme() + "://" + request.getServerName() + 
		 		":" + request.getServerPort() + request.getContextPath() %>/" />
	</head>
	<body>
		<s:form action="admin_get_user">
			<div id="unactive_search">
				<input id="unactive_username" name="userName" 
						style="position: absolute; left:25%;  top: 20%;">
				<INPUT id="submit_search" type=submit value="搜索" 
						style="position: absolute; left: 55%; top: 20%;">
			</div>
		</s:form>
			
			<%-- user.name : 用户名（注册邮箱） 
				user.status: 用户状态（0：未激活；1:激活；2:冻结）
			--%>
			<table id="unactive_list" style="position: absolute; left: 20%; top:25%;">																																										
				<tr>																																																																																																																								
					<td> 用户名：<s:property value="user.email"/> </td>
					
					<%-- 将用户状态的数字表示转化为实际含义 --%>
					<td>用户状态：
						<s:if test="0 == user.status">  未激活  </s:if>
						<s:elseif test="1 == user.status"> 已激活 </s:elseif>
						<s:elseif test="2 == user.status" > 已冻结 </s:elseif>
						<s:else> </s:else>
					</td>
					
					<td>
						<a href="admin/admin_activate_user?userName=<s:property value="user.email"/>">
							激活
						</a>
					</td>
					
					<td>
						<a href="admin/admin_frozen_user?userName=<s:property value="user.email"/>">
							冻结
						</a>
					</td>
					
					<td>
						<a href="admin/admin_delete_user?userName=<s:property value="user.email"/>">
							删除
						</a>
					</td>
					
					<%--暂不支持
					<td>
						<a href="">
							修改密码
						</a>
					</td>
					--%>
				</tr>
			</table>
	</BODY>
</HTML>
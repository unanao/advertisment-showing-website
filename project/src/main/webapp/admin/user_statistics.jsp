<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css_files/admin.css" />
	</head>
	<body>
			<table id="user_cnt_table" style="position: absolute; left: 20%; top: 23%;">																																										
				<tr>																																																																																																																								
					<td>总注册用户数</td>
					<td> <s:property value="registerNr"/> </td>
				</tr>
				<tr>																																																																																																																								
					<td>激活用户数</td>
					<td> <s:property value="activateNr"/> </td>
				</tr>
				<tr>																																																																																																																								
					<td>未激活用户数</td>
					<td> <s:property value="unactivateNr"/> </td>
				</tr>
				<tr>																																																																																																																								
					<td>冻结用户数</td>
					<td> <s:property value="frozenNr"/> </td>
				</tr>		
			</table>
	</BODY>
</HTML>
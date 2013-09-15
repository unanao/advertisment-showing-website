<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/personal.css" />			
</head>
<body>
	<div
		style="position: absolute; left: 0px; top: 0px; width: 100%; height: 100%;">

		<DIV class="rightbt" style="position: absolute; left: 0; top: 15%;">
			<b>账户信息</b>
		</DIV>

		<DIV id=u22_rtf class="rightcontent"
			style="position: absolute; left: 15%; top: 25%;">您拥有套餐：</DIV>
		<div id="scrollDiv"
			style="position: absolute; left: 10%; top: 30%; width: 80%; overflow: auto; cursor: default; display: inline; position: absolute; text-align: center;">
			<table id='accountTable' width=100%; cellpadding='0' cellspacing='0'
				style='table-layout: auto' bordercolor='lightgrey'>
				<tr class="FixedTitleRow">
					<th class="FixedTitleColumn">套餐名称</th>
					<th class="FixedTitleColumn">广告栏</th>
					<th class="FixedTitleColumn">产品栏</th>
					<th class="FixedTitleColumn">企业栏</th>
					<th class="FixedTitleColumn">开始时间</th>
					<th class="FixedTitleColumn">结束时间</th>
				</tr>

				<s:if test="null!=packages">
					<s:iterator value="packages" id="package" status="status">
						<tr align='center' valign='middle'>
							<td><s:property value="#package.name" /></td>
							<td><s:property value="#package.adNum" /></td>
							<td><s:property value="#package.displayProductNum" /></td>
							<td><s:property value="#package.displayEnterpriseNum" /></td>
							<td><s:property value="#package.startTime" /></td>
							<td><s:property value="#package.endTime" /></td>
						</tr>
					</s:iterator>
				</s:if>
				<s:else>
					<tr align='center' valign='middle'>
						<td>您还没有购买套餐</td>
					</tr>
				</s:else>
			</table>
		</div>
	</div>

</body>
</html>
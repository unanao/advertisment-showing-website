<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="../css_files/admin.css" />
	</head>
	<body>
		<div id="user_package_panel">
		
		<s:form action="admin_get_purchase_package">
			邮箱地址：
			<input id="user_email" name="userName" >
			<input id="submit_email" type=submit value="查询" >
		</s:form>
			
		<s:if test="null!=purchasePackages">
			该用户目前拥有套餐：
			<table id="user_package_list" style="position: absolute; left: 25%; top: 20%;">																																										
			<%--此表显示目前该用户所有套餐，供查看使用，如有冲突可删除，第一列套餐名称--%>			
				
					<s:iterator value="purchasePackages" id="purchasePackage" status="status">
						<tr> 
							<td> <s:property value="#purchasePackage.name" /> </td> 
							<td> 
								<a href="admin_delete_purchase?
									userName=<s:property value="userName"/>&
									packageName=<s:property value="#purchasePackage.name" />">
									删除
								</a>
							</td>
						</tr>
					</s:iterator>
		 	</table>
		</s:if>
		<s:else>
			该用户还没有购买套餐
		</s:else>
		
		<p> <s:actionerror /> </p>
		
		<form action="admin_set_purchase?userName=<s:property value="userName"/>" 
				method="post" enctype="multipart/form-data"> 
			<table id="modify_package" style="position: absolute; left: 20%; top: 43%;">																																										
				<%--第一列回显检索到的账户名email
					第二列选择要增加的套餐（自动检索套餐以列表形式回显）
					第三列套餐开始时间
					第四列结束时间
				--%>	
				<tr>		
					<td>用户名： <s:property value="userName"/> </td> 
					
					<td> 
						购买套餐类型
						<select name="packageName">
							<s:if test="null != packages && !packages.isEmpty()">
								<s:iterator value="packages" id="package" status="status">
									<%--下面option选项列出目前所有套餐供选择--%>
									<option value="<s:property value="#package.name" />">
										<s:property value="#package.name" />
									</option>	 
				 				</s:iterator>
							</s:if>
							<s:else>
								<option value="无套餐可购买"> 无套餐可购买 </option>
							</s:else>
						</select>
					</td>
					
					<td>
						套餐生效时间（格式必须为yyyy-mm-dd）：
						<input id=start_date class="input_att_100"  name="startTime" type=text">
					</td>
					
					<td>
						套餐失效时间（格式必须为yyyy-mm-dd）：
						<input id=end_date class="input_att_100"  name="endTime" type=text">
					</td>
					
					<td>
						<input id=submit class="input_att_50"  name="submit" value="增加" 
						type="submit">
					</td>
				</tr>
			</table>
		</form>		
		
		</div>
	</BODY>
</HTML>
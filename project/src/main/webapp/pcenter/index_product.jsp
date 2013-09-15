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
	<div style="position:absolute; left:0%; top:0%; width:100%; height:100%;">
		<DIV  class="rightbt" style="position:absolute; left:0%; top:10%;"><b>管理产品信息</b></DIV>
		<button id=u97  type=button value="new_product" class="rightbutton" 
		style="position:absolute; left: 65%; top:20%;"  onclick="location.href='pcenter/saveProductPage'">
			发布新产品
		</button>
			<table id="product_table" style="position:absolute; left:25%; top:30%;">
			<s:iterator value="products" id="product">
				<tr>
					<td><s:property value="#product.name"/> </td>
					<td><a href="product/showProduct?productId=<s:property value="#product.id" />"  
                            target="_blank">
                                   查看
                        </a></td>
					<td><a href="pcenter/updateProductPage?productId=<s:property value='#product.id'/>">编辑</a></td>
					<td><a href="pcenter/deleteProduct?productId=<s:property value='#product.id'/>">删除</a></td>
                    
				</tr>
			</s:iterator>
			</table>
	</div>
</body>
</html>
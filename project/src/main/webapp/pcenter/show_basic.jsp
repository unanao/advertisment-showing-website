<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


		<div  class="span12">
			<table id="basic_table" class="table">	
			<tbody>																																						
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
				</tbody>			
			</table>
	
			<INPUT id=u28 class="btn" contenteditable="true" type="submit"
			 value="修改" onclick="location.href='pcenter/getPersonalInfo'">
				
			<INPUT id=u29 class="btn" contenteditable="true" type=submit value="取消">
		</div>

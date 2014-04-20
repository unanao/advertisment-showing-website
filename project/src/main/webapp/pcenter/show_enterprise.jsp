﻿<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<div>
		<table width="80%">
		   <tr>
		       <td><b>企业名称</b></td>
		       <td><s:property  value="enterprise.name"/></td>
		   </tr>
		   <tr>
		       <td><b>所在地</b></td>
		       <td>
	                <s:if test="enterprise.province != null">
	                    <s:property value="enterprise.province"/>
	                </s:if>
	        
	                <s:if test="enterprise.city != null"><s:property value="enterprise.city"/>
	                </s:if>
	        
	                <s:if test="enterprise.county != null">
	                        <s:property value="enterprise.county"/>
	                </s:if>
		       </td>
		   </tr>
		   <tr>
		       <td><b>详细地址</b></td>
		       <td><s:property value="enterprise.address"/></td>
		   </tr>
		   <tr>
		       <td><b>规模(人)</b></td>
		       <td><s:property value="enterprise.scale"/></td>
		   </tr>
		   <tr>
		       <td><b>联系姓名</b></td>
		       <td><s:property value="phone.contacter"/></td>
		   </tr>
		    <tr>
	           <td><b>联系电话</b></td>
	           <td><s:property value="phone.number"/></td>
	       </tr>
	        <tr>
	           <td><b>企业简介</b></td>
	           <td><s:property value="enterprise.introduction"/></td>
	       </tr>
	        <tr>
	           <td><b>公司logo</b></td>
	           <td><img style="width:100px" src="<s:property value="enterprise.logo"/>"/></td>
	       </tr>
	       <tr>
	       		<td>
	       			<b></>产品图片</b>
	       		</td>
	       	</tr>
	       <tr>
	        
	            <td colspan="2">
                    <s:iterator id="p" value="enterprisePictureMap">         
                    	<img  class="picture_logo" onload="DrawImage(this,100,100)" src="<s:property value='value.path'/>" alt="挂掉啦！" >
                    </s:iterator>
	            </td>
	       </tr>
	       
		</table>
	
		<p class="show_corp_button" >
            <input type="submit" value="修改" 
            		onclick="location.href='pcenter/updateEnterprisePage'">
            <input type="reset" value="取消">
       </p>
	</div>
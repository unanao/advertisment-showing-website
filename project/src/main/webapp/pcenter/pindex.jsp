<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<base href="<%=request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()%>/" />
					
<link rel="stylesheet" type="text/css" href="css_files/pcenter/pindex.css"/>	
<script type="text/javascript" src="js/pcenter/pindex.js"></script>

<div class="container-fluid">
	<div class="page-header pcheader"> <h4> 欢迎您</h4> </div>
	
	<p> <span class="label badge-info margin5 font16 padding58"> 我的套餐</span> </p>
	<div class="row-fluid">
        <div class="span12">
        	<ul id = "packages_info" > </ul>
            <span class ="no_content_msg" id="no_package_msg"  style="color:green; display:none">
				您目前是免费套餐
			</span>
      	</div>
	</div>
          
    <p> <span class="label badge-info margin5 font16 padding58"> 我的企业</span> </p>
    <span class ="no_content_msg" id="no_enterprise_msg""> 
    	您还没有企业信息
    </span>
	<div  class="row-fluid">
    	<div class="span8" id="enterprise_info" style="display:none">
			<table class="table-condensed " width="80%">
		   	<tr>
		       <td><b>企业名称</b></td>
		       <td id = "enterpriseName"></td>
		       <td><b>所在地</b></td>
		       <td id = "location"></td>
		   	</tr>
		   	<tr>
		       <td><b>详细地址</b></td>
		       <td id = "address"></td>
		       <td><b>规模(人)</b></td>
		       <td id = "scale"></td>
		   	</tr>
		   	<tr>
		       <td><b>联系姓名</b></td>
		       <td id = "contacter"></td>
	           <td><b>联系电话</b></td>
	           <td id = "number"></td>
	       	</tr>
	        <tr>
	           <td><b>企业简介</b></td>
	           <td id = "introduction"></td>
	       	</tr>
	        <tr>
	           <td><b>公司logo</b></td>
	           <td><img  id = "logo" style="width:100px"/></td>
	       	</tr>
			</table>
		</div>
	</div>

    <span class="label badge-info margin5 font16 padding58"> 我的产品 </span>
    <ul id = "product_info" class="thumbnails"></ul>
    <span class ="no_content_msg" id="no_product_msg"  style="color:green;display:none"> 
    	您目前没有产品信息
    </span>
</div>

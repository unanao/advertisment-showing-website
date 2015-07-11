<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/search_more.css" />
	<style type="text/css">
		.search
		{
			color:#000000;
			text-align: left ; 
		}
		
		.padding_left
		{
	    	font-size : 16px;
	    	padding-left: 10px;
	    	font-family:'Arial';
		}
	
		.search_layout 	
		{
		   height: 40px; 
		   border:solid 1px #000; 
		   margin:0;
		   padding-top:10px;
		   background-color:#eeeeee;
		}
	</style>	
</head>
<body>
	<%@ include file="/includefiles/navigate4search.jsp" %>
	
	<%@ include file="../js/js_common.inc"%>
	<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>
	
	<s:form action="search_get_result" style="margin:0px;">
		<p class="search_layout">
			<label  class="padding_left"> <b>搜索</b> </label> 
			<INPUT name="content" type=text  value="">
			 
			<span  class="padding_left">高级搜索</span>
			 		
			<span  class="padding_left"> 类别 </span> 
			 <select id="category" name="category"></select>
			 <span  class="padding_left"> 产品 </span> 
			<select id="detail" name="specification"></select>
			
			<span  class="padding_left"> 地 区 </span>
			<span class="province_city_layout">
				<select id="province" name="province"></select>
				<select id="city" name="city" ></select>
				<select id="county" name="county"></select>
			</span>
			
			<INPUT type=submit value="搜索" style="text-align: center;">
		</p>
	</s:form>

	<div style="position: absolute; left: 14%; top: 250px; height: 105px;">
		<table>
			<s:include value="/product/traversal_product.jsp" />
	       	
	       	<%-- 企业和产品强制换行，更好的方案没有想出来 --%>
	       	</tr> <tr>
	       	
	       	<s:include value="/enterprise/traversal_enterprise.jsp" />
	    </table>
	    
	    <%-- 分页 --%>
		<s:include value="/includefiles/_pager.jsp">
        	<s:param name="url">
        		search/search_get_result?content=<s:property value="content"/>&
        		category=<s:property value="category"/>&
        		specification=<s:property value="specification"/>&
        		province=<s:property value="province"/>&
        		city=<s:property value="city"/>&
        		county=<s:property value="county"/>&
        	</s:param>
       </s:include>
	</div>
	

	<script type="text/javascript" src="js/province_city_select/search_sitedata_bas.js"></script>
	<script type="text/javascript" src="js/province_city_select/province_city.js"></script>
	<script type="text/javascript" src="js/product_select/product_category.js"></script>
	<script type="text/javascript" src="js/product_select/product_select.js"></script>
	<script type="text/javascript" src="js/pcenter/product.js"></script> 
	<script type="text/javascript" src='js/search/search.js'></script>
</body>
</html>
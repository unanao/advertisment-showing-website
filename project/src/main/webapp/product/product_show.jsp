<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
				
    	<link rel="stylesheet" type="text/css" href="library/bootstrap/css/bootstrap.css" />							
		<link rel="stylesheet" type="text/css" href="css_files/all_show_cat.css" />
		<link rel="stylesheet" type="text/css" href="css_files/common.css" />	
		<link rel="stylesheet" type="text/css" href="css_files/pcenter_common.css" />			
		<script type="text/javascript" src="library/jquery/jquery.js"></script>
		<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>	
		<script type="text/javascript" src="js/photo_switch_show.js"></script>	
		<script type="text/javascript" src="js/product/product_show.js"></script>
	</head>
	<body>
	  <%@ include file="../includefiles/navigate.jsp" %>
	  <div class="right-extra">
	    <%-- 大图和缩略图列表start --%>
	    <div class="fl">
	      <div id=div_img_main>
	        <%-- 待优化，style="height:100%;"，优化方式：用js代码动态调节 --%>
	        <img id="img_main"  onload="DrawImage(this,300,225)" 
	        src="<s:property value="product.icon"/>" alt="gua">
	      </div>
	      <div id=img_list>
	        <ul class="tb-thumb">
	          <s:iterator id="p" value="productPictures">
	            <li class="tb-selected">
	            <div class="tb-pic">
	              <IMG src="<s:property value="#p.path"/>"
	                  onload="DrawImage(this,50,50)"
	                  onmouseover="change_photo_show(this)"	
	                   alt="挂掉啦！">
	
	            </div>
	          </li>
	        </s:iterator>
	      </ul>
	    </div>
	  </div>
	  <%-- 大图和缩略图列表end --%>
	  
	  <%-- 文字信息列表start --%>
	  <div id="show_info">
	    <table id="E_Inf_Table" style="position:relative; ">
	      <tr>
	        <th width="150px">
	          产品名称：
	        </th>
	        <%--请后台提供产品名称--%>
	        <td>
	          <s:property value="product.name"/>
	        </td>
	      </tr>
	      <tr>
	        <th>
	          所属企业：
	        </th>
	        <%--请后台提供所属企业--%>
	        <td>
	          <a 
	              href="enterprise/showEnterprise?enterpriseId=<s:property value='enterprise.id'/>"
	              style="text-decoration:underline;">
	
	            <s:property value="enterprise.name"/>
	          </a>
	        </td>
	      </tr>
	      <tr>
	        <th>
	          联系人：
	        </th>
	        <%--请后台提供联系人--%>
	        	<td id="contacter"></td>
	      </tr>
	      <tr>
	        <th>
	          联系电话：
	        </th>
	        <%--请后台提供电话--%>
	        <td id="phonenumber"></td>
	      </tr>
	      <tr>
	        <th>
	          点击数：
	        </th>
	        <%--请后台提供点击数--%>
	        <td>
	          <a 
	              href="enterprise/showEnterprise?enterpriseId=<s:property value='enterprise.id'/>"
	              style="text-decoration:underline;">
	
	            <s:property value="enterprise.name"/>
	          </a>
	        </td>
	      </tr>
	      <tr>
	        <th>
	          收藏数：
	        </th>
	        <%--请后台提供收藏数--%>
	        <td>
	          <a 
	              href="enterprise/showEnterprise?enterpriseId=<s:property value='enterprise.id'/>"
	              style="text-decoration:underline;">
	
	            <s:property value="enterprise.name"/>
	          </a>
	        </td>
	      </tr>
	    </table>
	  </div>
	  <%-- 文字信息列表end --%>
	  
	  <%-- 产品详情start --%>
	  <div class="span12 briefinformation">
	    <div class="tabbable">
	        <a class="nav nav-tabs" data-toggle="tab">
	          产品详情
	        </a>
	    <div class="tab-content mg10">
	        <p>
	          <s:property value="product.introduction"/>	
	        </p>
	        <div>
	          <s:iterator id="p" value="productPictures">
	            <div class="mgt30">
	              <IMG  src="<s:property value="#p.path"/>" onload="DrawImage(this,500,500)" alt="挂掉啦！">
	            </div>
	          </s:iterator>
	      	</div>
	    </div>
	  </div>
	</div>
	</div>
	<!--right-extra end-->
	<%@include file="../includefiles/left.jsp"%>
	

    	<span class="clr">
	    </span>
	    <%@ include file="../includefiles/footer.jsp" %>	
	<!-- footer end -->
	</body>
	
</html>
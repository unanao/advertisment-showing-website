<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />		
		<link rel="stylesheet" type="text/css" href="css_files/all_show_cat.css" />
		<link rel="stylesheet" type="text/css" href="css_files/common.css" />
		<link rel="stylesheet" type="text/css" href="css_files/jquery.jqzoom.css" />
		<script type="text/javascript" src="js/photo_autosize.js"></script>
		<script type="text/javascript" src="js/jquery/jquery.js"></script>
		<script src="js/jquery/jquery-1.6.js" type="text/javascript"></script>
		<script src="js/jquery.jqzoom-core.js" type="text/javascript"></script>
		<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>	
		<script type="text/javascript" src="js/photo_switch_show.js"></script>	
	</head>
	<body style="height:700px;">	
		<%@ include file="../includefiles/navigate.jsp" %>	
		<h3 id="pcenter_title" align="center">产品展示</h3>
        <div id="show_photo">
           <div id="div_img_main">
            	<%-- 待优化，style="height:100%;"，优化方式：用js代码动态调节 --%>
                <img id="img_main" onload="DrawImage(this,300,225)" src="<s:property value="product.icon"/>" alt="gua">
			</div>
            <div id=img_list>
                <ul class="tb-thumb">
                    <s:iterator id="p" value="productPictures">
                        <li class="tb-selected">
                            <div class="tb-pic">
                                <IMG id=u126 src="<s:property value="#p.path"/>" onload="DrawImage(this,50,50)" 
								onmouseover="change_photo_show(this)"      alt="挂掉啦！">
                            </div>
                        </li>
                    </s:iterator>
                </ul>
            </div>
		</div>
		<div id="show_info">						
		<table id="E_Inf_Table" style="position:relative; ">																																										
			<tr>																																																																																																																								
				<th>产品名称：</th>
				<%--请后台提供产品名称--%>
				<td><s:property value="product.name"/></td>
			</tr>
			<tr>																																																																																																																								
				<th>所属企业：</th>
				<%--请后台提供所属企业--%>
				<td>
					<a href="enterprise/showEnterprise?enterpriseId=<s:property 
						value='enterprise.id'/>" 
						style="text-decoration:underline;">
						<s:property value="enterprise.name"/>
					</a>
				</td>
			</tr>
			<tr>
				<th>产品简介</th>
				<td>
				    <s:property value="product.introduction"/>
				</td>
			</tr>
		</table>				
		</div>		
		<div id="blank_space"></div>
				
	</body>
		<script type="text/javascript">
		$(document).ready(function() {
			$('.jqzoom').jqzoom({
		            zoomType: 'standard',
		            lens:true,
		            preloadImages: false,
		            alwaysOn:false
		        });
		});		
		</script>
</html>
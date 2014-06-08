<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
    	<link rel="stylesheet" type="text/css" href="css_files/bootstrap.css" />							
		<link rel="stylesheet" type="text/css" href="css_files/all_show_cat.css" />
		<link rel="stylesheet" type="text/css" href="css_files/common.css" />
		<link rel="stylesheet" type="text/css" href="css_files/plist20130808.css" />	
		<link rel="stylesheet" type="text/css" href="css_files/pcenter_common.css" />		
		<script type="text/javascript" src="js/photo_autosize.js"></script>
		<script type="text/javascript" src="js/jquery/jquery.js"></script>
		<script src="js/jquery/jquery-1.6.js" type="text/javascript"></script>
		<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>	
		<script type="text/javascript" src="js/photo_switch_show.js"></script>	
	</head>
	<body>	
		<%@ include file="../includefiles/navigate.jsp" %>	
        <div class="right-extra">
        	<div class="fl">
           		<div id=div_img_main>
            		<%-- 待优化，style="height:100%;"，优化方式：用js代码动态调节 --%>
                	<img id="img_main"  onload="DrawImage(this,300,225)" src="<s:property value="product.icon"/>" alt="gua">
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
				<th width="150px">产品名称：</th>
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
				<th>联系人：</th>
				<%--请后台提供联系人--%>
				<td>
					<a href="enterprise/showEnterprise?enterpriseId=<s:property 
						value='enterprise.id'/>" 
						style="text-decoration:underline;">
						<s:property value="enterprise.name"/>
					</a>
				</td>
			</tr>		
			<tr>																																																																																																																								
				<th>联系电话：</th>
				<%--请后台提供电话--%>
				<td>
					<a href="enterprise/showEnterprise?enterpriseId=<s:property 
						value='enterprise.id'/>" 
						style="text-decoration:underline;">
						<s:property value="enterprise.name"/>
					</a>
				</td>
			</tr>		

		</table>				
		</div>	
	<div class="span12 briefinformation">
			<div class="tabbable" id="tabs-149041">
				<ul class="nav nav-tabs">
					<li class="active">
						<a data-toggle="tab">产品简介</a>
					</li>
				</ul>
				<div class="tab-content">
					<div class="tab-pane active mg10" id="">
						<p>
							<s:property value="product.introduction"/>
							
						</p>
						<div>
                    <s:iterator id="p" value="productPictures">
                            <div class="mgt30">
                                <IMG  src="<s:property value="#p.path"/>" onload="DrawImage(this,500,500)" 
					      alt="挂掉啦！">
                            </div>
                    </s:iterator>						
						</div>
					</div>
				</div>
			</div>
	</div>
	</div>
	<!--right-extra end-->
	<%@include file="../includefiles/left.jsp"%>	
	</body>
</html>
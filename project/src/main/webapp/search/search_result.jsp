<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css_files/index_cat.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/search_more.css" />
	
	 <script type="text/javascript" src="library/jquery/jquery.js"></script>
	<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>
	<script type="text/javascript" src='js/search/search.js'></script>
	
</head>
<body>
	<%@ include file="/includefiles/navigate4search.jsp" %>
	
	<%-- 搜索内容 --%>
	<s:form action="search_get_result" style="margin:0px;">
		<s:include value="/search/search_input.jsp" />
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
</body>
</html>
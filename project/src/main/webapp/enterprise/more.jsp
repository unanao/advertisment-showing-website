<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/search_more.css" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css">
	<script type='text/javascript' src='js/jquery/jquery.js'></script>
</head>
<body>
	<%@ include file="/includefiles/navigate.jsp" %>
	<%-- 搜索内容 --%>
	<s:form action="/search/search_get_result" style="margin:0px;">
		<s:include value="/search/search_input.jsp" />
	</s:form>
	
		<!-- 下面顺序罗列搜索结果 -->
	       <table>
	       		<s:include value="traversal_enterprise.jsp" />
	        </table>
	        <s:include value="/includefiles/_pager.jsp">
                <s:param name="url">enterprise/listMoreEnterprises?county=<s:property value="county"/></s:param>
            </s:include>
</body>
	<script type="text/javascript">
		var mywidth = (document.body.offsetWidth) * 0.65 / 6;
		var myheight = mywidth * 3 / 4;
	</script>		 
</html>

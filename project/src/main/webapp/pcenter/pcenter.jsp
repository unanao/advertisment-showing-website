
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />		
	
		<%@ include file="../css_files/css_common.inc" %>
   		<link rel="stylesheet" type="text/css" href="css_files/plist.css" media="all">
		<link rel="stylesheet" type="text/css" href="css_files/pcenter/pcenter_common.css" />
		<%-- 下面的CSS文件待整合，目前应用于企业信息修改页面 --%>
	<link rel="stylesheet" type="text/css" href="css_files/form.css" />
	<link rel="stylesheet" type="text/css" href="css_files/pcenter/modify_enterprise.css" />
	</head>
	<body>
		<!--navigator start-->		
		<%@ include file="../includefiles/navigate.jsp" %>	
		<!--navigator end-->
		
        <div id="pcenter_right" class="right-extra">
			<%@ include file="pindex.jsp" %>	
		</div>
		<!--right-extra end-->
		
		<div class="left">	
			<%@include file="left.jsp"%>
		</div>	
		<!-- left-navigator end -->
	
	<%@ include file="../js/js_common.inc"%>
	<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>	
	<script type="text/javascript" src="js/pcenter/pcenter_navigator_switch.js"></script>
	
	<script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/local_preview.js"></script>	
	</body>
</html>


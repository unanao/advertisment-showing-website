<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<link rel="stylesheet" type="text/css" href="css_files/form.css" />
	<link rel="stylesheet" type="text/css" href="css_files/accounts/login.css" />
	
	<script type="text/javascript" src="library/jquery/jquery.js"></script>
	<script type="text/javascript" src='js/accounts/login.js'></script>
</head>
<body>
    <div class="w" id="header-2013">
      <div id="logo-2013" class="ld">
        <a href="http://www.58bancai.com/" hidefocus="true">
          <img src="images/logo.png" width="180" height="90" alt="58板材">
        </a>
      </div>
    </div>
	<%@ include file="_login.jsp" %>
</body>
</html>
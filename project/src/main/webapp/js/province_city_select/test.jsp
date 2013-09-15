<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

</html>
<head>
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + 
			request.getServerPort() + request.getContextPath() %>/" />
</head>

<body>
	<s:include value="province_city_select.jsp" />
</body>
</html>
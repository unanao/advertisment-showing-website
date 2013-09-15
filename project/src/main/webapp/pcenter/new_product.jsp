<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
                + request.getServerPort() + request.getContextPath() %>/" />



    </head>
    <body>
        <form action="pcenter/updateProduct" method="post" enctype="multipart/form-data">
        <%@ include file="product_operation_include.jsp" %>
        </form>
    </body>
</html>
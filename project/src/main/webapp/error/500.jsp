<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<% response.setStatus(500); %>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <title>错误提示页</title>
  <s:include value="/_head.jsp" />
</head>
<body>
<div id="container">
	<s:include value="/_banner.jsp" />
	<div id="inner">
		<div class="content">
			<center><h1>对不起，服务器开小差了 o(╯□╰)o</h1></center>
			<%//上线时去掉！ %>
			<a href="javascript:e=document.getElementById('es').style;if(e.display=='')e.display='none';else e.display='';void(0);">查看错误</a>
			<div id="es" style="display:none;">${exceptionStack}</div>
		</div><!-- #content -->
	</div><!-- #inner -->
	<s:include value="/_footer.jsp" />
</div><!--#container-->
<script type="text/javascript" src="http://front.free4lab.com/js/public.js"></script>
<script type="text/javascript">
$(function() {
  $("#es").html($("#es").html()
	  .replace(/Caused by:/ig, "<br/><br/><span style='color:red;font-weight:bold;'>Caused By:</span>")
	  .replace(/at /g, "<br/>&nbsp; &nbsp; &nbsp; &nbsp;at "));
});  
</script>
</body>
</html>
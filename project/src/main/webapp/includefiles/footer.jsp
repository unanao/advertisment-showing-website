<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script type="text/javascript">  
	$(function() {
		var myDate = new Date();  
    	document .getElementById ("currunt_year").innerHTML = myDate.getFullYear();
	});
</script>

<div id="footer">
    <a href="http://www.miitbeian.gov.cn/"> 京ICP备13003750号 </a> 
    <br>
    Copyright&copy; 2011-<span id='currunt_year'> </span> 58板材 版权所有
    <br>
    <img style="width:50px;height:50px;" src="images/wangjing.jpg">
</div>
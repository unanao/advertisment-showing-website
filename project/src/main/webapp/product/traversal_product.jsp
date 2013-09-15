<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />

<script type="text/javascript">
	var screen_width = document.body.offsetWidth;
	var mywidth = screen_width * 0.8 / 6;
	var myheight = mywidth * 3 / 4;
</script>

<s:if test="null != products">
<s:iterator value="products" id="product" status="status">
     	<td>
         	<img alt="正在加载..." onerror= "javascript:this.src='image/default43.jpg'" 
         		onload="DrawImage(this,mywidth,myheight)" src="<s:property value="#product.icon"/>" >
       		<br />
  			<a href="product/showProduct?productId=<s:property value="#product.id" />">
           		<s:property value="#product.name"/>
        	</a>
        	<br />
   		</td>
   		<s:if test="(#status.index + 1) % 6 == 0"> </tr><tr> </s:if>
	</s:iterator>
</s:if>

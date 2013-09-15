<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />

<script type="text/javascript">
	var screen_width = document.body.offsetWidth;
	var mywidth = screen_width * 0.8 / 6;
	var myheight = mywidth * 3 / 4;
</script>

<s:if test="null != enterprises">
	<s:iterator value="enterprises" id="enterprise" status="status">
        <td>
           	<img alt="正在加载logo..." onload="DrawImage(this,mywidth,myheight)" 
           	  	onerror= "javascript:this.src='image/default43.jpg'" 
           	  	src="<s:property value="#enterprise.logo"/>" >
            <br />
            <a href="enterprise/showEnterprise?enterpriseId=
            		<s:property value="#enterprise.id"/>">
              		<s:property value="#enterprise.name"/>
             </a>
             <br/>
      	</td>
      		
       	<s:if test="(#status.index + 1) % 6 == 0"> </tr><tr> </s:if>
   	</s:iterator>
</s:if> 

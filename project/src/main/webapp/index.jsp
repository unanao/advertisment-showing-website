<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
	<link rel="stylesheet" type="text/css" href="css_files/index_cat.css?v=3" />
	<link rel="stylesheet" type="text/css" href="css_files/common.css" />
	<script type="text/javascript" src="js/jquery/jquery.js"></script>
	<script type="text/javascript" src="js/image_auto_resize/autoresize_image.js"></script>
	<script type="text/javascript" src="js/advitise_photos.js"></script>
</head>
<body  onresize="window.location.reload()">	
	<script type="text/javascript">
		var screen_width = document.body.clientWidth-2;
		var mywidth = screen_width * 0.8 / 6;
		var myheight = mywidth * 3 / 4;
		var advertise_width = (screen_width / 4) - 4; /* minus 4, solve:the space of photo is just not enough,that one lay to line 2*/
		var advertise_height = advertise_width * 3 / 4;
	</script>
	
	<%@ include file="includefiles/navigate.jsp" %>
		<div id="banner">  
		    <div id="banner_bg"></div>  
		    <div id="banner_info">
		    	<table id="banner_info_name">
		    		<tr>
		    			<td></td>
						<td></td>
						<td></td>
						<td></td>
		    		</tr>
		    	</table>
		    </div> 
		    <ul>
		        <li class="on">1</li>
		        <li>2</li>
		    </ul>
		   <div id="banner_list">
		 	 <%--默认显示四个产品 --%>
<s:iterator value="advertiseProducts" id="p"><a href="product/showProduct?productId=<s:property value="#p.Id"/>"><img class="advertise" onload="DrawImage(this,advertise_width,advertise_height)" src="<s:property value="#p.icon"/>"  
alt="<s:property value="#p.name"/>" border="0"></a></s:iterator>		   
		        <%--默认显示四个企业 --%>
<s:iterator value="advertiseEnterprises" id="e"><a href="enterprise/showEnterprise?enterpriseId=<s:property value='#e.id'/>"><img class="advertise" onload="DrawImage(this,advertise_width,advertise_height)" src="<s:property value="#e.logo"/>" 
alt="<s:property value="#e.name"/>" border="0"></a></s:iterator></div>
		</div>		
		
		<%-- 搜索输入框 --%>
		<s:form action="search/search_get_result" style="margin:0;">
			<s:include value="search/search_input.jsp"/>
 		</s:form>  
		
		<%-- 下面开始企业名片显示部分 --%>
		 <div  class="main_body main_body1">
	        <div id="title1_jixie" class="title1">板材</div>
	
	        <div id="region1" class="card_block">
	            <div class="title2_region title2">
	                <div class="title2_name">胶合板</div><div class="title2_more"><a href="product/listMoreProducts?category=胶合板">更多...</a></div>
	            </div>
	            <table class="card_table">
	               <tr>
	                <s:iterator value="displayProducts" id="product" status="status" begin="0" end="5">
	                    <td>
	                    	<a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                          <img class="ent_product" onload="DrawImage(this,mywidth,myheight)"  src="<s:property value="#product.icon"/>" 
	                          		border="0" alt="images/default.jpg"/>
	                     	</a>
	                     	<br>
	                		<s:property value="#product.name"/><br>
	                    </td>
	                </s:iterator>
	                    </tr>
	             </table>
	        </div>
	
	        <div id="region2" class="card_block" >
	            <div  class="title2_region title2">
	                <div class="title2_name">防火板</div>
	                <div class="title2_more"><a href="product/listMoreProducts?category=防火板">更多...</a></div>
	            </div>
	            
	                <table class="card_table">
	                 <tr>
	                    <s:iterator value="displayProducts" id="product" status="status" begin="6" end="11">
	                       <td>
	                       <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                       <img class="ent_product" onload="DrawImage(this,mywidth,myheight)" src="<s:property value="#product.icon"/>" 
	                       		border="0" alt="fault" />
	                        </a><br>
	                       <s:property value="#product.name"/><br>
	                       </td>
	                    </s:iterator>
	                    </tr>
	                </table>
	        </div>
	
	
	         <div id="region3" class="card_block">
                <div class="title2_region title2">
                    <div class="title2_name">装饰面板</div>
                    <div class="title2_more"><a href="product/listMoreProducts?category=装饰面板">更多...</a></div>
                </div>
                
                    <table class="card_table">
                     <tr>
                        <s:iterator value="displayProducts" id="product" status="status" begin="12" end="17">
                           <td>
                           <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
                           <img class="ent_product" onload="DrawImage(this,mywidth,myheight)" src="<s:property value="#product.icon"/>" 
                           		border="0" alt="fault" />
                            </a><br>
                           <s:property value="#product.name"/><br>
                           </td>
                        </s:iterator>
                        </tr>
                    </table>
            </div>
	
	         <div id="region4" class="card_block">
                <div class="title2_region title2">
                    <div class="title2_name">实木板</div>
                    <div class="title2_more"><a href="product/listMoreProducts?category=实木板">更多...</a></div>
                </div>
                
                    <table class="card_table">
                     <tr>
                        <s:iterator value="displayProducts" id="product" status="status" begin="18" end="23">
                           <td>
                           <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
                           <img class="ent_product" onload="DrawImage(this,mywidth,myheight)" src="<s:property value="#product.icon"/>" 
                           		border="0" alt="fault" />
                            </a><br>
                           <s:property value="#product.name"/><br>
                           </td>
                        </s:iterator>
                        </tr>
                    </table>
            </div>	
	
			<div id="region5" class="card_block" >
	            <div  class="title2_region title2">
	                <span class="title2_name">细木工板</span>
	                <span class="title2_more"><a href="product/listMoreProducts?category=细木工板">更多...</a></span>
	            </div>
	            <table class="card_table">
	                   <tr>
	                    <s:iterator value="displayProducts" id="product" status="status" begin="24" end="29">
	                       <td>
	                       <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                       <img class="ent_product" onload="DrawImage(this,mywidth,myheight)"
	                       		src="<s:property value="#product.icon"/>" border="0" alt="fault" />
	                       </a><br>
	                       <s:property value="#product.name"/><br>
	                       </td>
	                    </s:iterator>
	                    </tr>
	                </table>
	        </div>
	    </div>
	
	
<%--下面是按机械显示部分 --%>
	    <div class="main_body main_body2">
	        <div id="title1_diqu" class="title1">机械</div>
	
	        <div id="region5" class="card_block">
	            <div  class="title2_region title2">
	                <span class="title2_name">旋切机</span>
	                <span class="title2_more"><a href="product/listMoreProducts?category=旋切机">更多...</a></span>
	            </div>
	            <table class="card_table">
	                   <tr>
	                    <s:iterator value="displayProducts" id="product" status="status" begin="30" end="35">
	                       <td>
	                       <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                       <img class="ent_product" onload="DrawImage(this,mywidth,myheight)"
	                       		src="<s:property value="#product.icon"/>" border="0" alt="fault" />
	                       </a><br>
	                       <s:property value="#product.name"/><br>
	                       </td>
	                    </s:iterator>
	                    </tr>
	                </table>
	        </div>
	
	        <div id="region6" class="card_block">
	            <div  class="title2_region title2">
	                <span class="title2_name">热压机</span>
	                <span class="title2_more"><a href="product/listMoreProducts?category=热压机">更多...</a></span>
	            </div>
	            <table class="card_table">
	                   <tr>
	                    <s:iterator value="displayProducts" id="product" status="status" begin="36" end="41">
	                       <td>
	                       <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                       <img class="ent_product" onload="DrawImage(this,mywidth,myheight)"
	                       		src="<s:property value="#product.icon"/>" border="0" alt="fault" />
	                       </a><br>
	                       <s:property value="#product.name"/><br>
	                       </td>
	                    </s:iterator>
	                    </tr>
	                </table>
	        </div>

	    </div>
		<%@ include file="includefiles/footer.jsp" %>
	</body>
</html>

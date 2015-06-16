<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
							
<script type="text/javascript" src="js/pcenter/product_list.js"></script>

<div class="span12">
	<div class="blank"></div>
	<p>
		<a  class="btn-small fr" style="margin-right:100px" value="new_product" 
			onclick="$('#pcenter_right').load('pcenter/product.jsp');">
			发布新产品》
		</a>
	</p>	

	<table class="table" id="product_table">
            <tbody>  
                <tr id="template">  
                   <td id = "name"></td>  
                   <td id = "preview"></td>  
                   <td id = "modify"></td>  
                   <td id = "delete"></td>          
                 </tr>  
             </tbody>  
	</table>

</div>

		

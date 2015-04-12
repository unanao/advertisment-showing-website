<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />		
    <script type="text/javascript" src="js/product_select/product_category.js"></script>
	<script type="text/javascript" src="js/product_select/product_select.js"></script>
	<script type="text/javascript" src="js/pcenter/product.js"></script> 
	
	<s:fielderror> <s:param> productId </s:param> </s:fielderror> 
	<!-- 输出系统的Action Error提示 -->
	<p>	   
	   <div class="common_error"> <s:actionerror /> </div>
	</p>
	<p>
	<span id="ename" class="common_error" style="position:relative; left:20%"> 
		<s:fielderror> <s:param> name </s:param> </s:fielderror> 
	</span>
	</p>
	 
	<p>
		<label class="form_label">产品名称</label>
       	<input id="name" name="name" class="form_input" type="text"/>
	</p>
	
	<p>
          <span id="ecategory" class="common_error" style="position:relative; left:20%"> 
              <s:fielderror> <s:param> category </s:param> </s:fielderror> 
          </span>
    </p>

	<p>
       	<label class="form_label">类别</label>
       	  <select id="category" name="category"></select>
           <select id="detail" name="detail"></select>
       </p>
              
        <p>
       		<span id="eintroduction" class="common_error" style="position:relative; left:20%"> 
				<s:fielderror> <s:param> introduction </s:param> </s:fielderror> 
			</span>
		</p>
		<p>
           <label class="form_label">描述</label>
           <textarea id="introduction" class="form_textarea" name="introduction"></textarea>
		</p>
	

         <%--上传多张图片开始--%>
         <p>
         	<label class="form_label">封面</label>
         	 <div id="icon"></div>
         </p>

		<p>         
	        <label class="form_label">上传照片</label>
	        
	        <!--  这部分只需要保留inpunt。
	                 javascript 在 product.js 中处理， 请使用ajax完成， 不然没有办法保证， 修改后直接可见。
	      		     完成后， 请将此处代码删除。
	        <INPUT id=u198  type="file" name="file" value="浏览"   onchange="deal_new_picture('productId','pcenter/saveProductPicture',
	            'pcenter/pubProductPicture','pcenter/deleteProductPicture','icon',this)" /> 
	          -->
	          <INPUT id=u198  type="file" name="file" value="浏览" /> 
	              
	        <input id="fileId" name="id" type="hidden" value="-1"/>
	        
	        <input id="enterpriseId" name="enterpriseId" type="hidden" />
			<input id="productId" name="productId" type="hidden"/>

	        <span style="font-size:10px;">最多可传5张图片</span>
        </p>
        
	         <div id="thumb" class="thumb" >
	                <ul  id="thumb_list">
	                    <%--此处由javascript控制动态显示图片缩略图--%>		
	                </ul>
	        </div>
	        
	        <!--   这部分 javascript 在 product.js 中处理， 请使用ajax完成， 不然没有办法保证， 修改后直接可见。
	      		     完成后， 请将此处代码删除。
			  <s:iterator value="productPictureMap" id="id" status="st">
            <script type="text/javascript" >
                deal_return_picture("<s:property value='key'/>","<s:property value='value.path'/>","productId",'pcenter/pubProductPicture','pcenter/deleteProductPicture','icon');
            </script>
           </s:iterator>	
           -->
           	
        <%--上传多张图片结束--%>  
        <div style="clear:both;"></div>     
        <div id="bottom_button_div">
        	<button id="submit" class="btn" type="button" value="提交"  onclick="setProduct()">提交</button>
        	<button id="cannel" class="btn" type="button" value="取消" onclick="deal_new_picture()">取消</button>
		</div>
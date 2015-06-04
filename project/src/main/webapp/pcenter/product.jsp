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
	<div class="common_error"> 	<p> <s:actionerror /></p> </div>
	
	<!-- Record productId -->
	<input id="fileId" name="id" type="hidden" value="-1"/>
	<input id="productId" name="productId" type="hidden"/>
	
	<span class="save_ok"  id="save_ok_msg" > 资料修改成功!</span>
	
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
         	 <img id="icon"></img>
         </p>

		<p>         
	        <label class="form_label">上传照片</label>
	         <INPUT id="product_pic"  type="file" name="file" value="浏览" /> 
	        <span style="font-size:10px;">最多可传5张图片</span>
        </p>
        
	         <div id="thumb" class="thumb" >
	                <ul  id="thumb_list">
	                    <%--此处由javascript控制动态显示图片缩略图--%>		
	                </ul>
	        </div>   	
        <%--上传多张图片结束--%>  
        
        <div style="clear:both;"></div>     
        <div id="bottom_button_div">
        	<button id="submit" class="btn" type="button" value="提交"  onclick="setProduct()">提交</button>
        	<button id="cannel" class="btn" type="button" value="取消" onclick="deal_new_picture()">取消</button>
		</div>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<base
	href="<%=request.getScheme() + "://" + request.getServerName()
					+ ":" + request.getServerPort() + request.getContextPath()%>/" />
  	<script type="text/javascript" src="js/jquery/jquery.js"></script>
  	<script  src="js/province_city_select/search_sitedata_bas.js"></script>
	<script  src="js/province_city_select/province_city.js"></script>	
    <!-- Should load enterprise.js firstly, otherwise will not get the data -->
    <script type="text/javascript" src="js/pcenter/enterprise.js"></script>	
 		
 	<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>	
	<script type="text/javascript" src="js/pcenter/pcenter_navigator_switch.js"></script>
		<%-- 下面的js文件待整合，目前应用于企业信息修改页面 --%>
    <script type="text/javascript" src="js/ajaxfileupload.js"></script>
    <script type="text/javascript" src="js/local_preview.js"></script>
 		
	<s:if test="(null != message) && (!message.isEmpty())">
		填写产品信息前，需要先填写企业信息		
	</s:if>
	
    <form> 
       	 
       	<!-- 企业名称 -->
       	<p>
       	 	<span id="ename" class="common_error error_postion"> 
        		<s:fielderror fieldName="name"/>
        	</span>
        </p>
        <p>
        	<label class="form_label">企业名称</label>
        	<INPUT id="name" name="name" class="form_input" type="text"/>
        </p>
        
        <p>
       		<label class="form_label">所在地</label>
       		<div class="province_city">
   			<select id="province" class="search_select" name="province"></select>
			<select id="city" class="search_select" name="city"></select>
			<select id="county" class="search_select" name="county"></select>
			</div>
		</p>
 
		<!-- 详细地址 -->
		<p>
			<span id="eaddress" class="common_error error_postion"> 
       			<s:fielderror fieldName="address"/>
       		</span>
       	</p>
       	<p>
       		<label class="form_label">详细地址</label>
       		<input id="address" name="address" class="form_input" type="text">
       		
       	</p>

		<!-- 规模 -->
		<p>
       		<span id="escale" class="common_error error_postion">
       			<s:fielderror fieldName="scale"/>
       		</span>
       	</p>
		<p>
       		<label class="form_label"> 规模 </label>
       		<input id="scale"   name="scale" class="form_input" type="text">
       	</p>
        
        <!-- 联系姓名 -->
        <p>
       		<span id="econtacter" class="common_error error_postion"> 
       			<s:fielderror fieldName="contacter"/> 
       		</span>
       	</p>
       	<p>
       		<label class="form_label">联系姓名</label>
       		<input id="contacter" name="contacter" class="form_input"  type="text">
       	</p>
       
       <!-- 联系电话 -->
		<p>
			<span id="enumber" class="common_error error_postion"> 
        		<s:fielderror fieldName="number"/> 
        	</span>
		</p>
		<p>
        	<label class="form_label">联系电话</label>
        	<input id="number" name="number" class="form_input"  type="text" >
        </p>
        
        <!-- 企业简介 -->
        <p>
        	<span id="eintroduction" class="common_error error_postion"> 
        		<s:fielderror fieldName="introduction"/> 
        	</span>
        </p>
        <p>
        	<label class="form_label">企业简介</label>
        	<TEXTAREA id="introduction" name="introduction" class="form_textarea"></TEXTAREA>
        </p>
        
         <%--上传多张图片开始--%>
         <p>
         	<label class="form_label">封面</label>
         	<div id="logo"></div>
         	<!--  
 	    	<img id="logo"  src="<s:property value='enterprise.logo'/>"/>
 	    	-->
         </p>
		<p>         
	        <label class="form_label">上传照片</label>
	        <INPUT id=u198  type="file" name="file" value="浏览"/>
	        <input id="fileId" name="id" type="hidden" value="-1"/>
	        <input id="enterpriseId" name="enterpriseId" type="hidden" value="<s:property value='enterpriseId'/>"/>
	        <span style="font-size:10px;">最多可传5张图片</span>
        </p>
 
	         <div id="thumb" class="thumb" >
	         	
	                <ul  id="thumb_list">
	                    <%--此处由javascript控制动态显示图片缩略图--%>		
	                </ul>
	        </div>
	        
	        <div id="logo"></div>
	        <!-- 
			  <s:iterator value="enterprisePictureMap" id="id" status="st">
				  <script type="text/javascript" >
				      deal_return_picture("<s:property value='key'/>","<s:property value='value.path'/>","enterpriseId",'pcenter/pubEnterprisePicture','pcenter/deleteEnterprisePicture','logo');
				  </script>
			  </s:iterator>	
			   -->	
        <%--上传多张图片结束--%>
        <br>
        <div style="clear:both;">
        	<button id="submit" type="button" class="btn" value="提交" onclick="setEnterprise()">提交</button>
        	<button id="cancel" type="button" class="btn" value="取消" onclick="deal_new_picture()">取消</button>
		</div>
    </form>
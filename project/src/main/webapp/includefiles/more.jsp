<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
	<head>
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
		<link rel="stylesheet" type="text/css" href="/bancai/css_files/more.css" />
		<s:include value="../includefiles/navigate.jsp"/>
	</head>
		<div style="position: absolute; left: 14%; top: 91px; width: 72%; height: 60px; border: 1px; border-style: solid;">
	
			<span class="search"
				style="position: absolute; left: 1%;"><b>搜 索</b></span> <INPUT
				id=u10 type=text class="search" value=""
				style="position: absolute; left: 5%; width: 20%;"> <span
				class="search" style="position: absolute; left: 28%; width: 70px;"><b>高级选项：</b></span>
	
			<span class="search"
				style="position: absolute; left: 36%; width: 30px;">产 品</span> <SELECT
				id=u15 class="search" style="position: absolute; left: 40%;">
				<OPTION value="旋削机">旋削机</OPTION>
				<OPTION value="旋切机">旋切机</OPTION>
				<OPTION value="热压机">热压机</OPTION>
				<OPTION value="锅炉">锅炉</OPTION>
			</SELECT> <span class="search"
				style="position: absolute; left: 50%; width: 30px;">地 区</span> <SELECT
				class="search" id=u12 style="position: absolute; left: 54%;"
				title="地区">
				<OPTION value="兰山区">兰山区</OPTION>
				<OPTION value="罗庄区">罗庄区</OPTION>
				<OPTION value="河东区">河东区</OPTION>
				<OPTION value="莒南县">莒南县</OPTION>
				<OPTION value="费县">费县</OPTION>
				<OPTION value="苍山县">苍山县</OPTION>
				<OPTION value="郯城县">郯城县</OPTION>
				<OPTION value="蒙阴县">蒙阴县</OPTION>
				<OPTION value="沂水县">沂水县</OPTION>
			</SELECT> <span class="search"
				style="position: absolute; left: 64%; width: 30px;">规格</span> <SELECT
				class="search" id=u135 style="position: absolute; left: 68%;" title="规格">
				<OPTION value="有卡">有卡</OPTION>
				<OPTION value="无卡">无卡</OPTION>
			</SELECT> <INPUT id=u137 type=submit class="search" value="搜索"
				style="position: absolute; left: 80%; text-align: center;">
		</div>
		<div id="site_path" style="position: absolute; left: 14%; top: 152px; width: 72%; height: 30px; border: 1px; border-style: solid;">
		
		</div>
		<!-- 下面顺序罗列搜索结果 -->
		 <div  style="position: absolute; left: 14%; top: 183px; height: 630px; width: 72%; border: 1px; border-style: solid;">
				<div style="position: absolute; top: 15px; height: 105px;">
	                <table>
	                    <tr>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>

	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       
	                    </tr>
	                    <tr>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>

	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       
	                    </tr>
	                    <tr>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>

	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       
	                    </tr>
	                    <tr>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>

	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       <td>
		                       <a href=#>
		                     	  <img style="width: 155px; height: 95px;" src="" border="0" alt="gua"/>
		                       </a>
	                       		<br>xx机
	                       </td>
	                       
	                    </tr>
	                    
	                    
	                </table>
	            </div>
		 </div>
</html>

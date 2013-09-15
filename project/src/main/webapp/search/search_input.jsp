<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style type="text/css">
	.search
	{
		color:#000000;
		text-align: left ; 
	}
	
	.padding_left
	{
    	font-size : 16px;
    	padding-left: 10px;
    	font-family:'Arial';
	}

	.search_layout 	
	{
	   height: 40px; 
	   border:solid 1px #000; 
	   margin:0;
	   padding-top:10px;
	   background-color:#eeeeee;
	}
</style>
<script type="text/javascript" src="js/province_city_select/search_sitedata_bas.js"></script>
<script type="text/javascript" src="js/province_city_select/province_city.js"></script>

<p class="search_layout">
	<label  class="padding_left"> <b>搜索</b> </label> 
	<INPUT name="content" type=text  value="">
	 
	<span  class="padding_left">高级搜索</span>
	 		
	<span  class="padding_left"> 产品 </span> 
	<select name="category">
		<OPTION value="不限"> 不限 </OPTION>
		<OPTION value="旋削机">旋削机</OPTION>
		<OPTION value="旋切机">旋切机</OPTION>
		<OPTION value="热压机">热压机</OPTION>
		<OPTION value="锅炉">锅炉</OPTION>
	</select> 
	
	<span  class="padding_left"> 地 区 </span>
	<%-- 省市级联 在引用的页面包含 
		FIXME： 一个页面包含另一个页面的问题没有搞定，
		只好在引用的页面在引用省市级联
	--%>
	<span class="province_city_layout">
		<select id="province" name="province"></select>
		<select id="city" name="city" ></select>
		<select id="county" name="county"></select>
		
		<input type="hidden" value="山东" id="hiddenprovince"/>
        <input type="hidden" value="临沂" id="hiddencity"/>
        <input type="hidden" value="不限" id="hiddencounty"/>
	</span>
	
	<span  class="padding_left"> 规格 </span> 
	<SELECT name="specification" title="规格">
		<OPTION value="不限">不限</OPTION>
		<OPTION value="有卡">有卡</OPTION>
		<OPTION value="无卡">无卡</OPTION>
	</SELECT> 
	
	<INPUT type=submit value="搜索" style="text-align: center;">
</p>

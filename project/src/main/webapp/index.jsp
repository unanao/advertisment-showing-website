
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base 
        href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/"
    />
    <title>
      58板材网
    </title>
    <meta name="keywords" content="板材、木材、机械、厂商、导购、图片">
    <meta name="description" content="国内最专业的板材行业产品、加工机械等销售批发信息服务网站">
    <link rel="stylesheet" type="text/css" href="css_files/index_cat.css" />
    <link rel="stylesheet" type="text/css" href="css_files/base.css" media="all">
    <link rel="stylesheet" type="text/css" href="css_files/plist20130808.css" media="all">
    <script type="text/javascript" src="js/jquery/jquery.js">
	<script type="text/javascript" src="js/image_auto_resize/autoresize_image.js"></script>
	<script type="text/javascript" src="js/advitise_photos.js"></script>    
    </script>
  </head>
  <body class="root61"  onresize="window.location.reload()">
  	<script type="text/javascript">
		var screen_width = document.body.clientWidth-2;
		var mywidth = screen_width * 0.8 / 6;
		var myheight = mywidth * 3 / 4;
		var advertise_width = (screen_width / 4) - 4; /* minus 4, solve:the space of photo is just not enough,that one lay to line 2*/
		var advertise_height = advertise_width * 3 / 4;
		<%--alert(advertise_width);--%>
	</script>
	
    <div id="shortcut-2013">
      <div class="w">
        <ul class="fl lh">
          <li class="fore1 ld">
          <a href="javascript:addToFavorite()" rel="nofollow">
            收藏58板材
          </a>
        </li>
      </ul>
      <ul class="fr lh">
        <li class="fore1" id="loginbar">
        您好，欢迎来到58板材！
        <span>
          <a href="javascript:login();">
            [登录]
          </a>
          <a href="javascript:regist();" class="link-regist">
            [免费注册]
          </a>
        </span>
      </li>
    </ul>
    <span class="clr">
    </span>
  </div>
</div>
<!--shortcut end-->

<div id="o-header-2013">
  <div class="w" id="header-2013">
    <div id="logo-2013" class="ld">
      <a href="http://www.58bancai.com/" hidefocus="true">
        <b>
        </b>
        <img src="./58bancai_files/logo.png" width="180" height="90" alt="58板材">
      </a>
    </div>
    <!--logo end-->
    <div id="search-2013">
      <div class="i-search ld">
        <ul id="shelper" class="hide">
        </ul>
        <div class="form">
          <input type="text" class="text" accesskey="s" id="key" autocomplete="off" style="color: rgb(153, 153, 153);">
          <input type="button" value="搜索" class="button" onclick="searchlzf(key&#39;);">
        </div>
      </div>
      <div id="hotwords">
        <strong>
          热门搜索：
        </strong>
        <a href="" target="_blank">
          胶合板
        </a>
        <a href="" target="_blank">
          实木板
        </a>
        <a href="" target="_blank">
          细木工板
        </a>
        <a href="" target="_blank">
          刨花板
        </a>
        <a href="" target="_blank">
          找圆机
        </a>
      </div>
    </div>
    <!--search end-->

  </div>
  <!--header end-->
  <div class="w">
    <div id="nav-2013">
      <ul id="navitems-2013">
        <li class="fore1" id="nav-home">
        <a href="http://www.jd.com/">
          首页
        </a>
      </li>
      <li class="fore2" id="nav-fashion">
      <a href="http://fashion.jd.com/">
        我的58板材
      </a>
    </li>
    <li class="fore3" id="nav-chaoshi">
    <a href="http://channel.jd.com/chaoshi.html">
      帮助手册
    </a>
  </li>
  <li class="fore4" id="nav-tuan">
  <a href="http://tuan.jd.com/" target="_blank">
    网站促销
  </a>
</li>
<li class="fore5" id="nav-auction">
<a href="http://auction.jd.com/">
  联系我们
</a>
</li>
</ul>
</div>
</div>
<script type="text/javascript">
  (function(){if(pageConfig.navId){var object=document.getElementById("nav-"+pageConfig.navId);if(object)object.className+=" curr";}})();
</script>
<!-- header end -->
<div class="w">
  <div class="breadcrumb">
    <strong>
      <a href="http://channel.jd.com/computer.html">
        板材
      </a>
    </strong>
    <span>
      &nbsp;&gt;&nbsp;
      <a href="http://channel.jd.com/670-671.html">
        细木板
      </a>
    </span>

  </div>
</div>
<!--crumb end-->
<div class="w main">
  <div class="right-extra">

		<div id="banner">
		  <div id="banner_bg">
		  </div>
		  <div id="banner_info">
		    <table id="banner_info_name">
		      <tr>
		        <td>
		        </td>
		        <td>
		        </td>
		        <td>
		        </td>
		        <td>
		        </td>
		      </tr>
		    </table>
		  </div>
		  <ul>
		    <li class="on">
		    1
		  </li>
		  <li>
		  2
		</li>
		</ul>
		<div id="banner_list">
		  <%--默认显示四个产品 --%>
		  <s:iterator value="advertiseProducts" id="p">
		    <a href="product/showProduct?productId=<s:property value="#p.Id"/>">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="<s:property value="#p.icon"/>"
		          alt="<s:property value="#p.name"/>"
		          border="0">
		
		
		    </a>
		  </s:iterator>
		  默认显示四个企业 
		  <s:iterator value="advertiseEnterprises" id="e">
		    <a href="enterprise/showEnterprise?enterpriseId=<s:property value='#e.id'/>">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="<s:property value="#e.logo"/>"
		          alt="<s:property value="#e.name"/>"
		          border="0">
		
		
		    </a>
		  </s:iterator>
<%--		    <a href="#">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="images/default.jpg"
		          alt="for test"
		          border="0">		  
		  </a>
		  		    <a href="#">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="images/default.jpg"
		          alt="for test"
		          border="0">		  
		  </a>
		    <a href="#">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="images/default.jpg"
		          alt="for test"
		          border="0">		  
		  </a>		  
		    <a href="#">
		      <img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="images/default.jpg"
		          alt="for test"
		          border="0">		  
		  </a>		  --%>
		  
		</div>
		</div>
		
			

 <%-- guanggaolan area 
    <div class="m" id="i-right">
      <div id="hotsale" clstag="thirdtype|keycount|thirdtype|hotsaleM" reco_id="3">
        <div class="mt">
          <h2>
            热销推荐
          </h2>
        </div>
        <!--热销商品-->

        <div class="mc list-h" rfid="373">
          <dl>
            <dt>
            <a href=".html" target="_blank">
              <img alt="" src=".jpg" width="100" height="100">
            </a>
          </dt>
          <dd>
          <div class="p-name">
            <a href=".html" target="_blank">
              广告位xxxx厂xxx板材
              <font color="#ff6600">
                广告位xxxx厂xxx板材
              </font>
            </a>
          </div>
          <div class="p-price" sku="889805">
            特价：
            <strong>
              ￥4299.00
            </strong>
          </div>
          <div class="btns">
            <a href="" target="_blank">
              立即抢购
            </a>
          </div>
        </dd>
      </dl>
      <dl>
        <dt>
        <a href=".html" target="_blank">
          <img alt="" src=".jpg" width="100" height="100">
        </a>
      </dt>
      <dd>
      <div class="p-name">
        <a href=".html" target="_blank">
          广告位xxxx厂xxx板材
          <font color="#ff6600">
            广告位xxxx厂xxx板材
          </font>
        </a>
      </div>
      <div class="p-price" sku="901526">
        特价：
        <strong>
          ￥4499.00
        </strong>
      </div>
      <div class="btns">
        <a href="" target="_blank">
          立即抢购
        </a>
      </div>
    </dd>
  </dl>
  <dl>
    <dt>
    <a href=".html" target="_blank">
      <img alt="" src=".jpg" width="100" height="100">
    </a>
  </dt>
  <dd>
  <div class="p-name">
    <a href=".html" target="_blank">
      广告位xxxx厂xxx板材
      <font color="#ff6600">
        广告位xxxx厂xxx板材
      </font>
    </a>
  </div>
  <div class="p-price" sku="802240">
    特价：
    <strong>
      ￥3599.00
    </strong>
  </div>
  <div class="btns">
    <a href="" target="_blank">
      立即抢购
    </a>
  </div>
</dd>
</dl>
</div>
</div>
<div id="market" clstag="thirdtype|keycount|thirdtype|market">
  <div class="mt">
    <h2>
      促销活动
    </h2>
  </div>
  <div class="mc">
    <!--促销活动-->

    <ul>
      <li>
      ·
      <a href="http://www.jd.com/news.aspx?id=13158" target="_blank">
        先科拉杆扩音器风靡今夏
      </a>
    </li>
    <li>
    ·
    <a href="http://www.jd.com/news.aspx?id=13038" target="_blank">
      AMD牵手京东迎来暑假促销季
    </a>
  </li>
  <li>
  ·
  <a href="http://www.jd.com/news.aspx?id=12888" target="_blank">
    联想扬天全金属超极本
  </a>
</li>
<li>
·
<a href="http://www.jd.com/news.aspx?id=12876" target="_blank">
  移动电源送彩票，千万大奖伺候！
</a>
</li>
<li>
·
<a href="http://www.jd.com/news.aspx?id=12847" target="_blank">
  惠普三重好礼过今夏
</a>
</li>
</ul>

</div>
</div>
</div>


 --%>
 
 
<div class="m plist-n7a" id="plist" clstag="thirdtype|keycount|thirdtype|plist">
  <ul class="list-h">
    <li index="0"  sku="853231">
    <div class="p-img">
      <a target="_blank" href=".html">
        <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
      </a>
    </div>
    <div class="p-name">
      <a target="_blank" href=".html" title="">
        <font style="color: #ff0000" class="adwords" name="853231">
        </font>
      </a>
    </div>
    <div class="extra">
      <span class="evaluate">
        <a target="_blank" href=".html">
          已有4154人评价
        </a>
      </span>
    </div>
    <div class="btns">
      <a id="coll853231" href="javascript:;" class="btn-coll">
        关注
      </a>
      <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
        <span>
        </span>
        对比
      </a>
    </div>
    <div class="p-shopnum">
    </div>
  </li>


  <li index="0"  sku="853231">
  <div class="p-img">
    <a target="_blank" href=".html">
      <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
    </a>
  </div>
  <div class="p-name">
    <a target="_blank" href=".html" title="">
      <font style="color: #ff0000" class="adwords" name="853231">
      </font>
    </a>
  </div>
  <div class="extra">
    <span class="evaluate">
      <a target="_blank" href=".html">
        已有4154人评价
      </a>
    </span>
  </div>
  <div class="btns">
    <a id="coll853231" href="javascript:;" class="btn-coll">
      关注
    </a>
    <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
      <span>
      </span>
      对比
    </a>
  </div>
  <div class="p-shopnum">
  </div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>

<li index="0"  sku="853231">
<div class="p-img">
  <a target="_blank" href=".html">
    <img width="220" height="220" alt="" src=".jpg" data-img="1" title="">
  </a>
</div>
<div class="p-name">
  <a target="_blank" href=".html" title="">
    <font style="color: #ff0000" class="adwords" name="853231">
    </font>
  </a>
</div>
<div class="extra">
  <span class="evaluate">
    <a target="_blank" href=".html">
      已有4154人评价
    </a>
  </span>
</div>
<div class="btns">
  <a id="coll853231" href="javascript:;" class="btn-coll">
    关注
  </a>
  <a class="btn-compare btn-compare-s" id="comp_853231" skuid="853231">
    <span>
    </span>
    对比
  </a>
</div>
<div class="p-shopnum">
</div>
</li>


</ul>
</div>
<!-- photo list div end -->


<div class="m clearfix">
  <div class="pagin fr">
    <span class="prev-disabled">
      上一页
      <b>
      </b>
    </span>
    <a href="" class="current">
      1
    </a>
    <a href="">
      2
    </a>
    <span class="text">
      …
    </span>
    <a href="l">
      25
    </a>
    <a href="" class="next">
      下一页
      <b>
      </b>
    </a>
  </div>
</div>
<div reco_id="2" class="shop-choice hide" id="shop-choice">
</div>

</div>
<!--right-extra end-->

<div class="left">
  <div class="m" id="sortlist" clstag="thirdtype|keycount|thirdtype|sortlist">

    <div class="mt">
      <h2>
        板材、机械
      </h2>
    </div>
    <div class="mc">
      <div class="item current">
        <h3>
          <b>
          </b>
          板材
        </h3>
        <ul>
          <li>
          <a href="./.htm">
            胶合板
          </a>
        </li>
        <li>
        <a href="http://list.jd.com/670-671-6864.html">
          实木板
        </a>
      </li>
      <li>
      <a href="http://list.jd.com/670-671-1105.html">
        细木工板
      </a>
    </li>
    <li>
    <a href="http://list.jd.com/670-671-2694.html">
      刨花板
    </a>
  </li>
  <li>
  <a href="http://list.jd.com/670-671-5146.html">
    纤维板
  </a>
</li>
<li>
<a href="http://list.jd.com/670-671-673.html">
  集成板
</a>
</li>
</ul>
</div>
<div class="item">
  <h3>
    <b>
    </b>
    机械
  </h3>
  <ul>
    <li>
    <a href="http://list.jd.com/670-677-678.html">
      热压机
    </a>
  </li>
  <li>
  <a href="http://list.jd.com/670-677-681.html">
    冷压机
  </a>
</li>
<li>
<a href="http://list.jd.com/670-677-679.html">
  锯边机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-683.html">
  涂胶机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-680.html">
  锅炉机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-687.html">
  木材干燥设备
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-691.html">
  粉碎设备
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-688.html">
  预压机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-684.html">
  液压升降机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-682.html">
  锯机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-5008.html">
  喷漆设备
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-5009.html">
  原木接长机
</a>
</li>
<li>
<a href="http://list.jd.com/670-677-5009.html">
  变曲木压机
</a>
</li>
</ul>
</div>
</div>

</div>
<!--sortlist end-->
<script type="text/javascript">
  $("#sortlist h3").bind("click",function(){
    var element=$(this).parent();
    if (element.hasClass("current")){
      element.removeClass("current");
    }else{
      element.addClass("current");
    }
    })
  </script>

  <!--daohangzhankai end-->

  <div id="ad_left" reco_id="6" class="m m0 hide">
  </div>
  <!--搜索广告推荐-->
  <div id="finalbuy" class="hide m m0">
  </div>
  <!--关注手机最终购买-->
  <div id="weekRank" class="m rank" clstag="thirdtype|keycount|thirdtype|mrank">
    <div class="mt">
      <h2>
        一周关注排行榜
      </h2>
    </div>
    <div class="mc">
      <ul class="tabcon">
        <li class="fore fore1">
        <span>
          1
        </span>
        <div class="p-img">
          <a target="_blank" href="http://item.jd.com/853231.html">
            <img alt="" width="50" height="50">
          </a>
        </div>
        <div class="p-name">
          <a target="_blank" href="http://item.jd.com/853231.html">
            关注1
          </a>
        </div>
        <div class="p-price">
          <strong>
            ￥4999.00
          </strong>
        </div>
      </li>
      <li class="fore2">
      <span>
        2
      </span>
      <div class="p-img" style="display:none;">
        <a target="_blank" href="http://item.jd.com/889798.html">
          <img 
              alt="ThinkPad E430C(33651D1) 14英寸笔记本电脑 （i5-2520M 4G 500G 1G独显 Linux）"
              src="./笔记本 【行情 价格 评价 正品行货】-京东商城_files/rBEQWFFrYvAIAAAAAAIuDxftK-IAAEHVAIXOZ0AAi4n826(3).jpg"
              width="50"
              height="50">

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="http://item.jd.com/889798.html">
          ThinkPad E430C(33651D1) 14英寸笔记本电脑 （i5-2520M 4G 500G 1G独显 Linux）
        </a>
      </div>
      <div class="p-price" sku="889798" style="display:none;">
        <strong>
          ￥3849.00
        </strong>
      </div>
    </li>

  </ul>
</div>
</div>
<!--rank end-->
</div>
<!--left end-->
<span class="clr">
</span>
<div id="Collect_Tip" class="Tip360 w260">
</div>
</div>

    <div class="w">
      <div id="service-2013">
        <dl class="fore1">
          <dt>
          <b>
          </b>
          <strong>
            购物指南
          </strong>
        </dt>
        <dd>
        <div>
          <a href="http://help.jd.com/help/question-56.html" target="_blank" rel="nofollow">
            购物流程
          </a>
        </div>
        <div>
          <a href="http://help.jd.com/help/question-57.html" target="_blank" rel="nofollow">
            会员介绍
          </a>
        </div>
        <div>
          <a href="http://help.jd.com/help/question-181.html" target="_blank" rel="nofollow">
            团购/机票
          </a>
        </div>
        <div>
          <a href="http://help.jd.com/help/question-61.html" target="_blank" rel="nofollow">
            常见问题
          </a>
        </div>
        <div>
          <a href="http://help.jd.com/help/question-63.html" target="_blank" rel="nofollow">
            大家电
          </a>
        </div>
        <div>
          <a href="http://help.jd.com/index.html" target="_blank" rel="nofollow">
            联系客服
          </a>
        </div>
      </dd>
    </dl>
    <dl class="fore2">
      <dt>
      <b>
      </b>
      <strong>
        配送方式
      </strong>
    </dt>
    <dd>
    <div>
      <a href="http://help.jd.com/help/question-64.html" target="_blank" rel="nofollow">
        上门自提
      </a>
    </div>
    <div>
      <a href="http://help.jd.com/help/question-360.html" target="_blank" rel="nofollow">
        211限时达
      </a>
    </div>
    <div>
      <a href="http://help.jd.com/help/distribution-768.html" target="_blank" rel="nofollow">
        配送服务查询
      </a>
    </div>
    <div>
      <a href="http://market.jd.com/giftcard/index.html#one5" target="_blank" rel="nofollow">
        如何送礼
      </a>
    </div>
    <div>
      <a href="http://help.en.360buy.com/help/question-2.html" target="_blank">
        Global Shipping
      </a>
    </div>
  </dd>
</dl>
<dl class="fore3">
  <dt>
  <b>
  </b>
  <strong>
    支付方式
  </strong>
</dt>
<dd>
<div>
  <a href="http://help.jd.com/help/question-67.html" target="_blank" rel="nofollow">
    货到付款
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-68.html" target="_blank" rel="nofollow">
    在线支付
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-71.html" target="_blank" rel="nofollow">
    分期付款
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-69.html" target="_blank" rel="nofollow">
    邮局汇款
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-70.html" target="_blank" rel="nofollow">
    公司转账
  </a>
</div>
</dd>
</dl>
<dl class="fore4">
  <dt>
  <b>
  </b>
  <strong>
    售后服务
  </strong>
</dt>
<dd>
<div>
  <a href="http://myjd.jd.com/afs/help/afshelp.action" target="_blank" rel="nofollow">
    售后政策
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-99.html" target="_blank" rel="nofollow">
    价格保护
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-100.html" target="_blank" rel="nofollow">
    退款说明
  </a>
</div>
<div>
  <a href="http://myjd.jd.com/repair/repairs.action" target="_blank" rel="nofollow">
    返修/退换货
  </a>
</div>
<div>
  <a href="http://order.jd.com/normal/list.action" target="_blank" rel="nofollow">
    取消订单
  </a>
</div>
</dd>
</dl>
<dl class="fore5">
  <dt>
  <b>
  </b>
  <strong>
    特色服务
  </strong>
</dt>
<dd>
<div>
  <a href="http://help.jd.com/help/question-79.html" target="_blank">
    夺宝岛
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-86.html" target="_blank">
    DIY装机
  </a>
</div>
<div>
  <a href="http://fuwu.jd.com/" target="_blank" rel="nofollow">
    延保服务
  </a>
</div>
<div>
  <a href="http://market.jd.com/giftcard/index.html" target="_blank" rel="nofollow">
    京东礼品卡
  </a>
</div>
<div>
  <a href="http://help.jd.com/help/question-91.html" target="_blank" rel="nofollow">
    节能补贴
  </a>
</div>
</dd>
</dl>
<span class="clr">
</span>
</div>
</div>
<!-- service end -->
<div class="w">
  <div id="footer-2013">
  </div>
</div>
<!-- footer end -->
</body>
</html>

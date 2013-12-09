
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
			+ request.getServerPort() + request.getContextPath() %>/" />
    <title>
      58板材网
    </title>
    <meta name="keywords" content="板材、木材、机械、厂商、导购、图片">
    <meta name="description" content="国内最专业的板材行业产品、加工机械等销售批发信息服务网站">
    <link rel="stylesheet" type="text/css" href="css_files/index_cat.css" />
    <link rel="stylesheet" type="text/css" href="css_files/base.css" media="all">
    <link rel="stylesheet" type="text/css" href="css_files/plist20130808.css" media="all">
    <script type="text/javascript" src="js/jquery/jquery.js"></script>
	<script type="text/javascript" src="js/image_auto_resize/autoresize_image.js"></script>
	<script type="text/javascript" src="js/advitise_photos.js"></script>    
  </head>
  <body class="root61">
  	<script type="text/javascript">
		var screen_width = document.body.clientWidth-18; /* 15 is the scrollbar width */
		var mywidth = screen_width * 0.83 * 0.15;
		var myheight = mywidth * 3 / 4;
		var advertise_width = (screen_width * 0.83 / 4); /* minus 4, solve:the space of photo is just not enough,that one lay to line 2*/
		var advertise_height = advertise_width * 3 / 4;
		/*alert(window.screen.width);*/
		/*alert(advertise_width);
		alert(screen_width);*/
		alert(document.body.clientWidth);
	</script>
	
    <div id="shortcut-2013">
      <div class="w">
        <ul class="fl lh">
          <li class="fore1 ld">
            <a href="javascript:HomepageFavorite.Homepage()"  >设为首页</a>
<a href="javascript:HomepageFavorite.Favorite(window.location.href, document.title)"  >加入收藏</a>
        </li>
      </ul>
      <ul class="fr lh">
        <li class="fore1" id="loginbar">
        您好，欢迎来到58板材！
        <span>
            <%-- 用户登陆了现实用户名和退出，用户没有登陆显示登陆和注册 --%>
            <% String loginName = (String)session.getAttribute("SESSION_LOGIN_NAME");
            if (null == loginName)
            { %>
            <a href="accounts/login.jsp">登陆</a>|<a href="accounts/register.jsp">免费注册</a>
            <% } else { %>
            <a href="pcenter/pcenter.jsp"><%= loginName %></a>|<a href="accounts/logout">退出</a>
            <% } %>
        </span>
      </li>
    </ul>
    <span class="clr">
    </span>
  </div>
</div>
<!--shortcut end-->

  <div class="w" id="header-2013">
    <div id="logo-2013" class="ld">
      <a href="http://www.58bancai.com/" hidefocus="true">
        <img src="images/logo.png" width="180" height="90" alt="58板材">
      </a>
    </div>
    <!--logo end-->
    <div id="search-2013" >
      <div class="i-search ld">
        <div class="form">
        	<s:form action="search/search_get_result" style="margin:0;">
          		<input type="text" class="text" accesskey="s" id="key" autocomplete="off" style="color: rgb(153, 153, 153);">
         		<input type="submit" value="搜索" class="button">
         	</s:form>
        </div>
      </div>
    </div>
    <!--search end-->

  </div>
  <!--header end-->
  <div class="w">
    <div id="nav-2013">
      <ul id="navitems-2013">
        <li class="fore1" id="nav-home">
        <a href=".">
          首页
        </a>
      </li>
      <li class="fore2" id="nav-fashion">
       <% if (null == loginName){ %>
       <a href="accounts/login.jsp?retPage=pcenter">我的58板材 </a>
       <% } else { %>
       <a href="pcenter/pcenter.jsp">我的58板材</a>
       <% } %>
    </li>
    <li class="fore3" id="nav-chaoshi">
    <a href="aboutus/user_manual.jsp">
      帮助手册
    </a>
  </li>
  <li class="fore4" id="nav-tuan">
  <a href=".">
    网站促销
  </a>
</li>
<li class="fore5" id="nav-auction">
<a href="aboutus/contactus.jsp">
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
		  <s:iterator value="advertiseProducts" id="p"><a href="product/showProduct?productId=<s:property value="#p.Id"/>"><img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="<s:property value="#p.icon"/>"
		          alt="<s:property value="#p.name"/>"
		          border="0" margin="0"></a></s:iterator>
		  <%--默认显示四个企业--%> 
		  <s:iterator value="advertiseEnterprises" id="e"><a href="enterprise/showEnterprise?enterpriseId=<s:property value='#e.id'/>"><img 
		          class="advertise"
		          onload="DrawImage(this,advertise_width,advertise_height)"
		          src="<s:property value="#e.logo"/>"
		          alt="<s:property value="#e.name"/>"
		          border="0"></a></s:iterator>
		  <%-- 上述代码严格按照上述格式写，iterator a img标签间不能出现任何的空格或者换行，否则图片间会产生间隙 --%>
		</div>
		</div>
 
 
<div class="m" id="plist">
  <ul class="list-h">

    <s:iterator value="displayProducts" id="product" status="status" begin="0" end="5">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
        已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>
      </div>
    </li>
  </s:iterator>
  
    <s:iterator value="displayProducts" id="product" status="status" begin="6" end="11">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>
      </div>
    </li>
  </s:iterator>
    <s:iterator value="displayProducts" id="product" status="status" begin="12" end="17">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>       
      </div>
    </li>
  </s:iterator>
    <s:iterator value="displayProducts" id="product" status="status" begin="18" end="23">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>       
      </div>
    </li>
  </s:iterator>
    <s:iterator value="displayProducts" id="product" status="status" begin="24" end="29">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>       
      </div>
    </li>
  </s:iterator>
    <s:iterator value="displayProducts" id="product" status="status" begin="30" end="35">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>       
      </div>
    </li>
  </s:iterator>
    <s:iterator value="displayProducts" id="product" status="status" begin="36" end="41">
      <li>
      <div class="p-img">
        <a href="product/showProduct?productId=<s:property value="#product.Id"/>">
          <img 
              onload="DrawImage(this,mywidth,myheight)"
              src="<s:property value="#product.icon"/>"
              border="0"
              alt="images/default.jpg"
          >

        </a>
      </div>
      <div class="p-name">
        <a target="_blank" href="product/showProduct?productId=<s:property value="#product.Id"/>"  title="">
          <font style="color: #ff0000" class="adwords">
            <s:property value="#product.name"/>
          </font>
        </a>
      </div>
      <div class="extra">
       已有<s:property value="#product.hits"/>人收藏
        <a class=btn-coll>我要收藏</a>       
      </div>
    </li>
  </s:iterator>

  
<%--
	                <s:iterator value="displayProducts" id="product" status="status" begin="0" end="5">
	                    <td>
	                    	<a href="product/showProduct?productId=<s:property value="#product.Id"/>">
	                          <img class="ent_product" onload="DrawImage(this,mywidth,myheight)"  src="<s:property value="#product.icon"/>" 
	                          		border="0" alt="images/default.jpg"/>
	                     	</a>
	                     	<br>
	                		<s:property value="#product.name"/><br>
	                    </td>
  	                </s:iterator>--%>



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
   <%
    String[] categoriesWood = new String[]{"实木板","细木工板","刨花板","纤维板","装饰面板","集成材","防火板","石膏板","PVC板","铝扣板","铝塑板","其他"};
    for(String category:categoriesWood){
        out.println(
                   "<li>"+
                           "<a target='_blank' href='product/listMoreProducts?category="+category+ "'>"   +
                                   category +
                           "</a>" +
                   "</li>");
    }
    %>
</ul>
</div>
<div class="item">
  <h3>
    <b>
    </b>
    机械
  </h3><ul>
   <%
    String[] categoriesTool = new String[]{"旋切机","热压机","预压机","锅炉","涂胶机","锯边机","其他"};
    for(String category:categoriesTool){
    	out.println(
    			   "<li>"+
    					   "<a target='_blank' href='product/listMoreProducts?category="+category+ "'>"   +
    							   category +
    	                   "</a>" +
    	           "</li>");
    }
   %>
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
        收藏总排行榜
      </h2>
    </div>
    <div class="mc">
      <ul class="tabcon">
      <s:iterator value="productRankList" id="product" status="status">
              <li class="fore fore1">
        <span>
        <s:property value="#status.index+1"/>
      </span>
        <div class="p-img">
          <a target="_blank" href="http://item.jd.com/853231.html">
                     <img 
              alt='<s:property value="#product.name"/>'
              src='<s:property value="#product.icon"/>'
              width="50"
              height="50">

        </a>
        </div>
        <div class="p-name">
          <a target="_blank" href="http://item.jd.com/853231.html">
            收藏<s:property value="#product.favourite"/>
          </a>
        </div>
        <div class="p-price">
          <strong>
            <s:property value="#product.name"/>
          </strong>
        </div>
      </li>
     
      
  </s:iterator>

     

  </ul>
</div>
</div>
<!--rank end-->
</div>
<!--left end-->
<div id="Collect_Tip" class="Tip360 w260">
</div>
</div>

<!-- service end -->
<div class="w">
  <div id="footer-2013">
  <span class="clr">
</span>
  		<%@ include file="includefiles/footer.jsp" %>
  </div>
</div>
<!-- footer end -->
<script type="text/javascript">
		alert(document.body.clientWidth);
</script>

</body>
<script>

    var HomepageFavorite = {
        //设为首页
        Homepage : function() {
            if (document.all) {
                document.body.style.behavior = 'url(#default#homepage)';
                document.body.setHomePage(window.location.href);
            } else if (window.sidebar) {
                if (window.netscape) {
                    try {
                        netscape.security.PrivilegeManager
                                .enablePrivilege("UniversalXPConnect");
                    } catch (e) {
                        alert("该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true");
                    }
                }
                var prefs = Components.classes['@mozilla.org/preferences-service;1']
                        .getService(Components.interfaces.nsIPrefBranch);
                prefs.setCharPref('browser.startup.homepage',
                        window.location.href);
            } else{
                alert("对不起您的浏览器不支持此操作!请使用菜单栏设为首页");
            }
        },
        //加入收藏
        Favorite : function Favorite(sURL, sTitle) {
            try {
                window.external.addFavorite(sURL, sTitle);
            } catch (e) {
                try {
                    window.sidebar.addPanel(sTitle, sURL, "");
                } catch (e) {
                    alert("对不起您的浏览器不支持此操作!请使用Ctrl+D收藏本站");
                }
            }
        }
    }
</script>
</html>

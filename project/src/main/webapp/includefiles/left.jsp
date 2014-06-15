<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
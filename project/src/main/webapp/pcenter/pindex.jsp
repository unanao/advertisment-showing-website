<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          <div class="page-header pcheader">
            <h4>
              欢迎您，xxxx
            </h4>
          </div>
          <p>
            您目前拥有以下套餐：您目前使用的为免费套餐服务。
          </p>
          <p>
            <a class="btn-small" href="#">
              更多套餐信息 »
            </a>
          </p>
          <span class="label badge-info margin5 font16 padding58">
            我的企业信息
          </span>
          <div  class="row-fluid">
          <div class="span8">
		<table class="table-condensed " width="80%">
		   <tr>
		       <td><b>企业名称</b></td>
		       <td><s:property  value="enterprise.name"/></td>
		       <td><b>所在地</b></td>
		       <td>
	                <s:if test="enterprise.province != null">
	                    <s:property value="enterprise.province"/>
	                </s:if>
	        
	                <s:if test="enterprise.city != null"><s:property value="enterprise.city"/>
	                </s:if>
	        
	                <s:if test="enterprise.county != null">
	                        <s:property value="enterprise.county"/>
	                </s:if>
		       </td>
		   </tr>
		   <tr>
		       <td><b>详细地址</b></td>
		       <td><s:property value="enterprise.address"/></td>
		       <td><b>规模(人)</b></td>
		       <td><s:property value="enterprise.scale"/></td>
		   </tr>
		   <tr>
		       <td><b>联系姓名</b></td>
		       <td><s:property value="phone.contacter"/></td>
	           <td><b>联系电话</b></td>
	           <td><s:property value="phone.number"/></td>
	       </tr>
	        <tr>
	           <td><b>企业简介</b></td>
	           <td><s:property value="enterprise.introduction"/></td>
	       </tr>
	        <tr>
	           <td><b>公司logo</b></td>
	           <td><img style="width:100px" src="<s:property value="enterprise.logo"/>"/></td>
	       </tr>
	       <tr>
	       		<td>
	       			<b></>产品图片</b>
	       		</td>
	       	</tr>
	       <tr>
	        
	            <td colspan="2">
                    <s:iterator id="p" value="enterprisePictureMap">         
                    	<img  class="picture_logo" onload="DrawImage(this,100,100)" src="<s:property value='value.path'/>" alt="挂掉啦！" >
                    </s:iterator>
	            </td>
	       </tr>       
		</table>
		</div>
		</div>
  
        <span class="label badge-info margin5 font16 padding58">
          产品信息
        </span>
        <ul class="thumbnails">
          <li class="span3">
          <div class="thumbnail">
            <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
            <div class="caption">
              <h5>
                冯诺尔曼结构
              </h5>            
            </div>
          </div>
        </li>
        <li class="span3">
        <div class="thumbnail">
          <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
          <div class="caption">
            <h5>
              哈佛结构
            </h5>
          </div>
        </div>
      </li>
      <li class="span3">
      <div class="thumbnail">
        <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
        <div class="caption">
          <h5>
            改进型哈佛结构
          </h5>
        </div>
      </div>
    </li>
  </ul>
<%-- product end --%>  

<!--
       <span class="label badge-info margin5 font16 padding58">
          我的收藏
        </span>
        <ul class="thumbnails">
          <li class="span3">
          <div class="thumbnail">
            <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
            <div class="caption">
              <h5>
                冯诺尔曼结构
              </h5>            
            </div>
          </div>
        </li>
        <li class="span3">
        <div class="thumbnail">
          <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
          <div class="caption">
            <h5>
              哈佛结构
            </h5>
          </div>
        </div>
      </li>
      <li class="span3">
      <div class="thumbnail">
        <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
        <div class="caption">
          <h5>
            改进型哈佛结构
          </h5>
        </div>
      </div>
    </li>
  </ul>
--> 
  
</div>
</div>
</div>

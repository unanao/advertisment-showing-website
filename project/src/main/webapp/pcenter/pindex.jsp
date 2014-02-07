
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base 
        href="<%= request.getScheme() + "://" + request.getServerName() + ":" +
         request.getServerPort() + request.getContextPath() %>/"
    />
    	<link rel="stylesheet" type="text/css" href="css_files/bootstrap.css" />
    	<link rel="stylesheet" type="text/css" href="css_files/pcenter_common.css" />
		<script type="text/javascript" src='js/image_auto_resize/autoresize_image.js'></script>			 
  </head>
  <body>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
          <div class="page-header">
            <h4>
              欢迎您，xxxx
            </h4>
          </div>
          <p>
            您目前拥有以下套餐：您目前使用的为免费套餐服务。
          </p>
          <p>
            <a class="btn" href="#">
              更多套餐信息 »
            </a>
          </p>
          <span class="label badge-info">
            企业信息
          </span>
          <ul class="thumbnails">
            <li class="span3">
            <div class="thumbnail">
              <img alt="300x200" src="images/default43.jpg" onload="DrawImage(this,200,150)" />
              <div class="caption">
                <h5>
                  冯诺尔曼结构
                </h5>
                <p>
                  <a class="btn btn-primary" href="#">
                    浏览
                  </a>
                  <a class="btn" href="#">
                    分享
                  </a>
                </p>
              </div>
            </div>
          </li>
        </ul>
        <span class="label badge-info">
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
              <p>
                <a class="btn btn-primary" href="#">
                  浏览
                </a>
                <a class="btn" href="#">
                  分享
                </a>
              </p>
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
            <p>
              <a class="btn btn-primary" href="#">
                浏览
              </a>
              <a class="btn" href="#">
                分享
              </a>
            </p>
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
          <p>
            <a class="btn btn-primary" href="#">
              浏览
            </a>
            <a class="btn" href="#">
              分享
            </a>
          </p>
        </div>
      </div>
    </li>
  </ul>
</div>
</div>
</div>
<script src="js/bootstrap.js">
</script>
</body>
</html>

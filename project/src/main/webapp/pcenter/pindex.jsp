<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />
	</head>
	<body>
			<DIV id=pd0u4 style="position:absolute; left:0px; top:0px;width:100%; height:100%;">
				<DIV id=u5 style="position:absolute; left:15%; top:15%;">
					<DIV id=u5_rtf>
						<span class="index_content">欢迎您：</span>
						<span class="index_content"><s:property value="name"/></span>
						<span class="index_content">先生/女士</span>
					</DIV>
				</DIV>
				
				<!--  一期不支持  
				<DIV id=u15 style="position:absolute; left:45%; top:45%;" >
						<span class="index_content">收藏数：168&nbsp; </span>
				</DIV>
				-->

			<%-- 套餐信息:只显示汇总信息,因为账户信息会显示详细信息 --%>				
			<DIV id=u11 style="position:absolute; left:18%; top:20%;" >
				<div class="index_content">您目前拥有以下服务套餐：</div>
				
				<s:if test="(null != packages) && (!packages.isEmpty())">
					<s:iterator value="packages" id="package" status="status">
						<span class="index_content"> <s:property value="#package.name" /> </span>
					</s:iterator>
					
					<div class="index_content">
						<a href="pcenter/getPackagesByEnterprise"> 详细套餐信息 </a>
					</div>
					
				</s:if>
				<s:else>
					<div class="index_content" style="position:relative; left:40%">
						您还没有购买套餐
					</div>
				</s:else>
			</DIV>			

				<DIV id=u9 style="position:absolute; left:18%; top:40%;" >
						<span class="index_content">您的企业信息：</span>
				</DIV>
				
				<s:if test="null!=enterprise">
				<DIV id=u10 style="position:absolute; left:20%; top:45%; " >
						<span class="index_content"><s:property value="enterprise.name"/></span>
				</DIV>
				<DIV id=u16 style="position:absolute; left:55%; top:45%; " >
					<DIV id=u16_rtf>
						<a href="pcenter/showEnterprise"> 
							<span class="index_content_link"> 查看修改企业信息 </span> 
						</a>
					</DIV>
				</DIV>
				
				</s:if>
				<s:else>
					<DIV id=u10 style="position:absolute; left:20%; top:45%; " >
						<span class="index_content">您还没有完善企业信息</span>
					</DIV>
					
					<DIV id=u16 style="position:absolute; left:55%; top:45%; " >
					<DIV id=u16_rtf>
						<span class="index_content_link">
							<a href="pcenter/updateEnterprisePage"> 添加完善企业信息 </a>
						</span>
					</DIV>
					</DIV>
				</s:else>
				
				
				
				<DIV id=u17 style="position:absolute; left:18%; top:55%; " >
					<DIV id=u17_rtf>
						<span class="index_content">您的产品：</span>
					</DIV>
				</DIV>
				
				<DIV id=u18 style="position:absolute; left:20%; top:60%;" >
				
					<s:if test="null!=products">
						<table>
						<s:iterator value="products" id="product" status="status">
						<tr>
							<td>
						<a href="product/showProduct?productId=<s:property value="#product.id" />"  
							target="_blank" >
								<s:property value="#product.name" />
						</a>
							</td>
						</tr>
						</s:iterator>
						</table>
					</s:if> 
					<s:else>
						您还没有完善你们的产品信息
					</s:else>
					
				</DIV>		
			</DIV>
	</body>
</html>
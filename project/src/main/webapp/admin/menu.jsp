<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
	<HEAD>	
	<LINK href="../css_files/admin.css" type="text/css" rel="stylesheet">
	<SCRIPT language=javascript>
		function expand(el)
		{
			childObj = document.getElementById("child" + el);
	
			if (childObj.style.display == 'none')
			{
				childObj.style.display = 'block';
			}
			else
			{
				childObj.style.display = 'none';
			}
			return;
		}
	</SCRIPT>
	</HEAD>
	<BODY>
		<TABLE height="100%" cellSpacing=0 cellPadding=0 width=170 
		background="../../images/menu_bg.jpg" border=0>
		  <TR>
		    <TD vAlign=top align=middle>
		      <TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
		        <TR>
		          <TD height=10></TD>
		        </TR>
			  </TABLE>
	      	  <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
	         	<TR height=22>
	         		 <TD style="PADDING-LEFT: 30px" background="../images/menu_bt.jpg">
	         		 <A  class=menuParent onclick=expand(1) 
	           		 href="javascript:void(0);">用户管理</A>
	           		 </TD>
	          </TABLE>
	      	  <TABLE id=child1 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
	      		width=150 border=0>
	        	<TR height=20>
	          		<TD align=middle width=30><IMG height=9 
	            		src=""../images/menu_icon.gif" width=9>
	            	</TD>
	          		<TD>
	          			<A class=menuChild  href="user_management.jsp" target=main>注册登录管理</A>
	          		</TD>
	          	</TR>
	        	 <TR height=20>
	          		<TD align=middle width=30><IMG height=9  src=""../images/menu_icon.gif" width=9>
	          		</TD>
	          		<TD>
	          			<A class=menuChild  href="assign_user_package.jsp"  target=main>用户套餐管理</A>
	          		</TD>
	          	</TR>
	     	    <TR height=4>
	          		<TD colSpan=2>
	          		</TD>
	          	</TR>
	      </TABLE>
	      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
	        <TR height=22>
	          <TD style="PADDING-LEFT: 30px" background="../images/menu_bt.jpg">
	          	<A class=menuParent onclick=expand(2) href="javascript:void(0);">套餐管理</A>
	          </TD>
	        </TR>
	      </TABLE>
	      <TABLE id=child2 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
	      width=150 border=0>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="new_package.jsp" target=main>新建套餐</A>
	          </TD>
	        </TR>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="admin_get_all_packages" target=main>编辑删除</A>
	          </TD>
	        </TR>
	        <TR height=4>
	          <TD colSpan=2></TD>
	        </TR>
	      </TABLE>
	      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
	        <TR height=22>
	          <TD style="PADDING-LEFT: 30px" background="../images/menu_bt.jpg">
	          	<A class=menuParent onclick=expand(3) href="javascript:void(0);">统计信息</A>
	          </TD>
	        </TR>
	      </TABLE>
	      <TABLE id=child3 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
	      width=150 border=0>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="admin_user_statistics" target=main>
	          		用户统计
	          	</A>
	          </TD>
	        </TR>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="flow_count.jsp" target=main>XX信息</A>
	          </TD>
	        </TR>
	        <TR height=4>
	          <TD colSpan=2></TD>
	        </TR>
	      </TABLE>
	      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
	        <TR height=22>
	          <TD style="PADDING-LEFT: 30px" background="../images/menu_bt.jpg">
	          	<A class=menuParent onclick=expand(4) href="javascript:void(0);">产品管理</A>
	          </TD>
	        </TR>
	      </TABLE>
	      <TABLE id=child4 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
	      width=150 border=0>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9  src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="../error/building.jsp"  target=main>待建设</A>
	          </TD>
	        </TR>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9>
	          </TD>
	          <TD>
	          	<A class=menuChild href="../error/building.jsp" target=main>待建设</A>
	          </TD>
	        </TR>
	      </TABLE>
	      <TABLE cellSpacing=0 cellPadding=0 width=150 border=0>
	        <TR height=22>
	          <TD style="PADDING-LEFT: 30px" background="../images/menu_bt.jpg">
	          	<A  class=menuParent onclick=expand(5) href="javascript:void(0);">企业管理</A>
	          </TD>
	        </TR>
	        <TR height=4>
	          <TD></TD>
	        </TR>
	      </TABLE>
	      <TABLE id=child5 style="DISPLAY: none" cellSpacing=0 cellPadding=0 
	      width=150 border=0>
	        <TR height=20>
	          <TD align=middle width=30>
	          	<IMG height=9 src=""../images/menu_icon.gif" width=9></TD>
	          <TD><A class=menuChild href="../error/building.jsp" target=main>待建设</A></TD>
	        </TR>
	        <TR height=4>
	          <TD colSpan=2>
	          </TD>
	        </TR>
	      </TABLE>
	</BODY>
</HTML>

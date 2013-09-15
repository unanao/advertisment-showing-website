<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<HTML>
<HEAD>
	<link rel="stylesheet" type="text/css" href="css_files/admin.css" />
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + 
			request.getServerPort() + request.getContextPath() %>/" />
	<TITLE>58板材网站后台管理</TITLE>
	<script type="text/javascript" src='js/verify_code.js'></script>
</HEAD>
<BODY onload=document.form1.name.focus();>

<!-- 输出系统的Action Error提示 -->
<div class="error" style="position:absolute; left: 20%; top: 50px; color:#ff0000;">
	<s:actionerror />
</div>

<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" bgColor=#002779 
border=0>
  <TR>
    <TD align=middle>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD><IMG height=23 src="images/login_1.jpg" 
          width=468></TD></TR>
        <TR>
          <TD><IMG height=147 src="images/login_2.jpg" 
            width=468></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 bgColor=#ffffff border=0>
        <TR>
          <TD width=16><IMG height=122 src="images/login_3.jpg" 
            width=16></TD>
          <TD align=middle>
            <TABLE cellSpacing=0 cellPadding=0 width=300 border=0>
            
   <s:form action="admin_login">
              <TR>
                <TD></TD>
                <TD width=100>用户名</TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                  maxLength=30 size=24 value="" name="name"></TD></TR>
              <TR height=20>
                <TD>&nbsp; </TD>
                <TD>密码</TD>
                <TD><INPUT 
                  style="BORDER-RIGHT: #000000 1px solid; BORDER-TOP: #000000 1px solid; BORDER-LEFT: #000000 1px solid; BORDER-BOTTOM: #000000 1px solid" 
                  type=password maxLength=30 size=24 value="" name="password"></TD>
               </TR>
              <TR>
                <TD></TD>
                <TD>验证码</TD>
                <TD><input name="verifyCode" type=text style="width:50%;">
                <img width="120" height="30" src="getVercode" , id="AuthImgAction"
						alt="验证码图片" onclick="changeValidateCode(this)">
				<a href="javascript:reloadImg();">看不清？换一张</a>
				</TD>
              </TR>
              <TR>
                <TD>&nbsp;</TD>
                <TD>&nbsp;</TD>
                <TD><INPUT type="submit" height=18 width=70 
                  src="images/bt_login.gif"></TD></TR>
    </s:form>
             </TABLE></TD>
          <TD width=16><IMG height=122 src="images/login_4.jpg" 
            width=16></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD><IMG height=16 src="images/login_5.jpg" 
          width=468></TD></TR></TABLE>
      <TABLE cellSpacing=0 cellPadding=0 width=468 border=0>
        <TR>
          <TD align=right><A href="#" target=_blank><IMG 
            height=26 src="images/login_6.gif" width=165 
            border=0></A></TD></TR></TABLE></TD></TR></TABLE></BODY></HTML>

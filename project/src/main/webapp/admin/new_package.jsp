<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="../css_files/admin.css" />
</head>
<body style="text-align:left;">
    
    <%-- 输出系统的Action Error提示 --%>
	<div class="error" style="position:absolute; left: 20%; top: 50px; color:#ff0000;">
		<s:actionerror />
	</div>
    
	<s:form action="admin_new_package">
		<div id=zhuti class="zhuti"	style="position: absolute; left: 20%; top: 100px; ">
			套餐名称:
			<INPUT id=u7  class="label_att"  name="name" type=text	>
			<br>
			
			广告栏(个数):
			<INPUT id=u9 class="input_att_100" name="adNum" type=text>
			<br>
			
			产品栏(个数):
			<INPUT id=u9 class="input_att_100"  name="displayProductNum" type=text>
			<br>
			
			企业栏(个数):
			<INPUT id=u9 class="input_att_100"  name="displayEnterpriseNum" type=text>
			<br>
			
			持续时间（天）:
			<INPUT id=u11 class="input_att_100" name="duration" type=text value="">
			<br>
			
			地区(不填-代表全国):
			<INPUT id=u12 name="area" class="input_att_100" >
			<br>
			
			产品类别（不填-代表所有产品）:
			<INPUT id=u12 name="productCategory" class="input_att_100"  >
			<br>
			
			开始时间（格式为yyyy-mm-dd）:
			<INPUT id=u12 name="startTime" class="input_att_100"  >
			<br>

			结束时间（格式为yyyy-mm-dd）:
			<INPUT id=u12 name="endTime" class="input_att_100"  >
			<br>

			套餐价格(元):
			<INPUT id=u12 name="price" class="input_att_100" >
			<br>
			
			<INPUT id=u12 class="reg_input_att" type=submit value="提交"
			style="position: relative; left: 2%;">
			<INPUT id=u13 class="reg_input_att" type=submit value="取消" 
			style="position: relative; left: 10%;">
		</div>
	</s:form>
</BODY>
</HTML>
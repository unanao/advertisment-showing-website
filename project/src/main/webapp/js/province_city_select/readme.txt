1、引入省市级联
	<s:include value="js/province_city_select/province_city_select.jsp" />
	注此处的路径只能写相对路径，测试时发现
	<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
	设置后还是要使用相对路径。

2、 布局设置
<style>
.province_city			
{
	position:absolute;
	top: 13px;				
	left: 54%;		
}
</style>

.province_city不要修改, 其它的地方根据需要添加

3、struts2可以直接使用，不要做任何修改
获取省、市、镇的name分别为：
省："province"
市: "city"
镇："county"

$(function() {
	var name = false;
	var introduction = false;
	var category = false;
	function checkName() 
	{
		var value = $("#name").val();
		
		if ((0 != value.length) && ("" != value) && (/^.{1,32}$/.exec(value))) 
		{
			$("#ename").html("");
			name = true;
		} 
		else 
		{
			$("#ename").html("产品名称长度为1 到 32个字符!");
			name = false;
		}
	}
	
	function checkCategory() 
	{
		var cate = $("#category").val();
		if("请选择" != cate && $("#detail")){
			var detail = $("#detail").val();
			if("请选择" != detail){
				$("#ecategory").html("");
				category = true;
			}else{
				$("#ecategory").html("产品种类不能为空");
				category = false;				
			}
			
		}else 
		{
			$("#ecategory").html("产品种类不能为空");
			category = false;
		}
	}
	
	function checkIntroduction()
	{
		var value = $("#introduction").val();
		
		if (("" == value) || (0 == value.length))
		{
			$("#eintroduction").html("描述不能为空");
			introduction = false;
		}
		else if (value.length > 255)
		{
			$("#eintroduction").html("描述长度需要小于255个字符");
			introduction = false;
		}
		else
		{
			$("#eintroduction").html("");
			introduction = true;
		}
	}
	
	$("#name").blur(checkName);
	$("#introduction").blur(checkIntroduction);
	
	$("#submit").click(function() {
		checkName();
		checkIntroduction();
		checkCategory();
		return name && introduction && category;
	});
});
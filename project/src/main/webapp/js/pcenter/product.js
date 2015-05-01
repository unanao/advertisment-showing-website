$(document).delegate('#u198', 'change', function() {
	deal_new_picture('productId','pcenter/saveProductPicture',
            'pcenter/pubProductPicture', 'pcenter/deleteProductPicture', 'icon', this)
});

/* init for page loading*/
$(function() {
	loadProductCategoryDetail("请选择", "请选择");
	
	return productCheck();
});

function displayProduct(productId) {
	if (null == productId) {
		return ;
	}
	
	$.getJSON("pcenter/showProduct", {productId: productId},  function(data) {
		$("#productId").val(data.product.id);
		$("#name").val(data.product.name);
		loadProductCategoryDetail(data.product.category, data.product.detail);
		$("#introduction").val(data.product.introduction);
		$("#icon").attr("src", data.product.icon).appendTo("#icon");
		
		/* example: http://www.w3school.com.cn/jquery/ajax_getjson.asp */
		 $.each(data.productPictureMap, function(key, item){
			 	if (key >= MAX_PIC_NUMBER) {
			 		return;
			    }
			 	
			    deal_return_picture(key, item.path, 
			    		"productId", 'pcenter/pubProductPicture','pcenter/deleteProductPicture','icon');
		 });
    });
}

function setProduct() {
	var productId = $("#productId").val();	
	var name = $("#name").val();
	var category = $("#category").val();
	var detail = $("#detail").val();
	var introduction = $("#introduction").val();
	$.post("pcenter/updateProduct", {
		productId : productId,
		name : name,
		category : category,
		detail : detail,
		introduction : introduction,
	}, function(data) {
		document .getElementById ("save_ok_msg").style.display="block";
	});
}

function productCheck() {
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
}
/* init for page loading*/
$(function() {
	listProduct();
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

function loadModifyProduct(productId) {
	$('#pcenter_right').load("pcenter/product.jsp?productId=" + productId);
	
	displayProduct(productId);
}

function listProduct() {
	$("#product_table tr:not(:first)").remove();
	
	$.getJSON("pcenter/listProducts",  function(data) {
		//example: http://www.w3school.com.cn/jquery/ajax_getjson.asp 
		$.each(data.products, function(i, product){                          
			var row = $("#template").clone();
			
            row.find("#name").text(product.name);
            row.find("#preview").html("<a href=product/showProduct?productId=" + product.id + ">查看</a>");
            row.find("#modify").html("<a href=\"javascript:loadModifyProduct(" + product.id + ")\">编辑</a>");   
            row.find("#delete").html("<a href=\"javascript:delProduct(" + product.id + ", this)\">删除</a>");
        
           	row.attr("id","ready" + product.id);//改变绑定好数据的行的id
            row.appendTo("#product_table");//添加到模板的容器中
		});
    });
    
}

function delProduct(productId, obj) {
	$.post("pcenter/deleteProduct", {
		productId : productId,
	}, function(data) {		
		listProduct();
	});
}
/* init for page loading*/
$(function() {
	displayPcenter();
});

function displayPcenter() {
	dispalyEnterprise();
	displayEntProducts();
	displayPackage();
}

function dispalyEnterprise() {
	
	$.getJSON("pcenter/showEnterprise", function(data) {
		enterprise_id = data.enterprise.id;
		if ((-1 != enterprise_id) && (null != enterprise_id)) {
			document .getElementById ("enterprise_info").style.display="block";
			document .getElementById ("no_enterprise_msg").style.display="none";
		}
		
		document .getElementById ("enterpriseName").innerHTML = data.enterprise.name;
		document .getElementById ("location").innerHTML = data.enterprise.province + 
		                              								data.enterprise.city + data.enterprise.county;
		document .getElementById ("address").innerHTML = data.enterprise.address;
		document .getElementById ("scale").innerHTML = data.enterprise.scale;
		document .getElementById ("contacter").innerHTML = data.phone.contacter;
		document .getElementById ("number").innerHTML = data.phone.number;
		document .getElementById ("introduction").innerHTML = data.enterprise.introduction;
		$("#logo").attr("src", data.enterprise.logo).appendTo("#logo");
    });
}

function displayEntProducts() {
	$.getJSON("pcenter/listProducts",  function(data) {
		var num = 0;

		//example: http://www.w3school.com.cn/jquery/ajax_getjson.asp 
		$.each(data.products, function(i, product){
			var picture = "<li class='span3'>"  + "<div class='thumbnail'>" + 
			 		"<img id='"+ i +"' onload='DrawImage(this,200,150)' src='"+ product.icon+"'/>" +
			 		"<div class='caption'>" + product.name + "</div>" + "</div>" + "</li>";
		    $("#product_info").append(picture); 
		    num++;
		});
	
		if (0 != num) {
			 document .getElementById ("no_product_msg").style.display="none";
		 }
		
    });
	
	
}

function displayPackage() {
	var num = 0;
	
	$.getJSON("pcenter/personalSummary",  function(data) {
		/* example: http://www.w3school.com.cn/jquery/ajax_getjson.asp */
		 $.each(data.packages, function(i, item){
			 var package = "<li>" + item.name  + "</li>";
			 $("#packages_info").append(package); 
			 num++;
		 });

		 if (0 == num) {
			 document .getElementById ("no_package_msg").style.display="block";
		 }
    });
}

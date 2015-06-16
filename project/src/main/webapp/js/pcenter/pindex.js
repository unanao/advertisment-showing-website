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
		
		var location = data.enterprise.province + data.enterprise.city;
		if (null != data.enterprise.county) {
			location += data.enterprise.county;
		}
		document .getElementById ("location").innerHTML =  location;
		
		document .getElementById ("address").innerHTML = data.enterprise.address;
		var scale = data.enterprise.scale;
		var scaleValue = "未知";
		if("1"==scale){
			scaleValue="小于50人";
		}else if("2"==scale){
			scaleValue="50-150人";
		}else if("3"==scale){
			scaleValue="150-500人";
		}else if("4"==scale){
			scaleValue="500-1000人";
		}else if("5"==scale){
			scaleValue="1000人以上";
		}
		document .getElementById ("scale").innerHTML = scaleValue;
		document .getElementById ("contacter").innerHTML = data.phone.contacter;
		document .getElementById ("number").innerHTML = data.phone.number;
		document .getElementById ("introduction").innerHTML = data.enterprise.introduction;
		
		
		var entprise_logo = 
		"<a href=enterprise/showEnterprise?enterpriseId=" + enterprise_id + ">" + 
				"<img onload='DrawImage(this,300,250)' src='"+ data.enterprise.logo+"'/>" +
		"</a>";
		$("#logo").append(entprise_logo);
    });
}

function displayEntProducts() {
	$.getJSON("pcenter/listProducts",  function(data) {
		var num = 0;

		//example: http://www.w3school.com.cn/jquery/ajax_getjson.asp 
		$.each(data.products, function(i, product){
			var picture = 
				"<li class='span3'>"  + 
					"<a href=product/showProduct?productId=" + product.id + ">" + 
					 	"<div class='thumbnail'>" +
			 				"<img id='"+ i +"' onload='DrawImage(this,200,150)' src='"+ product.icon+"'/>" +
			 	
			 				"<div class='caption'>" + product.name + "</div>" + 
			 			"</div>" +
						"</a>" +
			 	"</li>";
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

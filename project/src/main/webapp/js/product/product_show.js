/*
   jQuery - 设置内容和属性 http://www.w3school.com.cn/jquery/jquery_dom_set.asp
   post  : http://www.w3school.com.cn/jquery/ajax_post.asp
*/
/* init for page loading*/
$(function() {
	dispalyProuduct();
});

function displayEnterpriseInfo(enterpriseId) {
	$.getJSON("enterprise/showEnterpriseAjax", {enterpriseId : enterpriseId}, function(data) {
		document .getElementById ("contacter").innerHTML = data.phone.contacter;
		document.getElementById("number").innerHTML = data.phone.number;
    });
}

function dispalyProuduct() {
	$.ajaxSetup({  
	    async : false  
	}); 
	
	var productId = getUrlParam('productId');

	$.getJSON("product/showProductAjax", {productId : productId}, function(data) {
		displayEnterpriseInfo(data.enterprise.id);
    });
}
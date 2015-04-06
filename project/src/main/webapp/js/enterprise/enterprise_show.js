/*
   jQuery - 设置内容和属性 http://www.w3school.com.cn/jquery/jquery_dom_set.asp
   post  : http://www.w3school.com.cn/jquery/ajax_post.asp
*/
/* init for page loading*/
$(function() {
	dispalyEnterpriseInfo();
});

function dispalyEnterpriseInfo() {
	$.ajaxSetup({  
	    async : false  
	}); 
	
	var id = getUrlParam('enterpriseId');
	$.getJSON("enterprise/showEnterpriseAjax", {enterpriseId : id}, function(data) {
		document .getElementById ("contacter").innerHTML = data.phone.contacter;
		document.getElementById("number").innerHTML = data.phone.number;
    });
}
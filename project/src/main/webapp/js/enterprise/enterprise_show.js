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
		document .getElementById ("scale").innerHTML =scaleValue;
		document .getElementById ("contacter").innerHTML = data.phone.contacter;
		document.getElementById("number").innerHTML = data.phone.number;
    });
}
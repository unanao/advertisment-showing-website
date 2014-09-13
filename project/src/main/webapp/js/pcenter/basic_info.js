/*
   jQuery - 设置内容和属性 http://www.w3school.com.cn/jquery/jquery_dom_set.asp
   post  : http://www.w3school.com.cn/jquery/ajax_post.asp
*/
/* init for page loading*/
$(function() {
	displayBasicInfo();
});

function displayBasicInfo() {
	$.ajaxSetup({  
	    async : false  
	}); 
	
	$.getJSON("pcenter/getPersonalInfo", function(data) {
        $("#nickName").val(data.user.nickname);
		$("#name").val(data.user.name);
		$("#gender").val(data.user.gender);
		$("#officePhone").val(data.officePhone.number);
		$("#mobile").val(data.mobile.number);
		$("#qq").val(data.user.qq); 
    });
}

function setBasicInfo() {
	var nickName = $("#nickName").val();
	var name = $("#name").val();
	var gender = $("#gender").val();
	var officePhone = $("#officePhone").val();
	var mobile = $("#mobile").val();
	var qq = $("#qq").val();

	$.post("pcenter/editPersonalInfo", {
		nickName : nickName,
		name : name,
		gender : gender,
		officePhone : officePhone,
		mobile : mobile,
		qq : qq,
	}, function(data) {
		displayBasicInfo();
	});
}
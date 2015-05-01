/*
   jQuery - 设置内容和属性 http://www.w3school.com.cn/jquery/jquery_dom_set.asp
   post  : http://www.w3school.com.cn/jquery/ajax_post.asp
*/
/* init for page loading*/
$(function() {
	displayBasicInfo();
	
	return basic_info_check();
});

function displayBasicInfo() {	
	$.getJSON("pcenter/getPersonalInfo", function(data) {
        $("#nickName").val(data.user.nickname);
		$("#name").val(data.user.name);
		
		var gender =data.user.gender;
		$("input[name='gender']").each(function() {
			if ($(this).val() == gender) {
				$(this).attr("checked",  true);
			}
		});
		
		$("#officePhone").val(data.officePhone.number);
		$("#mobile").val(data.mobile.number);
		$("#qq").val(data.user.qq); 
    });
}

function setBasicInfo() {
	var nickName = $("#nickName").val();
	var name = $("#name").val();
	var gender = $("input[name='gender']:checked").val();
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
		document .getElementById ("save_ok_msg").style.display="block";
	});
}

function basic_info_check() {
	var nickName = true;
	var name = true;
	var officePhone = true;
	var mobile = true;
	var qq = true;
	
	function checkNickName() 
	{
		if ($("#nickName").val() == "") 
		{
			nickName = true;
			return;
		}
		
		if (/^.{2,32}$/.exec($("#nickName").val())) 
		{
			$("#enickName").html("");
			nickName = true;
		} 
		else 
		{
			$("#enickName").html("昵称长度为2 到 20个字符!");
			nickName = false;
		}
	}
	
	function checkName() 
	{
		if ($("#name").val() == "") 
		{
			name = true;
			return;
		}
		
		if (/^.{2,32}$/.exec($("#name").val())) 
		{
			$("#ename").html("");
			name = true;
		} 
		else 
		{
			$("#ename").html("昵称长度为2 到 20个字符!");
			name = false;
		}
	}
	
	function checkOfficePhone() 
	{
		var phone = $("#officePhone").val();
			
		if (phone == "") 
		{
			officePhone = true;
			return;
		}
		
		var tel = /[0-9]{3,4}-[0-9]{5,8}/;
		if(phone.replace(/\s/g,"")!="" && !(tel.exec(phone))) 
		{
			$("#eofficePhone").html("区号-座机号码");
		    officePhone =  false;
		}
		else
		{
			$("#eofficePhone").html("");
			officePhone = true;
		}
	}
	
	function checkMobile() 
	{
		var phone = $("#mobile").val();
			
		if (phone == "") 
		{
			mobile = true;
			return;
		}
		
		var tel = /[0-9]{4,14}/;
		if(phone.replace(/\s/g,"")!="" && !(tel.exec(phone))) 
		{
			$("#emobile").html("手机号码：11位手机号码");
		    mobile =  false;
		}
		else
		{
			$("#emobile").html("");
			mobile = true;
		}
	}
	
	function checkQQ()
	{
		var qq = $("#qq").val();
		if (qq == "") 
		{
			qq = true;
			return;
		}
		
		var patern=/^[1-9][0-9]{4,}$/;
		if(patern.exec(qq))
		{
			$("#eqq").html("");
		    qq = true;
		}
		else
		{
			$("#eqq").html("qq号码错误");
			qq = false;
		}
	}
	
	$("#nameName").blur(checkNickName);
	$("#name").blur(checkName);
	$("#officePhone").blur(checkOfficePhone);
	$("#mobile").blur(checkMobile);
	$("#qq").blur(checkQQ);
	
	$("#submit").click(function() {SyntaxError
		checkNickName();
		checkName();
		checkOfficePhone();
		checkMobile();
		checkQQ();
		
		return nickName && name && officePhone && mobile && qq;
	});
}
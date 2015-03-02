/* init for page loading*/
$(function() {
	dispalyProduct();
});

function dispalyEnterprise() {
	$.ajaxSetup({  
	    async : false  
	}); 
	
	$.getJSON("pcenter/showEnterprise", function(data) {
		$("#name").val(data.enterprise.name);
		$("#province").val(data.enterprise.province);
		$("#city").val(data.enterprise.city);
		$("#county").val(data.enterprise.county);
		$("#address").val(data.enterprise.address);
		$("#scale").val(data.enterprise.scale);
		$("#contacter").val(data.phone.contacter);
		$("#number").val(data.phone.number);
		$("#introduction").val(data.enterprise.introduction);
		$("<img/>").attr("src", data.enterprise.logo).appendTo("#logo");
		
		/* example: http://www.w3school.com.cn/jquery/ajax_getjson.asp */
		 $.each(data.items, function(i,item){
			    deal_return_picture(data.enterprisePictureMap.key, data.enterprisePictureMap.path, 
                 "enterpriseId", 'pcenter/pubEnterprisePicture', 'pcenter/deleteEnterprisePicture', 'logo');
		 });
    });
}

function setEnterprise() {
		var name = $("#name").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var conty = $("#county").val();
		var address = $("#address").val();
		var scale = $("#scale").val();
		var contacter = $("#contacter").val();
		var number = $("#number").val();
		var introduction = $("#introduction").val();

		$.post("pcenter/updateEnterprise", {
			name : name,
			province : province,
			city : city,
			conty : conty,
			address : address,
			scale : scale,
			contacter:contacter,
			number:number,
			introduction:introduction,
		}, function(data) {
			alert("资料修改成功"); 
			introduction();
		});
}

function enterpriseCheck() {
	var name = false;
	var address = false; 
	var scale = false;
	var contacter = false;
	var number = false;
	var introduction = false;
	
	function checkName() 
	{
		var value = $("#name").val();
		
		if ((0 != value.length) && ("" != value) && (/^.{2,32}$/.exec(value))) 
		{
			$("#ename").html("");
			name = true;
		} 
		else 
		{
			$("#ename").html("公司名称长度为2 到 32个字符!");
			name = false;
		}
	}
	
	function checkAddress() 
	{
		var value = $("#address").val();
		
		if (("" != value) && (/^.{2,32}$/.exec(value))) 
		{
			$("#eaddress").html("");
			address = true;
		} 
		else 
		{
			$("#eaddress").html("详细地址不能为空，长度为1 到 32个字符!");
			address = false;
		}
	}
	
	function checkScale()
	{
		var value = $("#scale").val();
		
		if ((value == "") || (0 == value.length)) 
		{
			$("#escale").html("公司规模不能为空");
			scale = false;
			return;
		}
		
		var reg =  /^[1-9][0-9]{1,}$/;
		if(value.replace(/\s/g,"")!="" && !(reg.exec(value))) 
		{
			$("#escale").html("规模为公司员工数，必须为数字");
			scale =  false;
		}
		else
		{
			$("#escale").html("");
			scale = true;
		}
	}
	
	function checkContacter()
	{
		var value = $("#contacter").val();
		
		if ((0 != value.length) && ("" != value) && (/^.{2,32}$/.exec(value))) 
		{
			$("#econtacter").html("");
			contacter = true;
		} 
		else 
		{
			$("#econtacter").html("联系人的长度为2 到 32个字符!");
			contacter = false;
		}
	}
	
	function checkNumber() 
	{
		var value = $("#number").val();
			
		if ((value == "") || (0 == value.length)) 
		{
			$("#enumber").html("联系电话不能为空");
			number = false;
			return;
		}
		
		var tel = /[0-9]{4,14}/;
		if((value.replace(/\s/g,"")!="") && !(tel.exec(value))) 
		{
			$("#enumber").html("请输入正确的电话号码");
			number =  false;
		}
		else
		{
			$("#enumber").html("");
			number = true;
		}
	}
	
	function checkIntroduction()
	{
		var value = $("#introduction").val();
		
		if (("" == value) || (0 == value.length))
		{
			$("#eintroduction").html("简介不能为空");
			introduction = false;
		}
		else if (value.length > 255)
		{
			$("#eintroduction").html("简介长度需要小于255个字符");
			introduction = false;
		}
		else
		{
			$("#eintroduction").html("");
			introduction = true;
		}
	}
	
	$("#name").blur(checkName);
	$("#address").blur(checkAddress);
	$("#scale").blur(checkScale);
	$("#contacter").blur(checkContacter);
	$("#number").blur(checkNumber);
	$("#introduction").blur(checkIntroduction);
	
	$("#submit").click(function() {
		checkName();
		checkAddress();
		checkScale();
		checkContacter();
		checkNumber();
		checkIntroduction();
		
		return name && contacter && number && scale && introduction && address;
	});
}
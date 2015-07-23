var accountsLogin  = {};

accountsLogin.loginAuth = function() {
	var userName = $("#userName").val();	
	var password = $("#password").val();
	
	alert(userName);
	alert(password);
	$.post("accounts/login", {
		userName:userName,
		password : password,
	}, function(data) {
		alert(hello);
	});
}

$function() {
	$("#username").blur(accountsLogin.checkUsername);
	$("#password").blur(accountsLogin.checkPassword);
}

accountsLogin.loginAuth = function() {
	var userName = $("#userName").val();	
	var password = $("#password").val();
	
	alert("no");
	
	if (true != accountsLogin.checkInput()) {
		return;
	}
	alert(userName);
	alert(password);
	$.post("accounts/login", {
		userName:userName,
		password : password,
	}, function(data) {
		alert(hello);
	});
}

accountsLogin.checkUsername = function () 
{
	if ($("#userName").val().replace(/[ ]/g, "") != "") 
	{
		if (/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.exec($("#userName").val())) 
		{
			$("#euserName").html("");
			return true;
		}
		else
		{
			$("#euserName").html("用户名为您的注册邮箱");
			return  false;
		}
		
	} 
	else 
	{
		$("#euserName").html("请输入用户名");
		return false;
	}
}

accountsLogin.checkPassword = function() {
	if ($("#password").val().replace(/[ ]/g, "") != "") {
		$("#epassword").html("");
		return true;
	} else {
		$("#epassword").html("请输入密码");
		return false;
	}
}
	
accountsLogin.checkInput = function() {
		var userName = checkUsername();
		var password = checkPassword();
		return userName && password;
}
	

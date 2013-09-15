/**
 * 
 */

$(function() {
	var  username = false, password = false;
	function checkUsername() 
	{
		if ($("#userName").val().replace(/[ ]/g, "") != "") 
		{
			if (/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.exec($("#userName").val())) 
			{
				$("#euserName").html("");
				username = true;
			}
			else
			{
				$("#euserName").html("用户名为您的注册邮箱");
				username = false;
			}
			
		} 
		else 
		{
			$("#euserName").html("请输入用户名");
			username = false;
		}
	}
	
	function checkPassword() {
		if ($("#password").val().replace(/[ ]/g, "") != "") {
			$("#epassword").html("");
			password = true;
		} else {
			$("#epassword").html("请输入密码");
			password = false;
		}
	}
	
	$("#username").blur(checkUsername);
	$("#password").blur(checkPassword);
	
	$("#submit").click(function() {
		checkUsername();
		checkPassword();
		return username && password;
	});
	
});
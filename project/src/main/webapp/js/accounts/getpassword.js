/**
 * 
 */
$(function() {
	var  username = false, email = false;
	function checkUsername() {
		if ($("#username").val().replace(/[ ]/g, "") != "") {
			$("#eusername").html("");
			username = true;
		} else {
			$("#eusername").html("请输入用户名");
			username = false;
		}
	}
	
	function checkEmail() {
		if (/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.exec($("#email").val())) {
			$("#eemail").html("<span class='pass'>√</span>");
			email = true;
		} else {
			$("#eemail").html("邮箱格式错误！");
			email = false;
		}
	}
	$("#username").blur(checkUsername);
	$("#email").blur(checkEmail);
	$("#submit").click(function() {
		return email;
	});
	
});
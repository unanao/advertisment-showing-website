function changePassword() {
	var oldPassword = $("#oldPassword").val();
	var newPassword = $("#newPassword").val();
	var passwordConfirm = $("#passwordConfirm").val();

	$.post("pcenter/changePersonalPassword", {
		oldPassword : oldPassword,
		newPassword : newPassword,
		passwordConfirm : passwordConfirm,
	}, function(data) {
		alert("密码修改成功"); 
	});
}

$(function() {
	var oldPassword = false;
	var newPassword = false;
	var passwordConfirm = false;
	
	function checkOldPassword() {
		if (/^.{6,32}$/.exec($("#oldPassword").val())) {
			$("#eoldPassword").html("");
			oldPassword = true;
		} else {
			$("#eoldPassword").html("密码必须6-32位!");
			oldPassword = false;
		}
	}
	
	function checkNewPassword() {
		if (/^.{6,32}$/.exec($("#newPassword").val())) {
			$("#enewPassword").html("");
			newPassword = true;
		} else {
			$("#enewPassword").html("密码必须6-32位!");
			newPassword = false;
		}
	}
	
	function checkPasswordConfirm() {
		if ($("#passwordConfirm").val() == "") {
			confirm = false;
			return;
		}
		
		if ($("#passwordConfirm").val() == $("#newPassword").val()) {
			$("#epasswordConfirm").html("");
			passwordConfirm = true;
		} else {
			$("#epasswordConfirm").html("前后密码不一致!");
			passwordConfirm = false;
		}
	}
	
	$("#oldpassword").blur(checkOldPassword);
	$("#newpassword").blur(checkNewPassword);
	$("#passwordconfirm").blur(checkPasswordConfirm);
	
	$("#submit").click(function() {
		checkOldPassword();
		checkNewPassword();
		checkPasswordConfirm();
		
		return newPassword && passwordConfirm && oldPassword;
	});
});
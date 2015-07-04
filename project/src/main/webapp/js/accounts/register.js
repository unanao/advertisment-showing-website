/**
 * 
 */

$(function(){
	var username = false;
	var password = false;
	var passwordConfirm = false;
	var agreement = false;
	var verifycode = false;
	$.ajaxSetup({  
	    async : false  
	}); 
	
	function checkUsername() {
		var value = $("#userName").val();
		
		if (/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.exec(value)) 
		{
			$.post("accounts/username_check",{
				userName:value
				},function(data) {
	            if (data.charAt(0) == "0") {
	                    $("#euserName").html("该邮箱已经注册!");
	                    username = false;
	                    return;
	            } else if (data.charAt(0) == "1") {
	                    $("#euserName").html("");
	                    username = true;
	            } else {
	                    $("#euserName").html("对不起，检查出错，请稍候再试!");
	                    username = false;
	                    return;
	            }
			});
		} else {
			$("#euserName").html("请输入正确的邮箱！");
			username = false;
			return;
		}
	}
	
	function checkPassword() {
		if (/^.{6,32}$/.exec($("#password").val())) {
			$("#epassword").html("");
			password = true;
		} else {
			$("#epassword").html("密码必须为6-32位!");
			password = false;
			return;
		}
	}
	
	function checkVerifyCode() {
		var value = $("#verifyCode").val();
		
		if (/^.{4,4}$/.exec(value)) {
			 
			$.post("accounts/verify_code_check", {
				verifyCode : value
			}, function(data) {
				 if (data.charAt(0) == "0") {
	                    $("#everifyCode").html("验证码不匹配");
	                    verifycode = false;
	            } else if (data.charAt(0) == "1") {
	                    $("#everifyCode").html("");
	                    verifycode = true;
	            } else {
	                    $("#everifyCode").html("对不起，检查出错，请稍候再试!");
	                    verifycode = false;
	            }
			});
		} else {
			$("#everifyCode").html("请输入正确的验证码!");
			verifycode = false;
			return;
		}
	}
	
	function checkPasswordConfirm() {
		if ($("#password").val() == "") {
			confirm = false;
			return;
		}
		
		if ($("#passwordConfirm").val() == $("#password").val()) {
			$("#epasswordConfirm").html("");
			passwordConfirm = true;
		} else {
			$("#epasswordConfirm").html("前后密码不一致!");
			passwordConfirm = false;
			return;
		}
	}
	
	function checkServiceProtocol() {
		if ($("#agreement").attr("checked")) {
			agreement = true;
		} else {
			$("#eagreement").html("您还没有接受服务条款！");
			agreement = false;
			return;
		}
	}
	
	$("#userName").blur(checkUsername);
	$("#password").blur(checkPassword);
	$("#passwordConfirm").blur(checkPasswordConfirm);
	$("#agreement").blur(checkServiceProtocol);
	$("#verifyCode").blur(checkVerifyCode);
	
	$("#submit").click(function() {
		checkUsername();
		checkPassword();
		checkPasswordConfirm();
		checkVerifyCode();
		checkServiceProtocol();
		
		return username && password && passwordConfirm && agreement && verifycode;
	});
	
});
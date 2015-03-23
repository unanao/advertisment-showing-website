<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<base href="<%= request.getScheme() + "://" + request.getServerName() + ":" 
				+ request.getServerPort() + request.getContextPath() %>/" />

<div class="blank"></div>
<form class="form-horizontal">
	<div class="control-group">
		<p>
			<span id="eoldPassword" class="common_error"> <s:fielderror>
					<s:param> oldPassword </s:param>
				</s:fielderror>
			</span>
		</p>
		<label class="control-label" for="oldPassword"> 原密码 </label>

		<div class="controls">
			<input id="oldPassword" name="oldPassword" placeholder="Old Password"
				type="password">
		</div>
	</div>

	<div class="control-group">
		<span id="enewPassword" class="common_error"> <s:fielderror>
				<s:param> newPassword </s:param>
			</s:fielderror>
		</span> <label class="control-label" for="newPassword"> 新密码 </label>

		<div class="controls">
			<input id="newPassword" name="newPassword" placeholder="New Password"
				type="password">
		</div>
	</div>

	<div class="control-group">
		<span id="epasswordConfirm" class="common_error"> <s:fielderror>
				<s:param> passwordConfirm </s:param>
			</s:fielderror> 
		</span> <label class="control-label" for="passwordConfirm"> 确认密码 </label>

		<div class="controls">
			<input id="passwordConfirm" name="passwordConfirm"
				placeholder="New Password" type="password">
		</div>
	</div>
	<div class="control-group">
		<div class="controls">
			<button class="btn" id="submit" onclick="changePassword()">保存</button>
			<button class="btn" id="cancel" type="reset">取消</button>
		</div>
	</div>
</form>

<script type="text/javascript" src="js/pcenter/change_passwd.js"></script>


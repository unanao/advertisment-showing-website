<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

	<s:form action="editPersonalInfo">
	<div >
		<div>
			
			<!-- 输出系统的Action Error提示 -->
			<p>
				 <s:actionerror />
			</p>
			
			 <!-- 昵称 -->
			<p>
				<label class="form_label"> 昵称 </label>
				<INPUT id="nickName" name="nickName" class="form_input" 
						type="text" value='<s:property value="user.nickname"/>'>
				<span id="enickName" class="common_error">
					<s:fielderror> <s:param> nickName </s:param> </s:fielderror>
				</span>
			</p>
			
			<!-- 姓名 -->
			<p>
				<label class="form_label">	 姓名 </label>
				<INPUT id="name" name="name" value='<s:property value="user.name"/>'
			 			class="form_input" type="text" >
				<span id="ename" class="common_error">
					<s:fielderror> <s:param> name </s:param> </s:fielderror>
				</span>
			</p>
	
			<!-- 性别 ： 单选框 
				FIXME:  判断是什么性别的代码写的不好 
			-->
			<p>
				<span class="form_label"> 性别 </span>
					
				<!-- 男 -->
				<s:if test="'male' == user.gender">
					<INPUT id="gender" type=radio value="male" name="gender" 
							checked="true">
				</s:if>
				<s:else>
					<INPUT id="gender" type=radio value="male" name="gender">
				</s:else>
				<label for="gender">男</label>
				<!-- 女 -->
				<s:if test="'female' == user.gender">
					<INPUT id="female" type=radio value="female" name="gender" 
							checked='true'>
				</s:if>
				<s:else>
					<INPUT id="female" type="radio" value="female" name="gender">
				</s:else>
				<label for="female">女</label>
			
				<!-- 默认采用 --“保密” -->
				<INPUT id="secret" type="radio" value="secret" name="gender" checked="true">
				<label for="secret">保密</label>
		</p>
	
			<!-- 办公电话 -->
			<p>
				<label class="form_label"> 固话 </label>
				<INPUT id="officePhone" name="officePhone" class="form_input" 
						type="text" value='<s:property value="officePhone.number"/>'>
				<span id="eofficePhone" class="common_error">
					<s:fielderror> <s:param> officePhone </s:param> </s:fielderror>
				</span>
			</p>
	
			<p>
				<label class="form_label">	 手机 </label>
				<INPUT id="mobile" name="mobile" class="form_input"
						value='<s:property value="mobile.number"/>' type="text">
				<span id="emobile" class="common_error">
					<s:fielderror> <s:param> mobile </s:param> </s:fielderror>
				</span>
			</p>
				
			<p>
				<label class="form_label">	QQ</label>
				<INPUT id="qq" name="qq" class="form_input" type="text"
						value='<s:property value="user.qq"/>'>
				<span id="eqq" class="common_error">
					<s:fielderror> <s:param> qq </s:param> </s:fielderror>
				</span>
			</p>
			
			<p>
				<INPUT id="submit" type="submit" value="确定" 
						style="position: absolute; left: 15%;"> 
				<INPUT id="cancel" type="reset" value="取消" 
						style="position: absolute; left: 55%;">
		   	</p>
		</div>
	</div>
	</s:form>
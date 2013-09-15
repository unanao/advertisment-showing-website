function reloadImg() {
	// 重新获取验证码，首先获取ID为authImg的图片元素，然后再次设置该图片元素的src元素
	// 发送时发送了一个now参数，理论上，发送该请求参数没有任何意义，但是浏览器都会缓存
	// 服务器响应。为了避免从缓存取出该验证码图片，我们每次发送请求时都发送一个now请求
	// 参数，该参数的值为当前时间，浏览器也就不会从缓存中读取该图片了。
	var timenow = new Date().getTime();
	document.getElementById("AuthImgAction").src = "accounts/verifyCodeImg?now" + timenow;
}

function changeValidateCode(obj) {
	// 获取当前的时间作为参数，无具体意义
	// 每次请求需要一个不同的参数，否则可能会返回同样的验证码
	// 这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
	var timenow = new Date().getTime();
	obj.src = "accounts/verifyCodeImg?now=" + timenow;
}

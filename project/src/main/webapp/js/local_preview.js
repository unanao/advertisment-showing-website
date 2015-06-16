var MAX_PIC_NUMBER = 5;
var num = 0;//编号
var count = 0;//控制图片个数
var id_name = null;//ajaxFileUpload时会用此变量回显上传的文件
var MAX_PIC_SIZE = 5 * 1024 * 1024;//5MB
var PIC_ALLOWED_TYPE_REGEX = "jpg|jpeg|gif|png|bmp";

//限制图片上传大小以及格式
function checkFile(fileInput, fileElementId) {
	var fileSize = null;
	//检测上传文件的类型 
	var imgName = document.getElementById(fileElementId).value;
	if (imgName == '') {
		//alert("请选择需要上传的文件!");
		return false;
	}
	var idx = imgName.lastIndexOf(".");
	if (idx != -1) {
		var ext = imgName.substr(idx + 1).toLowerCase();
		if (!PIC_ALLOWED_TYPE_REGEX.match(ext)) {
			alert("只能上传.jpg  .jpeg  .gif .png  .bmp类型的文件!");
			return false;
		}
	} else {
		alert("只能上传.jpg  .jpeg  .gif .png  .bmp类型的文件!");
		return false;
	}
	//检测上传文件的大小        
	if (window.ActiveXObject)//判断条件也可以改为navigator.userAgent.indexOf("MSIE")!=-1
	{
		//IE浏览器
		var image = new Image(); 
		
		fileInput.select();
		image.src   =   document.selection.createRange().text;
		image.onload = function(){
			fileSize=image.fileSize;
			return;
		};
	} else {
		//firefox、opera浏览器
		fileSize = fileInput.files[0].size;
	}
	if (fileSize > (MAX_PIC_SIZE)) {
		alert("文件大小不能超过5MB");
		return false;
	}
	
	return true;
}

function ajaxFileUpload(num, elementIdValue, urlValue, fileElementId) {
	$.ajaxFileUpload({
		productId : elementIdValue,
		fileId : 'fileId',
		fileIdValue : num,
		url : urlValue,//用于文件上传的服务器端请求地址
		secureuri : false,//一般设置为false
		fileElementId :  fileElementId,//文件上传空间的id属性  <input type="file" id="file" name="file" />
		dataType : 'json',//返回值类型 一般设置为json
		success : function(data, status) //服务器成功响应处理函数
		{
			//从服务器返回的json中取出message中的数据,其中message为在struts2中action中定义的成员变量
			document.getElementById(id_name).src = data.filePath;
		},
		error : function(data, status, e)//服务器响应失败处理函数
		{
			alert(e);
		}
	});
}


function deal_return_picture(id, file_url, typeId, pub_url, del_url, targetId) {
	selected_photo_thumb(id, file_url, typeId, pub_url, del_url, targetId);
}

function deal_new_picture(typeId, upload_url, pub_url, del_url, targetId,
		fileInput, fileElementId) {
	if (count >= MAX_PIC_NUMBER) {
		alert("您已上传超过5张，请删除部分照片再上传");
	} else {
		if (!checkFile(fileInput, fileElementId)) {
			return;
		}
		selected_photo_thumb(num, null, typeId, pub_url, del_url, targetId);	
		ajaxFileUpload(num, typeId, upload_url, fileElementId);
		num++;
		count++;
	}
}

function selected_photo_thumb(num, file_url, typeId,pub_url,del_url,targetId) {
	
		id_name = "thumb_pic" + num;

		var html = "<li><img id=thumb_pic"
			+ num
			+ " class=thumb_pic ><br><a href=\"javascript:publish("
			+ num + ",\'"   
			+ typeId + "\',\'"
			+ pub_url + "\',\'" 
			+ targetId + "\')\">设为封面</a><br><a href=\"javascript:rm_photo_thumb("
			+ num + ",\'" 
			+ typeId + "\',\'"
			+ del_url + "\')\">删除</a></li>";
		var temp = document.createElement("ul");
		temp.innerHTML = html;
		document.getElementById("thumb_list").appendChild(temp.firstChild);
		document.getElementById(id_name).src = file_url;
}
function publish(id_num, typeId, pub_url, targetId) {
	var xmlHttp = getXmlHttp();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			//处理完成的操作	
			var obj = eval("(" + xmlHttp.responseText + ")");
			if (obj.status == 0) {
				document.getElementById(targetId).src = obj.path;
			} else {
				alert("fail");
			}
			;
			//showJSON();
		}
		;
	};
	var type_id_value = document.getElementById(typeId).value;
	xmlHttp.open("GET", pub_url + "?id=" + id_num + "&" + typeId + "="
			+ type_id_value, true);
	xmlHttp.send(null);
}
function rm_photo_thumb(id_num, typeId, del_url) {
	var xmlHttp = getXmlHttp();
	xmlHttp.onreadystatechange = function() {
		if (xmlHttp.readyState == 4) {
			//处理完成的操作	
			var obj = eval("(" + xmlHttp.responseText + ")");
			if (obj.status == 0) {
				rm_photo_thumb0(id_num);
			} else {
				alert("封面不能删除!");
			}
			;
		}
		;
	};
	var type_id_value = document.getElementById(typeId).value;
	xmlHttp.open("GET", del_url + "?id=" + id_num + "&" + typeId + "="
			+ type_id_value, true);
	xmlHttp.send(null);
}
function rm_photo_thumb0(id_num) {
	var id_name = "thumb_pic" + id_num;
	var tmp = document.getElementById(id_name).parentNode;
	tmp.parentNode.removeChild(tmp);
	count--;
}

function getXmlHttp() {
	var xmlHttp;
	try {
		// Firefox,Opera 8.0+,Safari
		xmlHttp = new XMLHttpRequest();
	} catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
				alert("您的浏览器不支持AJAX！");
				return false;
			}
			;
		}
		;
	}
	return xmlHttp;
};


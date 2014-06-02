var Utils = {};
Utils.addEvent = function(el, type, func) {
	if (document.addEventListener) {
		el.addEventListener(type, func, false);
	} else if (document.attachEvent) {
		el.attachEvent('on' + type, func);
	}
};
/*2014-06-02 commented by lzf*/
/* 原因同省市级联， pcenter改造成AJAX后，加载此页面不会再触发window或document的load或ready事件*/
/* Utils.addEvent(window, 'load', function(){ */

    var category = document.getElementById("category");
    var detail = document.getElementById("detail");
    for (var i = 0; i < productArr.length; i++) {
    	category.options[i] = new Option(productArr[i].name, productArr[i].name);
    }
    category.options[0] = new Option("请选择", "请选择");
    detail.options[0] = new Option("请选择", "请选择");
    //detail.style.display = "none";
    
    
    var categoryValue = $("#hiddencategory").val();
    
    if ("" == categoryValue) {
        $("#category").val("请选择");
        
    }else {
        $("#category").val(categoryValue);
        var category_obj = productArr[category.selectedIndex];
        var detail_arr = category_obj.sub;
        detail.options.length = 0;
        for (var i = 0; i < detail_arr.length; i++) {
        	detail.options[i] = new Option(detail_arr[i].name, detail_arr[i].name);
        }
    }
        
    Utils.addEvent(category, 'change', function(){
        var category_obj = productArr[category.selectedIndex];
        var cate = category.options[category.selectedIndex].value;
        if(""!=cate){
	        var detail_arr = category_obj.sub;
	        detail.options.length = 0;
	        for (var i = 0; i < detail_arr.length; i++) {
	        	detail.options[i] = new Option(detail_arr[i].name, detail_arr[i].name);
	        }
	        detail.style.display = "";
        }else{
        	detail.style.display = "none";
        }
       
    });
    
    var detailValue = $("#hiddendetail").val();
    if ("" == detailValue) {
        $("#detail").val("请选择");
        
    }else {
        $("#detail").val(detailValue);
    }
/* }); */

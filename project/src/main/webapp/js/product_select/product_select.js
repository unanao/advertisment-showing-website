/*
 * @Usage
 * 1 include jquery
 * 2 include product_select.js
 * 3 When page load call  loadProductCategoryDetail(categoryVal, detailVal)  
 */

function addDetail(detailVal) {
	var category = document.getElementById("category");
	var detail = document.getElementById("detail");
	
	var selected = category.selectedIndex;
	var category_obj = productArr[selected]
    
	if (-1 != selected) {
		var detail_arr = category_obj.sub;
        detail.options.length = 0;
        for (var i = 0; i < detail_arr.length; i++) {
        	detail.options[i] = new Option(detail_arr[i].name, detail_arr[i].name);
        }
        
        $("#detail").val(detailVal);
	}
}

function loadProductCategoryDetail(categoryVal, detailVal)
{
	var category = document.getElementById("category");
	var detail = document.getElementById("detail");
	
	for (var i = 0; i < productArr.length; i++) {
		category.options[i] = new Option(productArr[i].name, productArr[i].name);
	}
	
	if (("" == categoryVal) || ("undefined" == typeof categoryVal) || (null == categoryVal)) {
	    $("#category").val("请选择");
	}
	else {
		 $("#category").val(categoryVal);
		 addDetail(detailVal);
	}
}

/*
 * Add change event
 * Function of "delegate" is more efficiency than "bind"  
 */
$(document).delegate('#category', 'change', function() {
   	 addDetail();
});

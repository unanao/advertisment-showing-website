var Utils = {};
Utils.addEvent = function(el, type, func) {
	if (document.addEventListener) {
		el.addEventListener(type, func, false);
	} else if (document.attachEvent) {
		el.attachEvent('on' + type, func);
	}
};
Utils.addEvent(window, 'load', function(){

    var region1 = document.getElementById("province");
    var region2 = document.getElementById("city");
    var region3 = document.getElementById("county");
    for (var i = 0; i < arrCity.length; i++) {
        region1.options[i] = new Option(arrCity[i].name, arrCity[i].name);
    }
    region2.options[0] = new Option("请选择", "请选择");
    region3.options[0] = new Option("请选择", "请选择");
    region3.style.display = "none";
    var province = $("#hiddenprovince").val();
    
    if ("" == province) {
        $("#province").val("请选择");
        
    }
    else {
        $("#province").val(province);
        var region1_obj = arrCity[region1.selectedIndex];
        var region2_arr = region1_obj.sub;
        region2.options.length = 0;
        region3.options.length = 0;
        region3.style.display = "none";
        for (var i = 0; i < region2_arr.length; i++) {
            region2.options[i] = new Option(region2_arr[i].name, region2_arr[i].name);
        }
    }
    
    Utils.addEvent(region1, 'change', function(){
        var region1_obj = arrCity[region1.selectedIndex];
        var region2_arr = region1_obj.sub;
        region2.options.length = 0;
        region3.options.length = 0;
        region3.style.display = "none";
        for (var i = 0; i < region2_arr.length; i++) {
            region2.options[i] = new Option(region2_arr[i].name, region2_arr[i].name);
        }
    });
    
    var city = $("#hiddencity").val();
    if ("" == city) {
        $("#city").val("请选择");
    }
    else {
        $("#city").val(city);
        var region1_obj = arrCity[region1.selectedIndex];
        var region2_obj = region1_obj.sub[region2.selectedIndex];
        var region3_arr = region2_obj.sub;
        if (region2_obj.type == 0) {
            region3.options.length = 0;
            region3.style.display = "inline";
            for (var i = 0; i < region3_arr.length; i++) {
                region3.options[i] = new Option(region3_arr[i].name, region3_arr[i].name);
            }
        }
        else {
            region3.style.display = "none";
        }
    }
    Utils.addEvent(region2, 'change', function(){
        var region1_obj = arrCity[region1.selectedIndex];
        var region2_obj = region1_obj.sub[region2.selectedIndex];
        var region3_arr = region2_obj.sub;
        if (region2_obj.type == 0) {
            region3.options.length = 0;
            region3.style.display = "inline";
            for (var i = 0; i < region3_arr.length; i++) {
                region3.options[i] = new Option(region3_arr[i].name, region3_arr[i].name);
            }
        }
        else {
            region3.style.display = "none";
        }
    });
    
    var county = $("#hiddencounty").val();
    if ("" == county) {
        $("#county").val(county);
    }
    else {
        $("#county").val(county);
    }
});

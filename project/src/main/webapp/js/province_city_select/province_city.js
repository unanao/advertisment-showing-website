function addCity() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var county = document.getElementById("county");
	var selected = province.selectedIndex;
	var province_obj = arrCity[selected];
    
	if (-1 != selected) {
		var city_arr = province_obj.sub;
	  //  city.options.length = 0;
	    county.options.length = 0;
	    county.style.display = "none";
	    for (var i = 0; i < city_arr.length; i++) {
	        city.options[i] = new Option(city_arr[i].name, city_arr[i].name);
	    }
	}
}

function addCounty() {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var county = document.getElementById("county");
	var province_obj = arrCity[province.selectedIndex];
	var city_obj = province_obj.sub[city.selectedIndex];
	var county_arr = city_obj.sub;
    
    if (city_obj.type == 0) {
   //      county.options.length = 0;
         county.style.display = "inline";
         for (var i = 0; i < county_arr.length; i++) {
             county.options[i] = new Option(county_arr[i].name, county_arr[i].name);
         }
     } else {
         county.style.display = "none";
     }
}


/*
 * Province and city example
 *  2 Province already selected
 *  	create city directly 
 *  1 Province not selected
 *  	call change function create city
 */
function loadProvinceCity(province_val_1, city_val_1, county_val_1, hiddlenprovince_val, hiddencity_val) {
	var province = document.getElementById("province");
	var city = document.getElementById("city");
	var county = document.getElementById("county");
	
	for (var i = 0; i < arrCity.length; i++) {
	    province.options[i] = new Option(arrCity[i].name, arrCity[i].name);
	}

	var province_val = province_val_1;
	if (null == province_val)
	{
		province_val = hiddlenprovince_val;
	}
	var city_val = city_val_1;
	if (null == city_val) {
		city_val = hiddencity_val;
	}
	var county_val = county_val_1;
	if (null == county_val) {
		county_val = "请选择";
	}


//	county.style.display = "none";
	
	if (("" == province_val) || ("undefined" == typeof province_val)) {
		    $("#province").val("请选择");
	}
	else {
			 $("#province").val(province_val);
			 addCity();
	}

	if ((""  ==  city_val)  ||  ("undefined" ==  typeof city_val)  ||  ("请选择" == city_val)) {
		$("#city").val("请选择");
	}
	else {
		    $("#city").val(city_val);
		    addCounty();
	}
	
	if ((""  !=  county_val)  &&  ("undefined" !=  typeof county_val)) {
		 var province_obj = arrCity[province.selectedIndex];
	     var city_obj = province_obj.sub[city.selectedIndex];
	     if (city_obj.type == 0) {
	    	 $("#county").val(county_val);
	     }
	}
}

/*
 * Add change event
 * Function of "delegate" is more efficiency than "bind"  
 */
$(document).delegate('#city', 'change', function() {
   	 addCounty();
});
$(document).delegate('#province', 'change', function() {
    addCity();
});
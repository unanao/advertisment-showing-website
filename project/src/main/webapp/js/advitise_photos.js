/*设定广告栏高度*/
$(document).ready(function(){
	$("#banner").css('height', advertise_height+20);
	$("#banner_list").css('height', advertise_height);
});

/*图片轮转 */
var t = n = 0, count=2;
var num_per_show=4;
$(document).ready(function(){				   
	count=$("#banner_list a").length/num_per_show;
	$("#banner_list a:nth-child(4)").nextAll().hide();
	for(var i=1; i<5; i++)
	{
			$("#banner_info td:nth-child("+i+")").html($("#banner_list a:nth-child("+i+")").find("img").attr('alt'));
			$("#banner_info td:nth-child("+i+")").click(function(){window.open($("#banner_list a:nth-child("+i+")").attr('href'), "_blank")});		
	}


	$("#banner li").click(function() {
		var current = $(this).text() - 1;// 获取Li元素内的值，即1，2，3，4
		n = current;
		if (current >= count) return;
		
		for(var i=1; i<5; i++)
		{
			$("#banner_info td:nth-child("+i+")").html($("#banner_list a").eq((current-1)*4+i-1).find("img").attr('alt'));
			$("#banner_info td:nth-child("+i+")").unbind().click(function(){window.open($("#banner_list a").eq((current-1)*4+i-1).attr('href'), "_blank")});
			$("#banner_list a").eq((current%2)*4+i-1).fadeOut(500).parent().children().eq((current-1)*4+i-1).fadeIn(1000);
		}
		$(this).toggleClass("on");
		$(this).siblings().removeAttr("class");
	});
	t = setInterval("showAuto()", 4000);
	$("#banner").hover(function(){clearInterval(t)}, function(){t = setInterval("showAuto()", 4000);});
})

function showAuto()
{
	n = n >=(count - 1) ? 0 : ++n;
	$("#banner li").eq(n).trigger('click');
}


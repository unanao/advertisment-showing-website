/*
 * this file contains the functions of enterprise and product show page,eg,switch the photo showing to the one your mouse over
 * author:lzf
 */
	
/*
 * switch the photo showing to the one your mouse over
*/	
function change_photo_show(ImgD)
{
	var img_show=document.getElementById('img_main');
	img_show.src=ImgD.src;
}	
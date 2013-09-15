
/*
$(document).ready(function(){
    mywidth = (document.body.offsetWidth) * 0.65 / 6;
	myheight=width*3/4;
});
*/

/*
function DrawImage(ImgD,iwidth,iheight){
     var image=new Image();
     image.src=ImgD.src;
     if(image.width>0 && image.height>0){
     flag=true;
     if(image.width/image.height>= iwidth/iheight){
         if(image.width>iwidth){  
        ImgD.width=iwidth;
         ImgD.height=(image.height*iwidth)/image.width;
         }else{
         ImgD.width=image.width;  
        ImgD.height=image.height;
         }
        // ImgD.alt=image.width+"×"+image.height;
         }
     else{
         if(image.height>iheight){  
        ImgD.height=iheight;
         ImgD.width=(image.width*iheight)/image.height;        
        }else{
         ImgD.width=image.width;  
        ImgD.height=image.height;
         }
       //  ImgD.alt=image.width+"×"+image.height;
         }
     }
 } 
*/
function DrawImage(ImgD, iwidth, iheight){
	var image=new Image();
	image.src=ImgD.src;
	if(image.width > 0 && image.height > 0){
		if(image.width/image.height >= 4/3){
			if(image.width > iwidth){
				ImgD.width = iwidth;
				ImgD.height= image.height * iwidth / image.width;
			}
			else{
				ImgD.width=image.width;
				ImgD.height=image.height;
			}
		}
		else{
			if(image.height > iheight){
				ImgD.height = iheight;
				ImgD.width = image.width * iheight / image.height;
			}
			else{
				ImgD.width=image.width;
				ImgD.height=image.height;
			}
		}
	}
}




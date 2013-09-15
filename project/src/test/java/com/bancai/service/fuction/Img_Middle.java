package com.bancai.service.fuction;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Img_Middle {
    public void img_change(String url,String name)
    {
            //三种不同的压缩图片
            Tosmallerpic(url,new File(url+name),"_middle",name,188,165,(float)0.7);
            Tosmallerpic(url,new File(url+name),"_small",name,45,45,(float)0.7);
            Tosmallerpic(url,new File(url+name),"_smaller",name,116,100,(float)0.7);
    }

    private static void  Tosmallerpic(String f,File filelist,String ext,String n,int w,int h,float per){
            Image src;
            try {
                src = javax.imageio.ImageIO.read(filelist); //构造Image对象

               String img_midname=f+n.substring(0,n.indexOf("."))+ext+n.substring(n.indexOf("."));
               int old_w=src.getWidth(null); //得到源图宽
               int old_h=src.getHeight(null);
               int new_w=0;
               int new_h=0; //得到源图长

               double w2=(old_w*1.00)/(w*1.00);
               double h2=(old_h*1.00)/(h*1.00);

               //图片跟据长宽留白，成一个正方形图。
               BufferedImage oldpic;
               if(old_w>old_h)
               {
                   oldpic=new BufferedImage(old_w,old_w,BufferedImage.TYPE_INT_RGB);
               }else{if(old_w<old_h){
                   oldpic=new BufferedImage(old_h,old_h,BufferedImage.TYPE_INT_RGB);
               }else{
                    oldpic=new BufferedImage(old_w,old_h,BufferedImage.TYPE_INT_RGB);
               }
               }
                Graphics2D g = oldpic.createGraphics();
                g.setColor(Color.white);
                if(old_w>old_h)
                {
                    g.fillRect(0, 0, old_w, old_w);
                    g.drawImage(src, 0, (old_w - old_h) / 2, old_w, old_h, Color.white, null);
                }else{
                    if(old_w<old_h){
                    g.fillRect(0,0,old_h,old_h);
                    g.drawImage(src, (old_h - old_w) / 2, 0, old_w, old_h, Color.white, null);
                    }else{
                        //g.fillRect(0,0,old_h,old_h);
                        g.drawImage(src.getScaledInstance(old_w, old_h,  Image.SCALE_SMOOTH), 0,0,null);
                    }
                }             
                g.dispose();
                src = oldpic;
                //图片调整为方形结束
               if(old_w>w)
               new_w=(int)Math.round(old_w/w2);
               else
                   new_w=old_w;
               if(old_h>h)
               new_h=(int)Math.round(old_h/h2);//计算新图长宽
               else
                   new_h=old_h;
               BufferedImage tag = new BufferedImage(new_w,new_h,BufferedImage.TYPE_INT_RGB);       
               //tag.getGraphics().drawImage(src,0,0,new_w,new_h,null); //绘制缩小后的图
               tag.getGraphics().drawImage(src.getScaledInstance(new_w, new_h,  Image.SCALE_SMOOTH), 0,0,null);
               FileOutputStream newimage=new FileOutputStream(img_midname); //输出到文件流
             
              
               //encoder.encode(tag); //近JPEG编码
               newimage.close();
               } catch (IOException ex) {
                Logger.getLogger(Img_Middle.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public static void main(String args[]){ 
        //String n="0e5465fc-025a-458d-8383-e9ced0c1e728.jpg"; 
        String f="F:\\test\\"; 
        File file=new File(f); 
        
        if(file.exists()) 
        { 
            File[] filelist=file.listFiles(); 
            for(int i=0;i<filelist.length;i++) 
            { 
                String n=filelist[i].getName(); 
                Tosmallerpic(f,filelist[i],"xxx",n,100,100,(float)0.9); 
            } 
        } 
    } 
   
}
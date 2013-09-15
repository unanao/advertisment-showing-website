/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: CompressFIle.java					
 *			
 * Description:										
 */

package com.bancai.service.fuction;

import java.io.*; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.awt.*; 
import java.awt.image.BufferedImage; 
/** 
* 
* @author Jiangpin 
*/ 
public class CompressFile { 
/** 
* 
* @param f 图片所在的文件夹路径 
* @param filelist 图片路径 
* @param ext 扩展名 
* @param n 图片名 
* @param w 目标宽 
* @param h 目标高 
* @param per 百分比 
*/ 
	private static void  ToSmallerPic(String f,File filelist,String n,float per){ 
            Image src; 
            try { 
               src = javax.imageio.ImageIO.read(filelist); //构造Image对象 

               String imgName=f+ "a" + n; 
               System.out.println(imgName);
               int old_w=src.getWidth(null); //得到源图宽 
               int old_h=src.getHeight(null); 
               BufferedImage tag = new BufferedImage(old_w,old_h,BufferedImage.TYPE_INT_RGB);        
               tag.getGraphics().drawImage(src.getScaledInstance(old_w, old_h,  Image.SCALE_SMOOTH), 0,0,null); 
               FileOutputStream newimage=new FileOutputStream(imgName); //输出到文件流 
          
              
               //encoder.encode(tag); //近JPEG编码 
               newimage.close(); 
               } catch (IOException ex) { 
                Logger.getLogger(CompressFile.class.getName()).log(Level.SEVERE, null, ex); 
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
                ToSmallerPic(f,filelist[i],n,(float)0.1); 
            } 
        } 
    } 
} 
/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: ProductPictureOperation.java					
 *			
 * Description:																
 */
package com.bancai.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * 
 * @author jiangge
 *
 */
public class FileUtils {
	static Logger logger = Logger.getLogger(FileUtils.class);
	
	/**
	 * 
	 * @param file
	 * @param destPath
	 * @throws Exception
	 */
	public static void saveFileToPath(File file,String destPath) throws Exception{
		long c = System.currentTimeMillis();
		
		//基于myFile创建一个文件输入流  
        InputStream is = new FileInputStream(file);  
          
        // 设置目标文件  
        File toFile = new File(destPath);  
          
        // 创建一个输出流  
        OutputStream os = new FileOutputStream(toFile); 
  
        //设置缓存  
        byte[] buffer = new byte[1024];  
  
        int length = 0;  
  
        logger.log(Level.INFO, "picture save path:" + destPath, null);
        //读取myFile文件输出到toFile文件中  
        while ((length = is.read(buffer)) > 0) {
        	try {
        		os.write(buffer, 0, length);
        	} catch (Exception ex) {
        		logger.log(Level.FATAL, "failed to save picture:" + destPath, ex);
        	}
        }  
        //关闭输入流  
        is.close();  
          
        //关闭输出流  
        os.close();  
        logger.log(Level.INFO,"compress elapse time:"
				+ (System.currentTimeMillis() - c) / 1000.0f + "s");
	}

	public static void deleteFile(String path) {
		File file = new File(path);
		if(file.exists()){
			file.delete();
		}
		
	}
	
	/**
	 * 删除目录及目录下的所有文件和目录
	 * @param path 目录
	 * @throws IOException
	 */
	public static void deleteDir(String path) throws IOException
	{
		File file = new File(path);
		
		try 
		{
			org.apache.commons.io.FileUtils.forceDelete(file);
		}
		catch (FileNotFoundException fileNotFound)
		{
			logger.log(Level.INFO, "success: as no direcotry exist" + path, null);
		}
	}
}

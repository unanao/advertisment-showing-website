/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: ProductPictureOperation.java					
 *			
 * Description:																
 */
package com.bancai.web.pcenter;

import java.io.File;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.bancai.constants.BancaiConstants;
import com.bancai.utils.FileUtils;
import com.bancai.utils.ImageUtils;
import com.bancai.web.base.BaseAction;

/**
 * @author unanao
 * @author jiangge
 */
public class PictureOperation extends BaseAction {
	private static final long serialVersionUID = -4288686938250653596L;
	
	/**
	 * 清楚存放图片的临时目录
	 */
	public static void clearPictureTempDir(){
		String context = ServletActionContext.getServletContext().getRealPath("");
		File file =new File(context + "/" +getTempRelativeDir());
		file.delete();
	}
	/**
	 * 获取存放图片的临时目录
	 */
	public static String getTempRelativeDir(){
		return  "picture/tmp";
	}
	
	/**
	 * 获取唯一临时相对路径，例如~/picture/tmp/XXXXXXXX.png
	 * @param fileName
	 * @return
	 */
	public static String getUniqueJpgPictureTempRelativePath(String fileName){
		String uuid = UUID.randomUUID().toString();
		return getTempRelativeDir() + "/" + uuid + ".jpg";
	}
	/**
	 * 获取用户存放图片的根路径
	 * @param name 用户名
	 * @return 用户存放所有图片的路径
	 */
	public static String getUserPictureRootDir(int userId)
	{
		
		return getPictureDir() + "/" + userId;
	}
	
	/**
	 * @return 存放图片的根目录
	 */
	private static String getPictureDir()
	{
		String context = ServletActionContext.getServletContext().getRealPath("");
		
		return context + "/" + "picture";
	}
	
	/**
	 * 返回产品图片的路径
	 * @param filePath
	 */
	public  static String getUniqueProductPictureRelativePath(String filePath,Integer userId){
		return getUniquePictureRelativePath(filePath, "product",userId);
	}
	/**
	 * 返回企业图片的路径
	 * @param filePath
	 */
	public  static String getUniqueEnterprisePictureRelativePath(String filePath,Integer userId){
		return getUniquePictureRelativePath(filePath, "enterprise",userId);
	}
	
	/**
	 * @param path
	 *            相对路径名，包含文件名
	 */
	public  static void deletePicture(String path) {
		String context = ServletActionContext.getServletContext().getRealPath(
				"");
		FileUtils.deleteFile(context + "/" + path);
	}
	/**
	 * @param path
	 *            相对路径名，包含文件名
	 */
	public  static boolean existPicture(String path) {
		String context = ServletActionContext.getServletContext().getRealPath(
				"");
		File f = new File(context + "/" + path);
		return f.exists();
	}
	/**
	 * 
	 * @param srcPic
	 * @param destPath
	 */
	public static void saveProductPicture(File srcPic, String destPath)
	{
		savePicture(srcPic, destPath, "product");
	}
	/**
	 * 
	 * @param srcPic
	 * @param destPath
	 */
	public static void saveEnterprisePicture(File srcPic, String destPath)
	{
		savePicture(srcPic, destPath, "enterprise");
	}
	
	/**
	 * 每调用一次，生成独一无二的产品存放路径+图片名字
	 * 
	 * @param filePath
	 * @param type
	 *            enterprise或者product
	 * @return
	 */
	public  static String getUniquePictureRelativePath(String filePath, String type,Integer userId) {
		if(filePath == null){
			return null;
		}
		String fileName = filePath.substring(filePath.lastIndexOf('/'));
		String path = getSaveRelativeDir(type,userId);
		return path + "/" + fileName;
	}
	
	
	/**
	 * @param type
	 * @param srcPic
	 * @param destPath
	 * @return
	 */
	private  static void savePicture(File srcPic, String destPath,String type) {
		String context = ServletActionContext.getServletContext().getRealPath(
				"");

		String absoluteDestPath = context + "/" + destPath;
		String absoluteDestDir = getPath(absoluteDestPath);
		try {
			File dir = new File(absoluteDestDir);
			if(!dir.exists()){
				dir.mkdirs();
			}
			FileUtils.saveFileToPath(srcPic, absoluteDestPath);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param type
	 *            enterprise 或者 product
	 * @return
	 */

	private  static String getSaveRelativeDir(String type,Integer userId) {
		String path = "picture" + "/" + userId + "/" + type;
		return path;
	}
	
	/**
	 * 复制文件
	 * @param srcPath 相对路径，例如picture/tmp/xxxxx.png
	 * @param destPath
	 */
	public static void copressFileToDest(String srcPath, String destPath,int targetWidth,int targetHeight) {
		String context = ServletActionContext.getServletContext().getRealPath(
				"");
		String absoluteSrcPath = context + "/" + srcPath;
		String absoluteDestPath = context + "/" + destPath;
		File destDir = new File(getPath(absoluteDestPath));
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		File srcFile = new File(absoluteSrcPath);
		File destFile = new File(absoluteDestPath);
		ImageUtils.resize(srcFile, destFile, targetWidth, targetHeight,false);
		
		if(destFile.exists()){
			srcFile.delete();
			ImageUtils.waterMarkText(BancaiConstants.WATERMARK_TEXT,destFile,targetWidth,targetHeight);
		}
	}
	
	/**
	 * 复制文件
	 * @param srcPath 相对路径，例如picture/tmp/xxxxx.png
	 * @param destPath
	 */
	public static void copyFile(String srcPath, String destPath) {
		String context = ServletActionContext.getServletContext().getRealPath(
				"");
		String absoluteSrcPath = context + "/" + srcPath;
		String absoluteDestPath = context + "/" + destPath;
		File destDir = new File(getPath(absoluteDestPath));
		if(!destDir.exists()){
			destDir.mkdirs();
		}
		File srcfile = new File(absoluteSrcPath);
		File destfile = new File(absoluteDestPath);
		srcfile.renameTo(destfile);
	}
	/**
	 * 根据文件路径获取目录
	 * @param path
	 * @return
	 */
	private static String getPath(String path){
		if(path == null){
			return null;
		}
		int end = path.lastIndexOf("/");
		if(end <= 0){
			return null;
		}
		return path.substring(0, end);
	}
}

/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: ImageCompress.java					
 *			
 * Description:										
 */
package com.bancai.service.fuction;

/**
 * ImageCompress 提供用户将大图片按比例压缩为小图片，支持JPG
 * Please refer to: <BR>
 * http://blog.csdn.net/feng_sundy/archive/2008/08/05/2769572.aspx
 * <P>
 * @author feng_sunddy <sundysea@hotmail.com>
 * @version 1.0
 * @see java.awt.image.BufferedImage
 **/
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImageCompress extends Frame {

	public static void main(String[] args) {
		String fileName = "F:/test/IMG_0144.JPG";
			long c = System.currentTimeMillis();
			ImageCompress.ImageScale(getFilePath(fileName),
					getFileFullName(fileName), getFileFullName(fileName));
			System.out.println("elapse time:"
					+ (System.currentTimeMillis() - c) / 1000.0f + "s");
	}


	public static void ImageScale(String path, String fileName,
			String toFileName) {
		try {
			Image image = javax.imageio.ImageIO.read(new File(path + fileName));
			int imageWidth = image.getWidth(null);
			int imageHeight = image.getHeight(null);
			float scale = getRatio(imageWidth, imageHeight, 1000, 750);
			imageWidth = (int) (scale * imageWidth);
			imageHeight = (int) (scale * imageHeight);

			image = image.getScaledInstance(imageWidth, imageHeight,
					Image.SCALE_AREA_AVERAGING);
			// Make a BufferedImage from the Image.
			BufferedImage mBufferedImage = new BufferedImage(imageWidth,
					imageHeight, BufferedImage.TYPE_INT_RGB);
			Graphics2D g2 = mBufferedImage.createGraphics();
			g2.drawImage(image, 0, 0, imageWidth, imageHeight, Color.white,
					null);
			g2.dispose();

			float[] kernelData2 = { -0.125f, -0.125f, -0.125f, -0.125f, 2,
					-0.125f, -0.125f, -0.125f, -0.125f };
			Kernel kernel = new Kernel(3, 3, kernelData2);
			ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
			mBufferedImage = cOp.filter(mBufferedImage, null);
			FileOutputStream out = new FileOutputStream(path + toFileName);
			// JPEGEncodeParam param =
			// encoder.getDefaultJPEGEncodeParam(bufferedImage);
			// param.setQuality(0.9f, true);
			// encoder.setJPEGEncodeParam(param);
			
			out.close();
		} catch (FileNotFoundException fnf) {
		} catch (IOException ioe) {
		} finally {

		}
	}

	/**
	 * 如果宽和高有一个需要压缩则压缩，且选压缩率较大的作为返回值
	 * @param width 实际宽度
	 * @param height
	 * @param maxWidth 目标宽度
	 * @param maxHeight
	 * @return
	 */
	private static float getRatio(int width, int height, int maxWidth,
			int maxHeight) {
		float ratio = 1.0f;
		float widthRatio;
		float heightRatio;
		widthRatio = (float) maxWidth / width;
		heightRatio = (float) maxHeight / height;
		if (widthRatio < 1.0 || heightRatio < 1.0) {
			ratio = widthRatio <= heightRatio ? widthRatio : heightRatio;
		}
		return ratio;
	}

	/**
	 * 获取文件名，包含扩展名
	 * @param filePath
	 * @return
	 */
	private static String getFileFullName(String filePath) {
		int pos = -1;
		if (!filePath.equals("")) {
			if (filePath.lastIndexOf("/") != -1) {
				pos = filePath.lastIndexOf("/") + 1;
			} else if (filePath.lastIndexOf("//") != -1) {
				pos = filePath.lastIndexOf("//") + 1;
			}
			if (pos == -1)
				pos = 0;
			return filePath.substring(pos);
		} else {
			return "";
		}
	}
	
	/**
	 * 获取文件的目录
	 * @param filePath
	 * @return
	 */
	private static String getFilePath(String filePath) {
		int pos = -1;
		if (!filePath.equals("")) {
			if (filePath.lastIndexOf("/") != -1) {
				pos = filePath.lastIndexOf("/") + 1;
			} else if (filePath.lastIndexOf("//") != -1) {
				pos = filePath.lastIndexOf("//") + 1;
			}
			if (pos != -1) {
				return filePath.substring(0, pos);
			} else {
				return "";
			}
		} else {
			return "";
		}
	}
}
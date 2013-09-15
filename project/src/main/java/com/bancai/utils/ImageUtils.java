/*
 * Copyright (C) 1998-2013 58BanCai Team.All Rights Reserved.		
 * 																	
 * FileName: ImageUtils.java					
 *			
 * Description:																
 */
package com.bancai.utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


/**
 * @author unanao
 * @author jiangge 增加压缩图片
 */

/**
 * @Usage
 * 	使用本类： ImageUtils imageUtils = new ImageUtils();
 * 加文字水印：
 *	    imageUtils.textWaterMark("水印文字", "加水印图片的路径");
 * 加图片水印：
 *      imageUtils.imageWaterMark("作为水印的图片", "要添加水印的图片");
 */
public class ImageUtils
{
	/**
	 * 图片水印
	 * 
	 * @param pressImg
	 *            水印图片
	 * @param targetImg
	 *            目标图片
	 * @param x
	 *            修正值 默认在中间
	 * @param y
	 *            修正值 默认在中间
	 * @param alpha
	 *            透明度
	 */
	public final static void pressImage(String pressImg, File targetImg,
			int x, int y, float alpha)
	{
		try
		{
			Image src = ImageIO.read(targetImg);
			int wideth = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(wideth, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, wideth, height, null);
			// 水印文件
			Image src_biao = ImageIO.read(new File(pressImg));
			int wideth_biao = src_biao.getWidth(null);
			int height_biao = src_biao.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			g.drawImage(src_biao, (wideth - wideth_biao) / 2,
					(height - height_biao) / 2, wideth_biao, height_biao, null);
			// 水印文件结束
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", targetImg);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 文字水印
	 * 
	 * @param pressText
	 *            水印文字
	 * @param targetImg
	 *            目标图片
	 * @param fontName
	 *            字体名称
	 * @param fontStyle
	 *            字体样式
	 * @param color
	 *            字体颜色
	 * @param fontSize
	 *            字体大小
	 * @param x
	 *            修正值
	 * @param y
	 *            修正值
	 * @param alpha
	 *            透明度
	 */
	public static void pressText(String pressText, File img,
			String fontName, int fontStyle, Color color, int fontSize, int x,
			int y, float alpha)
	{
		try
		{
			Image src = ImageIO.read(img);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage image = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D g = image.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);
			g.setFont(new Font(fontName, fontStyle, fontSize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
					alpha));
			g.drawString(pressText, (width - (getLength(pressText) * fontSize))
					+ x, (height - fontSize) + y);
			g.dispose();
			ImageIO.write((BufferedImage) image, "jpg", img);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * 图片缩放
	 * 
	 * @param filePath
	 *            图片路径
	 * @param expectedHeight
	 *            高度
	 * @param expectedWidth
	 *            宽度
	 * @param bb
	 *            比例不对时是否需要补白
	 */
	public static void resize(File srcFile, File destFile, int expectedWidth,int expectedHeight, boolean bb)
	{
		try
		{
			double ratio = 1.0; // 缩放比例
			BufferedImage bi = ImageIO.read(srcFile);
			ratio = getRatio(bi.getWidth(),bi.getHeight(),expectedWidth,expectedHeight);
			if(ratio > 1.0){
				ratio = 1.0;
			}
			Image srcImage = bi.getScaledInstance(expectedWidth, expectedHeight,
					Image.SCALE_SMOOTH);
			// 计算比例
			
			AffineTransformOp op = new AffineTransformOp(
					AffineTransform.getScaleInstance(ratio, ratio), null);
			srcImage = op.filter(bi, null);
			if (bb)
			{
				BufferedImage image = new BufferedImage(expectedWidth, expectedHeight,
						BufferedImage.TYPE_INT_RGB);
				Graphics2D g = image.createGraphics();
				g.setColor(Color.white);
				g.fillRect(0, 0, expectedWidth, expectedHeight);
				if (expectedWidth == srcImage.getWidth(null))
					g.drawImage(srcImage, 0, (expectedHeight - srcImage.getHeight(null)) / 2,
							srcImage.getWidth(null), srcImage.getHeight(null),
							Color.white, null);
				else
					g.drawImage(srcImage, (expectedWidth - srcImage.getWidth(null)) / 2, 0,
							srcImage.getWidth(null), srcImage.getHeight(null),
							Color.white, null);
				g.dispose();
				srcImage = image;
			}
			ImageIO.write((BufferedImage) srcImage, "jpg", new FileOutputStream(destFile));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static int getLength(String text)
	{
		return text.getBytes().length / 2 + 1;
	}
	
	/**
	 * 目标长宽/实际长宽
	 * @param actualWidth
	 * @param actualHeight
	 * @param expectedWidth
	 * @param expectedHeight
	 * @return
	 */
	private static double getRatio(int actualWidth,int actualHeight,int expectedWidth ,int expectedHeight){
		double ratio = 1.0;
		//当实际图像的宽度小于高度时，交换目标图像的宽度和高度
		if(actualWidth < actualHeight){
			int temp = expectedWidth;
			expectedWidth = expectedHeight;
			expectedHeight = temp;
		}
		double ratioHeight = (expectedHeight + 0.0)/actualHeight;
		double ratioWidth = (expectedWidth + 0.0)/actualWidth;
		ratio = ratioHeight < ratioWidth?ratioHeight : ratioWidth;
		return ratio;
	}

	/**
	 * 加文字水印(把文字加到图片上)
	 * 
	 * @param text
	 *            水印文字
	 * @param picture
	 *            加水印的图片
	 */
	public static void waterMarkText(String text, File picture,int expectedWidth,int expectedHeight)
	{
		double ratio = 1.0;
		try {
			BufferedImage bi = ImageIO.read(picture);
			ratio = getRatio(bi.getWidth(), bi.getHeight(), expectedWidth, expectedHeight);
		} catch (IOException e) {
			e.printStackTrace();
		}
		pressText(text, picture, "黑体", 50, Color.white, new Double(100 / ratio).intValue() + 1, 0, 0, 0.8f);
	}

	/**
	 * 加图片水印
	 * 
	 * @param waterMarkImg
	 *            作为水印的图片
	 * @param targetImg
	 *            加水印的图片
	 */
	public static void imageWaterMark(String waterMarkImg, File targetImg)
	{
		pressImage(waterMarkImg, targetImg, 0, 0, 0.8f);
	}
}

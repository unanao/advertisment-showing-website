/*
 * Copyright 2012 "58bancai team" All rights reserved.
 * 
 * 图形验证码的生成
 * 每次生成一个随机字符串，servlet 负责将该随机字符串写入图片中，并将该字符串保存到用户的session中。
 * 当用户提交请求时，Action 从session中取出图形验证码字符串，并于用户输入的图形验证码字符串进行比较
 * 
 * 用户登录的 Action 方法中，session.put("authSession", austr)表示一旦取出了authSession属性。立即清空
 * 强制验证码失效，从而保证安全性。
 */
package com.bancai.web.accounts;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.CommonConstants;
import com.bancai.utils.CharStringUtils;

/**
 * 负责生成图像验证码的servlet代码 随机生成 AUTH_IMG_CHAR_NO 个字符，并且根据字符临时生成图片
 * 
 * @author unanao <jianjiaosun@163.com>
 * 
 */
public class AuthImgAction extends ActionSupport implements AccountsContants, CommonConstants {
	private static final long serialVersionUID = 1L;

	private static final int MAX_COLOR = 255; // 颜色分量最大值
	
	private static final int AUTH_CHAR_BASE_COLOR = 20; // 随机字符的基色
	private static final int AUTH_CHAR_RANGE = 110; // 随即字符random的范围

	private static final int AUTH_IMG_LINE_COLOR = 102; // 线条的颜色
	private static final int AUTH_IMG_LINE_NO = 12; // 画干扰线条的个数

	private static final int AUTH_IMG_CHAR_NO = 4; // 验证图片上字符的个数
	private static final int AUTH_IMG_BOTTOM_COLOR = 200; // 设置验证码图片的底色

	private static final int AUTH_IMG_CHAR_DISTANCE_X = 20; // 画随机字符时的x轴的字符间隔
	// 验证图片的宽度 和高度
	private static final int AUTH_IMG_WIDTH = AUTH_IMG_CHAR_DISTANCE_X
			* (AUTH_IMG_CHAR_NO + 2);
	private static final int AUTH_IMG_HIGHT = 32;
	private static final int AUTH_IMG_CHAR_Y = AUTH_IMG_HIGHT / 3 * 2; // 随机字符y轴的位置

	private static final int AUTH_CHAR_SIZE = 22;			//验证码字体大小

	/**
	 * 设置图形验证码中字符串的字体和大小
	 */
	private Font authFont = new Font("Arial Black", Font.PLAIN, AUTH_CHAR_SIZE);

	/**
	 * @param baseColor
	 *            生成颜色的基础取值，为了保证小于255，所以使用(255 - baseRand) 作为rand的范围
	 *            如果不关注randRange, 可传入 MAX_COLOR
	 * @return Color 类型的随即颜色
	 */
	Color getRandColor(int baseColor, int randRange) {
		Random random = new Random();

		if (baseColor > MAX_COLOR) {
			baseColor = MAX_COLOR;
		}

		if ((baseColor + randRange) > MAX_COLOR) {
			randRange = MAX_COLOR - baseColor; // 防止下面相加后大于255
		}

		int red = baseColor + random.nextInt(randRange);
		int green = baseColor + random.nextInt(randRange);
		int blue = baseColor + random.nextInt(randRange);

		return new Color(red, green, blue);
	}

	/**
	 * 在传入的图片上画指定书目的随机线条
	 * 
	 * @param authGraphic
	 *            需要画线条的图片
	 * @param lineNo
	 *            需要画线条的数目
	 */
	void drawRandomLine(Graphics authGraphic, int lineNo) {
		Random random = new Random();

		for (int inc = 0; inc < lineNo; inc++) {
			int x1 = random.nextInt(AUTH_IMG_WIDTH);
			int y1 = random.nextInt(AUTH_IMG_HIGHT);
			int x2 = random.nextInt(AUTH_IMG_WIDTH);
			int y2 = random.nextInt(AUTH_IMG_HIGHT);

			authGraphic.drawLine(x1, y1, x2, y2);
		}
	}

	/**
	 * 在传入的图片上画指定的随机线条
	 * 
	 * @param authGraphic
	 *            需要画线条的图片
	 * @param CharNo
	 *            需要画的字符数目
	 * @return 生成的字符串
	 */
	String drawRandomChar(Graphics authGraphic, int charNo) {
		int realCharNo = (charNo + 1);
		String ch;
		String authStr = "";
		CharStringUtils charString = new CharStringUtils();

		for (int inc = 1; inc < realCharNo; inc++) {
			ch = charString.getRandomChar();
			authStr += ch;

			authGraphic.setColor(getRandColor(AUTH_CHAR_BASE_COLOR,
					AUTH_CHAR_RANGE));
			authGraphic.drawString(ch, AUTH_IMG_CHAR_DISTANCE_X * inc,
					AUTH_IMG_CHAR_Y);
		}

		return authStr;
	}

	/**
	 * 生成验证码的方法
	 * 
	 * @throws IOException
	 */
	public String execute() throws IOException {

		HttpServletResponse response = ServletActionContext.getResponse();

		// 阻止生成的页面内容被缓存
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/png");

		// 生成一张新图片
		BufferedImage authImg = new BufferedImage(AUTH_IMG_WIDTH,
				AUTH_IMG_HIGHT, BufferedImage.TYPE_INT_RGB);

		// 在图中绘制底色
		Graphics authGraphic = authImg.getGraphics();
		authGraphic.setColor(getRandColor(AUTH_IMG_BOTTOM_COLOR, MAX_COLOR)); // 设置验证码图片的底色颜色为随便设置的值，对程序没有影响，只是让辨认字符更困难一些
		authGraphic.fillRect(0, 0, AUTH_IMG_WIDTH, AUTH_IMG_HIGHT); // 指定填充矩形的区域

		// 画随机线条
		authGraphic.setColor(new Color(AUTH_IMG_LINE_COLOR,
				AUTH_IMG_LINE_COLOR, AUTH_IMG_LINE_COLOR));
		authGraphic.setFont(authFont);
		drawRandomLine(authGraphic, AUTH_IMG_LINE_NO);

		// 生成随机字符
		String authStr = drawRandomChar(authGraphic, AUTH_IMG_CHAR_NO);
		ActionContext.getContext().getSession().put(SESSION_AUTH, authStr);

		authGraphic.dispose(); // 释放graphics上下文

		ImageIO.write(authImg, "PNG", response.getOutputStream()); // 输出图形验证码图片

		return SUCCESS;
	}
}

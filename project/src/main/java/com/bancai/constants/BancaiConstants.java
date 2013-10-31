package com.bancai.constants;

import java.io.IOException;
import java.util.Properties;
 
import org.apache.log4j.Logger;

import com.bancai.utils.ConfigurationUtil;

public final class BancaiConstants {
	public final static int ADVERTISE_ENTERPRISE_SIZE;//广告区企业的个数
	public final static int ADVERTISE_PRODUCT_SIZE;//广告区产品的个数
	public final static int DISPLAY_PRODUCT_SIZE;//首页一行显示的产品个数
	public final static String[] PRODUCT_TYPES;//首页显示的产品类型
	public final static int DISPLAY_ENTERPRISE_SIZE;//首页一行显示的企业个数
	public final static String[] ENTERPRISE_AREA;//首页显示的企业区域
	public final static String CITY_CASCADE_DEFAULT;//省市级联默认的显示
	public final static String PRODUCT_DEFAULT_PATH;//产品默认图片路径
	public final static String ENTERPRISE_DEFAULT_PATH;//企业默认图片路径
	public final static Integer DEFAULT_ID;//默认企业或者产品ID
	public final static String DEFAULT_NAME;//默认企业或者产品的名称
	static String tmp; //store string for array for log
	public final static int DEFAULT_PICTURE_MAX_NUMBER;//默认上传图片最大数
	public final static int DEFAULT_PRODUCT_HINTS;//默认产品点击数
	public final static int DEFAULT_PRODUCT_SCORE;//默认点评得分
	public final static int DEFAULT_PRODUCT_FAVOURITES;//默认收藏数
	public final static int COMPRESS_TARGET_WIDTH;//图片压缩后宽度
	public final static int COMPRESS_TARGET_HEIGHT;//图片压缩后长度
	public final static String WATERMARK_TEXT;//水印内容
	public static final String CATEGORY_CASCADE_DEFAULT;//产品级联默认的显示
	public static final int DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE;//排行版显示数目
	static {
		final Logger logger = Logger.getLogger("Bancai configuration");
		logger.info("++++++++++++Bancai configuration information++++++++++++");
		try {
			Properties properties = new ConfigurationUtil().getPropertyFileConfiguration("bancai.properties");
			ADVERTISE_ENTERPRISE_SIZE = Integer.valueOf(properties.getProperty("ADVERTISE_ENTERPRISE_SIZE"));
			logger.info("ADVERTISE_ENTERPRISE_SIZE:" + ADVERTISE_ENTERPRISE_SIZE);
			ADVERTISE_PRODUCT_SIZE = Integer.valueOf(properties.getProperty("ADVERTISE_PRODUCT_SIZE"));
			logger.info("ADVERTISE_PRODUCT_SIZE:" + ADVERTISE_PRODUCT_SIZE);
			DISPLAY_PRODUCT_SIZE = Integer.valueOf(properties.getProperty("DISPLAY_PRODUCT_SIZE"));
			logger.info("DISPLAY_PRODUCT_SIZE:" + DISPLAY_PRODUCT_SIZE);
			
			/* as log a array of name is useless */
			tmp = properties.getProperty("PRODUCT_TYPES");
			PRODUCT_TYPES = tmp.split(" ");
			logger.info("PRODUCT_TYPES:" + tmp);
			
			DISPLAY_ENTERPRISE_SIZE = Integer.valueOf(properties.getProperty("DISPLAY_ENTERPRISE_SIZE"));
			logger.info("DISPLAY_ENTERPRISE_SIZE: " + DISPLAY_ENTERPRISE_SIZE);
			
			tmp = properties.getProperty("ENTERPRISE_AREA");
			ENTERPRISE_AREA = tmp.split(" ");
			logger.info("ENTERPRISE_AREA: " + tmp);
			
			CITY_CASCADE_DEFAULT = properties.getProperty("CITY_CASCADE_DEFAULT");
			logger.info("CITY_CASCADE_DEFAULT: " + CITY_CASCADE_DEFAULT);
			PRODUCT_DEFAULT_PATH = properties.getProperty("PRODUCT_DEFAULT_PATH");
			logger.info("PRODUCT_DEFAULT_PATH: " + PRODUCT_DEFAULT_PATH);
			ENTERPRISE_DEFAULT_PATH = properties.getProperty("ENTERPRISE_DEFAULT_PATH");
			logger.info("ENTERPRISE_DEFAULT_PATH: " + ENTERPRISE_DEFAULT_PATH);
			DEFAULT_ID = Integer.valueOf(properties.getProperty("DEFAULT_ID"));
			logger.info("DEFAULT_ID: " + DEFAULT_ID);
			DEFAULT_NAME = properties.getProperty("DEFAULT_NAME");
			logger.info("DEFAULT_NAME: " + DEFAULT_NAME); 
			DEFAULT_PICTURE_MAX_NUMBER= Integer.valueOf(properties.getProperty("DEFAULT_PICTURE_MAX_NUMBER"));
			logger.info("DEFAULT_PICTURE_MAX_NUMBER: " + DEFAULT_PICTURE_MAX_NUMBER); 
			DEFAULT_PRODUCT_SCORE = Integer.valueOf(properties.getProperty("DEFAULT_PRODUCT_SCORE"));
			logger.info("DEFAULT_PRODUCT_SCORE: " + DEFAULT_PRODUCT_SCORE); 
			DEFAULT_PRODUCT_HINTS= Integer.valueOf(properties.getProperty("DEFAULT_PRODUCT_HINTS"));
			logger.info("DEFAULT_PRODUCT_HINTS: " + DEFAULT_PRODUCT_HINTS);
			DEFAULT_PRODUCT_FAVOURITES= Integer.valueOf(properties.getProperty("DEFAULT_PRODUCT_FAVOURITES"));
			logger.info("DEFAULT_PRODUCT_FAVOURITES: " + DEFAULT_PRODUCT_FAVOURITES);
			COMPRESS_TARGET_WIDTH= Integer.valueOf(properties.getProperty("COMPRESS_TARGET_WIDTH"));
			logger.info("COMPRESS_TARGET_WIDTH: " + COMPRESS_TARGET_WIDTH);
			COMPRESS_TARGET_HEIGHT= Integer.valueOf(properties.getProperty("COMPRESS_TARGET_HEIGHT"));
			logger.info("COMPRESS_TARGET_HEIGHT: " + COMPRESS_TARGET_HEIGHT);
			WATERMARK_TEXT = properties.getProperty("WATERMARK_TEXT");
			logger.info("WATERMARK_TEXT: " + WATERMARK_TEXT);
			CATEGORY_CASCADE_DEFAULT = properties.getProperty("CATEGORY_CASCADE_DEFAULT");
			logger.info("CATEGORY_CASCADE_DEFAULT: " + CATEGORY_CASCADE_DEFAULT);
			DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE = Integer.valueOf(
														properties.getProperty("DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE"));
			logger.info("DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE: " + DEFAULT_FAVOURITE_PRODUCT_RANK_SIZE);
		} catch (IOException e) {
			logger.fatal("Failed to init bancai configuration", e);
			throw new RuntimeException("Failed to init bancai configuration", e);
		}
		logger.info("----------Bancai configuration successfully----------");
	}
} 

package com.bancai.utils;

public class CharStringUtils {
	private static final int UPPER_CASE = 1; // 如果是1， 随机生成大写字母
	private static final int LOWER_CASE = 2; // 如果是2， 随机生成小写字母

	private static final double EN_CHAR_NO = (26 - 1); // 字母的个数，由于直接和a/A相加，所以-1
	private static final double DIGIT_NO = (10 - 1); // 数字的个数，由于直接和0相加，所以-1

	private static final double EN_UPPER_CH_START = 65; // 英文大写字母A的ASCII
	private static final double EN_LOWER_CH_START = 97; // 英文小写字母a的ASCII
	private static final double DIGIT_ASCII_START = 48; // 数字0的ASCII

	/**
	 * 根据获取的数字判断返回是大写，小写还是数字
	 * 
	 * @return 返回生成的随即字符(包括数字0~9)
	 */
	public String getRandomChar() {
		int rand = (int) Math.round(Math.random() * 2);
		char ch;

		switch (rand) {
		case UPPER_CASE:
			ch = (char) Math.round(Math.random() * EN_CHAR_NO
					+ EN_UPPER_CH_START);
			break;

		case LOWER_CASE:
			ch = (char) Math.round(Math.random() * EN_CHAR_NO
					+ EN_LOWER_CH_START);
			break;

		default:
			ch = (char) Math
					.round(Math.random() * DIGIT_NO + DIGIT_ASCII_START);
			break;
		}

		return String.valueOf(ch);
	}

	/**
	 * @param len
	 *            获取随即字符串的长度
	 * @return 制定长度的随机字符串
	 */
	public String getRandStrByLen(int len) {
		String str = "";

		for (int inc = 0; inc < len; inc++) {
			str += getRandomChar();
		}

		return str;
	}
}

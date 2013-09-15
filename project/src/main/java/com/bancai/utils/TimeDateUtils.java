package com.bancai.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeDateUtils {

	/**
	 * 判断time1 和 time2 是否在同一天
	 * 
	 * @param time1
	 *            时间1
	 * @param time2
	 *            时间2
	 * @return <code>true </code> 在同一天; <code> false </code> 不在同一天
	 */
	public boolean isInSameDay(long time1, long time2) {
		Date d1 = new Date(time1);
		Date d2 = new Date(time2);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		c1.setTime(d1);
		c2.setTime(d2);

		return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR))
				&& (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH))
				&& (c1.get(Calendar.DAY_OF_MONTH) == c2
						.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 将秒转化为date
	 * @param time 需要转化的时间
	 * @return 转化后的date
	 */
	public String convertTime2DateFormat(long time) {
		Date date = new Date(time);
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");

		return sfd.format(date);
	}
}

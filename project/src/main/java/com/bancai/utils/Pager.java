package com.bancai.utils;

/**
 *用法:
 *  在Action中，定义:   Pager p = new Pager();  <b>注意变量名必须为p</b><br/>
 *  <pre>
 *  在jsp页面中，包含_pager.jsp, url参数可以使用各种语法的变量, 如下:<br/>
 *     &lt;s:include value="/_pager.jsp"&gt;<br/>
 *         &lt;s:param name="url"&gt;a/applist?appIntId=&lt;s:property value="appIntId"/&gt;&other=${other}&lt;/s:param&gt;<br/>
 *     &lt;/s:include&gt;<br/>	 
 *  <b>注意：如果url中不包含任何参数，那么，url应以?结尾， 如：a/applist?</b><br/>
 *  </pre>
 *				 
 *@author lzc, hubaiyu
 */
public class Pager {
	public final static int DEFAULT_PAGESIZE = 24;
	public final static boolean DEFAULT_NEEDSTOTAL = true;
	public final static int DEFAULT_SHOWPAGE = 10;
	public final static int MAX_PAGE_SIZE = 1000;

	private long total;
	private int pageNow = 1;
	private int pageSize = DEFAULT_PAGESIZE;
	private boolean needsTotal = DEFAULT_NEEDSTOTAL;
	private int showPage = DEFAULT_SHOWPAGE;

	public Pager() {
	}
	
	public static Pager defaultPager() {
		return new Pager();
	}
	
	/**
	 * 0 based start position
	 * @return
	 */
	public int getStart() {
		return (pageNow - 1) * pageSize;
	}
	
	/**
	 * 1 based pageNow
	 * @return
	 */
	public int getPageNow() {
		return pageNow;
	}
	
	/**
	 * 1 based pageNow
	 * @param pageNow
	 */
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
		this.pageNow = pageNow;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if (pageSize > MAX_PAGE_SIZE) pageSize = MAX_PAGE_SIZE;
		this.pageSize = pageSize;
	}
	public boolean isNeedsTotal() {
		return needsTotal;
	}
	public void setNeedsTotal(boolean needsTotal) {
		this.needsTotal = needsTotal;
	}
	public int getShowPage() {
		return showPage;
	}
	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}

}

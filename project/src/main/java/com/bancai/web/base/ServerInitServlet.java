package com.bancai.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.bancai.constants.BancaiConstants;


/**
 * 自定义初始化服务器任务
 * @author hubaiyu
 *
 */
public class ServerInitServlet extends HttpServlet {
	final static Logger logger = Logger.getLogger(ServerInitServlet.class);
	private static final long serialVersionUID = 1622275024878800964L;

	@Override
	public void init() throws ServletException {
		System.out.println(BancaiConstants.DISPLAY_PRODUCT_SIZE);
		logger.info("Server initialized!");
		super.init();
	}
}

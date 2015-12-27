package com.hadoop.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.apache.log4j.Logger;

import com.hadoop.main.Hadoop2Mysql;
import com.mysql.action.Mysql;

/**
 * Servlet implementation class Hadoopservlet
 */
public class HadoopServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(HadoopServlet.class);
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		logger.info("开始初始化配置+++++++++++++++++");

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		Writer writer = null;
		String action = request.getParameter("action");
		try {
			writer = response.getWriter();
			String tablename = "scores";
			String[] familys = { "grade", "course" };
			logger.info("开始处理action的请求");
			if (action.equalsIgnoreCase("hadoop")) {
				Hadoop2Mysql.start();
				writer.write("{\"responseData\":\"正在进行数据分析\"}");
				
			}
			else if (action.equalsIgnoreCase("getdata")) {
				
				writer.write(Mysql.getData());

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		} finally {
			writer.close();
		}
	}

}

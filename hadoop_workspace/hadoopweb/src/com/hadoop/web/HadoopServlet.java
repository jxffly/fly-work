package com.hadoop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.hadoop.temperature.NewTempearture;

import com.hadoop.lettercount.LetterCount;

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
		TableOperator tableOperator = new TableOperator();
		try {
			writer = response.getWriter();
			String tablename = "scores";
			String[] familys = { "grade", "course" };
			logger.info("开始处理action的请求");
			if (action.equalsIgnoreCase("createtable")) {

				writer.write(tableOperator.creatTable(tablename, familys));
			} else if (action.equalsIgnoreCase("addrecord")) {
				// add record zkb
				tableOperator.addRecord(tablename, "zkb", "grade", "", "5");
				tableOperator.addRecord(tablename, "zkb", "course", "", "90");
				tableOperator.addRecord(tablename, "zkb", "course", "math",
						"97");
				tableOperator
						.addRecord(tablename, "zkb", "course", "art", "87");
				// add record baoniu
				tableOperator.addRecord(tablename, "baoniu", "grade", "", "4");

				writer.write(tableOperator.addRecord(tablename, "baoniu",
						"course", "math", "89"));
			} else if (action.equalsIgnoreCase("queryall")) {

				writer.write(tableOperator.getAllRecord(tablename));
			} else if (action.equalsIgnoreCase("query")) {

				writer.write(tableOperator.getOneRecord(tablename, "zkb"));
			} else if (action.equalsIgnoreCase("deleterecord")) {

				writer.write(tableOperator.delRecord(tablename, "baoniu"));

			} else if (action.equalsIgnoreCase("deletetable")) {

				writer.write(tableOperator.deleteTable(tablename));

				
			}
			else if (action.equalsIgnoreCase("dohadoop")) {
				String params[]=new String[2];
				params[0]="hdfs://10.51.101.57:9000/user/grid/temprature/data";
				params[1]="hdfs://10.51.101.57:9000/user/grid/temprature/output-counter";
				
				NewTempearture.main(params);
				writer.write("{\"responseData\":\"sucesss\"}");

			}
			else if (action.equalsIgnoreCase("hadoophbase")) {
				LetterCount.run();
				writer.write("{\"responseData\":\"sucesss\"}");

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);

		} finally {
			writer.close();
		}
	}

}

package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_s_005fproperty_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      if (_jspx_meth_s_005fproperty_005f1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\" xml:lang=\"zh-CN\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n");
      out.write("<title>北京尚学堂Java论坛</title>\r\n");
      out.write("<meta name=\"description\"\r\n");
      out.write("\tcontent=\"北京尚学堂论坛频道，为软件开发人员提供高质量的交流社区，交流内容主要包括：JavaSE，JavaWeb，JavaEE\" />\r\n");
      out.write("<meta name=\"keywords\" content=\"论坛，java，javase，javaee\" />\r\n");
      out.write("<link rel=\"shortcut icon\" href=\"res/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"res/forum.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div id=\"page\">\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<div id=\"user_nav\">\r\n");
      out.write("\t\t\t\t\t<a href=\"/login\" class=\"welcome\" title=\"登录\">您还未登录 !</a> <a\r\n");
      out.write("\t\t\t\t\t\thref=\"http://www.javaeye.com/all\" style=\"color: red\">我的应用</a> <a\r\n");
      out.write("\t\t\t\t\t\thref=\"admin/Login-input\">管理员登录</a> <a href=\"/signup\" class=\"nobg\">注册</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"clearfix\">\r\n");
      out.write("\t\t\t\t<div id=\"branding\"></div>\r\n");
      out.write("\t\t\t\t<div id=\"gg\"></div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"content\" class=\"clearfix\">\r\n");
      out.write("\t\t\t<div id=\"main\">\r\n");
      out.write("\t\t\t\t<table id=\"forum_main\" cellspacing=\"1\">\r\n");
      out.write("\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"2\" class=\"first_col\" style=\"width: 620px;\">论坛</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"first_col\" style=\"width: 60px;\">主题</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"first_col\" style=\"width: 60px;\">文章</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"first_col\" style=\"width: 180px;\">最新文章</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t<tbody>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Java\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Java编程和Java企业应用</a><br />Java编程、Java\r\n");
      out.write("\t\t\t\t\t\t\t\tWeb开发、Java企业应用、Java设计模式、Java开源框架、Java应用服务器 <br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">12986</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">113949</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">11 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://iaimstar.javaeye.com' target='_blank'>iaimstar</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176522\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/web\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Web前端技术：AJAX和RIA</a><br />JavaScript编程、AJAX开发、UI界面设计、CSS、RIA技术\r\n");
      out.write("\t\t\t\t\t\t\t\t<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">4497</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">35898</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://davidtwins.javaeye.com' target='_blank'>Davidtwins</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176449\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/mobile\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">移动编程和手机应用开发</a><br />智能手机和上网本，移动应用平台领域的开发和应用\r\n");
      out.write("\t\t\t\t\t\t\t\t<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">632</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">4815</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">3 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://yulingkong.javaeye.com' target='_blank'>yulingkong</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176231\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"sep1\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Ruby\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Ruby</a><br /> <br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2492</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">18739</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">1 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://msnvip.javaeye.com' target='_blank'>msnvip</a> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/post/1176468\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/cpp\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">C和C++编程</a><br />C语言编程和C++语言编程，以及D语言编程<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">417</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">4322</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2009-09-18<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://smiletuna.javaeye.com' target='_blank'>smiletuna</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1172828\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Python\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Python</a><br /> <br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">312</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">1998</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">10 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://kevin24067.javaeye.com' target='_blank'>kevin24067</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1175556\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/PHP\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">PHP</a><br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">151</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">500</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">34 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://xiaoyu.javaeye.com' target='_blank'>xiaoyu</a> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/post/1176506\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Flash\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Flash编程</a><br />基于Flash的前端技术，ActionScript编程，AIR，Flex\r\n");
      out.write("\t\t\t\t\t\t\t\t<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">516</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2648</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">24 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://wuxi15932077655.javaeye.com' target='_blank'>wuxi15932077655</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176515\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/dotnet\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">Microsoft .Net</a><br />微软软件开发技术讨论区: dotnet,\r\n");
      out.write("\t\t\t\t\t\t\t\tC#, VB.net, VC<br /> <br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">343</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2129</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2009-09-14<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://csanycall.javaeye.com' target='_blank'>csanycall</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1167020\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"sep1\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Tech\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">综合技术</a><br />数据库、操作系统管理，算法、、Erlang/FP<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">1817</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">12130</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">27 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://argan.javaeye.com' target='_blank'>argan</a> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/post/1176513\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"sep1\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/New\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">入门讨论</a><br />基础知识，入门问题，简单技术问题交流和讨论版面</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">16418</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">53744</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">2 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://wufenghotle1.javaeye.com' target='_blank'>wufenghotle1</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176298\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"sep1\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/forums/board/develop\" class=\"forumtitle\">软件开发和项目管理</a><br />软件开发过程、XP、TDD、软件配置管理、软件测试、项目管理、UML<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">1180</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">20824</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">4 小时前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://caoyanbao.javaeye.com' target='_blank'>caoyanbao</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176160\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a\r\n");
      out.write("\t\t\t\t\t\t\t\thref=\"/forums/board/Industry\" class=\"forumtitle\">行业应用</a><br />金融，电信，互联网，医卫，制造，教育，电子政务，交通等行业IT建设，解决方案讨论<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">293</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">1998</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">27 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://chenxi621.javaeye.com' target='_blank'>chenxi621</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176512\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr class=\"sep1\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"5\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"read_forum\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_description\"><a href=\"/forums/board/Job\"\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"forumtitle\">招聘求职</a><br />招聘信息，公司信息，职场话题，求职相关，面试秘籍等<br /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">3699</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">78984</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"forum_index\">7 分钟前<br /> <a\r\n");
      out.write("\t\t\t\t\t\t\t\thref='http://ag-sherry.javaeye.com' target='_blank'>ag_sherry</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/post/1176525\" class=\"last_post\" title=\"浏览最新的文章\">&nbsp;</a>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t</tbody>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t<div id=\"forum_action\" class=\"clearfix\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/forums/mark_read_all\">标记所有文章已读</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/rss/forum\" class=\"rss\">订阅全部论坛新贴</a></li>\r\n");
      out.write("\t\t\t\t\t\t<li><a href=\"/rss/topic\" class=\"rss\">订阅全部论坛热点</a></li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"online_status\">\r\n");
      out.write("\t\t\t\t\t<h3>当前在线状态</h3>\r\n");
      out.write("\t\t\t\t\t<img src=\"/images/whosonline.gif\" /> 目前共有 <strong>2936</strong>\r\n");
      out.write("\t\t\t\t\t人在线，其中注册会员 <strong>365</strong> 人 <a href=\"#\" id=\"show_list\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"$('show_list').hide();$('hide_list').show();$('online_users').update('读取中...'); new Ajax.Updater('online_users', '/users/online', {asynchronous:true, evalScripts:true, method:'get'}); return false;\">显示列表</a><a\r\n");
      out.write("\t\t\t\t\t\thref=\"#\" id=\"hide_list\"\r\n");
      out.write("\t\t\t\t\t\tonclick=\"$('online_users').update(' ');$('show_list').show();$('hide_list').hide();return false;\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"display: none;\">隐藏列表</a> <a href=\"/users/online\"\r\n");
      out.write("\t\t\t\t\t\tid=\"all_list\">查看详细状态</a>\r\n");
      out.write("\t\t\t\t\t<div id=\"online_users\">&nbsp;</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<script type=\"text/javascript\">\r\n");
      out.write("    var current_index = 0;\r\n");
      out.write("    var s_adverts = [\"\\u003Cembed play=\\\"true\\\" src=\\\"http://ftp.javaeye.com/public/ibm/ibm_x.swf\\\" pluginspage=\\\"http://www.macromedia.com/go/getflashplayer\\\" type=\\\"application/x-shockwave-flash\\\" height=\\\"180\\\" loop=\\\"true\\\" menu=\\\"true\\\" width=\\\"370\\\"\\u003E\\u003C/embed\\u003E\\r\\n\\r\\n\\r\\n\"];\r\n");
      out.write("\r\n");
      out.write("    Event.observe(window,'load',function() {\r\n");
      out.write("      show_slide(0);\r\n");
      out.write("      new PeriodicalExecuter(show_slide, 30);\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    function show_slide(s_index) {\r\n");
      out.write("      if(typeof(s_index) != 'number') s_index = current_index + 1;\r\n");
      out.write("      if(s_index >= s_adverts.length) s_index = 0;\r\n");
      out.write("      \r\n");
      out.write("      $(\"slides\").innerHTML = s_adverts[s_index];\r\n");
      out.write("      var s_pagination = s_adverts.inject(\"<span class='pagination'>\", function(memo, value, i) {\r\n");
      out.write("        return memo + (s_index == i ? \"<span class='current'>\" + (i + 1) + \"</span>\" : \"<a href='#' onclick='show_slide(\" + i + \");return false;'>\" + (i + 1) + \"</a>\");\r\n");
      out.write("      }) + \"</span>\";\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("      $(\"slides\").insert(s_pagination);\r\n");
      out.write("\r\n");
      out.write("      current_index = s_index;\r\n");
      out.write("    }\r\n");
      out.write("  </script>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div id=\"footer\">\r\n");
      out.write("\t\t\t<div id=\"site_nav\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t<li></li>\r\n");
      out.write("\t\t\t\t\t<li>关于我们</li>\r\n");
      out.write("\t\t\t\t\t<li>联系我们</li>\r\n");
      out.write("\t\t\t\t\t<li class=\"last\">友情链接</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"copyright\">&copy; 2003-2009 xxx.com. All rights\r\n");
      out.write("\t\t\t\treserved.</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("  document.write(\"<img src='http://stat.javaeye.com/?url=\"+ encodeURIComponent(document.location.href) + \"&referrer=\" + encodeURIComponent(document.referrer) + \"&logged_in=no\" + \"' width='0' height='0' />\");\r\n");
      out.write("</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_s_005fproperty_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f0 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f0.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f0.setParent(null);
    // /index.jsp(7,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f0.setValue("categories");
    int _jspx_eval_s_005fproperty_005f0 = _jspx_th_s_005fproperty_005f0.doStartTag();
    if (_jspx_th_s_005fproperty_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f0);
    return false;
  }

  private boolean _jspx_meth_s_005fproperty_005f1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  s:property
    org.apache.struts2.views.jsp.PropertyTag _jspx_th_s_005fproperty_005f1 = (org.apache.struts2.views.jsp.PropertyTag) _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.get(org.apache.struts2.views.jsp.PropertyTag.class);
    _jspx_th_s_005fproperty_005f1.setPageContext(_jspx_page_context);
    _jspx_th_s_005fproperty_005f1.setParent(null);
    // /index.jsp(8,0) name = value type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_s_005fproperty_005f1.setValue("'hello'");
    int _jspx_eval_s_005fproperty_005f1 = _jspx_th_s_005fproperty_005f1.doStartTag();
    if (_jspx_th_s_005fproperty_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fs_005fproperty_0026_005fvalue_005fnobody.reuse(_jspx_th_s_005fproperty_005f1);
    return false;
  }
}

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.51
 * Generated at: 2020-07-08 03:31:56 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/../footer.jsp", Long.valueOf(1585103981004L));
    _jspx_dependants.put("/WEB-INF/lib/standard.jar", Long.valueOf(1583283797094L));
    _jspx_dependants.put("jar:file:/C:/Users/USER/eclipse-workspace/WebExam40/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/WebPortpolio/WEB-INF/lib/standard.jar!/META-INF/c.tld", Long.valueOf(1098678690000L));
    _jspx_dependants.put("/../header.jsp", Long.valueOf(1594124658440L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"UTF-8\">\r\n");
      out.write("\t<title>안은별의 포트폴리오</title>\r\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css\">\r\n");
      out.write("\t<link href=\"css/common.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"css/mystyle.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/earlyaccess/nicomoji.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=M+PLUS+Rounded+1c\" rel=\"stylesheet\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("    \t\r\n");
      out.write("      $('.slider').bxSlider({\r\n");
      out.write("    \t  mode: 'fade',\r\n");
      out.write("    \t  captions: true\r\n");
      out.write("      });\r\n");
      out.write("      \r\n");
      out.write("      $(\".sitemap\").click(function() {\r\n");
      out.write("\t\t\t$(\".sitewrap\").slideDown();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t  $(\"#close\").click(function() {\r\n");
      out.write("\t\t\t$(\".sitewrap\").slideUp();\r\n");
      out.write("\t\t})\r\n");
      out.write("\t\t\r\n");
      out.write("\t  $(\".nav > nav > .navi > li\").hover(function() {\r\n");
      out.write("\t\t  $(this).children(\".navi2\").stop().slideDown();\r\n");
      out.write("\t  }, function() {\r\n");
      out.write("\t\t  $(this).children(\".navi2\").stop().slideUp();\r\n");
      out.write("\t  });\r\n");
      out.write("\t\t\r\n");
      out.write("    });\r\n");
      out.write("  </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"header\">\r\n");
      out.write("\t\t<header>\r\n");
      out.write("\t\t\t<div class=\"topnav\">\r\n");
      out.write("\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t");

						if(session.getValue("user") == null){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"login.do\">ログイン</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"insert.do\">会員加入</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:void(0)\" class=\"sitemap\">サイト</a></li>\r\n");
      out.write("\t\t\t\t\t");

						}else{
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<li><a href=\"logout.do\">ログアウト</a></li>\r\n");
      out.write("\t\t\t\t\t<li><a href=\"javascript:void(0)\" class=\"sitemap\">サイト</a></li>\r\n");
      out.write("\t\t\t\t\t");

						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"navigation\">\r\n");
      out.write("\t\t\t\t<h1 class=\"logo\"><a href=\"index.do\" style=\"text-decoration: none;\">ホシナのサイト</a></h1>\r\n");
      out.write("\t\t\t\t<div class=\"nav\">\r\n");
      out.write("\t\t\t\t\t<nav>\r\n");
      out.write("\t\t\t\t\t\t<ul class=\"navi\">\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"syoukai.do\"> ご紹介</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"navi2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"rirekisyo.do\">履歴書</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"jicosyoukai.do\">自己紹介書</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"portfolio.do\">ポートフォリオ</a>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"board.do\">フリーボード</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"navi2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"qa.do\">Q&A</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"guest.do\">芳名録</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"diary.do\">日記</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<ul class=\"navi2\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"s_diary.do\">就職日記</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<li><a href=\"k_diary.do\">開発日記</a></li>\r\n");
      out.write("\t\t\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"contact.do\">CONTACT</a></li>\r\n");
      out.write("\t\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t\t</nav>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</header>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"line\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"sitewrap\">\r\n");
      out.write("\t\t<span class=\"fa fa-close\" id=\"close\" style=\"cursor:pointer\"></span>\r\n");
      out.write("\t\t<div class=\"inner\">\r\n");
      out.write("\t\t\t<span class=\"map\">내소개</span>\r\n");
      out.write("\t\t\t<span class=\"map\">포트폴리오</span>\r\n");
      out.write("\t\t\t<span class=\"map\">자유게시판</span>\r\n");
      out.write("\t\t\t<span class=\"map\">내일기</span>\r\n");
      out.write("\t\t\t<span class=\"map\">CONTACT</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"contain\" style=\"padding: 150px 0\">\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"write-form\" style=\"width:50%; margin:0 auto; border:1px solid #ccc; padding:20px;\">\r\n");
      out.write("\t\t<form name = \"frm\" method = \"post\" action = \"login.do\">\r\n");
      out.write("\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t<legend class=\"readonly\">로그인그룹</legend>\r\n");
      out.write("\t\t\t\t<div style=\"width:70%; float:left;\">\r\n");
      out.write("\t\t\t\t\t<label for=\"id\" class=\"readonly\">아이디</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"userid\" id=\"id\" placeholder=\"아이디\">\r\n");
      out.write("\t\t\t\t\t<label for=\"pw\" class=\"readonly\">패스워드</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"pwd\" id=\"pw\" placeholder=\"패스워드\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div style=\"width:28%; float:right;padding:15px;\r\n");
      out.write("\t\t\t\theight:132px; margin-top:3px;\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" value=\"로그인\" alt=\"로그인\"  onClick = \" return formcheck()\"\r\n");
      out.write("\t\t\t\t\tstyle=\"background: #FF4000; color:#fff;\r\n");
      out.write("\t\t\t\t\twidth:100%; height:100%; border:0 none; cursor:pointer;\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<p style=\"clear:both;padding-top:20px; text-align:center;\">아이디찾기 | 패스워드찾기 | 회원가입</p>\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\t\t</form>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction formcheck() {\r\n");
      out.write("\t\tif(frm.userid.value == \"\") {\r\n");
      out.write("\t\t\talert(\"아이디를 입력하세요\");\r\n");
      out.write("\t\t\tfrm.userid.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(frm.pwd.value == \"\") {\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t\tfrm.pwd.focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfrm.submit();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<div class=\"footer\">\r\n");
      out.write("\t\t<footer>\r\n");
      out.write("\t\t\t<p>&copy; EUNBYUL. All &nbsp;&nbsp;Rights Reserved.</p>\r\n");
      out.write("\t\t</footer>\r\n");
      out.write("\t\t<!-- &copy; &nbsp; &gt; > &lt;< -->\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

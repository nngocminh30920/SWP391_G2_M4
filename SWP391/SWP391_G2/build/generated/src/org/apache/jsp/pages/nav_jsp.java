package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class nav_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en-US\" data-menu=\"leftalign\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\" />\n");
      out.write("        <meta name=\"pagesport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />\n");
      out.write("        <title>Car Rental System</title>\n");
      out.write("        <link rel=\"icon\" type=\"image/jpg\" href=\"https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Font_Awesome_5_regular_smile-wink.svg/768px-Font_Awesome_5_regular_smile-wink.svg.png\">\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/style.css' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/leftalignmenu.css' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/kirki.css' type='text/css' media='all' />\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ec811f6ffe.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header_style_wrapper\" id=\"menu\">\n");
      out.write("            <div class=\"above_top_bar\" id=\"top_bar\">\n");
      out.write("                <div class=\"page_content_wrapper\">\n");
      out.write("                    <div class=\"social_wrapper\" style=\"height: 45.29px;\" >\n");
      out.write("                        <ul style=\"margin: 0;\">\n");
      out.write("                            <li><a target=\"_blank\" href=\"https://www.facebook.com/\"><i class=\"fab fa-facebook\"></i></a></li>\n");
      out.write("                            <li><a target=\"_blank\" href=\"http://twitter.com/\"><i class=\"fab fa-twitter\"></i></a></li>\n");
      out.write("                            <li><a target=\"_blank\" href=\"http://instagram.com/\"><i class=\"fab fa-instagram\"></i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"top_contact_info\">\n");
      out.write("                        <div><span><i class=\"fas fa-map-marker-alt\"></i></span>FPT University</div>\n");
      out.write("                        <div><a href=\"tel:012.345.6789\"><span ><i class=\"fas fa-mobile-alt\"></i></span>012.345.6789</a></div>\n");
      out.write("                        <div><span><i class=\"far fa-clock\"></i></span>Mon-Fri 09.00 - 17.00</div>\n");
      out.write("                    </div>\n");
      out.write("                    <br class=\"clear\"/>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"top_bar hasbg\" id=\"menu_bar\">\n");
      out.write("                <div class=\"standard_wrapper\">\n");
      out.write("                    <div>\n");
      out.write("                        <a href=\"../../Demo/pages/home.jsp\">\n");
      out.write("                            <img class = \"logo\" src=\"../../Demo/assets/image/logo.png\" alt=\"Logo\">\n");
      out.write("                        </a>\n");
      out.write("                        <div id=\"menu_wrapper\">\n");
      out.write("                            <div class=\"menu-main-menu-container\" >\n");
      out.write("                                <ul class=\"nav\" >\n");
      out.write("                                    <li><a href=\"../../Demo/pages/home.jsp\" style=\"padding-top: 15px;\">Home</a></li>\n");
      out.write("                                    <li><a href=\"../../Demo/search?brand=&type=&sort_by=asc\" style=\"padding-top: 15px;\">Cars&ensp;</a></li>\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                </ul>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> \n");
      out.write("        <script>\n");
      out.write("            var menu = document.getElementById('menu');\n");
      out.write("            var topbar = document.getElementById('top_bar');\n");
      out.write("            var menubar = document.getElementById('menu_bar');\n");
      out.write("            var origOffsetY = menu.offsetHeight;\n");
      out.write("\n");
      out.write("            function onScroll(e) {\n");
      out.write("                if (window.scrollY >= origOffsetY) {\n");
      out.write("                    topbar.style.display = \"none\";\n");
      out.write("                    menubar.style.backgroundColor = \"#000\";\n");
      out.write("                } else {\n");
      out.write("                    topbar.style.display = \"block\";\n");
      out.write("                    menubar.style.backgroundColor = \"rgba(0, 0, 0, 0)\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("            document.addEventListener('scroll', onScroll);\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <li><a href=\"../../Demo/pages/login.jsp\" style=\"padding-top: 15px;\">Log in</a></li>\n");
        out.write("                                        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <li><a href=\"../../Demo/author?action=addCar\" style=\"padding-top: 15px;\">Register car</a></li>\n");
        out.write("                                        <li><a href=\"../../Demo/author?action=manageCar\" style=\"padding-top: 15px;\">Manage car</a></li>\n");
        out.write("                                            ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\n");
        out.write("                                        <li><a href=\"#\"style=\"padding-top: 15px;\">Trips&ensp;<i class=\"fas fa-angle-down\"></i></a>\n");
        out.write("                                            <ul>\n");
        out.write("                                                <li><a href=\"../../Demo/pages/booked.jsp\" >Booked</a></li>\n");
        out.write("                                                <li><a href=\"../../Demo/pages/history.jsp\" >History</a></li>\n");
        out.write("                                            </ul>\n");
        out.write("                                        </li>\n");
        out.write("                                        <li><a href=\"#\" style=\"padding-top: 15px;\"><i class=\"far fa-user-circle fa-2x\"></i></i></a>\n");
        out.write("                                            <ul>\n");
        out.write("                                                <li><a href=\"../../Demo/pages/profile.jsp\" > Profile</a></li>\n");
        out.write("                                                <li><a href=\"../../Demo/logout\" >Log out</a></li>\n");
        out.write("                                            </ul> \n");
        out.write("                                        </li>\n");
        out.write("                                    ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.type == 3}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                            <li><a href=\"../../Demo/profileForAdmin?action=view\" style=\"padding-top: 15px;\">Manage profile</a></li>\n");
        out.write("                                            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }
}

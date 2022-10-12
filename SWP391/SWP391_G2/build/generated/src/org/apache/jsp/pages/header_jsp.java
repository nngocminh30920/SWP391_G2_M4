package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import dal.CarDAO;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
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
      out.write("\n");
      out.write("\n");
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
      out.write("                <link rel='stylesheet' href='../../Demo/assets/css/leftalignmenu.css' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/kirki.css' type='text/css' media='all' />\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ec811f6ffe.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        ");
CarDAO db = new CarDAO();
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <video autoplay=\"autoplay\" muted=\"muted\" loop=\"loop\" width=\"100%\">\n");
      out.write("            <source src=\"../../Demo/assets/video/header.mp4\" type=\"video/mp4\" >\n");
      out.write("            Your browser does not support the video tag. I suggest you upgrade your browser.\n");
      out.write("        </video> \n");
      out.write("        <div id=\"page_content_wrapper\">\n");
      out.write("            <form class=\"car_search_form\" action=\"../../Demo/search\">\n");
      out.write("                <div class=\"one_fourth \">\n");
      out.write("                    <select name=\"brand\">\n");
      out.write("                        <option value=\"\">Any Brand</option>\n");
      out.write("                        \n");
      out.write("                    </select>\n");
      out.write("                    <i class=\"fas fa-chevron-down\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one_fourth \">\n");
      out.write("                    <select name=\"type\">\n");
      out.write("                        <option value=\"\">Any Type</option>\n");
      out.write("                       \n");
      out.write("                    </select>\n");
      out.write("                    <i class=\"fas fa-chevron-down\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one_fourth\">\n");
      out.write("                    <select name=\"sort_by\">\n");
      out.write("                        <option value=\"asc\">Price Low to High</option>\n");
      out.write("                        <option value=\"desc\">Price High to Low</option>\n");
      out.write("                    </select>\n");
      out.write("                    <i class=\"fas fa-chevron-down\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one_fourth last \">\n");
      out.write("                    <input type=\"submit\" value=\"Search\" />\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>   \n");
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
}

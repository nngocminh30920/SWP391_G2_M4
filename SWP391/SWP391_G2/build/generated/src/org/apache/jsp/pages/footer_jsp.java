package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div id=\"footer\" class=\" ppb_wrapper\">\n");
      out.write("            <ul class=\"sidebar_widget three\">\n");
      out.write("                <li>\n");
      out.write("                    <h2 class=\"widgettitle\">About Us</h2>\n");
      out.write("                    <p>Getting dressed up and traveling with good friends makes for a shared, unforgettable experience. </p>\n");
      out.write("                    <img src=\"../../Demo/assets/image/logo.png\" alt=\"\" width=\"175\" height=\"24\">\n");
      out.write("                </li>\n");
      out.write("                <li style=\"margin-left: 150px;\">\n");
      out.write("                    <h2 class=\"widgettitle\">Contact Info</h2>\n");
      out.write("                    <div><i class=\"fas fa-map-marker-alt\"></i>&ensp;FPT University</div>\n");
      out.write("                    <div><a href=\"tel:012.345.6789\"><i class=\"fas fa-mobile-alt\"></i>&ensp;012.345.6789</a></div>\n");
      out.write("                    <div><i class=\"far fa-clock\"></i>&ensp;Mon-Fri 09.00 - 17.00</div>\n");
      out.write("                </li>\n");
      out.write("                <li style=\"width: 30px;\">\n");
      out.write("                    <div class=\"social_wrapper shortcode\">\n");
      out.write("                        <ul>\n");
      out.write("                            <li class=\"facebook\"><a target=\"_blank\" title=\"Facebook\" href=\"https://www.facebook.com/\"><i class=\"fa fa-facebook\"></i></a></li><br>\n");
      out.write("                            <li class=\"twitter\"><a target=\"_blank\" title=\"Twitter\" href=\"https://twitter.com/\"><i class=\"fa fa-twitter\"></i></a></li><br>\n");
      out.write("                            <li class=\"instagram\"><a target=\"_blank\" title=\"Instagram\" href=\"https://instagram.com/\"><i class=\"fa fa-instagram\"></i></a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"footer_bar\">\n");
      out.write("            <div class=\"footer_bar_wrapper \">\n");
      out.write("                <div class=\"menu-footer-menu-container\">\n");
      out.write("                    <ul id=\"footer_menu\" class=\"\">\n");
      out.write("                        <li><a href=\"../../Demo/pages/aboutUs.jsp\">About Us</a></li>\n");
      out.write("                        <li><a href=\"../../Demo/pages/faqs.jsp\">FAQs</a></li>\n");
      out.write("                        <li><a href=\"../../Demo/pages/contactUs.jsp\">Contact Us</a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div id=\"copyright\">© Copyright ngochien - Project</div>\n");
      out.write("                <br class=\"clear\" />\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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

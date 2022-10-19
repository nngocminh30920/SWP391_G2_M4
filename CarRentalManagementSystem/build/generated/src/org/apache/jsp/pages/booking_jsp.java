package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Account;
import dal.OrderDAO;
import model.Car;

public final class booking_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/pages/footer.jsp");
  }

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
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/leftalignmenu.css' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/kirki.css' type='text/css' media='all' />\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">        \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("      \n");
      out.write("                        <div class=\"sidebar_wrapper\">\n");
      out.write("                            <div class=\"single_car_booking_wrapper\">\n");
      out.write("                                <div class=\"single_car_header_content\">\n");
      out.write("                                    <div class=\"standard_wrapper\">\n");
      out.write("                                        <div class=\"single_car_header_price\">\n");
      out.write("                                            <span class=\"single_car_currency\">$</span><span class=\"single_car_price\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.car.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                                            <span class=\"single_car_price_per_unit\">\n");
      out.write("                                                <span id=\"single_car_unit\">Per Day</span>\n");
      out.write("                                            </span>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <form name=\"f\" method=\"post\" class=\"wpcf7-form\" >\n");
      out.write("                                    <p> \n");
      out.write("                                        <label> Full Name <br/>\n");
      out.write("                                            <input type=\"text\" id=\"rFullname\" name=\"rFullname\"\n");
      out.write("                                                   placeholder=\"Charles Calhoun\"\n");
      out.write("                                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.fullname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \n");
      out.write("                                                   size=\"40\" class=\"wpcf7-text\" required/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Email Address <br/>\n");
      out.write("                                            <input type=\"email\" required class=\"wpcf7-text\"\n");
      out.write("                                                   name=\"rEmail\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \n");
      out.write("                                                   size=\"40\" placeholder=\"sample@yourcompany.com\" \n");
      out.write("                                                   id=\"rEmail\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Address <br />\n");
      out.write("                                            <input type=\"text\" required class=\"wpcf7-text\" size=\"40\" \n");
      out.write("                                                   name=\"rAddress\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.address}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \n");
      out.write("                                                   placeholder=\"34 Mainfield Road\" id=\"rAddress\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> City\n");
      out.write("                                            <br />\n");
      out.write("                                            <input type=\"text\" required class=\"wpcf7-text\"\n");
      out.write("                                                   name=\"rCity\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.city}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" \n");
      out.write("                                                   size=\"40\" placeholder=\"Washington\" id=\"rCity\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Phone Number <br />\n");
      out.write("                                            <input type=\"number\" name=\"rPhone\" required\n");
      out.write("                                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user.phone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" size=\"40\" \n");
      out.write("                                                   class=\"wpcf7-text\" placeholder=\"0123456789\" \n");
      out.write("                                                   style=\"border-color: #dce0e0;\" id=\"rPhone\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Pick Up Address<br />\n");
      out.write("                                            <input type=\"text\" required class=\"wpcf7-text\"\n");
      out.write("                                                   name=\"pickupAddress\" size=\"40\"\n");
      out.write("                                                   placeholder=\"Heatrow Airport\" \n");
      out.write("                                                   id=\"pickupAddress\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Pickup Date<br />\n");
      out.write("                                            <input type=\"date\" id=\"fromDate\" required\n");
      out.write("                                                   name=\"pickupDate\" value=\"mm/dd/yyyy\"\n");
      out.write("                                                   class=\"wpcf7-date\" onchange=\"getTotal(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.car.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Drop Off Address<br />\n");
      out.write("                                            <input type=\"text\" required size=\"40\"\n");
      out.write("                                                   name=\"dropoffAddress\" class=\" wpcf7-text\"\n");
      out.write("                                                   placeholder=\"Heatrow Airport\"\n");
      out.write("                                                   id=\"dropoffAddress\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Drop Off Date<br />\n");
      out.write("                                            <input type=\"date\" id =\"toDate\"\n");
      out.write("                                                   name=\"dropoffDate\" required\n");
      out.write("                                                   class=\" wpcf7-date\" onchange=\"getTotal(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.car.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")\"/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    <p>\n");
      out.write("                                        <label> Total<br />\n");
      out.write("                                            <input id =\"total\" name=\"total\" type=\"text\" readonly/>\n");
      out.write("                                        </label>\n");
      out.write("                                    </p>\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                    <script>\n");
      out.write("                                        function validForm(action, id) {\n");
      out.write("                                            var fromDate = new Date(document.getElementById(\"fromDate\").value);\n");
      out.write("                                            var toDate = new Date(document.getElementById(\"toDate\").value);\n");
      out.write("                                            var currentDate = new Date();\n");
      out.write("                                            if (fromDate === currentDate) {\n");
      out.write("                                                window.alert('The pick up date must be greater than the current date');\n");
      out.write("                                            } else if (fromDate > toDate) {\n");
      out.write("                                                window.alert('The pick up date must be greater than the drop off date');\n");
      out.write("                                            } else {\n");
      out.write("                                                document.f.action = \"../../Demo/author?action=\" + action + \"&carid=\" + id;\n");
      out.write("                                                document.f.submit();\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("                                        function getTotal(price) {\n");
      out.write("                                            var fromDate = new Date(document.getElementById(\"fromDate\").value) !== '' ? new Date(document.getElementById(\"fromDate\").value) : null;\n");
      out.write("                                            var toDate = document.getElementById(\"toDate\").value !== '' ? new Date(document.getElementById(\"toDate\").value) : null;\n");
      out.write("                                            if (toDate && fromDate) {\n");
      out.write("                                                document.getElementById(\"total\").value = (toDate - fromDate) / 86400000 * price;\n");
      out.write("                                            }\n");
      out.write("                                        }\n");
      out.write("                                    </script>\n");
      out.write("                                </form>\n");
      out.write("                                <br class=\"clear\" />\n");
      out.write("                            </div> \n");
      out.write("                            <br class=\"clear\" />\n");
      out.write("                        </div>              \n");
      out.write("            ");
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
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user != null && (sessionScope.user.type == 1 || sessionScope.user.type == 3)}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <input type=\"submit\" onclick=\"validForm('requestOrder',");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.car.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(")\" value=\"Request for Booking\"/>\n");
        out.write("                                    ");
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
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.user == null || (sessionScope.user != null && sessionScope.user.type == 2)}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                        <button class=\"button\" style=\"width: 226.19px; height: 45.45px;\">\n");
        out.write("                                            <a href=\"../../Demo/pages/login.jsp\" style=\"color: #fff;\">Sign in to renter account</a>\n");
        out.write("                                        </button>\n");
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
}

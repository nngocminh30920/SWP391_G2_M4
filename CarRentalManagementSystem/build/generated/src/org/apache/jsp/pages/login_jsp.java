package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Account;
import model.Car;
import java.util.List;
import dal.CarDAO;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/pages/nav.jsp");
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
      out.write("                <link rel='stylesheet' href='../../Demo/assets/css/leftalignmenu.css' type='text/css' media='all' />\n");
      out.write("        <link rel='stylesheet' href='../../Demo/assets/css/kirki.css' type='text/css' media='all' />\n");
      out.write("        <script src=\"https://kit.fontawesome.com/ec811f6ffe.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\n");
      out.write("              integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\" class=\"hasbg transparent\">\n");
      out.write("            <br><br><br><br><br><br>\n");
      out.write("            ");
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
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <h2  style=\"color: red; text-align: center; margin-bottom: 30px; width: 100%\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.error}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</h2>\n");
      out.write("                    <br>\n");
      out.write("                    <div class=\"col-md-5 padd-l0\" >\n");
      out.write("                        <div class=\"wheel-register-log marg-lg-b50\">\n");
      out.write("                            <div class=\"wheel-header\">\n");
      out.write("                                <br>\n");
      out.write("                                <h5 style=\"text-align: left;\">have an account? Log In</h5>\n");
      out.write("                                <br>\n");
      out.write("                            </div>\n");
      out.write("                            ");

                                Cookie[] cookie = request.getCookies();
                                Account account = (Account) session.getAttribute("user");
                                String user = "";
                                String pass = "";
                                String remember = "";
                                if (cookie != null) {
                                    for (Cookie c : cookie) {
                                        if (c.getName().equals("c_user")) {
                                            user = c.getValue();
                                        }
                                        if (c.getName().equals("c_pass")) {
                                            pass = c.getValue();
                                        }
                                        if (c.getName().equals("c_remember")) {
                                            remember = c.getValue();
                                        }
                                    }
                                }
                            
      out.write("\n");
      out.write("                            <form action=\"../../Demo/login\" method=\"post\">\n");
      out.write("                                <label for=\"user\" class=\"fa fa-user\"><input type=\"text\" name=\"username\" placeholder='Username' value=\"");
      out.print( user);
      out.write("\" required=\"true\"/></label>\n");
      out.write("                                <label for=\"pass\" class=\"fa fa-lock\"><input type=\"password\" name=\"password\" placeholder='Passsword' value=\"");
      out.print( pass);
      out.write("\" required=\"true\"/></label>\n");
      out.write("                                <input type=\"submit\" value=\"Login now\" class=\"wheel-btn\" style=\"background-color: #04DBC0; color: #fff;\"/>\n");
      out.write("                                <label ><input type='checkbox' id='input-val2' name=\"remember\" ");
      out.print( remember.equals("on") ? "checked = 'true'" : "");
      out.write("> <span>Remember me</span></label>\n");
      out.write("                            </form>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                            <br>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-7 padd-r0\">\n");
      out.write("                        <div class=\"wheel-register-sign marg-lg-b50\">\n");
      out.write("                            <div class=\"wheel-header\">\n");
      out.write("                                <h5>Sign up Now </h5>\n");
      out.write("                                <h3>Get <span style=\"color: #04DBC0;\">Registered</span></h3>\n");
      out.write("                            </div>\n");
      out.write("                            <form action=\"../../Demo/register\" method=\"post\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Username\" name=\"register_username\" required=\"true\" value=\"\" autocomplete=\"new-password\">\n");
      out.write("                                <input type=\"password\" placeholder=\"Password\" name=\"register_password\" required=\"true\" value=\"\" autocomplete=\"new-password\">\n");
      out.write("                                <input type=\"password\" placeholder=\"Confirm Password\" name=\"cf_password\" required=\"true\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Fullname\" name=\"fullname\" required=\"true\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Email\" name=\"email\" required=\"true\">\n");
      out.write("                                <input type=\"text\" placeholder=\"Address\" name=\"address\" required=\"true\">\n");
      out.write("                                <input type=\"text\" placeholder=\"City\" name=\"city\" required=\"true\">\n");
      out.write("                                <input type=\"number\" placeholder=\"Phone\" name=\"phone\" required=\"true\">\n");
      out.write("                                <div>\n");
      out.write("                                    Role: \n");
      out.write("                                    <select name=\"type\">\n");
      out.write("                                        <option value=\"render\">Renter</option>\n");
      out.write("                                        <option value=\"jobber\">Jobber</option>\n");
      out.write("                                    </select>\n");
      out.write("                                    <i class=\"fas fa-chevron-down\"></i>\n");
      out.write("                                </div>\n");
      out.write("                                <br>\n");
      out.write("                                <input type=\"submit\" value=\"Sign up\"style=\"background-color: #04DBC0; color: #fff;\"/>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
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

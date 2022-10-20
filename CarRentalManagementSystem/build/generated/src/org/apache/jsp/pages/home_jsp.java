package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import dal.CarDAO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/pages/nav.jsp");
    _jspx_dependants.add("/pages/header.jsp");
    _jspx_dependants.add("/pages/footer.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div id=\"wrapper\" class=\"hasbg transparent\">\n");
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
      out.write("            ");
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
      out.write("        ");
request.setAttribute("listCarBrand", db.getCarBrand());
      out.write("\n");
      out.write("        ");
request.setAttribute("listCarType", db.getCarType());
      out.write("\n");
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
      out.write("                        ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <i class=\"fas fa-chevron-down\"></i>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one_fourth \">\n");
      out.write("                    <select name=\"type\">\n");
      out.write("                        <option value=\"\">Any Type</option>\n");
      out.write("                        ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
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
      out.write("\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("            <div class=\"inner\">\n");
      out.write("                <div style=\"text-align:center; padding:60px 0 60px 0;\">\n");
      out.write("                    <div class=\"standard_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <h2 class=\"ppb_title\">First Class Car Rental Services</h2>\n");
      out.write("                            <div class=\"page_tagline\">We offer professional car rental services in our range of high-end vehicles</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"standard_wrapper\">\n");
      out.write("                    <div class=\" gallery grid  three_cols\">\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/audiA5.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=audi&type=&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>Audi</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/bmwM8.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=bmw&type=&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>BMW</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/lexusNX.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=lexus&type=&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>Lexus</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div style=\"text-align:center; padding:60px 0 60px 0;\">\n");
      out.write("                    <div class=\"standard_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <h2 class=\"ppb_title\" >Find Car by Type</h2>\n");
      out.write("                            <div class=\"page_tagline\" >We offer professional car rental &amp; limousine services in our range of high-end vehicles</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"standard_wrapper\">\n");
      out.write("                    <div class=\" gallery grid three_cols\">\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/coupe.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=&type=Coupe&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>Coupe</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/sedan.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=&type=sedan&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>Sedan</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"element grid classic3_cols animated1\">\n");
      out.write("                            <div class=\" gallery3 grid\" style=\"background-image:url(../../Demo/assets/image/suv.jpg);\">\n");
      out.write("                                <a class=\"car_image\" href=\"../../Demo/search?brand=&type=suv&sort_by=asc\"></a>\n");
      out.write("                                <div class=\"portfolio_info_wrapper\">\n");
      out.write("                                    <h3>SUV</h3>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one\" style=\"text-align:center;padding:60px 0 60px 0;background-color:#5856d6;color:#ffffff;\">\n");
      out.write("                    <div class=\"page_content_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <h2 class=\"ppb_title\" style=\"color:#ffffff;\">Safe car sharing while navigating COVID-19</h2>\n");
      out.write("                            <div class=\"page_tagline\" style=\"color:#ffffff;\">Hit the road confidently</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one\" style=\"padding-top:0 !important;text-align:center;padding:10px 0 10px 0;background-color:#5856d6;color:#ffffff !important;\">\n");
      out.write("                    <div class=\"page_content_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <div class=\"one_third \" >\n");
      out.write("                                <span style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"fas fa-pump-medical fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #fff;\">Clean & disinfected cars</h4>\n");
      out.write("                                <p>The enhanced cleaning policy requires hosts to clean & disinfect their cars so you can feel good behind the wheel.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"one_third \">\n");
      out.write("                                <span  style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"fas fa-hand-holding-heart fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #fff;\">Contactless check-in options</h4>\n");
      out.write("                                <p>Maintain physical distance during check-in and checkout with a variety of remote access options.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"one_third last \">\n");
      out.write("                                <span style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"far fa-thumbs-up fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #fff;\">Flexible cancellations</h4>\n");
      out.write("                                <p>Cancel for free up to 24 hours before your trip starts. Plans can change and it helps to be flexible when they do.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one \" style=\"text-align:center;padding:60px 0 60px 0;\">\n");
      out.write("                    <div class=\"page_content_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <h2 class=\"ppb_title\" style=\"\">Discover the world's largest <br>car sharing marketplace</h2>\n");
      out.write("                            <div class=\"page_tagline\" style=\"color: rgb(60,60,60);\">Skip the rental counter</div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"one \" style=\"padding-top:0 !important;text-align:center;padding:10px 0 10px 0;\">\n");
      out.write("                    <div class=\"page_content_wrapper\">\n");
      out.write("                        <div style=\"margin:auto;width:100%\">\n");
      out.write("                            <div class=\"one_third \" >\n");
      out.write("                                <span style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"fas fa-car-side fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #000;\">Endless options</h4>\n");
      out.write("                                <p>Choose from hundreds of models you won’t find anywhere else. Pick it up or get it delivered where you want it.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"one_third \">\n");
      out.write("                                <span  style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"fas fa-headset fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #000;\">24/7 customer support</h4>\n");
      out.write("                                <p>Rest easy knowing that everyone in the Turo community is screened, and 24/7 customer support and roadside assistance are just a click away.</p>\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"one_third last\">\n");
      out.write("                                <span style=\"display:block;font-size:50px;margin-bottom:20px;\"><i class=\"fas fa-shield-alt fa-2x\"></i></span></p>\n");
      out.write("                                <h4 style=\"color: #000;\">Drive confidently</h4>\n");
      out.write("                                <p>Drive confidently with your choice of protection plans — all plans include varying levels of liability insurance from Liberty Mutual provided through Turo Insurance Agency and physical damage protection.</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    ");
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
      out.write("</div>\n");
      out.write("</body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCarBrand}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("brand");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${brand}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${listCarType}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("type");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                            <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                        ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }
}

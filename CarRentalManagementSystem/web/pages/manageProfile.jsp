<%@page import="java.util.List"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en-US" data-menu="leftalign">
    <head>
        <meta charset="UTF-8" />
        <meta name="pagesport" content="width=device-width, initial-scale=1, maximum-scale=1" />
        <title>Car Rental System</title>
        <link rel="icon" type="image/jpg" href="https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Font_Awesome_5_regular_smile-wink.svg/768px-Font_Awesome_5_regular_smile-wink.svg.png">
        <link rel='stylesheet' href='../../Demo/assets/css/style.css' type='text/css' media='all' />
        <link rel='stylesheet' href='../../Demo/assets/css/leftalignmenu.css' type='text/css' media='all' />
        <link rel='stylesheet' href='../../Demo/assets/css/kirki.css' type='text/css' media='all' />
        <script src="https://kit.fontawesome.com/ec811f6ffe.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <c:if test="${requestScope.listAccount == null}">
            <% request.setAttribute("error", "Not found any car!");%>
            <% request.setAttribute("mess", "Go to home");%>
            <% request.setAttribute("href", "../../Demo/pages/home.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>
            <% List<Account> list = (List<Account>) request.getAttribute("listAccount");%>
            <div class="standard_wrapper sidebar_content gallery classic two_cols" style="margin-top: 100px;" >
                <c:if test="${requestScope.listAccount != null}">
                    <c:forEach items="${requestScope.listAccount}" var="c">
                        <div class="element portfolio_type">
                            <a  href="../../Demo/profileForAdmin?action=edit&username=${c.username}">
                                <img src="../../Demo/assets/image/profile.png" style="height: 346.29px;"/>
                            </a>
                            <hr>
                            <div class="portfolio_info_wrapper">
                                <i class="fas fa-file-signature fa-2x"></i>
                                <span style="font-size: 30px;">${c.fullname}</span>
                                <br><br>
                                <i class="fas fa-user fa-2x"></i>
                                <span style="font-size: 30px;">${c.username}</span>
                                <div class="car_attribute_price" >
                                    <div class="car_attribute_price_day">
                                        <span class="single_car_price" style="font-size: 30px;border: 1px black dotted; ">
                                            <c:if test="${c.type == 1}">
                                                <i>Renter</i>
                                            </c:if>
                                            <c:if test="${c.type == 2}">
                                                <i>Jobber</i>
                                            </c:if>
                                        </span><br>
                                    </div>
                                </div>
                            </div>
                            <button class="button" style="width: 200px; margin: 10px; "><a href="../../Demo/profileForAdmin?action=edit&username=${c.username}" style="color: #fff;">Edit</a></button>
                            <button class="button" style="width: 200px; margin: 10px; "><a href="../../Demo/profileForAdmin?action=delete&username=${c.username}" style="color: #fff;">Delete</a></button>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </div>
</body>
</html>
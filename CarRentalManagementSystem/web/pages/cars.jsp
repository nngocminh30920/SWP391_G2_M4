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
        <c:if test="${requestScope.listCar == null}">
            <% request.setAttribute("error", "Not found any car!");%>
            <% request.setAttribute("mess", "Go to home");%>
            <% request.setAttribute("href", "../../Demo/pages/home.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>
            <%@include file="header.jsp" %>
            <div class="standard_wrapper sidebar_content gallery classic two_cols" style="margin-top: 100px;" >
                <c:if test="${requestScope.listCar != null}">
                    <c:forEach items="${requestScope.listCar}" var="c">
                        <div class="element portfolio_type">
                            <a  href="../../Demo/cardetail?id=${c.id}">
                                <img src="../../Demo/assets/image/${c.image}" style="height: 346.29px;"/>
                            </a>
                            <div class="portfolio_info_wrapper">
                                <div class="car_attribute_wrapper">
                                    <h2>${c.brand} ${c.model}</h2>
                                    <div class="one_fourth">
                                        <div ><i class="far fa-user"></i></div>
                                        <div style="font-size: 20px;">${c.seat}</div>
                                    </div>
                                    <div class="one_fourth">
                                        <div ><i class="fas fa-car-side"></i></div>
                                        <div style="font-size: 20px;">${c.door}</div>
                                    </div>
                                    <div class="one_fourth">
                                        <div><i class="fas fa-cogs"></i></div>
                                        <div style="font-size: 20px;">${fn:containsIgnoreCase(c.tranmission, "Automatic")?"Auto":c.tranmission}</div>
                                    </div>
                                </div>
                                <div class="car_attribute_price">
                                    <div class="car_attribute_price_day">
                                        <span class="single_car_currency">$</span><span class="single_car_price">${c.price}</span><br>
                                        <span>Per Day</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>
            <br class="clear" />
            <div class="container">
                <div class="pagination" style="margin-left: 500px;">
                    <c:set var="size" value="${Integer.parseInt(requestScope.size)}" />
                    <c:forEach var="i" begin="1" end="${Integer.parseInt(requestScope.numPage)}">
                        <a href="search?brand=${requestScope.searchByBrand}&type=${requestScope.searchByType}&sort_by=${requestScope.searchBySortBy}&start=${(i - 1) * 6}&end=${((i * 6) > size) ? size : (i * 6)}">${i}</a>
                    </c:forEach>   
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
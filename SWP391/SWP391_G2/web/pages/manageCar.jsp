<%@page import="model.Car"%>
<%@page import="dal.OrderDAO"%>
<%@page import="dal.CarDAO"%>
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
        <c:if test="${requestScope.listCar == null}">
            <% request.setAttribute("error", "Not found any car!");%>
            <% request.setAttribute("mess", "Register car");%>
            <% request.setAttribute("href", "../../Demo/pages/add.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <c:if test="${sessionScope.user.type == 3}">
            <% CarDAO odb = new CarDAO(); %>
            <% request.setAttribute("listCar", odb.getCar());%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>   
            <div class="standard_wrapper sidebar_content gallery classic two_cols" style="margin-top: 120px;" >
                <c:if test="${requestScope.listCar != null}">
                    <c:forEach items="${requestScope.listCar}" var="c">
                        <div class="element portfolio_type">
                            <a  href="../../Demo/manageCar?action=edit&id=${c.id}">
                                <img src="../../Demo/assets/image/${c.image}" style="height: 346.29px;"/>
                            </a>
                            <div class="portfolio_info_wrapper" >
                                <div class="car_attribute_wrapper" style="margin-bottom: 10px;">
                                    <h2>${c.brand} ${c.model}</h2>
                                    <button class="button" style="width: 150px;"><a href="../../Demo/author?action=editCar&id=${c.id}" style="color: #fff;">Edit</a></button>
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
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
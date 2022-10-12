<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dal.CarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
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
        <%CarDAO db = new CarDAO();%>
        <%request.setAttribute("listCarBrand", db.getCarBrand());%>
        <%request.setAttribute("listCarType", db.getCarType());%>
    </head>
    <body>
        <video autoplay="autoplay" muted="muted" loop="loop" width="100%">
            <source src="../../Demo/assets/video/header.mp4" type="video/mp4" >
            Your browser does not support the video tag. I suggest you upgrade your browser.
        </video> 
        <div id="page_content_wrapper">
            <form class="car_search_form" action="../../Demo/search">
                <div class="one_fourth ">
                    <select name="brand">
                        <option value="">Any Brand</option>
                        <c:forEach items="${listCarBrand}" var="brand">
                            <option value="${brand}">${brand}</option>
                        </c:forEach>
                    </select>
                    <i class="fas fa-chevron-down"></i>
                </div>
                <div class="one_fourth ">
                    <select name="type">
                        <option value="">Any Type</option>
                        <c:forEach items="${listCarType}" var="type">
                            <option value="${type}">${type}</option>
                        </c:forEach>
                    </select>
                    <i class="fas fa-chevron-down"></i>
                </div>
                <div class="one_fourth">
                    <select name="sort_by">
                        <option value="asc">Price Low to High</option>
                        <option value="desc">Price High to Low</option>
                    </select>
                    <i class="fas fa-chevron-down"></i>
                </div>
                <div class="one_fourth last ">
                    <input type="submit" value="Search" />
                </div>
            </form>
        </div>   
    </body>
</html>

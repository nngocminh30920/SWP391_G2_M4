<%@page import="model.Car"%>
<%@page import="dal.AccountDAO"%>
<%@page import="model.Account"%>
<%@page import="model.Order"%>
<%@page import="dal.OrderDAO"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>

    <body>
        <c:if test="${sessionScope.user == null || sessionScope.user.type == 1}">
            <% request.setAttribute("error", "UNAUTHORIZED!");%>
            <% request.setAttribute("mess", "Sign in to jobber account");%>
            <% request.setAttribute("href", "../../Demo/pages/login.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>
            <c:if test="${requestScope.car != null}">
                <% Car car = (Car) request.getAttribute("car");%>
                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img class="d-block img-fluid" src="../../Demo/assets/image/${requestScope.car.image}" style="width: 100%; height: 700px;;">
                        </div>
                        <c:forEach items="${requestScope.listImage}" var="i">
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="../../Demo/assets/image/${i.name}" style="width: 100%; height: 700px;">
                            </div>
                        </c:forEach>
                    </div>
                    <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                </div>
                <div id="page_content_wrapper" class="hasbg withtopbar ">
                    <form action="../../Demo/manageCar" method="post"  encType="multipart/form-data">
                        <div class="sidebar_content"  style="margin-bottom: 10px;">
                            <h1>${requestScope.car.brand} ${requestScope.car.model}</h1>
                            <div class="single_car_attribute_wrapper">
                                <div class="one_fifth">
                                    <div class="car_attribute_icon"><i class="fas fa-user"></i></div>
                                    <div class="car_attribute_content">&nbsp;<input type="number" name="seat" value="${requestScope.car.seat}" style="width: 100px; margin: 10px 0 10px 0;"  min="1" required/>&nbsp;Passengers </div>
                                </div>
                                <div class="one_fifth ">
                                    <div class="car_attribute_icon"><i class="fas fa-car-side"></i></div>
                                    <br><div class="car_attribute_content">&nbsp;<input type="number" name="door" value="${requestScope.car.door}" style="width: 100px; margin: 10px 0 10px 0;"  min="1" required/><br>&nbsp; Doors </div>
                                </div>
                                <div class="one_fifth">
                                    <div class="car_attribute_icon"><i class="fab fa-steam"></i></div><br>
                                    <div class="car_attribute_content" >&nbsp;<input type="text" name="type" value="${requestScope.car.type}" style="width: 100px; border-color: #000; margin-top: 10px;" required/></div>
                                </div>
                                <div class="one_fifth">
                                    <div class="car_attribute_icon"><i class="fas fa-cogs"></i></div><br>
                                    <div class="car_attribute_content">&nbsp;<input type="text" name="tranmission" value="${requestScope.car.tranmission}" style="width: 100px; border-color: #000; margin-top: 10px;" required/></div>
                                </div>
                                <div class="one_fifth last">
                                    <div class="car_attribute_icon"><i class="fas fa-dollar-sign"></i></div><br>
                                    <div class="car_attribute_content">&nbsp;<input type="number" name="price" value="${requestScope.car.price}" style="width: 100px; margin-top: 10px;"  min="0" required/></div>
                                </div>
                            </div>
                        </div>
                        <input id="checkbox_changeavatar" type="checkbox" name="changeavatar" value="1" onchange= "changeAvatar()">
                        <span>Change avatar of the car</span> 
                        <div id="change_avatar" style="display: none;">
                            <div class="single_car_attribute_wrapper">   
                                <div style="width: 270px; border-color: #000;">
                                    <div class="car_attribute_icon" ><i class="fas fa-images" style="float: left; padding-left: 0"></i></div>
                                    <input id="avatar" type="file" name="avatar" class="input1" style="float: right; width: 200px; padding-left: 0">
                                </div>
                            </div>
                        </div>
                        <br>
                        <input id="checkbox_changedetailedimage" type="checkbox" name="changeDetailImage" value="1" onchange= "changeDetailedImage()">
                        <span>Change detailed image of the car</span> 
                        <div id="change_detailedImage" style="display: none;">
                            <div class="single_car_attribute_wrapper">   
                                <div style="width: 270px; border-color: #000;">
                                    <div class="car_attribute_icon" ><i class="fas fa-images" style="float: left; padding-left: 0"></i></div>
                                    <input id="detailedImage" type="file" name="detailedImage" class="input1" style="float: right; width: 200px; padding-left: 0" multiple>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="single_car_attribute_wrapper">
                            <div>
                                <c:set var="description" value="${fn:split(requestScope.car.description, '/')}" />
                                <h4>Overview</h4>
                                <p><textarea name="overview" cols="40" rows="5" class="input1"  placeholder="If there is no description, write 'None'*" required>${description[0]}</textarea></p>
                                <h4>Engine, Transmission, and Performance</h4>
                                <p><textarea  name="description" cols="40" rows="5" class="input1" placeholder="If there is no description, write 'None'*" required>${description[1]}</textarea></p>
                            </div>
                        </div>
                        <input type="hidden" name="action" value="save"> 
                        <input type="hidden" name="id" value="${requestScope.car.id}"> 
                        <input type="submit" value="Save" style="width: 150px;">
                        <%OrderDAO odb = new OrderDAO(); %>
                        <%request.setAttribute("isValidDelete", (odb.getOrderByCarId(car.getId()).isEmpty()));%>
                        <c:if test="${requestScope.isValidDelete}">
                            <button class="button" style="width: 270px;"><a href="../../Demo/manageCar?action=delete&id=${requestScope.car.id}" style="color: #fff;">Delete</a></button>
                        </c:if>
                        <c:if test="${!requestScope.isValidDelete}">
                            <p class="button" style="width: 400px; color: #fff;">The car is being leased or requested to rent</p>
                        </c:if>
                    </form>
                </div>
            </c:if>
            <%@include file="footer.jsp" %>
        </div>
        <script>
            function changeAvatar() {
                if (document.getElementById("checkbox_changeavatar").checked) {
                    document.getElementById("change_avatar").style.display = "block";
                    document.getElementById("avatar").setAttribute('required', 'true');
                } else {
                    document.getElementById("change_avatar").style.display = "none";
                    document.getElementById("avatar").removeAttribute('required');
                }
            }
            function changeDetailedImage() {
                if (document.getElementById("checkbox_changedetailedimage").checked) {
                    document.getElementById("change_detailedImage").style.display = "block";
                    document.getElementById("detailedImage").setAttribute('required', 'true');
                } else {
                    document.getElementById("change_detailedImage").style.display = "none";
                    document.getElementById("detailedImage").removeAttribute('required');
                }
            }
        </script>
    </body>
</html>
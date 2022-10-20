<%@page import="model.Account"%>
<%@page import="dal.OrderDAO"%>
<%@page import="model.Car"%>
<%@page import="dal.CommentDAO"%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>

    <body>
        <c:if test="${requestScope.car == null}">
            <% request.setAttribute("error", "Not found information <br> about the car!");%>
            <% request.setAttribute("mess", "Go to home");%>
            <% request.setAttribute("href", "../../Demo/pages/home.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>
            <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                <div class="carousel-inner" role="listbox">
                    <div class="carousel-item active">
                        ${requestScope.car.image}                        <img class="d-block img-fluid" src="../../Demo/assets/image/${requestScope.car.image}" style="width: 100%; height: 700px;">
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
            <c:if test="${requestScope.car != null}">
                <!-- Begin content -->
                <div id="page_content_wrapper" class="hasbg withtopbar ">
                    <div class="inner">
                        <div class="sidebar_content">
                            <h1>${requestScope.car.brand} ${requestScope.car.model}</h1>
                            <div class="single_car_attribute_wrapper">
                                <div class="one_fourth">
                                    <div class="car_attribute_icon"><i class="fas fa-user"></i></div>
                                    <div class="car_attribute_content">&nbsp;${requestScope.car.seat}&nbsp;Passengers </div>
                                </div>
                                <div class="one_fourth ">
                                    <div class="car_attribute_icon"><i class="fas fa-car-side"></i></div>
                                    <div class="car_attribute_content">&nbsp;${requestScope.car.door}&nbsp; Doors </div>
                                </div>
                                <div class="one_fourth">
                                    <div class="car_attribute_icon"><i class="fab fa-steam"></i></div>
                                    <div class="car_attribute_content">&nbsp;${requestScope.car.type}</div>
                                </div>
                                <div class="one_fourth last">
                                    <div class="car_attribute_icon"><i class="fas fa-cogs"></i></div>
                                    <div class="car_attribute_content">&nbsp;${requestScope.car.tranmission}</div>
                                </div>
                            </div>
                            <br class="clear" />
                            <div>
                                <c:set var="description" value="${fn:split(requestScope.car.description, '/')}" />
                                <h4>Overview</h4>
                                <p>${description[0]}</p>
                                <h4>Engine, Transmission, and Performance</h4>
                                <p>${description[1]}</p>
                            </div>
                            <div>
                                <%CommentDAO cmdb = new CommentDAO();%>
                                <%OrderDAO odb = new OrderDAO();%>
                                <%Car car = (Car) request.getAttribute("car");%>
                                <%request.setAttribute("listComment", cmdb.getCommentByCarId(car.getId()));%>
                                <%request.setAttribute("countComment", cmdb.countCommentByCarId(car.getId()));%>
                                <h3 class="comment_title">${requestScope.countComment} Review(s)</h3>
                                <c:forEach items="${requestScope.listComment}" var="cm">
                                    <div  id="comment-1">
                                        <p style="font-size:125%; font-weight: bold; margin: 0">${cm.account.fullname}</p>
                                        <div class="comment_date" style="font-size: 13px;">${cm.createOn}</div>
                                        <p>${cm.content}</p>
                                        <br class="clear">
                                    </div>
                                    <hr>
                                </c:forEach>
                                <div id="respond" class="comment-respond">
                                    <h3 id="reply-title" class="comment-reply-title">Write A Review <small><a rel="nofollow" id="cancel-comment-reply-link" href="#" style="display:none;">Cancel reply</a></small></h3>
                                    <form action="../../Demo/comment?carid=${requestScope.car.id}" method="post" id="commentform" >
                                        <p class="comment-form-comment">
                                            Comment
                                            <textarea name="comment" cols="45" rows="8" maxlength="65525" required="required"></textarea>
                                        </p>
                                        <c:if test="${sessionScope.user != null && sessionScope.user.type == 1}">
                                            <%Account account = (Account) session.getAttribute("user");%>
                                            <%request.setAttribute("isValidComment", cmdb.validComment(account.getUsername(), car.getId()));%>
                                            <c:if test="${requestScope.isValidComment}">
                                                <p class="form-submit" > <input type="submit" value="Post Review"> </p>
                                                </c:if>
                                                <c:if test="${!requestScope.isValidComment}">
                                                <p class="button" style="width: 226.19px; height: 45.45px; margin: 25px;">
                                                    You need to rent this car
                                                </p>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${sessionScope.user == null || (sessionScope.user != null && sessionScope.user.type == 2)}">
                                            <button class="button" style="width: 226.19px; height: 45.45px; margin: 25px;">
                                                <a href="../../Demo/pages/login.jsp" style="color: #fff;">Sign in to renter account</a>
                                            </button>
                                        </c:if>
                                    </form>
                                </div>
                            </div>
                        </div>

                        <div class="sidebar_wrapper">
                            <div class="single_car_booking_wrapper">
                                <div class="single_car_header_content">
                                    <div class="standard_wrapper">
                                        <div class="single_car_header_price">
                                            <span class="single_car_currency">$</span><span class="single_car_price">${requestScope.car.price}</span>
                                            <span class="single_car_price_per_unit">
                                                <span id="single_car_unit">Per Day</span>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <form name="f" method="post" class="wpcf7-form" >
                                    <p> 
                                        <label> Full Name <br/>
                                            <input type="text" id="rFullname" name="rFullname"
                                                   placeholder="Charles Calhoun"
                                                   value="${sessionScope.user.fullname}" 
                                                   size="40" class="wpcf7-text" required/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Email Address <br/>
                                            <input type="email" required class="wpcf7-text"
                                                   name="rEmail" value="${sessionScope.user.email}" 
                                                   size="40" placeholder="sample@yourcompany.com" 
                                                   id="rEmail"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Address <br />
                                            <input type="text" required class="wpcf7-text" size="40" 
                                                   name="rAddress" value="${sessionScope.user.address}" 
                                                   placeholder="34 Mainfield Road" id="rAddress"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> City
                                            <br />
                                            <input type="text" required class="wpcf7-text"
                                                   name="rCity" value="${sessionScope.user.city}" 
                                                   size="40" placeholder="Washington" id="rCity"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Phone Number <br />
                                            <input type="number" name="rPhone" required
                                                   value="${sessionScope.user.phone}" size="40" 
                                                   class="wpcf7-text" placeholder="0123456789" 
                                                   style="border-color: #dce0e0;" id="rPhone"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Pick Up Address<br />
                                            <input type="text" required class="wpcf7-text"
                                                   name="pickupAddress" size="40"
                                                   placeholder="Heatrow Airport" 
                                                   id="pickupAddress"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Pickup Date<br />
                                            <input type="date" id="fromDate" required
                                                   name="pickupDate" value="mm/dd/yyyy"
                                                   class="wpcf7-date" onchange="getTotal(${requestScope.car.price})"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Drop Off Address<br />
                                            <input type="text" required size="40"
                                                   name="dropoffAddress" class=" wpcf7-text"
                                                   placeholder="Heatrow Airport"
                                                   id="dropoffAddress"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Drop Off Date<br />
                                            <input type="date" id ="toDate"
                                                   name="dropoffDate" required
                                                   class=" wpcf7-date" onchange="getTotal(${requestScope.car.price})"/>
                                        </label>
                                    </p>
                                    <p>
                                        <label> Total<br />
                                            <input id ="total" name="total" type="text" readonly/>
                                        </label>
                                    </p>
                                    <c:if test="${sessionScope.user != null && (sessionScope.user.type == 1 || sessionScope.user.type == 3)}">
                                        <input type="submit" onclick="validForm('requestOrder',${requestScope.car.id})" value="Request for Booking"/>
                                    </c:if>
                                    <c:if test="${sessionScope.user == null || (sessionScope.user != null && sessionScope.user.type == 2)}">
                                        <button class="button" style="width: 226.19px; height: 45.45px;">
                                            <a href="../../Demo/pages/login.jsp" style="color: #fff;">Sign in to renter account</a>
                                        </button>
                                    </c:if>
                                    <script>
                                        function validForm(action, id) {
                                            var fromDate = new Date(document.getElementById("fromDate").value);
                                            var toDate = new Date(document.getElementById("toDate").value);
                                            var currentDate = new Date();
                                            if (fromDate === currentDate) {
                                                window.alert('The pick up date must be greater than the current date');
                                            } else if (fromDate > toDate) {
                                                window.alert('The pick up date must be greater than the drop off date');
                                            } else {
                                                document.f.action = "../../Demo/author?action=" + action + "&carid=" + id;
                                                document.f.submit();
                                            }
                                        }
                                        function getTotal(price) {
                                            var fromDate = new Date(document.getElementById("fromDate").value) !== '' ? new Date(document.getElementById("fromDate").value) : null;
                                            var toDate = document.getElementById("toDate").value !== '' ? new Date(document.getElementById("toDate").value) : null;
                                            if (toDate && fromDate) {
                                                document.getElementById("total").value = (toDate - fromDate) / 86400000 * price;
                                            }
                                        }
                                    </script>
                                </form>
                                <br class="clear" />
                            </div> 
                            <br class="clear" />
                        </div>
                    </div>
                </div>
            </c:if>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
<%@page import="model.Account"%>
<%@page import="dal.OrderDAO"%>
<%@page import="model.Car"%>
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
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
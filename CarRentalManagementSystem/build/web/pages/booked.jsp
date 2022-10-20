<%@page import="java.util.List"%>
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
        <script src="https://kit.fontawesome.com/ec811f6ffe.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <c:if test="${sessionScope.user == null}">
            <% request.setAttribute("error", "UNAUTHORIZED!");%>
            <% request.setAttribute("mess", "Sign in to account");%>
            <% request.setAttribute("href", "../../Demo/pages/login.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <%@include file="nav.jsp" %>
        <br><br><br><br>
        <div id="page_content_wrapper">
            <c:if test="${sessionScope.user != null}">
                <%OrderDAO odb = new OrderDAO();%>
                <%Account account = (Account) session.getAttribute("user");%>
                <c:if test="${sessionScope.user.type == 1}">
                    <%request.setAttribute("listOrder", odb.getOrderByUsernameForRenter(account.getUsername()));%>
                </c:if>
                <c:if test="${sessionScope.user.type == 2}">
                    <%request.setAttribute("listOrder", odb.getOrderByUsernameForJobber(account.getUsername()));%>
                </c:if>
                <c:if test="${sessionScope.user.type == 3}">
                    <%request.setAttribute("listOrder", odb.getOrder());%>
                </c:if>
                <c:set var="i" value="0" />
                <%for (Order or : (List<Order>) request.getAttribute("listOrder")) {%>
                <%request.setAttribute("o", or);%>
                <c:if test="${!fn:containsIgnoreCase(requestScope.o.status, 'rejectHidden')  && !fn:containsIgnoreCase(requestScope.o.status, 'completedHidden')&& !fn:containsIgnoreCase(requestScope.o.status, 'cancel')}">
                    <c:set var="i" value="1"/>
                    <c:set var="href" value="../../Demo/author?action=veiwDetail&orderId=${requestScope.o.id}"/>
                    <c:if test="${sessionScope.user.type == 3}">
                        <c:set var="href" value="../../Demo/orderForAdmin?action=edit&orderId=${requestScope.o.id}&page=booked"/>
                    </c:if>
                    <a href="${href}">
                        <div class="post type-post has-post-thumbnail">
                            <div class="post_wrapper grid_layout" style="padding: 0;">
                                <div  style="float: left; width:350px;">
                                    <img src="../../Demo/assets/image/${requestScope.o.car.image}"  style="width:350px !important; height: 282.67px !important;"/>
                                </div>
                                <div  style="float: right; text-align: left; width: 575px;">
                                    <div class="post_header grid">
                                        <span class="post_info_date">
                                            <h4>${requestScope.o.pickupDate} &rarr; ${requestScope.o.dropoffDate}</h4>
                                        </span>
                                        <h2>${requestScope.o.car.brand} ${requestScope.o.car.model}</h2>
                                    </div>
                                    <c:if test="${sessionScope.user.type == 2}">
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'request')}">
                                            <%request.setAttribute("isValidOrder", odb.validOrder(or.getCar().getId(), or.getPickupDate(), or.getDropoffDate()));%>
                                            <c:if test="${requestScope.isValidOrder}">
                                                <button class="button" style="width: 250px;"><a href="../../Demo/author?action=acceptOrder&orderId=${requestScope.o.id}" style="color: #fff;">Accept</a></button>
                                                <button class="button" style="width: 250px;"><a href="../../Demo/author?action=rejectOrder&orderId=${requestScope.o.id}" style="color: #fff;">Reject</a></button>
                                            </c:if>
                                            <c:if test="${!requestScope.isValidOrder}">
                                                <h5  style="color: red; margin:0;">The car has been rented</h5>     
                                                <button class="button" style="width: 250px;"><a href="../../Demo/author?action=rejectOrder&orderId=${requestScope.o.id}" style="color: #fff;">Reject</a></button>
                                            </c:if>
                                        </c:if>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'accept')}">
                                            <button class="button" style="width: 250px;"><a href="../../Demo/author?action=deliverCar&orderId=${requestScope.o.id}" style="color: #fff;">Car has been delivered</a></button>
                                        </c:if>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'completed')}">
                                            <button class="button" style="width: 250px;"><a href="../../Demo/author?action=confirmCompletedHidden&orderId=${requestScope.o.id}" style="color: #fff;">The car has been paid</a></button>
                                        </c:if>
                                        <c:if test="${!fn:containsIgnoreCase(requestScope.o.status, 'completed')&& !fn:containsIgnoreCase(requestScope.o.status, 'accept')&& !fn:containsIgnoreCase(requestScope.o.status, 'request')}">
                                            <h3 style="color: red">${requestScope.o.status}</h3>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${sessionScope.user.type == 1}">
                                        <h3 style="color: red">${requestScope.o.status}</h3>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'request')}">
                                            <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/author?action=cancel&orderId=${requestScope.o.id}" style="color: #fff;">Cancel</a></button>
                                        </c:if>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'reject')}">
                                            <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/author?action=confirmRejectHidden&orderId=${requestScope.o.id}" style="color: #fff;">Confirm rejected</a></button>
                                        </c:if>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'deliverCar')}">
                                            <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/author?action=confirmReceivedCar&orderId=${requestScope.o.id}" style="color: #fff;">Confirm car has been received</a></button>
                                        </c:if>
                                        <c:if test="${fn:containsIgnoreCase(requestScope.o.status, 'inprogress')}">
                                            <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/author?action=completedOrder&orderId=${requestScope.o.id}" style="color: #fff;">Give car back</a></button>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${sessionScope.user.type == 3}">
                                        <h3 style="color: red">${requestScope.o.status}</h3>
                                        <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/orderForAdmin?action=edit&orderId=${requestScope.o.id}&page=booked" style="color: #fff;">Edit</a></button>
                                        <button class="button" style="width: 250px; margin-bottom: 10px; "><a href="../../Demo/orderForAdmin?action=delete&orderId=${requestScope.o.id}&page=booked" style="color: #fff;">Delete</a></button>
                                    </c:if>

                                </div>
                            </div>
                        </div>
                        <br class="clear" />
                    </a>
                </c:if>
                <%}%>
                <c:if test="${i==0}">
                    <% request.setAttribute("error", "Not found any order!");%>
                    <c:if test="${sessionScope.user.type == 1}">
                        <%request.setAttribute("mess", "Request order");%>
                        <%request.setAttribute("href", "../../Demo/search?brand=&type=&sort_by=asc");%>
                    </c:if>
                    <c:if test="${sessionScope.user.type == 2}">
                        <%request.setAttribute("mess", "Wait for the request");%>
                        <%request.setAttribute("href", "../../Demo/pages/home.jsp");%>
                    </c:if>
                    <c:if test="${sessionScope.user.type == 3}">
                        <%request.setAttribute("mess", "Go to home page");%>
                        <%request.setAttribute("href", "../../Demo/pages/home.jsp");%>
                    </c:if>
                    <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
                </c:if>
            </c:if> 
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
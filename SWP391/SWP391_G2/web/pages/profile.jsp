<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="../../Demo/assets/js/script.js" type="text/javascript"></script>
        <script src="https://kit.fontawesome.com/ec811f6ffe.js" crossorigin="anonymous"></script>
    </head>

    <body>
        <c:if test="${sessionScope.user == null}">
            <% request.setAttribute("error", "UNAUTHORIZED!");%>
            <% request.setAttribute("mess", "Sign in to account");%>
            <% request.setAttribute("href", "../../Demo/pages/login.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <div id="wrapper" class="hasbg transparent">
            <div class="header_style_wrapper" id="menu">
                <div class="above_top_bar" id="top_bar">
                    <div class="page_content_wrapper">
                        <div class="social_wrapper" style="height: 45.29px;" >
                            <ul style="margin: 0;">
                                <li><a target="_blank" href="https://www.facebook.com/"><i class="fab fa-facebook"></i></a></li>
                                <li><a target="_blank" href="http://twitter.com/"><i class="fab fa-twitter"></i></a></li>
                                <li><a target="_blank" href="http://instagram.com/"><i class="fab fa-instagram"></i></a></li>
                            </ul>
                        </div>
                        <div class="top_contact_info">
                            <div><span><i class="fas fa-map-marker-alt"></i></span>FPT University</div>
                            <div><a href="tel:012.345.6789"><span ><i class="fas fa-mobile-alt"></i></span>012.345.6789</a></div>
                            <div><span><i class="far fa-clock"></i></span>Mon-Fri 09.00 - 17.00</div>
                        </div>
                        <br class="clear"/>
                    </div>
                </div>
                <div class="top_bar hasbg" id="menu_bar">
                    <div class="standard_wrapper">
                        <div>
                            <a href="../../Demo/pages/home.jsp">
                                <img class = "logo" src="../../Demo/assets/image/logo.png" alt="Logo">
                            </a>
                            <div id="menu_wrapper">
                                <div class="menu-main-menu-container" >
                                    <ul class="nav" >
                                        <li><a href="../../Demo/pages/home.jsp" style="padding-top: 15px;">Home</a></li>
                                        <li><a href="../../Demo/search?brand=&type=&sort_by=asc" style="padding-top: 15px;">Cars&ensp;</a></li>
                                            <c:if test="${sessionScope.user == null}">
                                            <li><a href="../../Demo/pages/login.jsp" style="padding-top: 15px;">Log in</a></li>
                                            </c:if>
                                            <c:if test="${sessionScope.user != null}">
                                            <li><a href="../../Demo/author?action=addCar" style="padding-top: 15px;">Register car</a></li>
                                            <li><a href="../../Demo/author?action=manageCar" style="padding-top: 15px;">Manage car</a></li>
                                            <li><a href="#"style="padding-top: 15px;">Trips&ensp;<i class="fas fa-angle-down"></i></a>
                                                <ul>
                                                    <li><a href="../../Demo/pages/booked.jsp" >Booked</a></li>
                                                    <li><a href="../../Demo/pages/history.jsp" >History</a></li>
                                                </ul>
                                            </li>
                                            <li><a href="#" style="padding-top: 15px;"><i class="far fa-user-circle fa-2x"></i></i></a>
                                                <ul>
                                                    <li><a href="../../Demo/pages/profile.jsp" > Profile</a></li>
                                                    <li><a href="../../Demo/logout" >Log out</a></li>
                                                </ul> 
                                            </li>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> 
            <script>
                var menu = document.getElementById('menu');
                var topbar = document.getElementById('top_bar');
                var menubar = document.getElementById('menu_bar');
                var origOffsetY = menu.offsetHeight;

                function onScroll(e) {
                    if (window.scrollY >= origOffsetY) {
                        topbar.style.display = "none";
                        menubar.style.backgroundColor = "#000";
                    } else {
                        topbar.style.display = "block";
                        menubar.style.backgroundColor = "rgba(0, 0, 0, 5)";
                    }
                }
                document.addEventListener('scroll', onScroll);
            </script>
            <br><br><br><br><br>
            <c:if test="${requestScope.account == null}">
                <div class="profile_manage">
                    <div class="profile_left">
                        <div class="user">
                            <div class="display_user">
                                <i style="font-size: 80px;" class="fa fa-user-circle" aria-hidden="true"></i>
                            </div>
                            <div class="display_user">
                                <h2 class="ppb_title">${sessionScope.user.fullname}</h2>
                            </div>
                        </div>
                        <div id="profile" onclick="displayProfile()" style="border-right: 3px solid black">Profile</div>
                    </div>
                    <div class="profile_right">
                        <div id="display_profile">
                            <h2  style="color: red; text-align: center;">${requestScope.error}</h2>     
                            <form action="../../Demo/profile" method="POST">
                                Fullname:<br>
                                <input type="text" name="newFullName" size="90%" value="${sessionScope.user.fullname}" required><br><br>
                                Email:<br>  
                                <input type="text" size="90%" name="newEmail" value="${sessionScope.user.email}" required><br><br>    
                                Address:<br>  
                                <input type="text" size="90%" name="newAddress" value="${sessionScope.user.address}" required><br><br>    
                                City:<br>  
                                <input type="text" size="90%" name="newCity" value="${sessionScope.user.city}" required><br><br>    
                                Phone number:<br>
                                <input type="text" size="90%" name="newPhone" value="${sessionScope.user.phone}" required><br><br>
                                <span style="color: blue">Change password</span> 
                                <input id="checkbox_changepassword" type="checkbox" name="changePassword" value="1" onchange= "changePassFunction()">
                                <div id="change_password">
                                    <br/>
                                    <label style="width: 30%" for="">Current password: </label> 
                                    <input type="password" name="oldPassword" size="50%" id="oldPassword"><br>
                                    <label style="width: 30%" for="">New password: </label> 
                                    <input type="password" name="newPassword" size="50%" id="newPassword"><br>
                                    <label style="width: 30%" for="">Re-enter new password:</label> 
                                    <input type="password" name="reNewPassword" size="50%" id="reNewPassword"><br>
                                </div>
                                <br/><br/>
                                <input type="submit" value="Save" />
                                <p style="color: red;">${requestScope.error}</p>
                            </form>
                        </div>
                        <br>
                    </div>            
                </div>
            </c:if>
            <c:if test="${requestScope.account != null}">
                <div class="profile_manage">
                    <div class="profile_left">
                        <div class="user">
                            <div class="display_user">
                                <i style="font-size: 80px;" class="fa fa-user-circle" aria-hidden="true"></i>
                            </div>
                            <div class="display_user">
                                <h2 class="ppb_title">${requestScope.account.fullname}</h2>
                            </div>
                        </div>
                        <div id="profile" onclick="displayProfile()" style="border-right: 3px solid black">Profile</div>
                    </div>
                    <div class="profile_right">
                        <div id="display_profile">
                            <h2  style="color: red; text-align: center;">${requestScope.error}</h2>     
                            <form action="../../Demo/profileForAdmin?action=save&username=${requestScope.account.username}" method="POST">
                                Fullname:<br>
                                <input type="text" name="newFullName" size="90%" value="${requestScope.account.fullname}" required><br><br>
                                Email:<br>  
                                <input type="text" size="90%" name="newEmail" value="${requestScope.account.email}" required><br><br>    
                                Address:<br>  
                                <input type="text" size="90%" name="newAddress" value="${requestScope.account.address}" required><br><br>    
                                City:<br>  
                                <input type="text" size="90%" name="newCity" value="${requestScope.account.city}" required><br><br>    
                                Phone number:<br>
                                <input type="text" size="90%" name="newPhone" value="${requestScope.account.phone}" required><br><br>
                                Status<br/>
                                <select name="type">
                                    <%Account acc = (Account) request.getAttribute("account"); %>
                                    <option value="1" <%= acc.getType() == 1 ? "selected" : ""%>>Renter</option>
                                    <option value="2" <%= acc.getType() == 2 ? "selected" : ""%>>Jobber</option>
                                </select>
                                <br>
                                <span style="color: blue">Change password</span> 
                                <input id="checkbox_changepassword" type="checkbox" name="changePassword" value="1" onchange= "changePassFunction()">
                                <div id="change_password">
                                    <br/>
                                    <label style="width: 30%" for="">Current password: </label> 
                                    <input type="password" name="oldPassword" size="50%" id="oldPassword"><br>
                                    <label style="width: 30%" for="">New password: </label> 
                                    <input type="password" name="newPassword" size="50%" id="newPassword"><br>
                                    <label style="width: 30%" for="">Re-enter new password:</label> 
                                    <input type="password" name="reNewPassword" size="50%" id="reNewPassword"><br>
                                </div>
                                <br/><br/>
                                <input type="submit" value="Save" style="width: 200px;"/>
                                <p style="color: red;">${requestScope.error}</p>
                            </form>
                            <button class="button" style="width: 200px;"><a href="../../Demo/profileForAdmin?action=delete&username=${requestScope.account.username}" style="color: #fff;">Delete</a></button>
                        </div>
                        <br>
                    </div>            
                </div>
            </c:if>
            <%@include file="footer.jsp" %>
        </div>
        <script>
            function changePassFunction() {
                if (document.getElementById("checkbox_changepassword").checked) {
                    document.getElementById("change_password").style.display = "block";
                    document.getElementById("oldPassword").setAttribute('required', 'true');
                    document.getElementById("newPassword").setAttribute('required', 'true');
                    document.getElementById("reNewPassword").setAttribute('required', 'true');
                } else {
                    document.getElementById("change_password").style.display = "none";
                    document.getElementById("oldPassword").removeAttribute('required');
                    document.getElementById("newPassword").removeAttribute('required');
                    document.getElementById("reNewPassword").removeAttribute('required');
                }
            }
        </script>
    </body>
</html>
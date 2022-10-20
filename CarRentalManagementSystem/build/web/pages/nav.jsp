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
        <script src="https://kit.fontawesome.com/ec811f6ffe.js" crossorigin="anonymous"></script>
    </head>
    <body>
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
                                            <c:if test="${sessionScope.user.type == 3}">
                                            <li><a href="../../Demo/profileForAdmin?action=view" style="padding-top: 15px;">Manage profile</a></li>
                                            </c:if>
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
                    menubar.style.backgroundColor = "rgba(0, 0, 0, 0)";
                }
            }
            document.addEventListener('scroll', onScroll);
        </script>
    </body>
</html>

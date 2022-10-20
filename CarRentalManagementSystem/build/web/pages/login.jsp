<%@page import="model.Account"%>
<%@page import="model.Car"%>
<%@page import="java.util.List"%>
<%@page import="dal.CarDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <div id="wrapper" class="hasbg transparent">
            <br><br><br><br><br><br>
            <%@include file="nav.jsp" %>
            <div class="container">
                <div class="row">
                    <h2  style="color: red; text-align: center; margin-bottom: 30px; width: 100%">${requestScope.error}</h2>
                    <br>
                    <div class="col-md-5 padd-l0" >
                        <div class="wheel-register-log marg-lg-b50">
                            <div class="wheel-header">
                                <br>
                                <h5 style="text-align: left;">have an account? Log In</h5>
                                <br>
                            </div>
                            <%
                                Cookie[] cookie = request.getCookies();
                                Account account = (Account) session.getAttribute("user");
                                String user = "";
                                String pass = "";
                                String remember = "";
                                if (cookie != null) {
                                    for (Cookie c : cookie) {
                                        if (c.getName().equals("c_user")) {
                                            user = c.getValue();
                                        }
                                        if (c.getName().equals("c_pass")) {
                                            pass = c.getValue();
                                        }
                                        if (c.getName().equals("c_remember")) {
                                            remember = c.getValue();
                                        }
                                    }
                                }
                            %>
                            <form action="../../Demo/login" method="post">
                                <label for="user" class="fa fa-user"><input type="text" name="username" placeholder='Username' value="<%= user%>" required="true"/></label>
                                <label for="pass" class="fa fa-lock"><input type="password" name="password" placeholder='Passsword' value="<%= pass%>" required="true"/></label>
                                <input type="submit" value="Login now" class="wheel-btn" style="background-color: #04DBC0; color: #fff;"/>
                                <label ><input type='checkbox' id='input-val2' name="remember" <%= remember.equals("on") ? "checked = 'true'" : ""%>> <span>Remember me</span></label>
                            </form>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div>
                    <div class="col-md-7 padd-r0">
                        <div class="wheel-register-sign marg-lg-b50">
                            <div class="wheel-header">
                                <h5>Sign up Now </h5>
                                <h3>Get <span style="color: #04DBC0;">Registered</span></h3>
                            </div>
                            <form action="../../Demo/register" method="post">
                                <input type="text" placeholder="Username" name="register_username" required="true" value="" autocomplete="new-password">
                                <input type="password" placeholder="Password" name="register_password" required="true" value="" autocomplete="new-password">
                                <input type="password" placeholder="Confirm Password" name="cf_password" required="true">
                                <input type="text" placeholder="Fullname" name="fullname" required="true">
                                <input type="text" placeholder="Email" name="email" required="true">
                                <input type="text" placeholder="Address" name="address" required="true">
                                <input type="text" placeholder="City" name="city" required="true">
                                <input type="number" placeholder="Phone" name="phone" required="true">
                                <div>
                                    Role: 
                                    <select name="type">
                                        <option value="render">Renter</option>
                                        <option value="jobber">Jobber</option>
                                    </select>
                                    <i class="fas fa-chevron-down"></i>
                                </div>
                                <br>
                                <input type="submit" value="Sign up"style="background-color: #04DBC0; color: #fff;"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
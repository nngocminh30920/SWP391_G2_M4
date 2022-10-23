<%@page import="dao.AccountDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Account"%>
<%@page import="model.Order"%>
<%@page import="dao.OrderDAO"%>
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
        <c:if test="${sessionScope.user == null}">
            <% request.setAttribute("error", "UNAUTHORIZED!");%>
            <% request.setAttribute("mess", "Sign in to jobber account");%>
            <% request.setAttribute("href", "../../Demo/pages/login.jsp");%>
            <% request.getRequestDispatcher("/pages/error.jsp").forward(request, response);%>
        </c:if>
        <%@include file="nav.jsp" %>
        <div style="background-image: url('../../Demo/assets/image/bgOwnerRegister.jpg'); 
             background-repeat: no-repeat; background-size: 100% 100%;">
            <br><br><br><br>
            <div class="standard_wrapper">
                <div class="page_content_wrapper" style="margin:auto;width:60%">
                    <form action="../../Demo/add" method="post" encType="multipart/form-data">
                        <c:if test="${sessionScope.user.type == 3}">
                            <%AccountDAO adb = new AccountDAO();%>
                            <%request.setAttribute("listOwner", adb.getAccountsByType(2));%>
                            <div>
                                <br><label style="color: #fff; font-size: 18px;" >Brand</label>
                                <span>
                                    <select name="owner">
                                        <c:forEach items="${requestScope.listOwner}" var="owner">
                                            <option value="${owner.username}">${owner.fullname}</option>
                                        </c:forEach> 
                                    </select>
                                </span> 
                            </div>
                        </c:if>
                        <div >
                            <br><label style="color: #fff; font-size: 18px;" >Brand</label>
                            <span>
                                <input id="brand" type="text" name="brand" class="input1" placeholder="Brand*" required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Model</label>
                            <span>
                                <input id="model" type="text" name="model" class="input1" placeholder="Model*"required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Style</label>
                            <span>
                                <input id="type" type="text" name="type" class="input1" placeholder="Coupe/Sedan/SUV,..."required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Tranmission</label>
                            <span>
                                <input id="tranmission" type="text" name="tranmission" class="input1" placeholder="(Manual/Automatic)" required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Seats</label>
                            <span >
                                <input id="seat" type="number" name="seat" class="input1" placeholder="Seats*"required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Doors</label>
                            <span>
                                <input id="door" type="number" name="door" class="input1" placeholder="Doors*"required>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Price</label>
                            <span class="wpcf7-form-control-wrap " >
                                <input id="price" type="number" name="price" class="input1" placeholder="Price Per Day"required>
                            </span> 
                        </div>
                        <div style="width: 556px;">
                            <br><label style="color: #fff; font-size: 18px;" >Avatar of the car</label>
                            <span style="background-color: #fff;padding: 10px;border-radius: 5px;; ">
                                <input id="image" type="file" name="image" class="input1" required onchange="checkFile()">
                            </span> 
                        </div>
                        <div style="width: 556px;">
                            <br><label style="color: #fff; font-size: 18px;" >Detailed image of the car </label>
                            <span style="background-color: #fff;padding: 10px;border-radius: 5px;; ">
                                <input id="image1" type="file" name="image" class="input1" required onchange="checkFile()" multiple>
                            </span> 
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Overview</label>
                            <span> 
                                <textarea id="overview" name="overview" cols="40" rows="5" class="input1" placeholder="If there is no description, write 'None'*" required></textarea>
                            </span>
                        </div>
                        <div>
                            <br><label style="color: #fff; font-size: 18px;" >Engine, Transmission, and Performance</label>
                            <span><textarea id="description" name="description" cols="40" rows="5" class="input1" placeholder="If there is no description, write 'None'*" required></textarea></span>
                        </div>
                        <div>
                            <input type="submit" class="submit-button" value="Send">
                        </div>
                        <script>
                            function checkFile() {
                                var filename = document.getElementById('image').value;
                                var extension = filename.substr(filename.lastIndexOf(".") + 1);
                                if (!(extension === "jpg" || extension === "png")) {
                                    alert("You can only select files with 'JPG' or 'PNG' extension");
                                    document.getElementById('image').value = '';
                                }
                            }
                        </script>
                        <br>
                    </form>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body>
</html>
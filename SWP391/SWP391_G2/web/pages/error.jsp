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
        <div id="wrapper" class="hasbg transparent">
            <%@include file="nav.jsp" %>
            <div class="inner">
                <br><br><br><br><br><br><br><br>
                <h1  style="color: red; text-align: center; margin-top: 200px;">${requestScope.error}</h1>     
                <button class="button" style="width: 270px; margin-left: 43%;"><a href="${requestScope.href}" style="color: #fff;">${requestScope.mess}</a></button>
                <img src="${requestScope.image}">
                <br><br><br><br><br><br><br><br><br>
            </div>
            <%@include file="footer.jsp" %>
        </div>
    </body>
</html>
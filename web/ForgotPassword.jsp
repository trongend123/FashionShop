<%-- 
    Document   : ForgotPassword
    Created on : Feb 16, 2023, 11:02:22 PM
    Author     : laptop 368
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <link rel="stylesheet" href="CSS/login.css">
        <link rel="stylesheet" href="CSS/HomePage.css">
        <title>Login</title>
    </head>

    <body>

        <%@include file="Header.jsp" %>
        <div class="main">

            <div class="main-image">
                <div class="main-image-content">
                    <img src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_706,c_limit/c471e012-308c-4124-8d79-1530f5df5e2b/nike-just-do-it.png"
                         alt="">
                </div>
            </div>


            <div class="main-log">



                <form id="form" action="ForgotPasswordServlet" method="POST">

                    <div class="main-log-title">
                        <p>Forgot Password By Email</p>
                    </div>

                    <div class="main-log-info">
                        <label for="usernameId">User Name</label>
                        <p><input type="text" id="usernameId" name="usernameName"
                                  placeholder="Enter User Name or Phone Number">
                        </p>
                    </div>

                    <div class="submit">
                        <button type="submit">Reset Password</button>
                    </div>


                    <div class="error">
                        <p>${result}</p>
                    </div>

                </form>
            </div>



        </div>

        <%@include file="Footer.jsp"%>


    </body>

</html>

<%-- 
Document   : SignUp
Created on : Jan 12, 2023, 11:55:22 AM
Author     : ASUS
--%>
<%@taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 


        <!--        CSS-->
        <link rel="stylesheet" href="CSS/SignUp.css">
        <link rel="stylesheet" href="CSS/HomePage.css">
        <title>Sign Up</title>
    </head>

    <body>

        <%@include file="Header.jsp"%>

        <div class="main">

            <div class="main-image">
                <div class="main-image-content">
                    <img src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_706,c_limit/1b8b707e-0094-4414-92f3-7620bf2173cf/nike-just-do-it.jpg"
                         alt="">
                </div>
            </div>


            <div class="main-log">



                <form id="form" action="signUp" method="GET">

                    <div class="main-log-title">
                        <p>SIGN UP</p>
                    </div>

                    <div class="main-log-info">
                        <label for="usernameId">User Name</label>
                        <p><input type="text" id="usernameId" name="usernameName" placeholder="Enter User Name">
                        </p>
                    </div>


                    <div class="main-log-info">
                        <label for="passwordId">Pass Word</label>
                        <p><input type="password" id="passwordId" name="passwordName" placeholder="Enter Pass Word"></p>
                    </div>

                    <div class="main-log-info">
                        <label for="emailId">Email</label>
                        <p><input type="email" id="emailId" name="emailName" placeholder="Enter Email">
                        </p>
                    </div>

                    <div class="main-log-info">
                        <label for="usernameId">Phone</label>
                        <p><input type="text" id="phoneId" name="phoneName" placeholder="+84 ">
                        </p>
                    </div>


                    <div class="submit">
                        <br> <br>
                        <button type="submit">Sign Up</button>
                    </div>


                </form>
            </div>
        </div>

        <%@include file="Footer.jsp"%>

    </body>

</html>

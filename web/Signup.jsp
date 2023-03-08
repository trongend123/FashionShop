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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--        CSS-->
        <link rel="stylesheet" href="CSS/SignUp.css">
        <link rel="stylesheet" href="CSS/HomePage.css">

        <!--        Jquery-->

        <script src="https://code.jquery.com/jquery-3.6.3.js"
        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

        <!--        CDN Axios-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js"
                integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <!--        JS-->
        <script src="JS/SignUp.js" defer></script>
        <script src="JS/HomePage.js" defer></script>


        <title>Sign Up</title>
    </head>

    <body>

        <%@include file="Header.jsp" %>

        <div class="main">

            <div class="main-image">
                <div class="main-image-content">
                    <img src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_706,c_limit/1b8b707e-0094-4414-92f3-7620bf2173cf/nike-just-do-it.jpg"
                         alt="">
                </div>
            </div>


            <div class="main-log">


                <div>
                    <form id="signUpForm" action="signUp" method="POST">

                        <table class="table-signUp">
                            <tr>
                                <td> <label for="nameId">Name</label></td>
                                <td> <label for="UserNameId">User Name</label></td>
                            </tr>

                            <tr>
                                <td> <input type="text" id="nameId" name="nameName" placeholder="Enter Your Name"></td>
                                <td> <input type="text" id="userNameId" name="userNameName" placeholder="Enter User Name">
                                </td>
                            </tr>

                            <tr class="textDander">
                                <td id="textDanger-name"> </td>
                                <td id="textDanger-userName"> </td>
                            </tr>

                            <tr>
                                <td> <label for="passWordId">Pass Word</label></td>
                                <td> <label for="rePassWordId">Re Pass Word</label></td>
                            </tr>

                            <tr>
                                <td> <input type="password" id="passwordId" name="passwordName"
                                            placeholder="Enter Pass Word">
                                </td>
                                <td><input type="password" id="rePassWordId" name="rePassWordName"
                                           placeholder="Re Enter Pass Word"></td>
                            </tr>

                            <tr class="textDander">
                                <td id="textDanger-passWord"> </td>
                                <td id="textDanger-rePassWord"> </td>
                            </tr>
                            <tr>
                                <td> <label for="emailId">Email</label></td>
                                <td> <label for="phoneId">Phone Number</label></td>
                            </tr>

                            <tr>
                                <td> <input type="email" id="emailId" name="emailName" placeholder="Enter Your Email"></td>
                                <td> <input type="text" id="phoneId" name="phoneName" placeholder="+84 "></td>
                            </tr>

                            <tr class="textDander">
                                <td id="textDanger-email"> </td>
                                <td id="textDanger-phone"> </td>
                            </tr>

                            <tr>
                                <td> <label for="cityId">City</label></td>
                                <td> <label for="districtId">District</label></td>
                            </tr>

                            <tr>
                                <td> <select name="cityName" id="cityId">
                                    </select>
                                </td>
                                <td> <select name="districtName" id="districtId">
                                        <option value="">Chọn Quận</option>
                                    </select> 
                                </td>
                            </tr>

                            <tr class="textDander">
                                <td id="textDanger-city"> </td>
                                <td id="textDanger-district"> </td>
                            </tr>


                            <tr>
                                <td> <label for="addressDetailsId">Address Details</label></td>
                                <td><input type="text" id="addressDetailsId" name="addressDetailsName"
                                           placeholder="Enter Address Details"></td>
                            </tr>


                            <tr>
                            <tr class="textDander">
                                <td id="textDanger-email"> </td>
                                <td id="textDanger-addressDetails"> </td>
                            </tr>
                            </tr>

                        </table>
                        <input type="hidden" id="city" name="city">
                        <input type="hidden" id="district" name="district">
                    </form>

                    <div class="buttonSubmit">
                        <button id="submit-btnSignUp">Sign Up</button>
                    </div>
                </div>



            </div>
        </div>

        <%@include file="Footer.jsp" %>

    </body>

</html>
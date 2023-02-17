<%-- 
    Document   : ChangePassword
    Created on : Feb 16, 2023, 11:08:59 PM
    Author     : laptop 368
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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



                <form id="form" action="ChangePasswordServlet" method="POST">

                    <div class="main-log-title">
                        <p>Change Password</p>
                    </div>

                    <div class="main-log-info">
                        <label for="usernameId">User Name</label>
                        <p><input type="text" id="usernameId" name="usernameName"
                                  placeholder="Enter User Name or Phone Number">
                        </p>
                    </div>


                    <div class="main-log-info">
                        <label for="passwordId"> Old Pass Word</label>
                        <p><input type="password" id="passwordId" name="oldPass" placeholder="Enter Pass Word"></p>
                    </div>
                    
                    <div class="main-log-info">
                        <label for="passwordId"> New Pass Word</label>
                        <p><input type="password" id="passwordId" name="newPass" placeholder="Enter Pass Word"></p>
                    </div>
                    
                    <div class="main-log-info">
                        <label for="passwordId"> Confirm Pass Word</label>
                        <p><input type="password" id="passwordId" name="confirmPass" placeholder="Enter Pass Word"></p>
                    </div>


                    
                    <div class="submit">
                        <button type="submit">Change</button>
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

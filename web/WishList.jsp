<%-- 
    Document   : WishList
    Created on : Mar 1, 2023, 10:55:27 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--            CSS -->
        <link rel="stylesheet" href="CSS/UserProfile.css">
        <link rel="stylesheet" href="CSS/HomePage.css">

        <!--        JS-->
        <script src="JS/UserProfile.js" defer></script>
        <script src="JS/HomePage.js" defer></script>

        <!--        JQuery-->
        <script src="https://code.jquery.com/jquery-3.6.3.js"
        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">

        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        <script src="Bootstrap/jquery/dist/jquery.min.js"></script>
        <script src="Bootstrap/popper.js/dist/popper.min.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css"/>
        <title>Wish List</title>
    </head>
    <body>
        <%@include file="Header.jsp" %>

        <div class="userProfile">

            <div class="user-profile-left">

                <div class="user-profile-left-img">
                    <img src="data:image/jpeg;base64,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"
                         alt="">
                </div>

                <div class="user-profile-left-option">
                    <p><Button onclick="location.href = 'editUserProfile?userId=${sessionScope.account.getUserId()}'"> Profile </Button></p >
                    <p><Button onclick="location.href = 'changePassServlet?userId=${sessionScope.account.getUserId()}'">Account</Button></p>
                    <p><Button>History Orders</Button></p>
                    <input type="hidden" value="${sessionScope.account.getUserId()}" id="sessionUserId">
                </div>

            </div>



            <div class="user-profile-right">

                <c:if test="${empty wishList}">
                    <h2>Chưa có sản phẩm nào trong wish list của bạn</h2>
                </c:if>


                <div class="product">
                    <c:forEach items="${wishList}" var="c">
                        <div class="product-item">
                            <div class="product-item-img">
                                <a href="product?productId=${c.getProductId()}&userId=${sessionScope.account.getUserId()}"><img src="${c.getImg()}" alt=""> </a> 
                            </div>

                            <div class="product-item-name">
                                <p>${c.getProductnName()}</p>
                            </div>

                            <div class="product-item-price">
                                <p>${c.getPrice()}</p>
                            </div>
                            <a href="wishList?userId=${sessionScope.account.getUserId()}&productId=${c.getProductId()}&option=deleteInWishPage">Delete</a>
                        </div>
                    </c:forEach>
                </div>

            </div>

        </div>

        <%@include file="Footer.jsp" %>

    </body>
</html>

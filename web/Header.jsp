<%-- 
    Document   : Header
    Created on : Jan 12, 2023, 12:07:10 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- NAV-BAR -->
<div class="navBar">

    <div class="navBar-logo">

        <div>
            <a href="setUpHomePage"><img src="https://www.logoground.com/uploads/201679392016-09-124907954Mens-Fashion-Shopping-Logo.jpg" alt=""></a>
        </div>

    </div>


    <div class="navBar-search">

        <div class=" nvarBar-search-content navbar-search-searchInput">
            <form action="searchProduct">
                <input id="search-input" type="text" name="searchName" placeholder="Search products">
                <i class="fa fa-search">
                </i>
            </form>

        </div>

    </div>



    <c:if test="${sessionScope.account.getUserName() != null}">




        <div class="navBar-left">

            <div class=" nvarBar-left-content ">
                <a href="logOut"> <p><i class="fa-solid fa-right-from-bracket"></i></p></a> 
            </div>

            <c:if test="${sessionScope.account. getRole()>= 5}">

                <div class=" nvarBar-left-content ">
                    <a href="editUserProfile?userId=${sessionScope.account.getUserId()}"> <p><i class="fas fa-user"></i></p></a> 
                </div>
            </c:if>

            <c:if test="${sessionScope.account.getRole()!=5}">

                <div class=" nvarBar-left-content ">
                    <a href="editUserProfile?userId=${sessionScope.account.getUserId()}"> <p><i class="fa-solid fa-box-open"></i></p></a> 
                </div>

            </c:if>


            <c:if test="${sessionScope.account. getRole()>= 5}">

                <div class=" nvarBar-left-content navBar-left-cart">
                    <a href="ViewCart">  <p><i class="fa-solid fa-cart-shopping"></i> </p></a>
                </div>

            </c:if>


        </div>
    </c:if>


    <c:if test="${sessionScope.account.getUserName() == null}">
        <div class="navBar-left">

            <div class=" nvarBar-left-content navBar-left-login h">
                <a href="Login.jsp"> <p> LOG IN </p></a> 
            </div>

            <div class=" nvarBar-left-content navBar-left-sigUp">
                <a href="Signup.jsp"> <p> SIGN UP </p></a> 
            </div>

        </div>
    </c:if>

</div>

<div class="category">

    <ul class="categoryName">
        <c:forEach items="${listCategory}" var="c">
            <li class="categoryName-category"><a href="category?categoryId=${c.getCategoryId()}">${c.getCategoryName()}</a></li>
            </c:forEach>
    </ul>

</div>







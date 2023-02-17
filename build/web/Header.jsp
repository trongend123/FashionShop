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
            <a href="setUpHomePage"><img src="https://scontent.xx.fbcdn.net/v/t1.15752-9/291615425_1186048598852675_1348886276410323908_n.png?stp=dst-png_p206x206&_nc_cat=110&ccb=1-7&_nc_sid=aee45a&_nc_ohc=X0mrxHXzL_QAX91Jpid&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdRz-FAS6l4_SxG18sT7j5vf29-ukLWWZ820rqbFCn_bHA&oe=63E5E2DE"
                                         alt=""></a>
        </div>

    </div>


    <div class="navBar-search">

        <div class=" nvarBar-search-content navbar-search-searchInput">
            <input id="search-input" type="text" name="searchName" placeholder="Search products">
            <i class="fa fa-search">
            </i>
        </div>

    </div>



    <c:if test="${sessionScope.account.getUserName() != null}">


        <c:if test="${sessionScope.account.getRole()!=5 and sessionScope.account.getRole() ne null}">
            <a href="manage?aid=1">Ha Noi</a>
            <a href="manage?aid=2">Da Nang</a>
            <a href="manage?aid=3">TP HCM</a>
            <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
                <span class="caret"></span></button>
                 <ul class="dropdown-menu">
                 <li><a href="vieworder?aid=1">Ha Noi</a></li>
                 <li><a href="vieworder?aid=2">Da Nang</a></li>
                 <li><a href="vieworder?aid=3">TP HCM</a></li>
                 </ul>
            </div>
        </c:if>

        <div class="navBar-left">

            <div class=" nvarBar-left-content ">
                <a href="logOut"> <p><i class="fa-solid fa-right-from-bracket"></i></p></a> 
            </div>

            <c:if test="${sessionScope.account. getRole()>= 5}">

                <div class=" nvarBar-left-content ">
                    <a href="Login.jsp"> <p><i class="fas fa-user"></i></p></a> 
                </div>

            </c:if>

            <c:if test="${sessionScope.account. getRole()== 1}">

                <div class=" nvarBar-left-content ">
                    <p><i class="fa-solid fa-store"></i></p>
                </div>

            </c:if>


            <c:if test="${sessionScope.account.getRole() >1 && sessionScope.account.getRole() <5}">

                <div class=" nvarBar-left-content ">
                    <a href="ViewCart"> <p><i class="fa-solid fa-box-open"></i></p></a> 
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







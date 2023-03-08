<%-- 
    Document   : SearchProduct
    Created on : Feb 15, 2023, 7:59:28 AM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--        CSS-->
        <link rel="stylesheet" href="CSS/SearchProduct.css">
        <link rel="stylesheet" href="CSS/HomePage.css">

        <!--        FONT AWESOME-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css">


        <!--        JQuery-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">

        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>

        <!--        JS-->
        <script src="JS/SearchProducts.js" defer></script>
        <script src="JS/HomePage.js" defer></script>
        <script src="Bootstrap/jquery/dist/jquery.min.js"></script>
        <script src="Bootstrap/popper.js/dist/popper.min.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css"/>

        <title>Search Product</title>
    </head>

    <body>

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


        <div class="body-searchProduct">

            <div class="body-searchProduct-left">

                <div class="filTer">
                    <p class="filterPrice-title">Price</p>

                    <input class="filTerPrice" id="inputPrice-search-min"  type="text" placeholder="From">

                    <input class="filTerPrice" id="inputPrice-search-max"  type="text" placeholder="To">

                    <button id="buttonFilter">Lọc</button>

                    <p class="textDanger-productPrice-search"></p>
                    <br>
                </div>


                <div class="productSearch-listCategory">


                    <c:forEach items="${listCategory}" var="c">
                        <div class="productSearch-listCategory-categoryName"><a href="category?categoryId=${c.getCategoryId()}">${c.getCategoryName()}</a></div>
                        </c:forEach>

                </div>
            </div>


            <div class="body-searchProduct-product">

                <div class="body-searchProduct-buttonFilter">
                    <button id="btn-new-searchId">Mới nhất</button>
                </div>

                <div class="product" id="box-product-search">
                    <c:forEach items="${ listProductInSearch}" var="c">
                        <div class="product-item">
                            <div class="product-item-img">
                                <a href="product?productId=${c.getProductId()}"><img src="${c.getImg()}" alt=""> </a> 
                            </div>

                            <div class="product-item-name">
                                <p>${c.getProductnName()}</p>
                            </div>

                            <div class="product-item-price">
                                <p>${c.getPrice()}</p>
                            </div>
                        </div>
                    </c:forEach>

                </div>
            </div>




    </body>

</html>
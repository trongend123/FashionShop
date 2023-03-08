<%-- 
    Document   : AllProduct
    Created on : Jan 15, 2023, 3:18:35 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--            CSS -->
        <link rel="stylesheet" href="CSS/HomePage.css">
        <link rel="stylesheet" href="CSS/AllProduct.css">

        <!--          JS -->
        <script src="JS/AllProduct.js" defer></script>
        <script src="JS/HomePage.js" defer></script>

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--        Jquery-->
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


        <title> All Product </title>

    </head>


    <body>


        <%@include file="Header.jsp" %>

        <div class="cateogryName-AllProduct">

            <span class="cateogryName-AllProduct-category">
                <span>${categoryName.getCategoryName()}</span>
            </span>

        </div>



        <c:forEach items="${products}" var="products">
            <article class="style1">
                <a href="product?productId=${products.productId}" >
                    <span class="image">
                        <img src="${products.getImg()}" alt="" />
                    </span>
                    <h2>${products.getProductnName()}</h2>
                    <p><strong>$${products.getPrice()}</strong></p>
                </a>
            </article>
        </c:forEach>
        <hr>

        <div class="filTer">
            <div>

                <table>

                    <tr>
                        <td> Season </td>
                        <td> Price</td>
                        <td> Gender</td>
                        <td> Size</td>
                    </tr>


                    <tr>
                        <td>
                            <select name="seasonName" id="seasonId" Class="select">
                                <option value="empty">All Season</option>
                                <option value="1">Summer</option>
                                <option value="2">Winter</option>
                            </select>
                        </td>

                        <td>
                            <select name="priceName" id="priceId" Class="select">
                                <option value="empty">Default</option>
                                <option value="asc">Ascending</option>
                                <option value="desc">Descending</option>
                            </select>
                        </td>

                        <td>
                            <select name="genderName" id="genderId" Class="select">
                                <option value="empty">All Gender</option>
                                <option value="male">Man</option>
                                <option value="female">Woman</option>
                            </select>
                        </td>

                        <td>

                            <select name="sizeName" id="sizeId" Class="select">
                                <option value="empty">All size</option>
                                <c:forEach items="${listSizeByCategoryId}" var="c">
                                    <option value="${c.getSize()}">${c.getSize()}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>

                    <tr class="none-to-display">
                        <td rowspan="1" ></td>
                    </tr>

                    <tr class="tr-submitFilter">
                        <td colspan="4">
                            <button id="buttonFilter" value="${categoryIdNumber}"> Fil </button>
                        </td>
                    </tr>

                </table>
            </div>




        </div>



        <div class="product" id="product-box">
            <div class="container">
                <div class="row">
                    <c:forEach items="${listProductByCategoryId}" var="c">
                        <div class="card" style="width: 240px; margin: 20px">
                            <a href="product?productId=${c.getProductId()}&userId=${sessionScope.account.getUserId()}"><img src="${c.getImg()}" class="card-img-top" alt="..."></a>
                            <div class="card-body">
                                <h5 class="card-title">${c.getProductnName()}</h5>
                                <p class="card-text">$${c.getPrice()}</p>
                                <a href="#" class="btn btn-primary">Add to cart</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <%@include file="Footer.jsp" %>

    </body>

</html>




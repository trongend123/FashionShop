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
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css">
        <!--          JS -->
        <script src="JS/AllProduct.js" defer></script>

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--        Jquery-->

        <script src="https://code.jquery.com/jquery-3.6.3.js"
        integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>


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

            <c:forEach items="${listProductByCategoryId}" var="c">
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

        <%@include file="Footer.jsp" %>

    </body>

</html>




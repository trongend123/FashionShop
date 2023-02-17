<%-- 
    Document   : HomePage
    Created on : Jan 11, 2023, 11:30:56 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--        CSS         -->
        <link rel="stylesheet" href="CSS/HomePage.css">
        <title>Home Page</title>
    </head>


    <body>

        <%@include file="Header.jsp" %>

        <!-- VIDEO-BANNER -->


        <div class="banner">
            <div class="banner-content">
                <video src="IMG/Nike. Just Do It. Nike VN.mp4" autoplay="0" loop=""></video>
            </div>
        </div>



        <div class="product-man-woman">

            <div class="product-man item">
                <div>
                    <link rel="stylesheet" href=""><img
                        src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_467,c_limit/cb91797a-6054-4201-8bee-c08700c83e47/nike-just-do-it.png"
                        alt="">
                </div>
            </div>

            <div class="product-woman item">
                <div>
                    <link rel="stylesheet" href=""><img
                        src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_467,c_limit/b47f5049-1b86-4642-b50c-310ce59b5940/nike-just-do-it.png"
                        alt="">
                </div>
            </div>

        </div>




        <div class="new-item">

            <div class="new-item-title">
                <h1>NEW ARRIVALS</h1>
            </div>


            <div class="new-item-content">

                <c:forEach items="${listNewProduct}" var="products">
                    <div class="new-item-item">
                        <div class="new-item-item-img">
                            <a href="product?productId=${products.getProductId()}"><img src="${products.getImg()}" alt=""> </a>             
                        </div>

                        <div class="new-item-item-name">
                            <p>${products.getProductnName()}</p>
                        </div>

                        <div class="new-item-item-price">
                            <p>${products.getPrice()}</p>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>


        <div class="best-seller">

            <div class="best-seller-title">
                <h1>BEST SELLER</h1>
            </div>


            <div class="best-seller-content">


                <div class="best-seller-item">
                    <div class="best-seller-item-img">
                        <img src="" alt="">
                    </div>

                    <div class="best-seller-item-name">
                        <p></p>
                    </div>

                    <div class="best-seller-item-price">
                        <p></p>
                    </div>
                </div>

            </div>


        </div>



        <div class="latest">
            <div class="latest-content">
                <img src="https://static.nike.com/a/images/f_auto/dpr_1.3,cs_srgb/w_1423,c_limit/26deed59-a4a8-4138-9813-a8d3c6cc894e/men-s-shoes-clothing-accessories.jpg"
                     alt="">
            </div>
        </div>


        <%@include file="Footer.jsp" %>


    </body>

</html>

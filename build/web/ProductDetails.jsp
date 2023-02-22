<%-- 
    Document   : ProductDetails
    Created on : Feb 3, 2023, 8:01:41 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css">

        <!--        CSS-->     
        <link rel="stylesheet" href="CSS/Product.css">
        <link rel="stylesheet" href="CSS/HomePage.css">
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css">

        <!--          JS -->
        <script src="JS/ProductsDetails.js" defer></script>

        <title>${Product.getProductnName()}</title>
    </head>

    <body>


        <%@include file="Header.jsp" %>

        <div class="main-product">


            <div class="product">

                <div class="produc-img">
                    <img src="${product.getImg()}" alt="">
                </div>

                <div class="product-details">


                    <div class="product-details-name">
                        <h2>${product.getProductnName()}</h2>
                    </div>
                    <hr>
                    <div class="product-details-price">
                        <P>$${product.getPrice()}</P>
                    </div>

                    <div class="product-details-Agent">

                        <form action="product" method="get"> 
                            <input name="productId" value="${param["productId"]}" type="hidden">

                            Chon dai ly 
                            <select id="selectAgent" name="agent" onchange="this.form.submit()">
                                <option   value="0" >None</option>
                                <c:forEach items="${agents}" var="a">
                                    <option value="${a.agentId}" ${param["agent"]==a.agentId?"selected":""}> ${a.agentName}</option>
                                </c:forEach>
                            </select>


                        </form>



                    </div>
                    <form action="AddToCart" method="POST">
                        <div class="product-details-size">

                            <p><span>Size: <span> <select id="selectsize" name="size" onchange="setQuantity()">
                                            <option   value="0" > None</option>
                                            <c:forEach items="${sizesG}" var="size">
                                                <option   value="${size.size}-${size.quantity}"  ${param["size"]==size.size?"selected":""}> ${size.size}</option>
                                            </c:forEach>
                                        </select>
                                        <input name="productId" value="${param["productId"]}" type="hidden">
                                        <input name="selectedAgent" value="${param["agent"]}" type="hidden">
                                        <input name="selectedSize" value="${param["size"]}" type="hidden">
                                    </span></span></p>
                        </div>

                        <div class="product-details-quantity">
                            <p><span>Số lượng</span> <span>  <input type="number" id="selectQuantity" name="quantity" min="1" class="bg-transparent form-control" value="1" pattern="[0-9]+" required> </span></p>
                        </div>

                        <div class="product-details-addToCart">
                            <button type="submit" name="addtocart" class="primary" id="addCart" style="display: none;" value="Add to Cart">Add to cart +</button>
                            <button input type="submit" class="primary" value="Out of Stock"  id="disableCart" style="display: none;" disabled>Out Of Stock</button>                                                    
                            <input type="hidden" name="id" value="${product.getProductId()}">

                        </div>
                    </form>
                    <div class="product-details-description">
                        áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        vãi, k mua thì phí
                    </div>


                </div>

            </div>
        </div>



        <div class="reviewProduct">

            <div class="reviewProduct-input">
                <textarea name="reviewName" id="reviewId" cols="30" rows="10"
                          placeholder="  Put your review here"></textarea>
            </div>


        </div>


        <div class="comment">
            <div class="commentProduct">

                <div class="commentProduct-userName">
                    <p>user name</p>
                    <p>2/3/2023</p>
                </div>

                <div class="commentProduct-comment">
                    <p>hì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí</p>
                </div>

            </div>
            <div class="commentProduct">

                <div class="commentProduct-userName">
                    <p>user name</p>
                    <p>2/3/2023</p>
                </div>

                <div class="commentProduct-comment">
                    <p>hì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo
                        này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                        vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                        thì phí</p>
                </div>

            </div>
        </div>



        <div class="relateProduct-title">
            <h1>Relate Product</h1>
        </div>


        <div class="relateProduct">

            <div class="product-item">
                <div class="product-item-img">
                    <img src="https://bucket.nhanh.vn/store/16762/ps/20221024/CANDLEES_8.jpg" alt="">
                </div>

                <div class="product-item-name">
                    <p>Name</p>
                </div>

                <div class="product-item-price">
                    <p>$100</p>
                </div>
            </div>

            <div class="product-item">
                <div class="product-item-img">
                    <img src="https://bucket.nhanh.vn/store/16762/ps/20221024/CANDLEES_8.jpg" alt="">
                </div>

                <div class="product-item-name">
                    <p>Name</p>
                </div>

                <div class="product-item-price">
                    <p>$100</p>
                </div>
            </div>


            <div class="product-item">
                <div class="product-item-img">
                    <img src="https://bucket.nhanh.vn/store/16762/ps/20221024/CANDLEES_8.jpg" alt="">
                </div>

                <div class="product-item-name">
                    <p>Name</p>
                </div>

                <div class="product-item-price">
                    <p>$100</p>
                </div>
            </div>


            <div class="product-item">
                <div class="product-item-img">
                    <img src="https://bucket.nhanh.vn/store/16762/ps/20221024/CANDLEES_8.jpg" alt="">
                </div>

                <div class="product-item-name">
                    <p>Name</p>
                </div>

                <div class="product-item-price">
                    <p>$100</p>
                </div>
            </div>

        </div>
        <%@include file="Footer.jsp" %>


    </body>
</html>
<script src="Bootstrap/jquery/dist/jquery.min.js"></script>
<script src="Bootstrap/popper.js/dist/popper.min.js"></script>
<script src="Bootstrap/bootstrap/dist/js/bootstrap.js"></script>
<script src="Bootstrap/bootstrap/dist/js/bootstrap.bundle.js"></script>
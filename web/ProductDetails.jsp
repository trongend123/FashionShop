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


        <!--          JS -->
        <script src="JS/ProductsDetails.js" defer></script>

        <!--        JQuery-->
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

        <title>${Product.getProductnName()}</title>
    </head>

    <body>


        <%@include file="Header.jsp" %>

        <div class="container">


            <div class="row">

                <div class="col-5">
                    <img src="${product.getImg()}" style="height:500px" alt="">
                </div>

                <div class="col-7">


                    <div class="product-details-name">
                        <h2>${product.getProductnName()}</h2>
                    </div>
                    <hr>
                    <div class="product-details-price">
                        <P>Giá chỉ từ: $${product.getPrice()}</P>
                    </div>

                    <div class="product-details-Agent">

                        <form action="product" method="get"> 
                            <input type="hidden" name="productId" value="${product.getProductId()}">
                            <input type="hidden" name="userId" value="${sessionScope.account.getUserId()}">


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
                            <p><span>Số lượng</span> <span>  <input type="number" id="selectQuantity" name="quantity" min="1" class="bg-transparent form-control" value="1" pattern="[0-9]+" required style="width:200px"> </span></p>
                        </div>

                        <div class="product-details-addToCart">
                            <button type="submit" name="addtocart" class="primary" id="addCart" style="display: none;" value="Add to Cart">Add to cart +</button>
                            <button input type="submit" class="primary" value="Out of Stock"  id="disableCart" style="display: none;" disabled>Out Of Stock</button>                                                    
                            <input type="hidden" name="id" value="${product.getProductId()}">

                        </div>
                    </form>

                    <c:if test="${sessionScope.account.getUserName() != null}">
                        <c:if test = "${wish ==true }">
                            <a href="wishList?productId=${product.getProductId()}&userId=${sessionScope.account.getUserId()}&option=delete"> 
                                <i class="fa-sharp fa-solid fa-heart" style="color: red;"></i>
                            </a>
                        </c:if>
                        <c:if test = "${wish ==false }">
                            <a href="wishList?productId=${product.getProductId()}&userId=${sessionScope.account.getUserId()}&option=add">
                                <i class="fa-sharp fa-regular fa-heart"></i>
                            </a>
                        </c:if>

                    </c:if>


                </div>

            </div>
        </div>
        <div class="product-details-description">
            <div class="container">
                <div class="row">
                    <div>Description: </div>
                    áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp
                    vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua thì phí áo này đẹp vãi, k mua
                    vãi, k mua thì phí
                </div>
            </div>
        </div>



        <div class="reviewProduct">
            <c:if test="${sessionScope.account.getUserName() != null}">

                <c:if test="${commentList.size()==0}">
                    <h2>Hãy là người đầu tiên bình luận về sản phẩm này </h2>
                    <form method="GET" action="addComment">
                        <div class="reviewProduct-input">                   
                            <input  name="reviewName" id="reviewId"
                                    placeholder="   Put your review here">
                            <input type="hidden" name="productId" value="${product.getProductId()}">
                            <input type="hidden" name="userId" value="${sessionScope.account.getUserId()}">
                        </div>
                    </form>
                </c:if>
                <c:if test="${commentList.size()!=0}">
                    <form method="GET" action="addComment">
                        <div class="reviewProduct-input">                   
                            <input  name="reviewName" id="reviewId"
                                    placeholder="   Put your review here">
                            <input type="hidden" name="productId" value="${product.getProductId()}">
                            <input type="hidden" name="userId" value="${sessionScope.account.getUserId()}">
                        </div>
                    </form>
                </c:if>

            </c:if>

            <c:if test="${sessionScope.account.getUserName() == null}">
                <h2>Vui lòng đăng nhập để bình luận </h2>
            </c:if>



        </div>


        <div class="comment">
            <c:forEach items="${commentList}" var="c">
                <div class="commentProduct">

                    <div class="commentProduct-userName">
                        <p>${c.getUserName()}</p>
                        <p>${c.getDate()} </p>
                    </div>

                    <div class="commentProduct-comment">
                        <p>${c.getContent()}</p>
                    </div>
                </div>
            </c:forEach>
        </div>



        <div class="relateProduct-title">
            <h1>Relate Product</h1>
        </div>

<div class="container">
        <div class="relateProduct">
            
            <c:forEach items="${relateProductList}" var="c">
              
                        <div class="card" style="width: 240px; margin: 10px">
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
        <%@include file="Footer.jsp" %>


    </body>




</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : viewcart
    Created on : Feb 5, 2023, 5:40:24 PM
    Author     : Hoang Phi Hung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--        CSS         -->
        <link rel="stylesheet" href="CSS/Cart.css">
        <link rel="stylesheet" href="CSS/HomePage.css">



        <title> Cart </title>
    </head>

    <body>

        <%@include file="Header.jsp" %>

        <div class="cart-title">

            <h1>Giỏ hàng của bạn</h1>

        </div>


        <c:if test="${empty clist}">
            <div class="cart-title-empty">

                <h1>Giỏ hàng của bạn hiện đang trống </h1>

            </div>
        </c:if>



        <c:if test="${not empty clist}">

            <div class="cart-body">


                <div class="cart-product">

                    <div class="product-title">
                        <h4>Toàn bộ sản phẩm trong giỏ hàng của bạn</h4>
                    </div>

                    <form action="payment" method="POST">

                        <c:forEach var="c" items="${clist}">
                            <hr>
                            <div class="product-content">

                                <div class="product-content-img">

                                    <input type="checkbox" name ="cartId" value="${c.getCartID()}" >

                                    <img src="${c.getImg()}" alt="">

                                </div>

                                <div class="product-content-details">
                                    <div class="product-content-name">
                                        <p>${c.getProductName()}</p>
                                    </div>

                                    <div class="product-content-quantity">

                                        <p>Quantity: 
                                            <c:if test="${c.getQuantity()-1!=0}">
                                                <span><a href="ChangeQuantityCartItem?itemId=${c.cartID}&quantity=${c.getQuantity()-1}"> <i class="fa-solid fa-minus"></i></a></span>
                                                    </c:if>
                                            <input class="inputQuantityCart" type="text" name="" value=${c.quantity}>
                                            <span><a href="ChangeQuantityCartItem?itemId=${c.cartID}&quantity=${c.getQuantity()+1}"> <i class="fa-solid fa-plus"></i> </a></span>
                                        </p>
                                    </div>

                                    <div class="product-content-size">


                                        <p> Size : ${c.getSize()} </p>
                                    </div>


                                    <div class="product-content-agent">


                                        <c:if test="${c.getAgentID()== 1}">
                                            <p> Đại Lý : Hà Nội </p>
                                        </c:if>

                                        <c:if test="${c.getAgentID()== 2}">
                                            <p> Đại Lý : Đà Nẵng </p>
                                        </c:if>


                                        <c:if test="${c.getAgentID()== 3}">
                                            <p> Đại Lý : TP HCM </p>
                                        </c:if>
                                    </div>


                                </div>

                                <div class="product-content-price">
                                    <p>$ ${c.getQuantity() * c.getPrice()}</p>
                                </div>

                                <div class="product-content-delete">
                                    <p><a href="DeleteCartItem?itemId=${c.cartID}"><i class="fa-solid fa-trash"></i></a></p>

                                </div>
                            </div>
                        </c:forEach>

                </div>

            </div>


            <div class="cartPayment">

                <div class="cart-payment-button">

                    <div class="cart-payment-button-shopping">
                        <button>Tiếp tục mua sắm</button>
                    </div>

                    <div class="cart-payment-button-payment">
                        <button type="submit">Đi đến thanh toán</button>
                    </div>

                </div>

            </div>
        </form>
    </c:if>


    <%@include file="Footer.jsp"%>

</body>

</html>

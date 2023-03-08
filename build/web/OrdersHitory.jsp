<%-- 
    Document   : OrdersHitory
    Created on : Mar 2, 2023, 2:33:09 PM
    Author     : ASUS
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--        Front awesome-->
        <link rel="stylesheet" href="F-A/fontawesome-free-6.2.1-web/css/all.css"> 

        <!--            CSS -->
        <link rel="stylesheet" href="CSS/OrdersHistory.css">
        <link rel="stylesheet" href="CSS/HomePage.css">

        <!--        JS-->
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
        <title>Orders History</title>

    </head>
    <body>
        <div class="historyOrder-title">
            <h2>Lịch sử mua hàng của bạn </h2>
        </div>

        <div class="historyOrder-button">


            <div> <Button>Profile</Button></div>
            <div> <Button>Account</Button></div>
            <div> <Button>Wish List</Button></div>


        </div>

        <div class="historyOrder-search">

            <div class="historyOrder-showAll">
                <p><a href="">Show All Orders History</a></p>
            </div>

            <div class="historyOrder-search-input">
                <form action=""><input type="text" name="historyOrderSearchName" id="historyOrderSearchId" placeholder="Search by Product Name, Order Id or Agent Name "> <i class="fa fa-search"></i></form>

            </div>

        </div>


        <div class="historyOrder-tableContent">

            <div>

                <c:forEach items="${ordersHistoryList}" var="o" varStatus="status">

                    <c:if test="${status.index != 0}">
                        <c:if test="${o.getOrderId() != prevOrderId }">
                            <div class="historyOrder-footer">
                                <div id="tableHistoryOrder-total">Tổng: $ ${o.getPayment()}</div>
                                <div><a href=""><span id="tableHistoryOrder-buyAgain">Mua Lại</span> </a></div>
                            </div>
                            <hr>
                        </c:if>


                    </c:if>

                    <table id="tableHistoryOrder">
                        <c:if test="${o.getOrderId() != prevOrderId}">
                            <tr class="tableHistoryOrder-title">
                                <td>Product Name</td>
                                <td>Size</td>
                                <td>Image</td>
                                <td>Price</td>
                                <td>Quantity</td>
                                <td>Agent</td>
                                <td>OrderDate</td>
                                <td>Status</td>
                            </tr>
                        </c:if>

                        <tr>
                            <td>${o.getProductName()}</td>
                            <td>${o.getSize()}</td>
                            <td><img src="${o.getImage()}" alt=""></td>
                            <td> $ ${o.getPrice()} </td>
                            <td>${o.getQuantity()}</td>
                            <td>${o.getAgent()}</td>
                            <td>${o.getOrderDate()}</td>
                            <td>${o.getStatus()}</td>
                        </tr>      

                    </table> 

                    <c:if test="${status.last}">
                        <div class="historyOrder-footer">
                            <div id="tableHistoryOrder-total">Tổng: $ ${o.getPayment()}</div>
                            <div><a href=""><span id="tableHistoryOrder-buyAgain">Mua Lại</span> </a></div>
                        </div>
                        <hr>
                    </c:if>

                    <c:set var="prevOrderId" value="${o.getOrderId()}"/>

                </c:forEach>






            </div>
    </body>
</html>

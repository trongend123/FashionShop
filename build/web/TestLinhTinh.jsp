<%-- 
    Document   : TestLinhTinh
    Created on : Jan 15, 2023, 3:06:27 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <h1>${email}</h1> <br><!-- comment -->
        <h1>${payment}</h1> <br>

        <c:forEach var="c" items="${listCart}">

            <div class="product-content-name">
                <p>${c.getCartID()}</p>
            </div>

            <div class="product-content-name">
                <p>${c.getProductName()}</p>
            </div>

            <div class="product-content-quantity">
                <p>quantity: ${c.getQuantity()}</p>
            </div>

        </c:forEach>




    </body>
</html>

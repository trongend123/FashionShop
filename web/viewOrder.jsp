<%-- 
    Document   : viewOrder
    Created on : Feb 15, 2023, 10:21:37 AM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       
        
        <table border="1px">
            <thead>
                <tr>
                <th>OrderId</th>
                <th>Username</th>
                <th>PhoneNum</th>
                <th>Email</th>
                <th>ProductName</th>
                <th>Quantity</th>
                <th>Image</th>
                <th>Payment</th>
                
                <th>OrderDate</th>
                <th>ShipDate</th>
                <th>ReceiveDate</th>
                <th>Status</th>
                
                
                <td></td>
                <th>deleteOrder</th>
                </tr>
            </thead>
            <tbody>
                <form action="updatestatus" method="post">
                <c:forEach items="${requestScope.olist}" var="o">
                    <tr>
                
                        <td>${o.orderId}</td>
                        <th>${o.username}</th>
                        <th>${o.phoneNumber}</th>
                        <th>${o.email}</th>
                        <th>${o.productName}</th>
                        <th>${o.quantity}</th>
                        <th><img src="${o.img}" width="100px" height="100px" alt="alt"/></th>
                        <th>${o.payment}</th>
                        <th>${o.orderDate}</th>
                        <th>${o.shipDate}</th>
                        <th>${o.receviedDate}</th>
                        
                        <th>
                            ${o.status}
                        </th>
                        
                        <th>
                            
                                 <input type="hidden" name="orderId" value="${o.orderId}">
                                 <input type="hidden" name="aid" value="${param.aid}">
                            
                            <input type="checkbox" name="status${param.aid}" id="deliver" value="Delivered"><!-- comment -->
                            
                            <label for="deliver">Delivered</label><br/>
                            <input type="checkbox" name="status${param.aid}" id="closed" value="Closed"><!-- comment -->
                            
                            <label for="closed">Closed</label>
                            
                        </th>   
                        <th><a href="deleteorder?orderId=${o.orderId}">Delete Order</a></th>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        <input type="submit" value="Save"><!-- comment -->
   </form>
            
    </body>
</html>

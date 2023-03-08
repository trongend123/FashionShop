<%-- 
    Document   : manage
    Created on : Jan 31, 2023, 5:48:16 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <<link rel="stylesheet" href="CSS/manage"/>
        <title>JSP Page</title>
        <script src="Bootstrap/jquery/dist/jquery.min.js"></script>
        <script src="Bootstrap/popper.js/dist/popper.min.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css"/>
    </head>
    <body>
        
        
       
        <table border="1px">
            <h2>Product Management</h2> <a href="#addEmployeeModal"  class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Product</span></a>
            <input type="hidden" name="aid" value="${param.aid}"><!-- comment -->
            <thead>
            <tr>
                <th>ProductID</th>
                <th>ProductName</th>
                <th>Price</th>
                <th>Image</th>
                <th>Season</th>
                <th>Description</th>
                <th>Gender</th>
                <th>Category</th>
                <th>Size</th>
                <th>Quantity</th>
                <td></td>
            </tr>
            </thead>
            
            <tbody>
                <c:forEach items="${requestScope.listP}" var="p">
                    <tr>
                        <td>${p.productId}</td>
                        <td>${p.productnName}</td>
                        <td>${p.price}</td>
                        <td><img src="${p.img}" width="100px" height="100px" alt="alt"/></td>
                        <td>${p.season}</td>
                        <td>${p.descripTion}</td>
                        <td>${p.gender}</td>
                        <td>${p.categoryObject.categoryName}</td>
                        <td>${p.sizeObject.size}</td>
                        <td>${p.sizeObject.quantity}</td>
                        <td> <a href="edit?pid=${p.productId}&aid=${param.aid}"  class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                            <a href="delete?pid=${p.productId}&aid=${param.aid}">Delete</a></td>
                    </tr>
                    </c:forEach>
            </tbody>
        </table>
        
        
            <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="insert" method="post">
                        <input type="hidden" name="aid" value="${param.aid}"><!-- comment -->
                        
                        <div class="modal-header">						
                            <h4 class="modal-title">Add Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input name="pname" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Season</label>
                                <textarea name="season" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Gender</label>
                                <textarea name="gender" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <textarea name="description" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Category</label>
                                <textarea name="category" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Size</label>
                                <textarea name="size" class="form-control" required></textarea>
                            </div>
                            <div class="form-group">
                                <label>Quantity</label>
                                <textarea name="quantity" class="form-control" required></textarea>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
            </div>  
        
    </body>
</html>

<%-- 
    Document   : Payment
    Created on : Feb 10, 2023, 1:30:40 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!--        CSS-->
        <link rel="stylesheet" href="CSS/Payment.css">
        
         <!--        JQuery-->
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">

        <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
        
            <!--       JS-->
        <script src="JS/HomePage.js" defer></script>
        <script src="Bootstrap/jquery/dist/jquery.min.js"></script>
        <script src="Bootstrap/popper.js/dist/popper.min.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.js"></script>
        <script src="Bootstrap/bootstrap/dist/js/bootstrap.bundle.js"></script>
        <link rel="stylesheet" href="Bootstrap/bootstrap/dist/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="Bootstrap/bootstrap-social/bootstrap-social.css"/>
        <title>Payment</title>
    </head>

    <body>



        <main class="main">

            <div class="information">

                <div class="title">
                    <h4>Vận Chuyển </h4>
                </div>

                <form action="submitOrder" method="POST" id="formAddressValue">
                    <div class="information-option">

                        <p><input type="radio" name="addressOptionName" id="another" onclick="hidenDefault();"checked>Địa chỉ khác </p>

                        <p><input type="radio" name="addressOptionName" id="default"  onclick="hidenAnother();"> Địa chỉ mặc định</p>

                    </div>
                </form>


                <form class="formPayment" action="submitOrder" method="POST" id="formAnother">

                    <table class="table">

                        <div class="information-email">
                            <tr class="row">
                                <td><label for="emailId">Email1</label></td>
                                <td> <input type="email" name="emailName" id="emailId" placeholder="Email"></td>
                            </tr>
                        </div>


                        <div class="information-name">
                            <tr>
                                <td> <label for="nameId">Name</label></td>
                                <td> <input type="text" name="nameName" id="nameId" placeholder="Name"></td>

                            </tr>
                        </div>

                        <tr>
                        <div class="information-phone">
                            <td> <label for="phoneId">Phone</label></td>
                            <td> <input type="text" name="phoneName" id="phoneId" placeholder="Phone Number"></td>

                        </div>
                        </tr>


                        <tr>
                        <div class="information-address">
                            <td><label for="detailsAddress">Address</label></td>
                            <td> <input type="text" name="addressName" id="addressName" placeholder=" Address"></td>
                        </div>
                        </tr>

                        <tr>
                        <div class="information-note">
                            <td><label for="noteId">Note</label></td>
                            <td> <input type="text" name="noteName" id="noteId" placeholder=" Note"></td>
                        </div>
                        </tr>


                        <tr>
                        <div class="information-city">
                            <td><label for="cityId">City</label></td>
                            <td><select name="cityName" id="cityId">
                                    <option value="">Ha Noi</option>
                                    <option value="">Son La</option>
                                </select></td>
                        </div>
                        </tr>


                        <tr>
                        <div class="information-distric">
                            <td><label for="districId">DistricT</label></td>
                            <td><select name="districName" id="districId">
                                    <option value="">Ha Noi</option>
                                    <option value="">Son La</option>
                                </select></td>
                        </div>
                        </tr>

                    </table>



                    <div class="button-submit">
                        <button onclick="submitAllForm();">Đặt Hàng</button>
                        <input name="payment" value="${totalPrice}" style="display: none;"> 
                        <c:forEach var="c" items="${listCart}">
                            <input  name="lisrCartId" value="${c.getCartID()}" style="display: none;">  
                        </c:forEach>
                    </div>


                </form>



                <form class="formPayment" action="submitOrder" method="POST" id="formDefault" style="display: none;">



                    <table class="table">

                        <div class="information-email">
                            <tr class="row">
                                <td><label for="emailId">Email</label></td>
                                <td> <input type="email" name="emailName" id="emailId" placeholder="Email" value="${sessionScope.account.getEmail()}" readonly></td>
                            </tr>
                        </div>


                        <div class="information-name">
                            <tr>


                                <td> <label for="nameId">Name</label></td>
                                <td> <input type="text" name="nameName" id="nameId" placeholder="Name" value="${sessionScope.account.getName()} " readonly></td>

                            </tr>
                        </div>

                        <tr>
                        <div class="information-phone">
                            <td> <label for="phoneId">Phone</label></td>
                            <td> <input type="text" name="phoneName" id="phoneId" placeholder="Phone Number" value="${sessionScope.account.getPhoneNumber()}" readonly></td>

                        </div>
                        </tr>


                        <tr>
                        <div class="information-address">
                            <td><label for="detailsAddress">Address</label></td>
                            <td> <input type="text" name="addressName" id="addressName" placeholder=" Address" value="${sessionScope.account.getAddress()}" readonly></td>
                        </div>
                        </tr>

                        <tr>
                        <div class="information-note">
                            <td><label for="noteId">Note</label></td>
                            <td> <input type="text" name="noteName" id="noteId" placeholder=" Note"></td>
                        </div>
                        </tr>

                        <tr>
                        <div class="information-city">
                            <td><label for="cityId">City</label></td>
                            <td><select name="city" id="">
                                    <option value="">${sessionScope.account.getCity()}</option>

                                </select></td>
                        </div>
                        </tr>

                        <tr>
                        <div class="information-distric">
                            <td><label for="districId">Distric</label></td>
                            <td><select name="districId" id="">
                                    <option value="" readonly>${sessionScope.account.getDistrict()}</option>
                                </select></td>
                        </div>
                        </tr>
                    </table>



                    <div class="button-submit">
                        <button onclick="submitAllForm();">Đặt Hàng</button>
                        <input  name="payment" value="${totalPrice}" style="display: none;"> 

                        <c:forEach var="c" items="${listCart}">
                            <input  name="lisrCartId" value="${c.getCartID()}" style="display: none;">  
                        </c:forEach>

                    </div>


                </form>


            </div>



            <div class="product">

                <div class="title">
                    <h4>Đơn Hàng</h4>
                </div>

                <c:forEach var="c" items="${listCart}">
                    <hr>
                    <div class="product-content">

                        <div class="product-content-img">

                            <img src="${c.getImg()}" alt="">
                        </div>

                        <div class="product-content-details">
                            <div class="product-content-name">
                                <p>${c.getProductName()}</p>
                            </div>

                            <div class="product-content-quantity">
                                <p>quantity: ${c.getQuantity()}</p>
                            </div>

                            <div class="product-content-size">
                                <p> size : ${c.getSize()}</p>
                            </div>
                        </div>

                        <div class="product-content-price">
                            <p>${c.getPrice()}</p>
                        </div>

                    </div>
                </c:forEach>

                <hr>

                <div class="payment">
                    <div class="">Total</div>
                    <div class="">${totalQuantity}</div>
                    <div class="">${totalPrice}</div>
                </div>

            </div>

        </main>



        <script>

            function hidenDefault() {
                var x = document.getElementById("formAnother");
                var x2 = document.getElementById("formDefault");
                x2.style.display = "none";
                x.style.display = "block";
            }

            function hidenAnother() {

                var x = document.getElementById("formAnother");
                var x2 = document.getElementById("formDefault");

                x2.style.display = "block";
                x.style.display = "none";
            }

            function submitAllForm() {
                var anotherAddress = document.getElementById("another");
                var defaultAddress = document.getElementById("default");

                  if (anotherAddress.checked) {
                    document.getElementById("formAnother").submit();
                }

                if (defaultAddress.checked) {
                    document.getElementById("formDefault").submit();
                }
            }

        </script>

    </body>

</html>
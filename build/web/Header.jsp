<%-- 
    Document   : Header
    Created on : Jan 12, 2023, 12:07:10 PM
    Author     : ASUS
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!-- NAV-BAR -->
<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: black;">
    <a class="navbar-brand" href="setUpHomePage"><img
            src="https://scontent.xx.fbcdn.net/v/t1.15752-9/291615425_1186048598852675_1348886276410323908_n.png?stp=dst-png_p206x206&_nc_cat=110&ccb=1-7&_nc_sid=aee45a&_nc_ohc=X0mrxHXzL_QAX91Jpid&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdRz-FAS6l4_SxG18sT7j5vf29-ukLWWZ820rqbFCn_bHA&oe=63E5E2DE"
            alt=""></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <div class="navBar-search">

                    <div class=" nvarBar-search-content navbar-search-searchInput">
                        <input id="search-input" type="text" name="searchName" placeholder="Search products">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                            </svg>
                    </div>
            </li>

        </ul>
    </div>
    <div>
        <a href="ChangePassword.jsp"> <p> Change Password </p></a>
    </div>
    <c:if test="${sessionScope.account.getUserName() != null}">
        <c:if test="${sessionScope.account.getRole()!=5 and sessionScope.account.getRole() ne null}">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
                    Agent
                </a>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="manage?aid=1">Ha Noi</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="manage?aid=2">Da Nang</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="manage?aid=3">Sai Gon</a>
                </div>
            </li>
        </c:if>
        <div class="navBar-left">
            <div class=" nvarBar-left-content ">
                <a href="logOut"> <p><i class="fa-solid fa-right-from-bracket"></i></p></a> 
            </div>
            <c:if test="${sessionScope.account. getRole()>= 5}">
                <div class=" nvarBar-left-content ">
                    <a href="Login.jsp"> <p><i class="fas fa-user"></i></p></a> 
                </div>
            </c:if>
            <c:if test="${sessionScope.account. getRole()== 1}">
                <div class=" nvarBar-left-content ">
                    <p><i class="fa-solid fa-store"></i></p>
                </div>
            </c:if>
            <c:if test="${sessionScope.account.getRole() >1 && sessionScope.account.getRole() <5}">
                <div class=" nvarBar-left-content ">
                    <a href="ViewCart"> <p><i class="fa-solid fa-box-open"></i></p></a> 
                </div>
            </c:if>
            <c:if test="${sessionScope.account. getRole()>= 5}">
                <div class=" nvarBar-left-content navBar-left-cart">
                    <a href="ViewCart">  <p><i class="fa-solid fa-cart-shopping"></i> </p></a>
                </div>
            </c:if>
        </div>
    </c:if>
    <c:if test="${sessionScope.account.getUserName() == null}">
        <div class="navBar-left">
            <!-- Button trigger modal -->
            <!--            <div class="modal-dialog modal-dialog-centered">-->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop">
                Login
            </button>
            <!-- Modal -->
            <div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form id="form" action="login" method="POST">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel" style="color: black;">Login your account</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                
                                <div class="main-log-info">
                                    <label for="usernameId" style="color: black;">User Name</label>
                                    <p><input type="text" id="usernameId" name="usernameName"
                                              placeholder="Enter User Name or Phone Number">
                                    </p>
                                </div>
                                <div class="main-log-info">
                                    <label for="passwordId" style="color: black;">Pass Word</label>
                                    <p><input type="password" id="passwordId" name="passwordName" placeholder="Enter Pass Word"></p>
                                </div>
                                <!--                    <div class="remember">
                                                    <p>Remember me <input type="checkbox"> </p>
                                                </div>-->
                                <div>
                                    <a href="ForgotPassword.jsp"> <p> Forgot Password </p></a>
                                </div>
                                <div class="error">
                                    <p>${result}</p>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                <button type="submit" class="btn btn-primary">Login</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <!--            <div class="modal-dialog modal-dialog-centered">-->
            <!-- Button trigger modal -->
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#staticBackdrop2">
                Sign Up
            </button>
            <div class="modal fade" id="staticBackdrop2" data-backdrop="static" data-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form id="form" action="signUp" method="GET"></form>
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel" style="color: black;">Sign Up</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="main-log-info">
                                <label for="usernameId" style="color: black;">User Name</label>
                                <p><input type="text" id="usernameId" name="usernameName" placeholder="Enter User Name">
                                </p>
                            </div>
                            <div class="main-log-info">
                                <label for="passwordId" style="color: black;">Pass Word</label>
                                <p><input type="password" id="passwordId" name="passwordName" placeholder="Enter Pass Word"></p>
                            </div>
                            <div class="main-log-info">
                                <label for="emailId" style="color: black;">Email</label>
                                <p><input type="email" id="emailId" name="emailName" placeholder="Enter Email">
                                </p>
                            </div>
                            <div class="main-log-info">
                                <label for="usernameId" style="color: black;">Phone</label>
                                <p><input type="text" id="phoneId" name="phoneName" placeholder="+84 ">
                                </p>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" class="btn btn-primary">Sign Up</button>
                        </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </c:if>
</div>
</nav>
<div class="container">

    <ul class="row">
        <c:forEach items="${listCategory}" var="c">
            <div class="col-2"
            <a href="category?categoryId=${c.getCategoryId()}">${c.getCategoryName()}</a>
            </div>
            </c:forEach>
    </ul>

</div>






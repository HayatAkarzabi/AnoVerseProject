<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admine</title>
    <%@include file="CSS.jsp"%>
</head>
<body>
    <%@include file="navbar.jsp"%>
    <div class="container ">
        <div class="row p-5 justify-content-center">
            <div class="col-md-3">
                <a href="">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fas fa-plus-square fa-3x"></i><br>
                            <h4>Add Films</h4>
                    </div>
                </div>
                </a>
            </div>

            <div class="col-md-3">
                <a href="">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-video fa-3x"></i><br>
                        <h4>All Films</h4>
                    </div>
                </div>
                </a>
            </div>

            <div class="col-md-3">
                <a href="">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-ticket fa-3x"></i><br>
                        <h4>Sales</h4>
                    </div>
                </div>
                </a>
            </div>
        </div>
        <div class="row p-3 justify-content-center">
            <div class="col-md-3">
                <a href="">
                    <div class="card">
                        <div class="card-body text-center">
                            <i class="fa-solid fa-user-plus fa-3x"></i><br>
                            <h4>Add User</h4>
                        </div>
                    </div>
                </a>
            </div>

            <div class="col-md-3">
                <a href="">
                <div class="card">
                    <div class="card-body text-center">
                        <i class="fa-solid fa-arrow-right-to-bracket fa-3x"></i></i><br>
                        <h4>Logout</h4>
                    </div>
                </div>
                </a>
            </div>
        </div>
    </div>






</body>
</html>

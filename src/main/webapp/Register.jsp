
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Ragister page</title>
    <%@include file="Component/CSS.jsp"%>
</head>
<body>
<%@include file="Component/navbar.jsp"%>
<div class="container p-2">
    <div class="row align-items-center"> <!-- Utilisation de align-items-center pour centrer verticalement -->
        <div class="col-md-6 text-center">  <!-- Ajout de col-md-6 -->
            <img src="Images/logo1.jpeg" class="logo bounce">
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-body">
                    <form action="Register" method="post">
                        <h3 class="text-center">Registration Page</h3>
                        <% String error = (String) request.getAttribute("error"); %>
                        <% if (error != null) { %>
                        <div class="alert alert-danger" role="alert">
                            <%= error %>
                        </div>
                        <% } %>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Confirm Password</label>
                            <input type="password" name="checkInputPassword" class="form-control" id="checkInputPassword1" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

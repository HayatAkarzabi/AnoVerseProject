<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <%@ include file="Component/CSS.jsp" %>
</head>
<body>

<%@ include file="Component/navbar.jsp" %>

<div class="container p-3">
    <div class="row align-items-center">
        <div class="col-md-6 text-center">  <!-- Ajout de col-md-6 -->
            <img src="Images/logo.jpg" class="logo bounce">
        </div>
        <div class="col-md-6 ">
            <div class="card ">
                <div class="card-body">
                    <h3 class="text-center">Login</h3>

                    <!-- Affichage du message d'erreur si les identifiants sont incorrects -->
                    <% String error = (String) request.getAttribute("error"); %>
                    <% if (error != null) { %>
                    <div class="alert alert-danger" role="alert">
                        <%= error %>
                    </div>
                    <% } %>

                    <!-- Affichage du message de succès (si besoin) -->
                    <% String success = (String) request.getAttribute("success"); %>
                    <% if (success != null) { %>
                    <div class="alert alert-success" role="alert">
                        <%= success %>
                    </div>
                    <% } %>

                    <!-- Formulaire de connexion -->
                    <form action="Login" method="post">
                        <div class="form-group">
                            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email" required>
                        </div>

                        <div class="form-group">
                            <input type="password" name="password" class="form-control" id="password" placeholder="Password" required>
                        </div>

                        <div class="text-center">
                            <button type="submit" class="btn btn-primary">Login</button><br>
                            <a href="Register.jsp">Create Account</a>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>

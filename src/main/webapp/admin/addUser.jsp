<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 04/04/2025
  Time: 05:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add User</title>
    <%@include file="CSS.jsp"%>
</head>
<body>

<div class="continer">
    <div class="row">
        <div class="col-md-6 offset-md-4">
            <div class="card">
                <div class="card-body">
                    <form action="../addUser" method="post">
                        <h3 class="text-center">add User</h3>
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
                            <label for="role">Rôle</label>
                            <select name="role" id="role" class="form-control">
                                <option value="">-- Sélectionner un rôle --</option>
                                <option value="admin">admin</option>
                                <option value="client">client</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Confirm Password</label>
                            <input type="password" name="checkInputPassword" class="form-control" id="checkInputPassword1" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">ajouter</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

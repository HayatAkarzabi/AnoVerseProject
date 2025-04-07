<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 05/04/2025
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>add salle</title>
    <%@include file="CSS.jsp"%>
  </head>
  <body>
  <div class="continer">
    <div class="row">
      <div class="col-md-6 offset-md-4">
        <div class="card">
          <div class="card-body">
            <h2 class="text-center">Ajouter Salle</h2>
            <form action="../addSalle" method="post">
              <div class="form-group">
                <label for="Numero">Numero de la salle</label>
                <input type="text" name="numero" id="Numero" class="form-control" placeholder="Numero de la salle" required>
              </div>
              <div class="form-group">
                <label for="Capacite">Capacite de la salle</label>
                <input type="number"  name="capacite" class="form-control" id="Capacite" placeholder="Capacite de la salle" required>
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

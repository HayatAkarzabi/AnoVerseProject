<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List, Metier.Reservation" %>
<%
    List<Reservation> reservations = (List<Reservation>) request.getAttribute("reservations");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Liste des Réservations</title>
</head>
<body>
<h2>Liste des Réservations</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>Film</th>
        <th>Status</th>
        <th>Description</th>
        <th>Location</th>
    </tr>
    <%
        if (reservations != null) {
            for (Reservation r : reservations) {
    %>
    <tr>
        <td><%= r.getId() %></td>
        <td><%= r.getDate() %></td>
        <td><%= r.getFilm() %></td>
        <td><%= r.getStatus() %></td>
        <td><%= r.getDescription() %></td>
        <td><%= r.getLocation() %></td>
    </tr>
    <%
            }
        }
    %>
</table>

<h3>Ajouter une Réservation</h3>
<form action="reservations" method="post">
    Film: <input type="text" name="film" required><br>
    Status: <input type="text" name="status"><br>
    Description: <input type="text" name="description"><br>
    Location: <input type="text" name="location"><br>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>

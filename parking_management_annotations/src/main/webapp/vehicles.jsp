<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Vehicle" %>
<html>
<body>
<h2><%= request.getAttribute("title") %></h2>
<%
    Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
    if (vehicle != null) {
%>
<p><%= vehicle.toString() %></p>
<%
    } else {
        List<Vehicle> list = (List<Vehicle>) request.getAttribute("vehicles");
        if (list != null && !list.isEmpty()) {
%>
<table border="1">
<tr><th>ID</th><th>Placa</th><th>Cilindraje</th><th>Combustible</th><th>Número motor</th><th>Marca</th><th>Modelo</th></tr>
<%
            for (Vehicle v : list) {
%>
<tr>
<td><%= v.getId() %></td>
<td><%= v.getPlate() %></td>
<td><%= v.getCylinder() %></td>
<td><%= v.getFuel_type() %></td>
<td><%= v.getMotor_number() %></td>
<td><%= v.getBrand() %></td>
<td><%= v.getSeries() %></td>
</tr>
<%
            }
%>
</table>
<%
        } else {
%>
<p>No hay vehículos.</p>
<%
        }
    }
%>
<a href="index.jsp">Volver</a>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Drivers</title></head>
  <body>
    <h1>Driver List</h1>
    <table border="1" cellpadding="6">
      <tr>
        <th>ID</th><th>Nombre</th><th>Cargo</th>
        <th>Tipo ID</th><th>Número ID</th><th>Vehículos</th>
      </tr>
      <%
        java.util.List<com.example.model.Driver> list =
            (java.util.List<com.example.model.Driver>) request.getAttribute("drivers");
        if (list != null) {
          for (com.example.model.Driver d : list) {
      %>
      <tr>
        <td><%= d.getId() %></td>
        <td><%= d.getName() %></td>
        <td><%= d.getPosition() %></td>
        <td><%= d.getId_type() %></td>
        <td><%= d.getId_number() %></td>
        <td>
          <ul>
          <%
            for (com.example.model.Vehicle v : d.getVehicles()) {
          %>
            <li><%= v.getPlate() %> - <%= v.getBrand() %></li>
          <%
            }
          %>
          </ul>
        </td>
      </tr>
      <%
          }
        }
      %>
    </table>
  </body>
</html>

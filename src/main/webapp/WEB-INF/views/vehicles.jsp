<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Vehicles</title></head>
  <body>
    <h1>Vehicle List</h1>
    <table border="1" cellpadding="6">
      <tr>
        <th>ID</th><th>Placa</th><th> </th><th>Cilindraje</th>
        <th>Combustible</th><th>Núm. Motor</th><th>Serie</th>
      </tr>
      <%
        java.util.List<com.example.model.Vehicle> list =
            (java.util.List<com.example.model.Vehicle>) request.getAttribute("vehicles");
        if (list != null) {
          for (com.example.model.Vehicle v : list) {
      %>
      <tr>
        <td><%= v.getId() %></td>
        <td><%= v.getPlate() %></td>
        <td><%= v.getBrand() %></td>
        <td><%= v.getCylinder() %></td>
        <td><%= v.getFuel_type() %></td>
        <td><%= v.getMotor_number() %></td>
        <td><%= v.getSeries() %></td>
      </tr>
      <%
          }
        }
      %>
    </table>
  </body>
</html>

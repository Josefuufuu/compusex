<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Buscar Vehículos por Cédula</title></head>
  <body>
    <h1>Buscar Vehículos por Cédula</h1>
    <form method="post" action="<%= request.getContextPath() %>/driver/vehicles">
      Cédula: <input type="text" name="ident_number" /><br/>
      <input type="submit" value="Buscar" />
    </form>
    <%
       String msg = (String) request.getAttribute("message");
       if (msg != null) {
    %>
       <p><%= msg %></p>
    <%
       }
       java.util.List<com.example.model.Vehicle> list =
           (java.util.List<com.example.model.Vehicle>) request.getAttribute("vehicles");
       if (list != null && !list.isEmpty()) {
    %>
    <table border="1" cellpadding="6">
      <tr>
        <th>ID</th><th>Placa</th><th>Marca</th><th>Cilindraje</th>
        <th>Combustible</th><th>Núm. Motor</th><th>Serie</th>
      </tr>
      <%
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
      %>
    </table>
    <%
       }
    %>
  </body>
</html>

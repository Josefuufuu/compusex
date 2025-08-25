<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Eliminar Vehículo</title></head>
  <body>
    <h1>Eliminar Vehículo por Placa</h1>
    <form method="post" action="<%= request.getContextPath() %>/vehicle/delete">
      Placa: <input type="text" name="placa" />
      <input type="submit" value="Eliminar" />
    </form>
    <% String msg = (String) request.getAttribute("message");
       if (msg != null) { %>
       <p><%= msg %></p>
    <% } %>
  </body>
</html>

<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Agregar Vehículo</title></head>
  <body>
    <h1>Agregar Vehículo</h1>
    <form method="post" action="<%= request.getContextPath() %>/vehicle/add">
      Placa: <input type="text" name="plate" /><br/>
      Marca: <input type="text" name="brand" /><br/>
      Cilindraje: <input type="text" name="cylinder" /><br/>
      Combustible: <input type="text" name="fuel_type" /><br/>
      Núm. Motor: <input type="text" name="motor_number" /><br/>
      Serie: <input type="text" name="series" /><br/>
      <input type="submit" value="Agregar" />
    </form>
    <% String msg = (String) request.getAttribute("message");
       if (msg != null) { %>
       <p><%= msg %></p>
    <% } %>
  </body>
</html>

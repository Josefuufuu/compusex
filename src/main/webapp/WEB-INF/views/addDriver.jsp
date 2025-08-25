<%@ page contentType="text/html; charset=UTF-8" %>
<html>
  <head><title>Agregar Conductor</title></head>
  <body>
    <h1>Agregar Conductor</h1>
    <form method="post" action="<%= request.getContextPath() %>/driver/add">
      Nombre: <input type="text" name="name" /><br/>
      Cargo: <input type="text" name="position" /><br/>
      Tipo ID: <input type="text" name="id_type" /><br/>
      Número ID: <input type="text" name="id_number" /><br/>
      <input type="submit" value="Agregar" />
    </form>
    <% String msg = (String) request.getAttribute("message");
       if (msg != null) { %>
       <p><%= msg %></p>
    <% } %>
  </body>
</html>

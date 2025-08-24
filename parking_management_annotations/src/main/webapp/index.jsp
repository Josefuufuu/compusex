<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<body>
<h2>Gestión de Estacionamiento</h2>
<ul>
  <li><a href="vehicles">Listar vehículos</a></li>
  <li><a href="drivers">Listar conductores</a></li>
</ul>
<h3>Buscar vehículo por placa</h3>
<form action="vehicles" method="get">
  Placa: <input type="text" name="plate" />
  <input type="submit" value="Buscar" />
</form>
<h3>Eliminar vehículo por placa</h3>
<form action="vehicles" method="post">
  <input type="hidden" name="action" value="delete" />
  Placa: <input type="text" name="plate" />
  <input type="submit" value="Eliminar" />
</form>
<h3>Agregar conductor</h3>
<form action="drivers" method="post">
  <input type="hidden" name="action" value="addDriver" />
  Nombre: <input type="text" name="name" /><br />
  Cargo: <input type="text" name="position" /><br />
  Tipo de identificación: <input type="text" name="id_type" /><br />
  Número de identificación: <input type="text" name="ident_number" /><br />
  <input type="submit" value="Agregar" />
</form>
<h3>Agregar vehículo</h3>
<form action="vehicles" method="post">
  <input type="hidden" name="action" value="addVehicle" />
  Id: <input type="text" name="id" /><br />
  Placa: <input type="text" name="plate" /><br />
  Cilindraje: <input type="text" name="cylinder" /><br />
  Tipo de combustible: <input type="text" name="fuel_type" /><br />
  Número de motor: <input type="text" name="motor_number" /><br />
  Marca: <input type="text" name="brand" /><br />
  Modelo: <input type="text" name="series" /><br />
  Identificación del conductor: <input type="text" name="driver_ident" /><br />
  <input type="submit" value="Agregar" />
</form>
<h3>Consultar vehículos de un conductor</h3>
<form action="drivers" method="get">
  Número de identificación: <input type="text" name="ident_number" />
  <input type="submit" value="Consultar" />
</form>
</body>
</html>

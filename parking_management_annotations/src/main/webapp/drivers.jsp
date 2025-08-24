<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Driver" %>
<%@ page import="com.example.model.Vehicle" %>
<html>
<body>
<h2><%= request.getAttribute("title") %></h2>
<%
    Driver driver = (Driver) request.getAttribute("driver");
    if (driver != null) {
%>
<h3><%= driver.getName() %> (<%= driver.getId_number() %>)</h3>
<ul>
<%
        for (Vehicle v : driver.getVehicles()) {
%>
<li><%= v.toString() %></li>
<%
        }
%>
</ul>
<%
    } else {
        List<Driver> drivers = (List<Driver>) request.getAttribute("drivers");
        if (drivers != null && !drivers.isEmpty()) {
%>
<ul>
<%
            for (Driver d : drivers) {
%>
<li><%= d.getName() %> (<%= d.getId_number() %>)
    <ul>
    <%
                for (Vehicle v : d.getVehicles()) {
    %>
    <li><%= v.getPlate() %> - <%= v.getBrand() %></li>
    <%
                }
    %>
    </ul>
</li>
<%
            }
%>
</ul>
<%
        } else {
%>
<p>No hay conductores.</p>
<%
        }
    }
%>
<a href="index.jsp">Volver</a>
</body>
</html>

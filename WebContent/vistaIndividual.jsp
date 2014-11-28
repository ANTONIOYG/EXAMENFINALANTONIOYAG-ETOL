<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="es.examen.modelo.TarjetaCredito"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista Individual</title>
<style>
table, td, th {
    border: 1px solid blue;
}
table {
    width: 100%;
}
th {
    height:50px;
}
</style>
</head>
<body>
<form action="Procesar" method="get">
 <%  TarjetaCredito tarjetacredito =(TarjetaCredito) request.getAttribute("tarjetacredito"); %>
<table>
    <tr>
      <th>Id</th>
      <th>Numero</th>
      <th>CupoMaximo</th>
      <th>CupoDisponible</th>
      <th>Tipo</th>
      <th>NumeroComprobacion</th>
      <th>contrasehna</th> 
    </tr>
   <tr>
      <td><input type="text" readonly="readonly" name="id" value="<%=tarjetacredito.getId() %>"/></td>  
      <td><input type="text" name="numero" value="<%=tarjetacredito.getNumero() %>"/></td>
      <td><input type="text" name="cupoMaximo" value="<%=tarjetacredito.getCupoMaximo() %>"/></td>
      <td><input type="number" name="cupoDisponible" min="20" max="1000" step="10" value="<%=tarjetacredito.getCupoDisponible() %>"/></td>
      <td><input type="text" name="tipo" value="<%=tarjetacredito.getTipo() %>"/></td>
      <td><input type="text" name="numeroComprobacion" value="<%=tarjetacredito.getNumeroComprobacion() %>"/></td>
      <td><input type="text" name="contrasehna" value="<%=tarjetacredito.getContrasehna() %>"/></td>
  </tr>
</table>
 <input class="botones" type="submit" value="Actualizar" id="actualizar" name="actualizar"/>
</form>
  <a href="index.html"><h1>Ir a inicio</h1></a>
</body>
</html>
      

        
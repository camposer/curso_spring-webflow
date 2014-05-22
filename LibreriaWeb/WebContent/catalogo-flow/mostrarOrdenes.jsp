<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Catálogo</title>
	<style>
		table {
			margin-left: auto;
			margin-right: auto;
		}
		
		h1 {
			text-align: center;
		}
		
		#formulario tr:nth-child(4) td {
			text-align: center;
		}
		
		#btnComprar {
			text-align: center;
		}
	</style>
</head>
<body>
	<h1>Catálogo</h1>
	<form:form action="${flowExecutionUrl}" modelAttribute="ordenForm">
		<table>
			<tr>
				<th>Libro</th>
				<th>Precio</th>
				<th>Cantidad</th>
				<th>Total</th>
			</tr>
			<c:forEach items="${ordenLibros}" var="l">
				<tr>
					<td>${l.nombre}</td>
					<td>${l.precio}</td>
					<td>${l.cantidad}</td>
					<td>${l.total}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="btnComprar">
			<input type="submit" value="Atrás" name="_eventId_atras"/>		
			<input type="submit" value="Agregar" name="_eventId_agregar"/>		
			<input type="submit" value="Comprar" name="_eventId_comprar"/>		
		</div>
	</form:form>
	<hr/>
</body>
</html>
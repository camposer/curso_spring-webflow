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
	<script>
		var cambiarCategoria = function() {
			document.forms[0].submit();
		};

		var agregar = function() {
			document.forms[0].action = "agregar.lib";
			document.forms[0].submit();
		};
		
		var comprar = function() {
			window.location.href = "comprar.lib";
		}
	</script>
</head>
<body>
	<h1>Catálogo</h1>
	<form:form action="catalogo.lib" modelAttribute="ordenForm">
		<table id="formulario">
			<tr>
				<td>Categoría</td>
				<td>
					<form:select path="categoria" 
						items="${categorias}" itemValue="id" itemLabel="nombre" onchange="javascript:cambiarCategoria()">
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Libros</td>
				<td>
					<form:select path="libro" 
						items="${libros}" itemValue="id" itemLabel="nombre">
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td><form:input path="cantidad"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Agregar" onclick="javascript:agregar()"/>
				</td>
		</table>
	</form:form>
	<hr/>
	<table>
		<tr>
			<th>Libro</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Total</th>
		</tr>
		<c:forEach items="${sessionScope.ordenLibros}" var="l">
			<tr>
				<td>${l.nombre}</td>
				<td>${l.precio}</td>
				<td>${l.cantidad}</td>
				<td>${l.total}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="btnComprar">
		<input type="button" value="Comprar" onclick="javascript:comprar()"/>		
	</div>
</body>
</html>







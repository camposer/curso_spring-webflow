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
	<form:form action="agregar.lib" modelAttribute="ordenForm">
		<table id="formulario">
			<tr>
				<td>Categoría</td>
				<td>
					<form:select path="categoria" 
						items="${categorias}" itemValue="id" itemLabel="nombre">
					</form:select>
				</td>
			</tr>
			<tr>
				<td>Libros</td>
				<td>select</td>
			</tr>
			<tr>
				<td>Cantidad</td>
				<td><form:input path="cantidad"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<form:button>Agregar</form:button>
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
		<tr>
			<td>Libro #1</td>
			<td>300</td>
			<td>2</td>
			<td>600</td>
		</tr>
		<tr>
			<td>Libro #2</td>
			<td>250</td>
			<td>2</td>
			<td>500</td>
		</tr>
	</table>
	<div id="btnComprar">
		<input type="button" value="Comprar"/>		
	</div>
</body>
</html>







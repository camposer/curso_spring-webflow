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
	</style>
</head>
<body>
	<h1>Catálogo</h1>
	<form:form action="${flowExecutionUrl}" modelAttribute="ordenForm">
		<table id="formulario">
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
					<input type="submit" value="Atrás" name="_eventId_atras"/>
					<input type="submit" value="Siguiente" name="_eventId_siguiente"/>
				</td>
		</table>
	</form:form>
</body>
</html>
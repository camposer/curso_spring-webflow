<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Mundo</title>
</head>
<body>
	<form:form action="${flowExecutionUrl}">
		Mundo<br/>
		<input type="submit" name="_eventId_atras" value="atrás"/>			
		<input type="submit" name="_eventId_finalizar" value="finalizar"/>
	</form:form>
</body>
</html>
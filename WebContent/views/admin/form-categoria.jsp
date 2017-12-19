<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadstro Categoria</title>
	</head>
	<body>
		<form action=<c:url value="/admin/categoria"/> method="POST">
			Categoria: <input type="text" name="descricao" />
			<button type="submit">Salvar</button>
		</form>
	</body>
</html>
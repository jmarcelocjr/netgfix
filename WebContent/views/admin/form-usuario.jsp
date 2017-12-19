<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadstro Usuario</title>
	</head>
	<body>
		<form action=<c:url value="/admin/usuario"/> method="POST">
			Nome: <input type="text" name="nome" />
			Email: <input type="text" name="email" />
			Senha: <input type="password" name="senha" />
			Tipo acesso: 
			<select name="role">
				<c:forEach var="role" items="${roles}">
					<option value="${role}">${role}</option>
				</c:forEach>
			</select>
			<button type="submit">Salvar</button>
		</form>
	</body>
</html>
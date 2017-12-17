<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Usuários</title>
	</head>
	<body>
		<div>
			<h1>Lista de Usuarios</h1>
			<br/>
			<a href=<c:url value="/usuario" /> >Novo</a>
		</div>
		<br/>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Tipo</th>	
				</tr>
			</thead>
			<tbody>
				<c:forEach var="usuario" items="${usuarios}">
					<tr>
						<td>${usuario.id}</td>
						<td>${usuario.nome}</td>
						<td>${usuario.email}</td>
						<td>${usuario.role}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
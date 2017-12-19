<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista de Categorias</title>
	</head>
	<body>
		<div>
			<h1>Lista de Gifs</h1>
			<br/>
			<a href=<c:url value="/admin/gif" /> >Novo</a>
		</div>
		<br/>
		<table>
			<thead>
				<tr>
					<th>Gif</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="gif" items="${gifs}">
					<tr>
						<td>${gif.titulo}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>
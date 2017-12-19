<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Cadstro Usuario</title>
	</head>
	<body>
		<form action=<c:url value="/admin/gif"/> method="POST" enctype="multipart/form-data" >
			Titulo: <input type="text" name="titulo" />
			Descricao: <input type="text" name="descricao" />
			Categoria: 
			<select name="categoria">
				<c:forEach var="categoria" items="${categorias}">
					<option value="${categoria.descricao}">${categoria.descricao}</option>
				</c:forEach>
			</select>
			Arquivo: <input type="file" name="arquivo" />
			<button type="submit">Salvar</button>
		</form>
	</body>
</html>
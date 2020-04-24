<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="design.css" />
<title>View Users</title>
</head>
<body>
	<h1>Users List</h1>

	<p>
		<a href="adduser">Add New User</a>
	</p>

	<table border="1" style="width: 50%;">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mot de passe</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="u" items="${list}">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getNom()}</td>
				<td>${u.getPrenom()}</td>
				<td>${u.getMp()}</td>
				<td><a href="removeUser?id=${u.getId()}">Delete</a></td>
				<!--td><a href="updateuser?id=${u.getId()}">Update</a></td-->
			</tr>
		</c:forEach>
	</table>
	<br />
</body>
</html>
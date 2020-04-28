<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="../design.css" />
<title>Update User</title>
</head>
<body>
	<form action="updateUser" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id"
					value="${userToUpdate.getId()}" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Nom:</td>
				<td><input type="text" name="name"
					value="${userToUpdate.getNom()}" required /></td>
			</tr>
			<tr>
				<td>Prenom:</td>
				<td><input type="text" name="surname"
					value="${userToUpdate.getPrenom()}" required /></td>
			</tr>
			<tr>
				<td>Mot de passe:</td>
				<td><input type="text" name="password"
					value="${userToUpdate.getMp()}" required /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Go" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
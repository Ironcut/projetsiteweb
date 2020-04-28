<%@ page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../design.css" />
<title>View Users</title>
</head>
<body>
	<h1>-Users List-</h1>

	<p>
		<c:if test="${sessionScope.admin=='true'}">
			<a href="../admin/adduser">Add New User</a>
			
		</c:if>
		<c:if test="${sessionScope.admin=='false'}">
			<p>(Mode public: vous n'avez pas la possibilité de modifier la liste)</p>
			
		</c:if>
	</p>

	<table border="1" style="width: 50%;">
		<tr>
			<th>Id</th>
			<th>Nom</th>
			<th>Prenom</th>
			<th>Mot de passe</th>

			<c:if test="${sessionScope.admin=='true'}">
				<th>Delete</th>
			</c:if>
			<c:if test="${sessionScope.admin=='true'}">
				<th>Update</th>
			</c:if>
		</tr>
		<c:forEach var="u" items="${list}">
			<tr>
				<td>${u.getId()}</td>
				<td>${u.getNom()}</td>
				<td>${u.getPrenom()}</td>
				<td>${u.getMp()}</td>

				<c:if test="${sessionScope.admin=='true' }">
					<td><a href="../admin/removeUser?id=${u.getId()}">Delete</a></td>
					<!--td><a href="updateuser?id=${u.getId()}">Update</a></td-->
				</c:if>
				<c:if test="${sessionScope.admin=='true' }">
					<td><a href="../admin/updateUser?id=${u.getId()}">Update</a></td>
					<!--td><a href="updateuser?id=${u.getId()}">Update</a></td-->
				</c:if>
			</tr>
			
		</c:forEach>
	</table>

	
	
	<p><c:if test="${sessionScope.admin=='true'}">
			<a href="../logout">Log Out</a>
		</c:if>
		<c:if test="${sessionScope.admin=='false'}">
			<a href="../login">Log In</a>
		</c:if>
	</p>
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../design.css" />
<title>Add User</title>
</head>
<body>
<form action="adduser" method="post">
<table>
	<tr>
		<td>Nom:</td>
		<td><input type="text" name="name" value="" required/></td>
	</tr>
	
    <tr>
		<td>Prenom:</td>
		<td><input type="text" name="surname" value="" required/></td>
	</tr>
     
    <tr>
		<td>Mot de passe:</td>
		<td><input type="text" name="password" value="" required/></td>
	</tr>
    
    <tr>
      	<td colspan="2">
     	<input type="submit" value="Go"/>
    	</td>
    </tr>
</table>

</form>
</body>
</html>
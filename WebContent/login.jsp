<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css"/>
</head>
<body>
	<h1>Veuillez vous authentifier</h1>
	<br><br>
	
	
	<form method="post" action="login">
		<label>Login :</label>
		<input name="txtLogin" type="text" autofocus value='${login}'/><br>
		<label>Password :</label>
		<input name="txtPassword" type="password" value='${password}' /><br>
		<button id="btnContent" type="submit">Login</button>
	</form>
</body>
</html>
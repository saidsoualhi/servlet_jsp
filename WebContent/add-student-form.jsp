<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<title>Add new student</title>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
<h1>Add new student</h1>
 <form action="StudentControllerServlet" method="get">
 <input type="hidden" name="command" value="ADD" />
 	<div>
	 	<span>First name</span>
	 	<input type="text" name="firstName">
 	</div>
 	<div>
	 	<span>Last name</span>
	 	<input type="text" name="lastName">
 	</div>
 	<div>
	 	<span>Email name</span>
	 	<input type="text" name="email">
 	</div>
 	<br>
 	<input type="submit" value="valider" class="save">
 </form>
</body>
</html>
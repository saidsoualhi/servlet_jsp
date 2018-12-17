<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-student-style.css">
<title>Update student</title>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>
<h1>Update student</h1>
 <form action="StudentControllerServlet" method="get">
 
 <input type="hidden" name="command" value="UPDATE" />
 
 <input type="" name="studentId" value="${THE_STUDENT.id}" />
 	<div>
	 	<span>First name</span>
	 	<input type="text" name="firstName" value="${THE_STUDENT.firstName}">
 	</div>
 	<div>
	 	<span>Last name</span>
	 	<input type="text" name="lastName" value="${THE_STUDENT.lastName}">
 	</div>
 	<div>
	 	<span>Email name</span>
	 	<input type="text" name="email" value="${THE_STUDENT.email}">
 	</div>
 	<br>
 	<button class="save_btn" type="submit">
 		<a>Update</a>
 	</button>
 </form>
</body>
</html>
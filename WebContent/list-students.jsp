<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Student Tracker App</title>
	
	<link type="text/css" rel="stylesheet" href="css/style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>FooBar University</h2>
		</div>
	</div>

	<div id="container">
	
		<div id="content">
				
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Actions</th>
				</tr>
				
				<button type="button" class="add-student_btn">
					<a onclick="window.location.href='add-student-form.jsp'; return false;" >Add student</a>
				</button>
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
				
					<!-- set up a link for each student -->
					<c:url var="tempLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<!-- set up a link for delete student -->
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					<tr>
						<td> ${tempStudent.firstName} </td>
						<td> ${tempStudent.lastName} </td>
						<td> ${tempStudent.email} </td>
						<td>
							<button  name="updateStudent" class="update-button">
							
							<a href="${tempLink}">update</a></button>
							<br>
							<button  name="deleteStudent" class="delete-button">
							<a href="${deleteLink}" onclick="(!(confirm('Are you sure ?'))) return false">delete</a></button>
						</td>
					</tr>
				
				</c:forEach>
				
			</table>
		
		</div>
	
	</div>
</body>


</html>









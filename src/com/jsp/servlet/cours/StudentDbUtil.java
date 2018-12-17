package com.jsp.servlet.cours;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {

	private DataSource dataSource;

	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	// method return la liste des etudiants
	public List<Student> getStudents() throws Exception {
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student order by last_name";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create new student object
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				// add it to the list of students
				students.add(tempStudent);				
			}
			
			return students;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	// method pour fermer la connexion
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	// method pour ajouter un etudiant
	public void addStudent(Student theNewStudent) throws SQLException {
		// 
		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "insert into student (first_name, last_name, email) values ( ?,?,?)";
			
			// execute query
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theNewStudent.getFirstName());
			myStmt.setString(2, theNewStudent.getLastName());
			myStmt.setString(3, theNewStudent.getemail());
			myStmt.execute();
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}		
	}

	// method pour charger un etudiant
	public Student getStudent(String studentId) throws SQLException {
		Student theStudent = null;
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		int theStudentId;
		try {
			// convert student id to int
			theStudentId = Integer.parseInt(studentId);
			
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "select * from student where id=?";
			
			// execute query
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setInt(1, theStudentId);
			
			// execute statement
			myRs = myStmt.executeQuery();
			
			// retrieve data from result set now
			if (myRs.next()) {
				String firstName = myRs.getString("first_name");
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// use the student ID during construction
				theStudent = new Student(theStudentId, firstName, lastName, email);
			}
			
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}	
		
		return theStudent;
	}

	public void updateStudent(Student theStudent) throws SQLException {
		
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "update student set first_name=?, last_name=?, email=? where id=?";
			
			// execute query
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setString(1, theStudent.getFirstName());
			myStmt.setString(2, theStudent.getLastName());
			myStmt.setString(3, theStudent.getemail());
			myStmt.setInt(4, theStudent.getId());
			myStmt.execute();
			
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}	
	}

	public void deleteStudent(int idStudent) throws SQLException {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		try {
			
			// get a connection
			myConn = dataSource.getConnection();
			
			// create sql statement
			String sql = "delete from student where id=?";
			
			// execute query
			myStmt = myConn.prepareStatement(sql);
			
			// set the param values for the student
			myStmt.setInt(1, idStudent);
			myStmt.execute();
			
			
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, null);
		}	
		
	}

}
















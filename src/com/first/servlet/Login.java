package com.first.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		if (login == null) login = "";
		if (password == null) password = "";
		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("txtLogin");
		String password = request.getParameter("txtPassword");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		
		if (login.equals("user") && password.equals("0000")) {
			request.getRequestDispatcher("/connected.jsp").forward(request, response);
			session.setAttribute("isConnected", true);
		} else {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			session.setAttribute("isConnected", false);
		}
	}

}

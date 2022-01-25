package fr.formation.inti.controller;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private final static Log log = LogFactory.getLog(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// null.equals() "root".equals(null)
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		// mettre une valeur NOT NULL en premier pour equals
		 if ("root".equals(login) && "123456".equals(password)) {
			Writer out = response.getWriter();
			out.append("<html>").append("<head><title>login success</title>")
					.append("<link href=\"css/style.css\" rel=\"stylesheet\">")
					.append("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">   ")
					.append("</head><body>")
					.append("<h1>Hello " + request.getParameter("login") + "</h1>").append("<p>You are connected!</p>")
					.append("<p>Date : " + new Date() + "</p>");

		} else {
			// request.getContextPath() retourne l'URL principale de notre webapp ici : /web01
			response.sendRedirect(request.getContextPath() + "/index.html");
		}

		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

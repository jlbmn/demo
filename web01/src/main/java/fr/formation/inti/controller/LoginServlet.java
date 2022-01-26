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

		HttpSession session = request.getSession();	
		
		String msg = (String) session.getAttribute("msg");
		Date con = (Date) session.getAttribute("dateCo");
		String login = (String) session.getAttribute("login");
		
		if(session == null || login == null ) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		} else { 
			 response.getWriter().append(msg).append("<br> Date : ").append(con.toString())
				.append("<br>Session Id : ").append(session.getId())
				.append("<br>Login : ").append(login);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// null.equals() "root".equals(null)
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();	
		session.setMaxInactiveInterval(60); // 60 secondes
		
		// mettre une valeur NOT NULL en premier pour equals
		 if ("root".equals(login) && "123456".equals(password)) {
			 session.setAttribute("msg", "You are connected!");
			 session.setAttribute("dateCo", new Date());
			 session.setAttribute("login", login);
			 
			Writer out = response.getWriter();
			out.append("<html>").append("<head><title>login success</title>")
					.append("<link href=\"css/style.css\" rel=\"stylesheet\">")
					.append("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">   ")
					.append("</head><body>")
					.append("<h1>Hello " + session.getAttribute("login") + "</h1>").append("<p>You are connected!</p>")
					.append("<p>Date : " + session.getAttribute("dateCo") + "</p>");

		} else {
			// request.getContextPath() retourne l'URL principale de notre webapp ici : /web01
			response.sendRedirect(request.getContextPath() + "/index.jsp");
		}
		
		//doGet(request, response);
	}

}

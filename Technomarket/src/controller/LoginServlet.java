package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(UserDAO.getInstance().validLogin(email, password)){
			User u = UserDAO.getInstance().getAllUsers().get(email);
			HttpSession session = request.getSession();
			session.setAttribute("user", u);
			session.setMaxInactiveInterval(3000);
			session.setAttribute("logged", true);
			//TODO
			response.sendRedirect("index.jsp");
		}
		else{
			//TODO
			response.sendRedirect("errorLogin.html");
		}
	}

}

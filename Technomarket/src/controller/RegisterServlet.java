package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String familyName = request.getParameter("family_name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String birthDate = request.getParameter("birthdate");
	
		DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;
        LocalDate date = LocalDate.parse(birthDate, formatter);
		
		User u = new User(name, familyName, email, password, gender, date, false);
		UserDAO.getInstance().addUser(u);
		//TODO
		response.sendRedirect("uspeshnaRegistraciya.html");
		
	}

}

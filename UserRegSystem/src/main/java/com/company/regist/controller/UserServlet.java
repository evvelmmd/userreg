package com.company.regist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.regist.dao.UserDao;
import com.company.regist.model.User;


@WebServlet("/register")
public class UserServlet extends HttpServlet{
private static final long serialVersionUID=1L;


private UserDao userDao=new UserDao();

public UserServlet() {
	super();
}

protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/userregister3.jsp");
	dispatcher.forward(request, response);
}

protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
String firstName = request.getParameter("firstName");
String lastName = request.getParameter("lastName");
String username = request.getParameter("username");
String password = request.getParameter("password");
String adress = request.getParameter("address");
String contact = request.getParameter("contact");

User u = new User();
u.setFirstName(firstName);
u.setLastName(lastName);
u.setUsername(username);
u.setPassword(password);
u.setAdress(adress);
u.setContact(contact);

try {
	userDao.registerUser(u);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/view/userdetails.jsp");
dispatcher.forward(request, response);
}
}

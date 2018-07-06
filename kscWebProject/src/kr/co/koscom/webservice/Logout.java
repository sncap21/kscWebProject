package kr.co.koscom.webservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		System.out.println("Logout.java : enrty point...");
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("LoginOK")) {
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					System.out.println("Logout.java : Cookie deleted!!!!");
				} else {
					System.out.println("Logout.java : NO targt cookie..... ");
				} 				
			}
		}
		response.sendRedirect("Welcome.html");
	}

}

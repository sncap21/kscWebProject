package kr.co.koscom.webservice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koscom.dao.MemberDAO;
import kr.co.koscom.dao.MemberDAOImpl;
import kr.co.koscom.dto.MemberDTO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberDAO dao = new MemberDAOImpl();
		MemberDTO member = dao.getMember(id);
		
		if (member.getPassword().equals(password)) {
			String cookieName = "LoginOK";
			Cookie cookie = new Cookie(cookieName,"");
			cookie.setPath("/");
			cookie.setMaxAge(-1);

			response.addCookie(cookie);
			System.out.println("Login.java : LoginOK cookie seted.!!");
			
			RequestDispatcher rd = request.getRequestDispatcher("ListMember");
			rd.forward(request, response);
		} else {
			System.out.println("Login.java : Password check failed!!");
			response.sendRedirect("LoginForm.html");
		}
	}
}

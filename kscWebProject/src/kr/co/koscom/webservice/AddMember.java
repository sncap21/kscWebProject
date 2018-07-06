package kr.co.koscom.webservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koscom.dao.MemberDAOImpl;
import kr.co.koscom.dto.MemberDTO;

//import javax.servlet.http.HttpServletResponseWrapper;

/**
 * Servlet implementation class AddMember
 */
@WebServlet("/AddMember")
public class AddMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		MemberDAOImpl dao = new MemberDAOImpl();
		
		System.out.println("BBBBBBBBBBBBBBBBBBBBBBBBB");
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		
		int result = dao.addMember(member);
		System.out.println("result: " + result);
		if (result != 1) {
			System.out.println("Add Member failed");
			response.sendError(500, "Add Member failed\n");
		}
	}
*/	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO member = new MemberDTO();
		MemberDAOImpl dao = new MemberDAOImpl();
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAA");
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		
		int result = dao.addMember(member);
		
		/*
		System.out.println("id : " + request.getParameter("id"));
		System.out.println("name : " + request.getParameter("name"));
		System.out.println("password : " + request.getParameter("password"));
		System.out.println("email : " + request.getParameter("email"));
		System.out.println("result: " + result);
		*/
		if (result != 1) {
			System.out.println("Add Member failed");
			response.sendError(500, "Add Member failed\n");
		}
		response.sendRedirect("ListMember");
		
	}
	
	
}

package kr.co.koscom.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.koscom.dao.MemberDAOImpl;
import kr.co.koscom.dto.MemberDTO;

/**
 * Servlet implementation class ListMember
 */
@WebServlet({ "/ListMember", "/Member" })
public class ListMember extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAOImpl dao = new MemberDAOImpl();
		List<MemberDTO> memberList = dao.getMemberList();
		
		
		request.setAttribute("memberList", memberList);
		RequestDispatcher rd = request.getRequestDispatcher("ListMember.jsp"); //jsp call
		rd.forward(request, response);
	}
*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Login Check
		boolean loginFlag = false;
		String id = null;

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("LoginOK")) {
					loginFlag = true;
					id = cookie.getValue();
					break;
				}
			}	
		}
		System.out.println("ListMember.java : LoginCheck finished.!!");

		if (loginFlag) {
			System.out.println("ListMember.java : LoginOk Cookie exist.!!!");
			
			MemberDAOImpl dao =new MemberDAOImpl();
			List<MemberDTO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
		
			System.out.println("ListMember.java : doGet");
			RequestDispatcher rd = request.getRequestDispatcher("ListMember.jsp"); //jsp call
			rd.forward(request, response);
	    } else {
			System.out.println("ListMember.java : LoginOk Cookie NOT exist.!!!");
	    	response.sendRedirect("LoginForm.html");
	    }

		/*
		String id = request.getParameter("id");
		System.out.println("id:" + id);
		if (id != null) {
			MemberDTO member = dao.getMember(id);
			List<MemberDTO> memberList = new <MemberDTO>ArraysList();
			request.setAttribute("memberList", member);
		} else {
			List<MemberDTO> memberList = dao.getMemberList();
			request.setAttribute("memberList", memberList);
		}
		*/
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAOImpl dao =new MemberDAOImpl();
		List<MemberDTO> memberList = dao.getMemberList();
		
		request.setAttribute("memberList", memberList);
		
		System.out.println("ListMember.java : doPost");
		RequestDispatcher rd = request.getRequestDispatcher("ListMember.jsp"); //jsp call
		rd.forward(request, response);
	}
}

<%@ page import="kr.co.koscom.dto.*" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>List Member</title>
</head>
<body>
<h1> Member List</h1>
<%
	List<MemberDTO> memberList = (List<MemberDTO>)request.getAttribute("memberList");
%>
<table>
	<tr>
		<th> ID </th>
		<th> NAME </th>
		<th> PASSWORD </th>
		<th> EMAIL </th>
	</tr>
<%if( memberList != null) {
	for (MemberDTO member : memberList) {
%>	
	<tr>
		<td> <%=member.getId() %> </td>
		<td> <%=member.getName() %></td>
		<td> <%=member.getPassword() %> </td>
		<td> <%=member.getEmail() %> </td>
	</tr>
<%
	} //end for
} //end if
%>	
</table>
<br>
<br>
<form action = "Logout" method = "post">
	<input type = "submit" value = "LOGOUT">
<form action = "ShowBoard" method = "post">
	<input type = "submit" value = "ShowBoard">
</form>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>

<%  
	//html부분은 필요없어서 지움
	
	// 데이터 받아서
	String name = request.getParameter("name");
	int age = 20;
	// 보내주기
%>
<%=name%>
<%=age%>
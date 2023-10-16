<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>contextExam1.jsp</h1>
	<h2>session에 값을 저장</h2>
	<%
		session.setAttribute("i",10);
	%>
	
	<h2>application에 값 저장</h2>
	<%
		application.setAttribute("i",100);
	%>
	
	<h2>pageContext에 값 저장</h2>
	<%
		pageContext.setAttribute("i",200);
	%>
</body>
</html>
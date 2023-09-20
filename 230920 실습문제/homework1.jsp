<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	
	%>

	<h3>당신의 성적입니다.</h3>
	총점: <%=kor + eng + mat %>
	<br>
	평균: <%=(kor + eng + mat)/3 %>
	
</body>
</html>
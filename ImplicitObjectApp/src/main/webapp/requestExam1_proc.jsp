<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String addr = request.getParameter("addr");
		String[] hobbies = request.getParameterValues("hobby");
	%>
	<ul>
		<li>이름: <%= name  %> </li>
		<li>주소: <%= addr %> </li>
	<%
	if(hobbies != null){
		for(String hobby: hobbies){		
	%>
		<li><%=hobby %></li>
	<%
		}
	}
	%>
	</ul>
</body>
</html>
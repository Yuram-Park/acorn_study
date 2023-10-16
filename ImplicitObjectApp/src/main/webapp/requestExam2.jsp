<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if(request.getMethod().equealsIgnoreCase("get")){
%>
	<form action="requestExam2.jsp" method="post">
		이름 : <input type="text" name="name"/><br><br>
		주소 : <input type="text" name="addr"/><br><br>
		취미 : <br>
		<input type="checkbox" name="hobby" value="등산">등산<br>
		<input type="checkbox" name="hobby" value="독서">독서<br>
		<input type="checkbox" name="hobby" value="여행">여행<br>
		<input type="checkbox" name="hobby" value="낚시">낚시<br>
		<input type="submit" value="전송"/>
	</form>
<%
	} else{
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
	<%
		}
	%>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
		if(id == "" || id == null) {
	%>
		<script>alert("ID 를 입력하세요.")</script>
		<script>location.href="login.jsp"</script>	
	<%
		} else if (pw =="" || pw == null){
	%>
			<script>alert("PW 를 입력하세요.")</script>
			<script>location.href="login.jsp"</script>
	<%
		} else {
	%>
			<script>alert("로그인 되었습니다..")</script>
	<%
			session.setAttribute("id", id);
			session.setAttribute("pw", pw);
	%>
			<script>location.href="index.html"</script>
	<%
		}
	%>
</body>
</html>
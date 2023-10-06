<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="user.UserBean"%>
<%@ page import="user.UserDAO"%>

<!DOCTYPE html>
<html>
<head>
<script>
function goLogin() {
	location.href = "../view/Login.jsp";
}

</script>
<meta charset="UTF-8">
<title>회원가입 처리 JSP</title>
</head>
<body>
	<!-- signup.jsp에서 입력한 정보를 받아 처리 -->
	<%
	// 인코딩
	request.setCharacterEncoding("utf-8");
	%>

	<jsp:useBean id="userBean" class="user.UserBean" />
	<jsp:useBean id="dao" class="user.UserDAO" />
	<jsp:setProperty property="*" name="userBean" />

	<%
	try {
		dao.insertUser(userBean);
	} catch (Exception e) {
		out.println("오류 발생: " + e.getMessage());
		
	}
	%>
	<h1>회원가입 정보를 확인하세요.</h1>
	<h3><%=userBean.getNickname()%>님 가입을 축하드립니다.
	</h3>
	<table>
		<tr>
			<td id="title">아이디</td>
			<td><%=userBean.getId()%></td>
		</tr>

		<tr>
			<td id="title">비밀번호</td>
			<td><%=userBean.getPassword()%></td>
		</tr>

		<tr>
			<td id="title">이메일</td>
			<td><%=userBean.getEmail()%></td>
		</tr>

		<tr>
			<td id="title">이름</td>
			<td><%=userBean.getName()%></td>
		</tr>

		<tr>
			<td id="title">닉네임</td>
			<td><%=userBean.getNickname()%></td>
		</tr>

		<tr>
			<td id="title">생일</td>
			<td><%=userBean.getBirthyy()%>년 <%=userBean.getBirthmm()%>월 <%=userBean.getBirthdd()%>일
			</td>
		</tr>

		<tr>
			<td id="title">성별</td>
			<td><%=userBean.getGender()%></td>
		</tr>
	</table>

	<br>
	<input type="button" value="확인" onclick="goLogin()">
</body>
</html>
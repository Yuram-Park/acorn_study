<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	// 인코딩
	request.setCharacterEncoding("utf-8");
%>
<meta charset="UTF-8">
<title>로그인 화면</title>
<script>
	function checkValue(){
		inputForm = eval("documnet.loginInfo");
		if(!inputForm.id.value){
			alert("아이디를 입력하세요");
			inputForm.id.focus();
			return false;
		}
		if(!inputForm.password.value){
			alert("비밀번호를 입력하세요");
			inputForm.password.focus();
			return false;
		}
	}
	
	// 회원가입 버튼 클릭 시 회원가입 화면으로 이동
	function goSignup() {
		location.href = "Signup.jsp";
	}
</script>
</head>
<body>
	<form name="loginInfo" method="post" action="../proc/LoginProc.jsp" onsubmit="return checkValue()">
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>
		</table>
		<br>
		<input type="submit" value="로그인"/>
		<input type="button" value="회원가입" onclick="goSignup()"/>
	</form>
	
	<%
		String msg=request.getParameter("msg");
	
		if(msg!=null && msg.equals("0")){
			out.println("<br>");
			out.println("<font color='red' size='5'>비밀번호를 확인해주세요.</font>");
		}
		else if(msg!=null && msg.equals("-1")){
			out.println("<br>");
			out.println("<font color='red' size='5'>아이디를 확인해주세요.</font>");
		}
	%>
</body>
</html>
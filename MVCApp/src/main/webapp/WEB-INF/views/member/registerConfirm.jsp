<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>registerConfirm</title>
</head>
<body>
	<h1>회원 가입 확인</h1>
	당신이 입력한 내용은 다음과 같습니다.<br>
	
	<ul>
		<!-- 변수를 가져오는게 아니라 메서드를 가져오는 것임 -->
		<li>아이디: ${member.id} </li>
		<li>패스워드: ${member.pw}</li>
		<li>이메일: ${member.email}</li>
	</ul>
	<form method="post" action="/MVCApp/mem">
		<input type="hidden" name="command" value="COMPLETE"/>
		
		<!-- session에 저장 안하면 보내줘야함 -->
		<!-- <input type="hidden" name="id" value="${id}"/>-->
		
		<input type="submit" value="가입 완료"/> &nbsp;&nbsp;&nbsp;
		<input type="button" value="뒤로"/>
		
	</form>
</body>
</html>
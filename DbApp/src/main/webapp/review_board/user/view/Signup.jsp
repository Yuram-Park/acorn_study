<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
	//필수 정보 입력되었는지 확인
	function checkValue() {
		if (!document.userInfo.id.value) {
			alert("아이디를 입력하세요.");
			return false;
		}

		if (!document.userInfo.password.value) {
			alert("비밀번호를 입력하세요.");
			return false;
		}

		// 비밀번호 동일한지 확인
		if (document.userInfo.password.value != document.userInfo.passwordcheck.value) {
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}

		if (!document.userInfo.email.value) {
			alert("이메일을 입력하세요.");
			return false;
		}

		// 이메일 인증 구현
		//if(!document.userInfo.emailCode.value){
		//	alert("이메일 인증 코드를 입력하세요.");
		//	return false;
		//}

		if (!document.userInfo.name.value) {
			alert("이름을 입력하세요.");
			return false;
		}

		if (!document.userInfo.nickname.value) {
			alert("닉네임을 입력하세요.");
			return false;
		}

		if (!document.userInfo.birthyy.value) {
			alert("연도를 입력하세요.");
			return false;
		}

		if (!document.userInfo.birthdd.value) {
			alert("날짜를 입력하세요.");
			return false;
		}
	}

	// 취소 버튼 클릭 시 로그인 화면으로 이동
	function goLogin() {
		location.href = "Login.jsp";
	}

	
</script>
<meta charset="UTF-8">
<title>회원가입 화면</title>

</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<!-- 입력한 값 전송 -->
	<form method="post" action="../proc/SignupProc.jsp" name="userInfo"
		onsubmit="return checkValue()">
		<table>
			<tr>
				<td id="title">아이디</td>
				<td>
				<input type="text" name="id"> 
				<input type="button"
					value="중복확인">
					</td>
			</tr>

			<tr>
				<td id="title">비밀번호</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td id="title">비밀번호 확인</td>
				<td><input type="password" name="passwordcheck"></td>
			</tr>

			<tr>
				<td id="title">이메일 등록</td>
				<td><input type="text" name="email"> <input
					type="button" value="인증 요청"></td>
			</tr>

			<tr>
				<td id="title">인증 코드</td>
				<td><input type="text" name="emailCode"></td>
			</tr>

			<tr>
				<td id="title">이름</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td id="title">닉네임</td>
				<td><input type="text" name="nickname"> <input
					type="button" value="중복확인"></td>
			</tr>

			<tr>
				<td id="title">생년월일</td>
				<td><input type="text" name="birthyy" maxlength="4"
					placeholder="년(4자)" size="6"> <select name="birthmm">
						<option value="">월</option>
						<option value="01">1</option>
						<option value="02">2</option>
						<option value="03">3</option>
						<option value="04">4</option>
						<option value="05">5</option>
						<option value="06">6</option>
						<option value="07">7</option>
						<option value="08">8</option>
						<option value="09">9</option>
						<option value="10">10</option>
						<option value="11">11</option>
						<option value="12">12</option>
				</select> <input type="text" name="birthdd" maxlength="2" placeholder="일"
					size="4"></td>
			</tr>

			<tr>
				<td id="title">성별</td>
				<td><input type="radio" name="gender" value="M" checked>남
					<input type="radio" name="gender" value="F">여</td>
			</tr>

			<tr>
				<td id="title">회원 종류</td>
				<td><input type="radio" name="grade" value="1" checked>판매자
					회원 <input type="radio" name="grade" value="2">일반 회원</td>
			</tr>

		</table>

		<br> <input type="submit" value="가입" /> <input type="button"
			value="취소" onclick="goLogin()">
	</form>
</body>
</html>
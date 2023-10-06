<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	두 수의 덧셈: <br>
	${param.num1} + ${param.num2 } = ${param.num1 + param.num2 }
	두 수는 모두 양수인가? <br>
	${(param.num1 > 0)} and (param.num2 > 0)}<br>
	두 수는 모두 양수인가? <br>
	${(param.num1 gt 0) and (param.num2 gt 0)}
	<hr>
	두 숫자가 모두 같은 숫자인가?(예/아니오로 대답)<br>
	${(param.num1 eq param.num2)? "예" : "아니오"}<br>
	두 숫자가 모두 같은 숫자인가?(예/아니오로 대답)<br>
	${(param.num1 == param.num2)? "예" : "아니오"}<br>
	<hr>
	안녕하세요. ${empty param.id? "guest" : param.id} 님! 환영합니다.
		
</body>
</html>
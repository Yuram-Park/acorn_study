<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 내용</h1>
	<form method="post" action="<c:url value='/board/update'/>">
		<input type="text" value="${board.bTitle}"/><br>
		작성자: ${board.bWriter} | 작성날짜: ${board.bRegdate} | 조회수: ${board.bViewcnt}
		<hr>
		<textarea rows="10" cols="30">${board.bContent}</textarea>
		<hr>
		<input type="submit" value="전송"/>
	</form>
	
</body>
</html>
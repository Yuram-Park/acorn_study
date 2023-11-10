<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 내용</h1>
	<h4>${board.bTitle }</h4>
	작성자: ${board.bWriter} | 작성날짜: ${board.bRegdate} | 조회수: ${board.bViewcnt}
	<hr>
	${board.bContent}
	<hr>
	<c:forEach items="${boardImageDtoList}" var="boardImageDto">
		<img src="<c:url value='/images/${boardImageDto.link}'/>"/>
	</c:forEach>
	<hr>
	<a href="<c:url value='/board/update'/>">수정하기</a> &nbsp;&nbsp;&nbsp;&nbsp;
	<a href="<c:url value='/board/delete'/>">삭제하기</a>
</body>
</html>
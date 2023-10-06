<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="mybean.*" %>
<jsp:useBean id="dao" class="mybean.BoardDao" />
<jsp:useBean id="dto" class="mybean.Board" />

<%
	request.setCharacterEncoding("euc-kr");
	
%>

<jsp:setProperty property="*" name="dto" />


<%
	Board parent = dao.getBoard(dto.getB_num());

	dao.replyUpdatePos(parent); // 부모 보다 pos 높은 글의 pos값 증가시켜줌
	
	dto.setPos(parent.getPos()); // 부모 pos값으로 바꿔주기
	dto.setDepth(parent.getDepth()); // 부모 depth값으로 바꿔주기
	
	dao.replyBoard(dto);
	response.sendRedirect("List.jsp");
%>


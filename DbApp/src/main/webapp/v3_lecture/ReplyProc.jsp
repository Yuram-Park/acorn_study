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

	dao.replyUpdatePos(parent); // �θ� ���� pos ���� ���� pos�� ����������
	
	dto.setPos(parent.getPos()); // �θ� pos������ �ٲ��ֱ�
	dto.setDepth(parent.getDepth()); // �θ� depth������ �ٲ��ֱ�
	
	dao.replyBoard(dto);
	response.sendRedirect("List.jsp");
%>


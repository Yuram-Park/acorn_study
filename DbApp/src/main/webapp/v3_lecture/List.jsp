<%@ page contentType="text/html;charset=euc-kr" %>
<%@ page import="mybean.*" %>
<%@ page import="java.util.*" %>

<%!
	int totalRecord = 0; // 총 글의 갯수
	int numPerPage = 5; // 한 페이지 당 보여질 글 갯수
	int totalPage = 0; // 총 페이지 수
	int nowPage = 0; // 현재 페이지
	int beginPerPage = 0; // 페이지별 시작 번호
	int pagePerBlock = 2; // 블럭 당 페이지 수
	int totalBlock = 0; // 총 블럭 수
	int nowBlock = 0; // 현재 블럭
	
%>
<HTML>
<link href="style.css" rel="stylesheet" type="text/css">
<script>
	function check(){
		if(document.search.keyWord.value == ""){
			alert("검색어를 입력하세요.");
			document.search.keyWord.focus();
			return;
		}
		document.search.submit();
	}
</script>
<BODY>
<jsp:useBean id="dao" class="mybean.BoardDao" />
<%

	request.setCharacterEncoding("euc-kr");
	String keyWord = request.getParameter("keyWord");
	String keyField = request.getParameter("keyField");
	
	
	Vector vec = (Vector)dao.getBoardList(keyField, keyWord);
	
	totalRecord = vec.size();
	totalPage = (int)Math.ceil((double) totalRecord / numPerPage) ;
	
	if(request.getParameter("nowPage") != null )
		nowPage = Integer.parseInt(request.getParameter("nowPage"));
	
	if(request.getParameter("nowBlock") != null )
		nowBlock = Integer.parseInt(request.getParameter("nowBlock"));
	
	beginPerPage = nowPage * numPerPage;
	totalBlock =(int) Math.ceil((double)totalPage / pagePerBlock);
%>
<center><br>
<h2>JSP Board</h2>

<table align=center border=0 width=80%>
<tr>
	<td align=left>Total :  Articles(
		<font color=red>  <%=nowPage +1 %> / <%=totalPage %> Pages </font>)
	</td>
</tr>
</table>

<table align=center width=80% border=0 cellspacing=0 cellpadding=3>
<tr>
	<td align=center colspan=2>
		<table border=0 width=100% cellpadding=2 cellspacing=0>
			<tr align=center bgcolor=#D0D0D0 height=120%>
				<td> 번호 </td>
				<td> 제목 </td>
				<td> 이름 </td>
				<td> 날짜 </td>
				<td> 조회수 </td>
			</tr>
	
	<%
	if(vec != null || !vec.isEmpty()) { // 데이터 있을 때 조건처리(예외처리 해줘도 됨)
		for(int i=beginPerPage; i<beginPerPage + numPerPage; i++){
			if(i == totalRecord)
				break;
			Board board = (Board)vec.get(i);
	%>
	<tr>
		<td><%=board.getB_num()%></td>
		<td>
			<%=dao.useDepth(board.getDepth()) %>
			<%
				if(board.getDepth() > 0) {
			%>
					<img src="../img/re.gif"/>
			<%
				}
			%>
			<a href="Read.jsp?b_num=<%=board.getB_num()%>">
			<%=board.getB_subject()%></a></td>
		<td><%=board.getB_name()%></td>
		<td><%=board.getB_regdate()%></td>
		<td><%=board.getB_count()%></td>
	</tr>
	<%
		}
	} else {
	%>
		<tr><td>데이터가 없습니다.</td></tr>
	<%
	}
	%>
		</table>
	</td>
</tr>
<tr>
	<td><BR><BR></td>
</tr>
<tr>
	
	<td align="Left"> Go to Page&nbsp;&nbsp;&nbsp;
	<% if(nowBlock > 0) { %>
		<a href="List.jsp?nowPage=<%=pagePerBlock*(nowBlock-1)%>&nowBlock=<%=nowBlock-1%>">이전 <%=pagePerBlock %> 개 :::</a>&nbsp;&nbsp;&nbsp;
	<%
		}
		for(int i=0; i<pagePerBlock; i++){
			if((nowBlock* pagePerBlock) + i == totalPage)
				break;
	%>
		
		<a href="List.jsp?nowPage=<%=(nowBlock * pagePerBlock) + i %>&nowBlock=<%=nowBlock%>"><%=(nowBlock * pagePerBlock) + i + 1 %></a>&nbsp;&nbsp;&nbsp;
		
	<%
		}
	%>
	<!--  -->
	<% if(totalBlock > nowBlock+1){ %>
		<a href="List.jsp?nowPage=<%=pagePerBlock*(nowBlock+1) %>&nowBlock=<%=nowBlock+1 %>">::: 다음 <%= pagePerBlock %> 개</a>&nbsp;&nbsp;&nbsp;
	<% } %>
	</td>
	<td align=right>
		<a href="Post.jsp">[글쓰기]</a>
		<a href="javascript:list()">[처음으로]</a>
	</td>
</tr>
</table>
<BR>
<form action="List.jsp" name="search" method="post">
	<table border=0 width=527 align=center cellpadding=4 cellspacing=0>
	<tr>
		<td align=center valign=bottom>
			<select name="keyField" size="1">
				<option value="b_name"> 이름
				<option value="b_subject"> 제목
				<option value="b_content"> 내용
			</select>

			<input type="text" size="16" name="keyWord" >
			<input type="button" value="찾기" onClick="check()">
			<input type="hidden" name="page" value= "0">
		</td>
	</tr>
	</table>
</form>
</center>	
</BODY>
</HTML>
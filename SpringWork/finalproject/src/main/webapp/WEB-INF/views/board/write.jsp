<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function readURL(input) {
		var file = input.files[0]
		console.log(file)
		if (file != '') {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function (e) {
				console.log(e.target)
				console.log(e.target.result)
				$('#preview').attr('src', e.target.result);
			}
		}
	}

</script>
</head>
<body>
	<h1>글쓰기</h1>
	<form method="post" action="<c:url value='/board/write'/>" enctype="multipart/form-data">
		제목: <input type="text" name="bTitle"/><br><br>
		글쓴이: <input type="text" name="bWriter"/><br><br>
		내용: <textarea rows="5" cols="50" name="bContent"></textarea><br><br>
		<div class="form-group" style="height: 150px; width: 200px;">
			<label>이미지 파일 첨부</label>
			<!--  multiple= 여러개 선택 가능 , accept= default 이미지를 파일로 설정 -->
			<input type="file" name="boardFiles" multiple="multiple" accept="image/*"/>
			<img id="preview" src="#" width=200 height=150 alt="선택된 이미지가 없습니다."/>
			<input type="submit" value="글쓰기"/>
		</div>
	</form>
</body>
</html>
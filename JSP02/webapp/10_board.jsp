<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSP</title>
	</head>
	<body>
	
	
	<h1>게시판 글쓰기</h1>
	<form action="10_board_result.jsp" method="get">
	 
		<input type="number" name="boardId"placeholder="글 번호"/>
		<input type="text" name="title" placeholder="제목"/>
		<textarea rows="5" cols="80" name="content" placeholder="글 본문"></textarea>
		<input type="text" name="writer" placeholder="작성자"/>
		<input type="submit" value="작성 완료"/>
	</form>
	</body>
</html>
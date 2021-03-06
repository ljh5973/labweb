<%@page import="edu.web.model.Board"%>
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
	
	<h1>게시판 글쓰기 결과 페이지</h1>
	
	<h2>scriptlet, expression</h2>
	
	<%
	// form 에서  POST로 보낸 데이터 (요청 파라미터)의 한글을 제대로 처리하기
	request.setCharacterEncoding("UTF-8");
	// 이런식으로 선언을 해주는것도 가능하다
	int boardId= Integer.parseInt(request.getParameter("boardId"));
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String writer=request.getParameter("writer");
	Board b1=new Board();
	b1.setBoardId(boardId);
	b1.setTitle(title);
	b1.setContent(content);
	b1.setWriter(writer);
	%>
	<div id="boardId">글 번호 <%=b1.getBoardId() %></div>
	<div id="title">글 제목 <%= b1.getTitle() %></div>
	<div id="content">글 본문 <%= b1.getContent() %></div>
	<div id="writer">글 작성자 <%=b1.getWriter() %></div>
	
	<%-- 1. Java bean 객체 생성 --%>
	<jsp:useBean id="b2" class="edu.web.model.Board"></jsp:useBean>
	
	<%-- 2. 요청 파라미터(request parameter) 값들로 Java Bean 객체의 property 설정 --%>
	<jsp:setProperty property="boardId" name="b2"/>
	<jsp:setProperty property="title" name="b2" param="title"/>
	<jsp:setProperty property="content" name="b2" param="content"/>
	<jsp:setProperty property="writer" name="b2"/>
	
	<hr>
	<%--
	<div>
	 글 번호 : <jsp:getProperty property="boardId" name="b2"/><br>
	 글 제목: <jsp:getProperty property="title" name="b2"/><br>
	 글 본문: <jsp:getProperty property="content" name="b2"/><br>
	 글 작성자: <jsp:getProperty property="writer" name="b2"/>
	</div>
	 --%>
	
	<jsp:setProperty property="*" name="b2"/>
	
	<%-- 요청 파라미터를 모두 이용해서 Java Bean 객체 b2의 모든 속성들의 값을 설정 --%>
	</body>
</html>
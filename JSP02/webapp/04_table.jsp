<%@page import="java.sql.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.web.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style >
			th, td{
			border: 1px solid #777}
		</style>
	</head>
	<body>
	
	
	<h1>JSP scriptlet과 expression을 사용한 테이블 작성</h1>
	
	<%-- 
		Model 클래스 : Board
			boardId: 글 번호 (int)
			title: 제목		(String)
			content: 내용		(String)
			writer: 작성자	(String)
			updateTime: 작성/수정 시간 (date)
			viewCount: 조회수(int)
			
			
		Board를 저장하는 ArraytList를 선언, 생성.
		ArrayList에 더미 데이터를 저장.
	 --%>
	 
	 <% 
	 
	 Board board=new Board(); 
	 	ArrayList<Board> list=new ArrayList<>();
	 	
	 	long now=System.currentTimeMillis();
	 	Date time= new Date(now);
	 	
	 	
	 	int num=1;
	 	Board test=new Board(num++,"제목", "내용", "작성자", time, 2);
	 	list.add(test);
	 	list.add(new Board(num++,"사랑합니다.", "뭐가뭐가", "나야나",time, 1));
	 %>
	 <%=test %>>
	 <table>
	 	<thead>
	 		<tr>
	 			<th>글 번호</th>
	 			<th>제목 </th>
	 			<th>내용</th>
	 			<th>작성자</th>
	 			<th>작성/수정 시간</th>
	 			<th>조회수</th>
	 		</tr>
	 	</thead>
	 	<tbody>
	 		<%for (Board b: list){%>
	 			<tr>
	 				<td><%=b.getBoardId() %></td>
	 				<td><%=b.getTitle()%></td>
	 				<td><%=b.getContent() %></td>
	 				<td><%=b.getWriter()%></td>
	 				<td><%=b.getUpdateTime() %></td>
	 				<td><%=b.getViewCount()%></td>
	 			</tr>
	 		<% } %>
	 	</tbody>
	 </table>
	</body>
</html>
<%@page import="java.util.ArrayList"%>
<%@page import="edu.web.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, th, td {
	border: 1px solid #777;
}
</style>
</head>
<body>

	<h1>JSP Scriptlet을 사용한 테이블 작성</h1>
	<h2>Model class 테스트</h2>

	<%
		Member member = new Member("admin", "1234", "admin@admin.com");
	%>
	<div><%=member%>
		<%--  --%>
	</div>

	<%-- 테이블을 만들 더미 데이터 생성 --%>
	<%
		ArrayList<Member> list = new ArrayList<>();
	list.add(member);
	list.add(new Member("guest", "guest", null));
	list.add(new Member("오썜", "오쌤", "jake@jake.com"));
	%>

	<h2>테이블 만들기</h2>
	<table>
		<thead>
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이메일</th>
			</tr>
		</thead>
		<br>
		<tbody>
			<%
				for (Member m : list) {
				out.print("<tr>");
				out.print("<td>");
				out.print(m.getMemberId());
				out.print("</td>");

				out.print("<td>");
				out.print(m.getMemberPassword());
				out.print("</td>");

				out.print("<td>");
				out.print(m.getMemberEmail());
				out.print("</td>");
				out.print("</tr>");

			}
			%>
		</tbody>
	</table>

	<table>
		<thead>
			<tr>
				<th>Member Id</th>
				<th>Member Password</th>
				<th>Member Email</th>
			</tr>
		</thead>
		<tbody>
		<% for(Member m:list) {%>
			<tr>
				<td><%= m.getMemberId() %></td>
				<td><%= m.getMemberPassword() %></td>
				<td><%= m.getMemberEmail() %></td>
			</tr>
		<%} %>
		</tbody>
	</table>
</body>
</html>
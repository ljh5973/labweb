<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<% request.setCharacterEncoding("UTF-8"); %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		
		<style >
		span{
		color: ${param.color}
		}
		</style>
	</head>
	<body>
	
	<h1>결과 페이지</h1>
	<h2>사용자 이름: <span>${param.userName }</span></h2>
	</body>
</html>
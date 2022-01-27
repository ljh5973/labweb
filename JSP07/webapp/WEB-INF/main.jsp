<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" />
</head>
<body>


	<h1>메인 페이지</h1>

	<c:if test="${empty userId }">
		<%-- userId 변수의 값이 빈 문자열("")이거나 또는 null인 경우 --%>
		<%-- 로그인되어 있지 않은 경우 --%>
		<a href="signin">로그인</a>

	</c:if>

	<c:if test="${not empty userId }">
		<%-- 로그인 되어있을 때 --%>
		<div>${userId }님환영합뉘뒤~!</div>
		<a href="logout">로그아웃</a>
	</c:if>

	<script
		src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%-- taglib 지시자 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
JSTL 사용 방법:
1. tomcat.apache.org site의 taglibs download page에서 jar file 다운로드
	impl, spec 두개는 필수
	jar파일을 WEB-INF - > lib 에 추가 

2. taglib 지시자(directive) 작성
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 --%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JSTL</title>
	</head>
	<body>
	
	<h1>JSTL</h1>
	<h2>JSP(Java Server Page) Standard Tag Library</h2>

	<c:set var="userName" value="관리자"></c:set>
	<%-- 
	<c:set var="변수이름" value="변수 값" scope="변수를 저장할 영역" > </c:set>
	변수 저장 영역: page(기본값), request, session, application
 	 --%>
	<h3>
		<c:out value="${userName }"></c:out><br>
		
		<%-- 위 코드는 아래와 동일
		<% out.print(pageContext.getAttribute("userName")); %>
		
		 --%>
	</h3>
	</body>
</html>
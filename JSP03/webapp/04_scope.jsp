<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>EL</title>
	</head>
	<body>
	
	<h1>JSP 내장 객체 vs EL 내장  객체</h1>
	<%--
	JSP에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
	 * pageContent : JSP 페이지가 유지되는 동안 유지되는 객체. <% pageContext.get(); %>
	 * request : 요청(request)이 유지되는 동안 유지되는 객체. <% request.getParameter(); %>
	 * session : 세션(session)이 유지되는 동안 유지되는 객체. 
	 * application : 웹 애플리케이션이 동작 중(서버 실행 중)에 계속 유지되는 객체.
	 
	EL에서 상태 정보들을 유지하기 위해서 사용하는 객체들:
	 * pageScope: ${pageScope}. JSP에 pageContext 객체
	 * requestScope: ${requestScope} . JSP의 request 객체.
	 * sessionScope: ${sessionScope}. JSP의 session 객체.
	 * applicationScope: ${ applicationScope}. JSP의 application 객체.
	 
	 EL의 ${}의 동작 원리:
	  * EL은 변수 이름을 pageScope -> requestScope -> sessionScope -> applicationScope 순서대로 찾음.
	  * { 변수 }  
	 --%>
	
	<h2>JSP scriptlet & expression</h2>
	
	<%
	// pageContext 객체에 "number1" 속성 값을 1로 설정
	pageContext.setAttribute("number1", 1);
	
	// request객체에 "number2" 속성 값을 설정
	request.setAttribute("number2", 2);
	//
	session.setAttribute("number3", 3);
	//
	application.setAttribute("number4", 4);
	%>
	
	<div>
	page 속성: <%=pageContext.getAttribute("number1") %><br>
	request 속성: <%=request.getAttribute("number2") %><br>
	session 속성: <%= session.getAttribute("number3") %><br>
	application 속성: <%= application.getAttribute("number4") %>
	</div>
	
	<h2>EL</h2>
	
	<div>
	<%-- pageScope나 다른것들을 안써줘도 차례대로 알아서 찾아줌 --%>
	page 속성: ${pageScope.number1 } <br>		<%-- number1 --%>
	request 속성: ${requestScope.number2 } <br> <%-- number2 이런식으로 사용해도 된다. pageScope에서 찾아보고 없으면 requestScope에서 찾아본다 --%>
	session 속성: ${sessionScope.number3 } <br>
	application 속성:	 ${applicationScope.number4 }
	</div>
	</body>
</html>
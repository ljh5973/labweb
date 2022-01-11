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
	
	<h1>숫자 입력 form</h1>
	
	
	<form action="02_number_result.jsp" method="get">
		<input type="number" name="number1" step="any">
		<br>
		
		<%-- step="0.1"은 소숫점 한자리수 --%>
		<input type="number" name="number2" step="0.01">
		<br>
		<input type="submit" value="계산">
	</form>
	</body>
</html>
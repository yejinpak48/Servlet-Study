<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>오늘의 메뉴 <%@ include file="today.jsp" %></h2>
	
	<form action="<%= request.getContextPath() %>/menuOrder" method="get">
		<select name="menu">
			<option value="햄버거">햄버거</option>
			<option value="짜장면">짜장면</option>
			<option value="짬뽕">짬뽕</option>
			<option value="순대국">순대국</option>
		</select>
		<input type="submit" value="선택완료">
	</form>
</body>
</html>




















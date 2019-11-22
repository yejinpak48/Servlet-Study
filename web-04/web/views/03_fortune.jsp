<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%-- <%
	Date now = new Date();
	String today = String.format("%tY년 %tm월 %td일 %tA", now, now, now, now);
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <h2>오늘의 운세<sub style="color:lightgray;"><%=today%></sub></h2> --%>
	<h2>오늘의 운세<%@ include file="today.jsp" %></h2>
	<select>
		<option>쥐띠</option>
		<option>소띠</option>
		<option>호랑이띠</option>
		<option>토끼띠</option>
		<option>용띠</option>
		<option>뱀띠</option>
		<option>말띠</option>
		<option>양띠</option>
		<option>원숭이띠</option>
		<option>닭띠</option>
		<option>개띠</option>
		<option>돼지띠</option>
	</select>
	
	
	
</body>
</html>




















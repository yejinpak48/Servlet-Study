<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) request.getAttribute("name");
	String color = (String) request.getAttribute("color");
	String animal = (String) request.getAttribute("animal");
	String foods = (String) request.getAttribute("foods");
	String recommendation = (String) request.getAttribute("recommendation");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2 style="color:red;">개인 취향 테스트 결과(JSP)</h2>
	
	<span style="color:lightblue; font-weight:bold"><%= name %></span>님의 개인 취향은
	<br><br>
	<span style="color:lightgreen; font-weight:bold"><%= color %></span>색을 좋아하고,
	<span style="color:hotpink; font-weight:bold"><%= animal %></span>를 좋아합니다.
	<br><br>
	좋아하는 음식은 <%= foods %> 입니다.
	<br>
	<h3>진호의 추천!</h3>
	<p><%= recommendation %>어떠세요?</p>
	
</body>
</html>






















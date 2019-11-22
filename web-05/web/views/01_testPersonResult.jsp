<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//1. 전달 파라미터 한글 처리
	request.setCharacterEncoding("UTF-8");

	//2. 전달된 파라미터 변수에 담기
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String animal = request.getParameter("animal");
	String[] foodArr = request.getParameterValues("food");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div id="container">
		<div id="header">
			<h2><span style="color:blue"><%= name %></span>님의 개인 취향 테스트 결과</h2>
		</div>
		<div id="color">
			<span class="title">당신이 좋아하는 색깔은?</span><br>
		</div>
		<div id="animal">
			<span class="title">당신이 좋아하는 동물은?</span><br>
		</div>
		<div id="food">
			<span class="title">당신이 좋아하는 음식은?</span><br>
		</div>
	</div>
	<script>
		$(function(){
			<%
				switch(color){
					case "빨강" : 
			%>
						$("#color").append("<img src='<%=request.getContextPath()%>/images/red.png'>");
			<% 
					    break;
					case "파랑" : 
			%>
						$("#color").append("<img src='<%=request.getContextPath()%>/images/blue.png'>");
			<%
						break;
					case "노랑" :
			%>	
						$("#color").append("<img src='<%=request.getContextPath()%>/images/yellow.png'>");			
			<% 			break;
			
				} 
			%>
		});
	</script>
</body>
</html>
















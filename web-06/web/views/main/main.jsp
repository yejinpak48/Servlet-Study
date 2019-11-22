<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w6.member.model.vo.Member"%>
<% 
	//Member loginUser = (Member) request.getAttribute("loginUser");
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	#userInfo {
		float:right;
	}
</style>
</head>
<body>
	<h1 align="center">Welcome to MVC 랜드</h1>
	<div id="userInfo">
		<label><%= loginUser.getUserName() %>님 환영합니다.</label><br>
		<button id="changeInfo">정보수정</button>
		<button id="logout">로그아웃</button>
	</div>
	<script>
		$(function(){
			$("#logout").click(function(){
				location.href="<%=request.getContextPath()%>/logout";
			})
		})
	</script>
</body>
</html>
















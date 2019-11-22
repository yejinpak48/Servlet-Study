<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.member.model.vo.*"%>
<% 
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div > button {
		float:right;
	}
</style>
</head>
<body>
	<h1 align="center">메뉴바</h1>
	<h3 align="right"><%= loginUser.getUserName() %>님 환영합니다.</h3>
	<div>
		<button onclick="logout()">로그아웃</button>
		<% if(!loginUser.getUserId().equals("admin")){ %>
		<button onclick="location.href='/w7/views/member/memberUpdateForm.jsp'">내 정보 수정</button>
		<% }else{ %>
		<button onclick="location.href='/w7/views/admin/adminPage.jsp'">관리자 메뉴로</button>
		<% } %>
	</div>
	<script>
		function logout(){
			var check = window.confirm("로그아웃 하시겠습니까?");
			
			if(check == true){
				location.href = '<%=request.getContextPath()%>/logout';
			}
		}
	</script>
</body>
</html>



















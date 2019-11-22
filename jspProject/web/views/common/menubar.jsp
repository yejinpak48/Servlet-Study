<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.jsp.member.model.vo.Member"%>
<% 
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	body {
		background:url("/jsp/image/city1.PNG") no-repeat;
		background-size:cover;
	}
	.wrap {
		background:black;
		width:100%;
		height:50px;
	}
	.menu {
		background:black;
		color:white;
		text-align:center;
		display:table-cell;
		vertical-align:middle;
		width:150px;
		height:50px;
	}
	.nav {
		width:600px;
		margin:0 auto;
	}
	.menu:hover {
		background:darkgray;
		color:orangered;
		font-weight:bold;
		cursor:pointer;
	}
	.btns {
		align:center
	}
	#loginBtn, #memberJoinBtn, #logoutBtn, #changeInfo {
		display:inline-block;
		text-align:center;
		background:orangered;
		color:white;
		height:25px;
		width:100px;
		border-radius:5px;
	}
	#memberJoinBtn, #changeInfo {
		background:yellowgreen;
	}
	#loginBtn:hover, #changeInfo:hover, #logoutBtn:hover, #memberJoinBtn:hover {
		cursor:pointer;
	}
	.loginArea > form, #userInfo {
		float:right;
	}
</style>
</head>
<body>
	<h1 align="center">Welcome JSP world</h1>
	
	<div class="loginArea">
	<% if(loginUser == null){ %>
		<form action="<%= request.getContextPath() %>/login.me" method="post" id="loginForm">
			<table>
				<tr>
					<td><label class="text">ID : </label></td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td><label class="text">PWD : </label></td>
					<td><input type="password" name="userPwd"></td>
				</tr>
			</table>
			<div class="btns" align="center">
				<div id="memberJoinBtn" onclick="memberJoin();">회원가입</div>
				<div id="loginBtn" onclick="login();">로그인</div>
			</div>
		</form>
	<% }else{ %>
		<div id="userInfo">
			<label><%= loginUser.getNickName() %>님의 방문을 환영합니다.</label>
			<div class="btns" align="right">
				<div id="changeInfo" onclick="changeInfo();">정보수정</div>
				<div id="logoutBtn" onclick="logout();">로그아웃</div>
			</div>
		</div>
	<% } %>
	</div>
	<script>
		function login(){
			$("#loginForm").submit();
		}
		
		function logout(){
			location.href="<%=request.getContextPath()%>/logout.me";
		}
		
		function memberJoin(){
			location.href="/jsp/views/member/memberJoinForm.jsp";
		}
		
		function changeInfo(){
			location.href="/jsp/views/member/memberUpdateForm.jsp"; 
		}
	</script>
	
	<br clear="both">
	<br>
	<div class="wrap">
		<div class="nav">
			<div class="menu" onclick="goHome();">HOME</div>
			<div class="menu" onclick="goNotice();">공지사항</div>
			<div class="menu" onclick="goBoard();">게시판</div>
			<div class="menu" onclick="goThumbnail();">사진게시판</div>
		</div>
	</div>
	<script>
		function goHome(){
			location.href="/jsp/index.jsp";
		}
		
		function goNotice(){
			location.href="/jsp/selectList.no";
		}
		
		function goBoard(){
			location.href="/jsp/selectList.bo";
		}
		
		function goThumbnail(){
			location.href="/jsp/selectList.tn";
		}
	</script>
</body>
</html>






















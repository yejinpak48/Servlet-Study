<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html {
		height:100%
	}
	body {
		background:skyblue;
		height:100%;
	}
	#main {
		min-height:90%;
	}
	h1 {
		color:navy;
	}
	#title {
		color:orangered;
	}
	input[type='submit'] {
		height:50px;
		background:orangered;
		color:white;
		border-radius:10px;
	}
	table {
		text-align:center;
	}
</style>
</head>
<body>
	<div id="main">
		<h1 align="center">Welcome to <label id="title">Jinho's World</label></h1>
		<div>
			<form action="/w7/login" method="post">
				<table align="center">
					<tr>
						<td><label>ID</label></td>
						<td colspan="2"><input type="text" name="userId"></td>
						<td rowspan="2"><input type="submit" value="LOG-IN"></td>
					</tr>
					<tr>
						<td><label>PWD</label></td>
						<td colspan="2"><input type="password" name="password"></td>
					</tr>
					<tr>
						<td colspan="4"><a href="views/member/memberJoinForm.jsp">회원가입하기</a></td>
					</tr>
					<tr>
						<td colspan="4"><a href="#">아이디 / 비밀번호 찾기</a></td>
					</tr>
				</table>
			</form>
		</div>
		<%@ include file="views/common/footer.jsp" %>
	</div>
</body>
</html>






















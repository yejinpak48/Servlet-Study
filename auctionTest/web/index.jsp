<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
h5 {
	color: red;
}

div>button, input[type=submit] {
	width: 200px;
	margin-top: 10px;
}
</style>
</head>
<body>
	<br>
	<h1 align="center">JH Auction</h1>
	<br>
	<br>
	<h3 align="center">로그인이 필요한 서비스 입니다.</h3>
	<br><br>
	<h5 align="center">19세 미만 사용자는 사용 불가능하니 꺼지세요.</h5>
	<Br>

	<form action="<%= request.getContextPath() %>/login.me" method="post" id="loginForm">
		<table align="center">
			<tr>
				<td>
					<div class="input-group mb-3 input-group-lg">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width:120px">아이디</span>
						</div>
						<input type="text" class="form-control" name="userId">
					</div>
				</td>
				<td rowspan="2"></td>
			</tr>
			<tr>
				<td>
					<div class="input-group mb-3 input-group-lg">
						<div class="input-group-prepend">
							<span class="input-group-text" style="width:120px">비밀번호</span>
						</div>
						<input type="password" class="form-control" name="userPwd">
					</div>
				</td>

			</tr>
		</table>
	</form>
	<div align="center">
		<input type="submit" value="로그인" class="btn btn-info">
		<br>
		<button class="btn btn-success">19세 이상 회원 가입 하기</button>
		<br>
		<button class="btn btn-secondary">아이디 / 비밀번호 찾기</button>
	</div>
	
	<script>
		$(function(){
			$("input[name=userId]").focus();
			
			$("input[type=submit]").click(function(){
				$("#loginForm").submit();
			});
		})
	</script>
</body>
</html>










<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	input[type='submit'] {
		height:55px;
	}
</style>
</head>
<body>
	<div align="center">
		<h2>로그인 테스트</h2>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table>
				<tr>
					<td><label>아이디 </label></td>
					<td><input type="text" name="userId"></td>
					<td rowspan="2"><input type="submit" value="로그인"></td>
				</tr>
				<tr>
					<td><label>비밀번호 </label></td>
					<td><input type="password" name="password"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>





















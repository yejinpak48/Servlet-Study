<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">회원가입</h1>
	<form action="<%=request.getContextPath()%>/insertMember" method="post">
		<table align="center">
			<tr>
				<td><label>아이디</label></td>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<td><label>비밀번호</label></td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><label>비밀번호확인</label></td>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td><label>이름</label></td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td><label>나이</label></td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td><label>성별</label></td>
				<td>
					<input type="radio" name="gender" value="M" id="male">
					<label for="male">남</label>
					<input type="radio" name="gender" value="F" id="female">
					<label for="female">여</label>
				</td>
			</tr>
			<tr>
				<td><label>이메일</label></td>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<td><label>전화번호</label></td>
				<td><input type="tel" name="phone"></td>
			</tr>
			<tr>
				<td><label>주소</label></td>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<td><label>취미</label></td>
				<td>
					<input type="checkbox" name="hobby" value="운동" id="sports">
					<label for="sports">운동</label>
					<input type="checkbox" name="hobby" value="낚시" id="fishing">
					<label for="fishing">낚시</label>
					<input type="checkbox" name="hobby" value="등산" id="climbing">
					<label for="climbing">등산</label>
					<input type="checkbox" name="hobby" value="요리" id="cooking">
					<label for="cooking">요리</label>
				</td>
			</tr>
			<tr align="center">
				<td colspan="2">
					<input type="reset" value="취소하기">&nbsp; &nbsp;
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
























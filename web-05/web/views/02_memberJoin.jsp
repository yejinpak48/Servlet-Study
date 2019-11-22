<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h2>회원 가입 정보 입력</h2>
		<br>
		<form action="02_memberJoinResult.jsp" method="post">
			<input type="text" placeholder="아이디" name="userId" id="userId"><br>
			
			<input type="password" placeholder="패스워드" name="password" id="password"><br>
			
			<input type="text" placeholder="이름" name="userName" id="userName"><br>
			
			<input type="text" placeholder="나이" name="age" id="age"><br>
			
			<input type="email" placeholder="이메일" name="email" id="email"><br>
			
			<input type="tel" placeholder="휴대폰" name="phone" id="phone"><br>
			
			<input type="text" placeholder="주소" name="address" id="address"><br>
			
			<label>성별 : </label>
			<input type="radio" name="gender" id="male" value="M">
			<label for="male">남</label>
			<input type="radio" name="gender" id="female" value="F">
			<label for="female">여</label>
			
			<br><br>
			
			<label>취미 : </label>
			<input type="checkbox" name="hobby" id="hobby0" value="운동">
			<label for="hobby0">운동</label>
			<input type="checkbox" name="hobby" id="hobby1" value="등산">
			<label for="hobby1">등산</label>
			<input type="checkbox" name="hobby" id="hobby2" value="독서">
			<label for="hobby2">독서</label>
			<input type="checkbox" name="hobby" id="hobby3" value="게임">
			<label for="hobby3">게임</label>
			<input type="checkbox" name="hobby" id="hobby4" value="여행">
			<label for="hobby4">여행</label>
			
			<br><br>
			
			<input type="submit" value="가입"> &nbsp; &nbsp;
			<input type="reset" value="취소">
		</form>
	</div>
	
	
	
	
	
</body>
</html>


















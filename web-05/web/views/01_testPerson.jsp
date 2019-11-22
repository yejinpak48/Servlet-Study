<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개인 취향 테스트(MVC1)</h2>
	당신의 취향을 테스트합니다<br>
	데이터 입력 후 확인 버튼을 누르세요<br>
	
	<form action="01_testPersonResult.jsp" method="post">
		<ul style="list-style:none; line-height:200%">
			<li>이름? <input type="text" name="name" size="10"></li>
			<li>좋아하는 색?
				<input type="radio" name="color" id="color-red" value="빨강">
				<label for="color-red">빨강</label>
				<input type="radio" name="color" id="color-blue" value="파랑">
				<label for="color-blue">파랑</label>
				<input type="radio" name="color" id="color-yellow" value="노랑">
				<label for="color-yellow">노랑</label>
			</li>
			<li>좋아하는 동물은?
				<select name="animal" id="animal">
					<option value="강아지">강아지</option>
					<option value="고양이">고양이</option>
					<option value="금붕어">금붕어</option>
				</select>
			</li>
			<li>좋아하는 음식?(모두 고르세요)
				<input type="checkbox" name="food" id="food1" value="짜장면">
				<label for="food1">짜장면</label>
				<input type="checkbox" name="food" id="food2" value="짬뽕">
				<label for="food2">짬뽕</label>
				<input type="checkbox" name="food" id="food3" value="탕수육">
				<label for="food3">탕수육</label>
				<input type="checkbox" name="food" id="food4" value="양장피">
				<label for="food4">양장피</label>
				<input type="checkbox" name="food" id="food5" value="팔보채">
				<label for="food5">팔보채</label>			
			</li>
			<li>
				<br>
				<input type="submit" value="확인">&nbsp; &nbsp;
				<input type="reset" value="취소">
			</li>
		</ul>
	</form>
	
	
	
</body>
</html>






















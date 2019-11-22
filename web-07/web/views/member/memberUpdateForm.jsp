<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.member.model.vo.Member"%>
<%
	Member loginUser = (Member) session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<h1 align="center"><%= loginUser.getUserName() %>님의 회원 정보 수정</h1>
	<button>탈퇴하기</button>
	<form action="<%=request.getContextPath()%>/updateMember" method="post">
		<table align="center">
			<tr>
				<td><label>아이디</label></td>
				<td><input type="text" name="userId" value="<%=loginUser.getUserId()%>" readonly></td>
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
				<td><input type="text" name="userName" value="<%=loginUser.getUserName()%>"></td>
			</tr>
			<tr>
				<td><label>나이</label></td>
				<td><input type="number" name="age" value="<%=loginUser.getAge()%>"></td>
			</tr>
			<tr>
				<td><label>성별</label></td>
				<td>
					<% if(loginUser.getGender().equals("M")){ %>
					<input type="radio" name="gender" value="M" id="male" checked>
					<label for="male">남</label>
					<input type="radio" name="gender" value="F" id="female">
					<label for="female">여</label>
					<% }else{ %>
					<input type="radio" name="gender" value="M" id="male">
					<label for="male">남</label>
					<input type="radio" name="gender" value="F" id="female" checked>
					<label for="female">여</label>
					<% } %>
				</td>
			</tr>
			<tr>
				<td><label>이메일</label></td>
				<td><input type="email" name="email" value="<%=loginUser.getEmail()%>"></td>
			</tr>
			<tr>
				<td><label>전화번호</label></td>
				<td><input type="tel" name="phone" value="<%=loginUser.getPhone()%>"></td>
			</tr>
			<tr>
				<td><label>주소</label></td>
				<td><input type="text" name="address" value="<%=loginUser.getAddress()%>"></td>
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
	<script>
		$(function(){
			$("input[name=hobby]").each(function(){
				var arr = '<%= loginUser.getHobby() %>'.split(",");
				console.log(arr)
				for(var i = 0; i < arr.length; i++){
					if($(this).val() == arr[i]){
						$(this).attr("checked", true);
					}
				}
			})
		});
		
		function deleteMember(){
			var answer = window.confirm("정말로 탈퇴하실건가요?");
			
			if(answer == true){
				location.href = '<%=request.getContextPath()%>/deleteMember';
			}
		}
	</script>
</body>
</html>
























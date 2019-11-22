<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.w7.member.model.vo.*"%>
<%
	ArrayList<Member> list = (ArrayList<Member>) request.getAttribute("list");
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
	<% if(loginUser == null || !loginUser.getUserId().equals("admin")){
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다.");
		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	}else{ %>
		<h1 align="center">회원 정보 전체 보기</h1>
		<div align="center">
			<form action="<%= request.getContextPath() %>/searchMember" method="get">
				<input type="radio" name="searchCondition" value="findId" checked>
				<label>아이디로 찾기</label>
				<input type="radio" name="searchCondition" value="findName">
				<label>이름으로 찾기</label>
				<input type="radio" name="searchCondition" value="findGender">
				<label>성별로 찾기</label>
				<br>
				<div id="idNameBox">
					<input type="search" name="searchValue">
					<button type="submit">검색하기</button>
				</div>
				<div id="genderBox">
					<select name="gender">
						<option value="M">남자</option>
						<option value="F">여자</option>
					</select>
					<button type="submit">검색하기</button>
				</div>
			</form>
		</div>
		<script>
			$(function(){
				$("#genderBox").hide();
				
				$("input:radio").change(function(){
					if($(this).val() === "findGender"){
						$("#idNameBox").hide();
						$("#genderBox").show();
					}else{
						$("#idNameBox").show();
						$("#genderBox").hide();
					}
				});
			});
		</script>
		
		<br>
		<table align="center">
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>성별</th>
				<th>나이</th>
				<th>이메일</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>취미</th>
				<th>가입일</th>
			</tr>
			<%-- <% for(Member m : list){ %>
			<tr>
				<td><%= m.getUserId() %></td>
				<td><%= m.getUserName() %></td>
				<td><%= m.getGender() %></td>
				<td><%= m.getAge() %></td>
				<td><%= m.getEmail() %></td>
				<td><%= m.getPhone() %></td>
				<td><%= m.getAddress() %></td>
				<td><%= m.getHobby() %></td>
				<td><%= m.getEnrollDate() %></td>
			</tr>
			<% } %> --%>
		</table>
	<% } %>
	<script>
		$(function(){
			<% for(Member m : list) { %>
			
				var $tableBody = $("table tbody");
				
				var $tr = $("<tr>");
				var $idTd = $("<td>").text('<%=m.getUserId()%>');
				var $nameTd = $("<td>").text('<%= m.getUserName()%>');
				var $genderTd = $("<td>").text('<%= m.getGender()%>');
				var $ageTd = $("<td>").text(<%=m.getAge()%>);
				var $emailTd = $("<td>").text('<%=m.getEmail()%>');
				var $phoneTd = $("<td>").text('<%=m.getPhone()%>');
				var $addressTd = $("<td>").text('<%=m.getAddress()%>');
				var $hobbyTd = $("<td>").text('<%=m.getHobby()%>');
				var $enrollDateTd = $("<td>").text(<%= m.getEnrollDate() %>);
				
				$tr.append($idTd);
				$tr.append($nameTd);
				$tr.append($genderTd);
				$tr.append($ageTd);
				$tr.append($emailTd);
				$tr.append($phoneTd);
				$tr.append($addressTd);
				$tr.append($hobbyTd);
				$tr.append($enrollDateTd);
				
				$tableBody.append($tr);
				
			
			<% } %>
		});
	</script>
</body>
</html>





















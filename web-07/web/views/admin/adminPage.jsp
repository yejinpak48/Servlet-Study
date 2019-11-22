<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.w7.member.model.vo.Member"%>
<% Member loginUser = (Member) session.getAttribute("loginUser"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	if(loginUser == null || !loginUser.getUserId().equals("admin")){ 
		request.setAttribute("msg", "잘못된 경로로 접근하셨습니다!!");
		request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
	} else { 
	%>
		<h1>관리자메뉴</h1>
		<div align="center">
			<button onclick="selectAll();">회원 정보 전체 보기</button>
		</div>
	<% } %>
	<script>
		function selectAll(){
			location.href='<%=request.getContextPath()%>/selectAll';
		}
	</script>
		
</body>
</html>

















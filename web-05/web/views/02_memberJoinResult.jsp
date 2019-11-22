<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%
	//1. 한글 인코딩 처리
	request.setCharacterEncoding("UTF-8");

	//2. 전송값 꺼내서 변수에 기록하기
	String userId = request.getParameter("userId");
	String password = request.getParameter("password");
	String userName = request.getParameter("userName");
	int age = Integer.parseInt(request.getParameter("age"));
	String gender = request.getParameter("gender");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");
	String address = request.getParameter("address");
	String[] hobbyArr = request.getParameterValues("hobby");
	
	String hobby = String.join(",", hobbyArr);
	
	//3. 비지니스 로직 구성
	Connection conn = null;
	PreparedStatement pstmt = null;
	String msg = null;
	
	try{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jsp", "jsp");
		
		String query = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?,?,?,?, SYSDATE)";
		
		pstmt = conn.prepareStatement(query);
		
		pstmt.setString(1, userId);
		pstmt.setString(2, password);
		pstmt.setString(3, userName);
		pstmt.setString(4, gender);
		pstmt.setInt(5, age);
		pstmt.setString(6, email);
		pstmt.setString(7, phone);
		pstmt.setString(8, address);
		pstmt.setString(9, hobby);
		
		int result = pstmt.executeUpdate();
		
		//4. 처리 결과
		if(result > 0){
			conn.commit();
			msg = "성공적으로 회원이 가입되었습니다.";
		}else{
			conn.rollback();
			msg = "회원 가입에 실패했습니다.";
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try{
			pstmt.close();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul style="list-style:none; line-height:150%">
		<li>아이디 : <%= userId %></li>
		<li>패스워드 : <%= password %></li>
		<li>이름 : <%= userName %></li>
		<li>나이 : <%= age %></li>
		<li>이메일 : <%= email %></li>
		<li>성별 : <span id="gender" style="font-weight:bold; color:<%
			String genderColor = "";
			if("M".equals(gender)){
				genderColor = "blue";
			}else{
				genderColor = "red";
			}
		%><%=genderColor%>"><%= gender %></span></li>
		<li>휴대폰 : <%= phone %></li>
		<li>취미 : <%= hobby %></li>
		<li>주소 : <%= address %></li>
	</ul>
	<hr>
	<p><%= msg %></p>







</body>
</html>






















<%-- directive page : 페이지 지시자 태그 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP 주석 --%>
	<!-- HTML 주석 -->
	<%-- JSP 주석의 차이점 : 클라이언트에게 전달되지 않는다. --%>
	
	<%-- scripting element 1 : scriptlet --%>
	<%-- <% 로 시작해서 %>로 끝나는 것을 스크립틀릿 태그라고 부른다. --%>
	<%
		int total = 0;
	
		for(int i = 1; i <= 10; i++){
			total += i;
		}
		//자바와 동일하게 주석을 적을 수 있다.
		/*
		여러 줄 주석도 사용할 수 있다.
		*/
		//System.out.println(total);
		
		String s = null;
		System.out.println(s.charAt(0));
		
	%>
	
	<%-- scripting element2 : expression --%>
	<%-- 자바 코드로 작성한 결과를 출력해주는 용도이다. --%>
	<%-- expression Tag는 세미콜론을 사용하면 에러가 난다. --%>
	<h4>1부터 10까지의 합은 <span style="color:red; font-size:16pt;"><%= total %></span>입니다.</h4>
	<h4>1부터 10까지의 합은 <span style="color:red; font-size:16pt;"><% out.println(total); %></span>입니다.</h4>
	
</body>
</html>
























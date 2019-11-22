<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%
	ArrayList<HashMap<String, Object>> list =
			(ArrayList<HashMap<String, Object>>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<style>
	.outer {
		width:1000px;
		height:700px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	.thumbnailArea {
		width:760px;
		height:550px;
		margin:0 auto;
	}
	.searchArea {
		width:420px;
		margin:0 auto;
	}
	.thumb-list {
		width:220px;
		border:1px solid white;
		display:inline-block;
		margin:10px;
		align:center;
	}
	.thumb-list:hover {
		opacity:0.8;
		cursor:pointer;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">사진게시판</h2>
		
		<!-- 썸네일 리스트 영역 -->
		<div class="thumbnailArea">
			<% for(int i = 0; i < list.size(); i++){ 
				   HashMap<String, Object> hmap = list.get(i);
			%>
				<div class="thumb-list" align="center">
					<div>
						<input type="hidden" value="<%= hmap.get("bid") %>">
						<img src="/jsp/thumbnail_uploadFiles/<%=hmap.get("changeName")%>" width="200px" height="150px">
					</div>
					<p>No. <%= hmap.get("bno") %> <%= hmap.get("btitle") %><br>
					조회수 : <%= hmap.get("bcount") %></p>
				</div>
			
			<% } %>
		</div> <!-- 썸네일 리스트 영역 끝 -->
		<script>
			$(function(){
				$(".thumb-list").click(function(){
					var num = $(this).children().children().eq(0).val();
					console.log(num);
					
					location.href="<%=request.getContextPath()%>/selectOne.tn?num=" + num;
				});
			});
		</script>
		
		<!-- 검색영역 -->
		<div class="searchArea">
			<select id="searchCondition" name="serchCondition">
				<option value="writer">작성자</option>
				<option value="title">제목</option>
				<option value="content">내용</option>
			</select>
			<input type="search">
			<button type="submit">검색하기</button>
			<% if(loginUser != null){ %>
			<button onclick="location.href='views/thumbnail/thumbnailInsertForm.jsp'">작성하기</button>
			<% } %>
		</div>
		
		
		
	</div>






</body>
</html>























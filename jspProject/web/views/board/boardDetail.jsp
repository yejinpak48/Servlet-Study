<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.jsp.board.model.vo.*"%>
<% Board b = (Board) request.getAttribute("b"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
		width:800px;
		height:500px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:50px;
	}
	td {
		border:1px solid white;
	}
	.tableArea {
		border:1px solid white;
		width:800px;
		height:350px;
		margin:0 auto;
	}
	#content {
		height:230px;
	}
	.replyArea {
		width:800px;
		color:white;
		background:black;
		margin:0 auto;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<br>
		<h2 align="center">게시판 상세 보기</h2>
		<div class="tableArea">
			<table align="center" width="800px">
				<tr>
					<td>분야</td>
					<td><span><%= b.getCategory() %></span></td>
					<td>제목</td>
					<td colspan="3"><span><%= b.getbTitle() %></span></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><span><%= b.getbWriter() %></span></td>
					<td>조회수</td>
					<td><span><%= b.getbCount() %></span></td>
					<td>작성일</td>
					<td><span><%= b.getbDate() %></span></td>
				</tr>
				<tr>
					<td colspan="6">내용</td>
				</tr>
				<tr>
					<td colspan="6">
						<p id="content"><%= b.getbContent() %></p>
					</td>
				</tr>
			</table>
		</div>
		<div align="center">
			<button onclick="location.href='<%=request.getContextPath()%>/selectList.bo'">메뉴로 돌아가기</button>
		</div>
	</div>
	
	<div class="replyArea">
		<div class="replyWriteArea">
			<table align="center">
				<tr>
					<td>댓글 작성</td>
					<td><textarea rows="3" cols="80" id="replyContent"></textarea></td>
					<td><button id="addReply">댓글 등록</button></td>
				</tr>
			</table>
		</div>
		<div>
			<table id="replySelectTable" border="1" align="center">
				<tbody></tbody>
			</table>
		</div>
	</div>
	<script>
		$(function(){
			$("#addReply").click(function(){
				var writer = <%= loginUser.getUno() %>;
				var bid = <%= b.getBid() %>;
				var content = $("#replyContent").val();
				
				$.ajax({
					url:"/jsp/insertReply.bo",
					data:{writer:writer, content:content, bid:bid},
					type:"post",
					success:function(data){
						//console.log(data);
						
						var $replySelectTable = $("#replySelectTable tbody");
						$replySelectTable.html("");
						
						for(var key in data){
							var $tr = $("<tr>");
							var $writeTd = $("<td>").text(data[key].bWriter).css("width", "100px");
							var $contentTd = $("<td>").text(data[key].bContent).css("width", "400px");
							var $dateTd = $("<td>").text(data[key].bDate).css("width", "200px");
							
							console.log($writeTd)
							
							$tr.append($writeTd);
							$tr.append($contentTd);
							$tr.append($dateTd);
							$replySelectTable.append($tr);
						}
						
						
					},
					error:function(){
						console.log("실패!");
					}
				});
			});
		});
	</script>


</body>
</html>




























<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.kh.jsp.board.model.vo.*"%>
<%
	Board b = (Board) request.getAttribute("b");
	ArrayList<Attachment> fileList = 
			(ArrayList<Attachment>) request.getAttribute("fileList");
	Attachment titleImg = fileList.get(0);
	Attachment detailImg1 = fileList.get(1);
	Attachment detailImg2 = fileList.get(2);
	Attachment detailImg3 = fileList.get(3);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.outer {
		width:1000px;
		height:650px;
		background:black;
		color:white;
		margin-left:auto;
		margin-right:auto;
		margin-top:auto;
	}
	.detail td {
		text-align:center;
		border:1px solid white;
	}
	#titleImgArea {
		width:500px;
		height:300px;
		margin:0 auto;
	}
	.detailImgArea {
		width:250px;
		height:210px;
		margin:0 auto;
	}
	#titleImg {
		width:500px;
		height:300px;
	}
	.detailImg {
		width:250px;
		height:180px;
	}
</style>
</head>
<body>
	<%@ include file="../common/menubar.jsp" %>
	<div class="outer">
		<table class="detail" align="center">
			<tr>
				<td width="50px">제목</td>
				<td colspan="5"><label><%= b.getbTitle() %></label></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><label><%= b.getbWriter() %></label></td>
				<td>조회수</td>
				<td><label><%= b.getbCount() %></label></td>
				<td>작성일</td>
				<td><label><%= b.getbDate() %></label></td>
			</tr>
			<tr>
				<td>대표사진</td>
				<td colspan="4">
					<div id="titleImgArea" align="center">
						<img id="titleImg" src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=titleImg.getChangeName()%>">
					</div>
				</td>
				<td>
					<button onclick="location.href='<%=request.getContextPath()%>/download.tn?num=<%=titleImg.getFid()%>'">다운로드</button>
				</td>
			</tr>
			<tr>
				<td>사진메모</td>
				<td colspan="6">
					<p id="contentArea"><%= b.getbContent() %></p>
				</td>
			</tr>
		</table>
		<table class="detail" align="center">
			<tr>
				<td>
					<div class="detailImgArea">
						<img id="detailImg1" class="detailImg"
						src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=detailImg1.getChangeName()%>">
						<button>다운로드</button>
					</div>
				</td>
				<td>
					<div class="detailImgArea">
						<img id="detailImg2" class="detailImg"
						src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=detailImg2.getChangeName()%>">
						<button>다운로드</button>
					</div>
				</td>
				<td>
					<div class="detailImgArea">
						<img id="detailImg3" class="detailImg"
						src="<%=request.getContextPath()%>/thumbnail_uploadFiles/<%=detailImg3.getChangeName()%>">
						<button>다운로드</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>






















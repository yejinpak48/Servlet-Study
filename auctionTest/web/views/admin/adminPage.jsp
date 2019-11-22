<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kh.auction.member.model.vo.*"%>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<% if(loginUser != null && loginUser.getUserId().equals("admin")){ %>
		<h1 align="center">관리자가 '갑'인 경매사이트 관리자페이지 </h1>
		<br>
		<div align="center">
			<div><img id="product" width="200" height="150" style="background:yellowgreen"></div>
			<input type="file" name="productFile" id="productFile"><br><br>
			<table align="center">
				<tr>
					<td>경매 물품명 : </td>
					<td><input type="text" name="productName" id="productName"></td>
				</tr>
				<tr>
					<td>경매 시작 가격 : </td>
					<td><input type="text" name="startPrice" id="startPrice"></td>
				</tr>
				<tr>
					<td>경매 희망 시간 : </td>
					<td>
						<input type="text" name="hour" size="1" id="hour">시간 &nbsp;
						<input type="text" name="min" size="1" id="min">분 &nbsp;
						<input type="text" name="sec" size="1" id="sec">초
					</td>
				</tr>
			</table>
			<br>
			<button id="startBtn" class="btn btn-danger" onclick="getConnection();">경매 시작하기</button>
			<br><br>
			<label>잔여 경매 시간 : </label>
			<label id="remainTime">00 : 00 : 00</label>
			<br><br>
			<label>최고 입찰자 : </label>
			<label id="selector"></label>
			<br><br>
			<label>최고 입찰 금액 : </label>
			<label id="bestPrice"></label>
		</div>
		
		<script>
			$(function(){
				$("#productFile").hide();
				getConnection2();
			})
		
			function getConnection(){
				ws = new WebSocket("ws://localhost:8001" + '<%=request.getContextPath()%>/serverStart');
				//서버 시작할 때 동작
				ws.onopen = function(event){
					var productName = $("#productName").val();
					var startPrice = $("#startPrice").val();
					var hour = $("#hour").val();
					var min = $("#min").val();
					var sec = $("#sec").val();
					
					var sendText = productName + ":" + startPrice + ":" + hour + ":" + min + ":" + sec;
					
					ws.send(sendText);
					
					interval();
				}
				//서버로부터 메세지를 전달 받을 때 동작하는 메소드
				ws.onmessage = function(event){
					onMessage(event);
				}
				
				//서버에서 에러가 발생할 경우 동작할 메소드
				ws.onerror = function(event){
					onError(event);
				}
				
				//서버와의 연결이 종료될 경우 동작하는 메소드
				ws.onclose = function(event){
					onClose(event);
				}
			
			}
			
			function send(msg){
				ws.send(msg);
			}
			
			function onMessage(event){
				var serverMessage = event.data.split(":");
				
				var productName = serverMessage[0];
				var startPrice = serverMessage[1];
				var currentPrice = serverMessage[1];
				var remainHour = serverMessage[2];
				var remainMin = serverMessage[3];
				var remainSec = serverMessage[4];
				
				$remainTime = $("#remainTime");
				
				$remainTime.html(remainHour + " : " + remainMin + " : " + remainSec);
			}
			
			function onError(event){
				alert(event.data);
			}
			
			function onClose(event){
				alert(event);
			}
			
			function interval(){
				count = 0;
				console.log(count);
				
				var timeCount = window.setInterval(function(){
					var productName = $("#productName").val();
					var startPrice = $("#startPrice").val();
					var remainTime = $("#remainTime").text();
					count++;
					console.log(remainTime);
					var arr = remainTime.split(" : ");
					
					var hour = arr[0];
					var min = arr[1];
					var sec = arr[2];
					
					setTimeout(function(){
						clearInterval(timeCount);
					}, 30000)
					
					if(hour > 0){
						if(min > 0){
							if(sec > 0){
								sec--;
							}else{
								sec = 59;
								min--;
							}
						}else{
							hour--;
							
							min = 59;
						}
					}else{
						if(min > 0){
							if(sec > 0){
								sec--;
							}else{
								sec = 59;
								min--;
							}
						}else{
							hour--;
							
							min = 59;
						}
					}
					
					var sendText = productName + ":" + startPrice + ":" + hour + ":" + min + ":" + sec;
					
					ws.send(sendText);
				}, 50);
			}
			
			function getConnection2(){
				ws2 = new WebSocket("ws://localhost:8001" + "<%=request.getContextPath()%>/auctionStart");
				
				ws2.onopen2 = function(event){

				}
				//서버로부터 메세지를 전달 받을 때 동작하는 메소드
				ws2.onmessage = function(event){
					onMessage2(event);
				}
				
				//서버에서 에러가 발생할 경우 동작할 메소드
				ws2.onerror = function(event){
					onError2(event);
				}
				
				//서버와의 연결이 종료될 경우 동작하는 메소드
				ws2.onclose = function(event){
					onClose2(event);
				}
			}
			
			
			function onMessage2(event){
				var msg = event.data.split(":");
				var user = msg[0];
				var price = msg[1];
				
				$("#selector").html(user);
				$("#bestPrice").html(price);
			}
			
			function onError2(event){
				alert(event.data);
			}
			
			function onClose2(event){
				alert(event);
			}
		</script>



		
	<% }else{ 
		request.setAttribute("msg", "넌 뭐야?");
		request.getRequestDispatcher("../common/errorPage.jsp").forward(request, response);
	} %>
	
</body>
</html>
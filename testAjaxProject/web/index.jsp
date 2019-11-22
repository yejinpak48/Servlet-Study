<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(function(){
		//1번
		$("#nameBtn").click(function(){
			var name = $("#myName").val();
			
			$.ajax({
				url:"test1.do",
				data:{name:name},
				type:"get",
				success:function(data){
					console.log("서버 전송 성공!");
				},
				error:function(err){
					console.log("서버 전송 실패!");
				},
				complete:function(data){
					console.log("무조건 호출되는 함수");
				}
			});
		});
		
		//2번
		$("#getServerTextBtn").click(function(){
			$.ajax({
				url:"test2.do",
				type:"get",
				success:function(data){
					$("#p1").text(data);
				},
				error:function(){
					console.log("실패!");
				}
			});
		});
		
		//3번
		$("#plusBtn").click(function(){
			var firstNum = $("#firstNum").val();
			var secondNum = $("#secondNum").val();
			
			$.ajax({
				url:"test3.do",
				type:"get",
				data:{firstNum:firstNum, secondNum:secondNum},
				success:function(data){
					$("#p2").text(data);
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//4번
		$("#studentTest").click(function(){
			var student1 = $("#student1").val();
			var student2 = $("#student2").val();
			var student3 = $("#student3").val();
			
			var student = {student1:student1, student2:student2, student3:student3};
			
			$.ajax({
				url:"test4.do",
				data:student,
				type:"get",
				success:function(data){
					console.log("성공!");
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//5번
		$("#getUserInfoBtn").click(function(){
			var userIndex = $("#userIndex").val();
			
			$.ajax({
				url:"test5.do",
				data:{userIndex:userIndex},
				type:"get",
				success:function(data){
					//console.log(data);
					
					var resultStr = data.userNo + ", "
								+ decodeURIComponent(data.userName) + ", "
								+ decodeURIComponent(data.userNation);
					
					$("#p3").val(resultStr);
					
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//6번
		$("#getUserInfoBtn2").click(function(){
			var userIndex = $("#userIndex2").val();
			
			$.ajax({
				url:"test6.do",
				data:{userIndex:userIndex},
				type:"get",
				success:function(data){
					//console.log(data);
					
					var resultText = "";
					
					for(var key in data){
						var user = data[key];
						
						resultText += user.userNo + ", ";
						resultText += decodeURIComponent(user.userName) + ", ";
						resultText += decodeURIComponent(user.userNation) + "\n";
					}
					$("#p4").text(resultText);
					
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//7번
		$("#getUserInfoBtn3").click(function(){
			$.ajax({
				url:"test7.do",
				data:{userIndexes:$("#userIndex3").val()},
				type:"get",
				success:function(data){
					console.log(data);
					
					var resultText = "";
					
					for(var key in data.list){
						var user = data.list[key];
						resultText += user.userNo + ", ";
						resultText += decodeURIComponent(user.userName) + ", ";
						resultText += decodeURIComponent(user.userNation) + "\n";
					}
					
					$("#p5").text(resultText);
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//8번
		$("#getUserInfoBtn4").click(function(){
			$.ajax({
				url:"test8.do",
				data:{userIds:$("#userIndex4").val()},
				type:"get",
				success:function(data){
					//console.log(data);
					
					var resultStr = "";
					for(var key in data){
						var user = data[key];
						resultStr += user.userNo + ", ";
						resultStr += decodeURIComponent(user.userName) + ", ";
						resultStr += decodeURIComponent(user.userNation) + "\n";
					}
					$("#p6").val(resultStr);
				},
				error:function(data){
					console.log("실패!");
				}
			});
		});
		
		//9번
		$("#userInfoBtn").click(function(){
			$.ajax({
				url:"test9.do",
				type:"get",
				success:function(data){
					//console.log(data);
					
					var $tableBody = $("#userInfoTable tbody");
					
					$tableBody.html("");
					
					$.each(data, function(index, value){
						var $tr = $("<tr>");
						var $noTd = $("<td>").text(value.userNo);
						var $nameTd = $("<td>").text(decodeURIComponent(value.userName));
						var $nationTd = $("<td>").text(decodeURIComponent(value.userNation));
						
						$tr.append($noTd);
						$tr.append($nameTd);
						$tr.append($nationTd);
						
						$tableBody.append($tr);
					})
					
					
				},
				error:function(data){
					console.log("실패!");
				}
			})
		})
		
		//10번
		$("#selectListBtn").click(function(){
			$.ajax({
				url:"test10.do",
				type:"get",
				success:function(data){
					//console.log(data);
					
					var $select = $("#selectListTest");
					
					$select.find("option").remove();
					
					for(var i = 0; i < data.length; i++){
						var name = decodeURIComponent(data[i].userName);
						var selected = (name == $("#selectUserName").val()?"selected":"");
						
						$select.append("<option value='" + data[i].userNo + "' " + selected  + ">" + name + "</option>");
					}
					
				},
				error:function(data){
					console.log("실패!");
				}
			})
		});
		
		//11번
		$("#gsonListBtn").click(function(){
			
			$.ajax({
				url:"test11.do",
				type:"get",
				success:function(data){
					//console.log(data);
					
					var $select = $("#gsonListSelect");
					$select.find("option").remove();
					
					for(var key in data){
						var $option = $("<option>");
						$option.val(data[key].userNo);
						$option.text(data[key].userName);
						$select.append($option);
					}
					
				},
				error:function(data){
					console.log("실패!");
				}
			})
		});
		
		//12번
		$("#gsonMapBtn").click(function(){
			$.ajax({
				url:"test12.do",
				type:"get",
				success:function(data){
					console.log(data);
					var $select = $("#gsonMapSelect");
					$select.find("option").remove();
					
					for(var key in data){
						var $option = $("<option>");
						$option.val(data[key].userNo);
						$option.text(data[key].userName);
						$select.append($option);
					}
					
				},
				error:function(data){
					console.log("실패!");
				}
			})
		})
		
	});
</script>
</head>
<body>
	<h1 align="center">JQuery를 이용한 Ajax 테스트</h1>
	<h1>1. 버튼 선택 시 전송 값 서버에 출력</h1>
	<label>이름 : </label>
	<input type="text" id="myName">
	<button id="nameBtn">이름 보내기</button>
	<hr>
	
	<h2>2. 버튼 선택 시 서버에서 보낸 값 사용자가 수신 확인</h2>
	<button id="getServerTextBtn">서버에서 보낸 값 확인</button>
	<p id="p1" style="width:300px; height:50px; border:1px solid red"></p>
	<hr>
	
	<h1>3. 서버로 기본형 전송값 있고, 결과로 문자열 받아 처리하는 방법</h1>
	<h3>두 개의 값을 더한 결과를 받아옴</h3>
	첫 번째 숫자 : <input type="text" id="firstNum"><br>
	두 번째 숫자 : <input type="text" id="secondNum"><br>
	<button id="plusBtn">결과확인</button>
	<p id="p2" style="width:300px; height:50px; border:1px solid red"></p>
	<hr>
	
	<h1>4. 서버로 Object 형태의 데이터 전송, 서버에서 처리 후 서버 console에 출력</h1>
	학생1 : <input type="text" id="student1"><br>
	학생2 : <input type="text" id="student2"><br>
	학생3 : <input type="text" id="student3"><br>
	<button id="studentTest">4번 결과 확인</button>
	<hr>
	
	<h1>5. 서버로 기본형 데이터 전송, 서버에서 객체 반환</h1>
	<h3>유저 번호 보내서 해당 유저 정보 가져오기</h3>
	유저 정보(순번) : <input type="text" id="userIndex">
	<button id="getUserInfoBtn">정보 가져 오기</button><br>
	<textarea id="p3" style="border:1px solid red;" cols="40" rows="5"></textarea>
	<hr>
	
	<h1>6. 기본값 전송, 서버에서 리스트 객체 반환</h1>
	<h3>유저 번호 요청 -> 해당 유저가 있는 경우 유저 정보, 없는 경우 전체 가져오기</h3>
	유저 정보(순번) : <input type="text" id="userIndex2">
	<button id="getUserInfoBtn2">정보 가져 오기</button><br>
	<textarea id="p4" style="border:1px solid red;" cols="40" rows="5"></textarea>
	<hr>
	
	<h1>7. 여러 값 전송, 서버에서 리스트 객체 반환</h1>
	<h3>유저 번호를 전송 -> 현재 있는 유저 정보만 모아서 출력</h3>
	유저 번호 (번호, 번호, 번호) : <input type="text" id="userIndex3">
	<button id="getUserInfoBtn3">정보 가져오기</button><br>
	<textarea id="p5" style="border:1px solid red;" cols="40" rows="5"></textarea>
	<hr>
	
	<h1>8. 서버로 기본형 데이터 여러 개 전송, 서버에서 맵 형태의 객체 반환</h1>
	<h3>이하 내용은 7번 문제와 동일</h3>
	유저 번호(번호, 번호, 번호) : <input type="text" id="userIndex4">
	<button id="getUserInfoBtn4">정보 가져 오기</button><br>
	<textarea id="p6" style="border:1px solid red;" cols="40" rows="5"></textarea>
	<hr>
	
	
	<h1>9. 서버 유저 정보로 표 구성하기</h1>
	<button id="userInfoBtn">유저 정보 불러오기</button>
	<table id="userInfoTable" border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>국적</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	<hr>
	
	<h1>10. 서버에서 List객체 반환</h1>
	유저 이름 : <input type="text" id="selectUserName">
	<button id="selectListBtn">목록 가져 오기</button>
	<select id="selectListTest"></select>
	
	<hr>
	
	<h1>11. Gson을 이용한 리스트 반환</h1>
	<button id="gsonListBtn">list 가져오기</button><br>
	<select id="gsonListSelect"></select>
	<hr>
	
	<h1>12. Gson을 이용한 Map 반환</h1>
	<button id="gsonMapBtn">Map 가져오기</button>
	<select id="gsonMapSelect"></select>
	
	
</body>
</html>





















<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width"/>
<title>Login Demo - Kakao JavaScript SDK</title>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<body>
<a id="kakao-login-btn" href="https://kauth.kakao.com/oauth/authorize?client_id=c0d1a908cd87c1bcccaebb29fbf807c5&redirect_uri=http://localhost:8001/kakaoLoginTest/kakaoLogin&response_type=code"></a>
<script type='text/javascript'>
  //<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('b69d26629816e09eaec0f6cad0c17920');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
    	  Kakao.API.request({

    	       url: '/v1/user/me',

    	       success: function(res) {
    	             
    	             console.log(authObj);
    	             console.log(res);

    	           }

    	         })


      },
      fail: function(err) {
         alert(JSON.stringify(err));
      }
    });
  //]]>
</script>	


</body>
</html>
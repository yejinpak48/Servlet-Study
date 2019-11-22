package com.kh.kakao.model.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class KakaoLoginService {
	
	public String getAccessToken(String authCode) {
		String accessToken = "";
		String refreshToken = "";
		String reqUrl = "https://kauth.kakao.com/oauth/token";
		
		try {
			//url 연결을 위한 Connection 생성
			URL url = new URL(reqUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//API 요청 방식에 따라 메소드 변경
			conn.setRequestMethod("POST");
			//POST요청을 위해 기본값이 false인 setDoOutput을 true로 변경
			conn.setDoOutput(true);
			
			
			//POST요청에 필요로 하는 파라미터 스트림을 통해 전송
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=c0d1a908cd87c1bcccaebb29fbf807c5");
            sb.append("&redirect_uri=http://localhost:8001/kakaoLoginTest/kakaoLogin");
            sb.append("&code=" + authCode);
            bw.write(sb.toString());
            bw.flush();
            
            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";
            
            while ((line = br.readLine()) != null) {
                result += line;
            }
            
            System.out.println("response body : " + result);
            
            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);
            
            accessToken = element.getAsJsonObject().get("access_token").getAsString();
            refreshToken = element.getAsJsonObject().get("refresh_token").getAsString();
            
            System.out.println("access_token : " + accessToken);
            System.out.println("refresh_token : " + refreshToken);
            
            br.close();
            bw.close();
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		return accessToken;
	}
	
	public HashMap<String, Object> getUserInfo(String accessToken){
		
		 HashMap<String, Object> userInfo = new HashMap<>();
		 String reqURL = "https://kapi.kakao.com/v2/user/me";
		 
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setRequestMethod("POST");
		    
		    conn.setRequestProperty("Authorization", "Bearer " + accessToken);
		    
		    int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String line = "";
	        String result = "";
	        
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        System.out.println("response body : " + result);
	        
	        JsonParser parser = new JsonParser();
	        JsonElement element = parser.parse(result);
	        
	        JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
	        JsonObject kakaoAccount = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
	        
	        String id = element.getAsJsonObject().get("id").getAsString();
	        String nickname = properties.getAsJsonObject().get("nickname").getAsString();
	        String email = "";
	        if(kakaoAccount.getAsJsonObject().get("email") != null) {
	        	email = kakaoAccount.getAsJsonObject().get("email").getAsString();
	        }
	        
	        userInfo.put("id", id);
	        userInfo.put("nickname", nickname);
	        userInfo.put("email", email);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
		 
		 return userInfo;
	}
	
}

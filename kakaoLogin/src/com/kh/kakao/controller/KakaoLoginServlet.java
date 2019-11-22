package com.kh.kakao.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.kakao.model.service.KakaoLoginService;

/**
 * Servlet implementation class KakaoLoginServlet
 */
@WebServlet("/kakaoLogin")
public class KakaoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		
		System.out.println("code : " + code);
		
		String accessToken = new KakaoLoginService().getAccessToken(code);
		
		System.out.println("controller accessToken : " + accessToken);
		
		HashMap<String, Object> userInfo = new KakaoLoginService().getUserInfo(accessToken);
	    System.out.println("login Controller : " + userInfo);
	} 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

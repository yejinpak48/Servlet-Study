package com.kh.ajax.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.ajax.model.vo.User;

/**
 * Servlet implementation class TestServlet12
 */
@WebServlet("/test12.do")
public class TestServlet12 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet12() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, User> userMap = new HashMap<String, User>();
		User user1 = new User(1, "홍길동", "한국");
		User user2 = new User(2, "수지", "일본");
		User user3 = new User(3, "페이", "중국");
		User user4 = new User(4, "박문수", "일본");
		User user5 = new User(5, "김진호", "한국");
		User user6 = new User(6, "유병승", "호주");
		User user7 = new User(7, "유정훈", "미국");
		User user8 = new User(8, "노민수", "프랑스");
		User user9 = new User(9, "김동현", "호주");
		User user10 = new User(10, "강보람", "독일");
		
		userMap.put(user1.getUserName(), user1);
		userMap.put(user2.getUserName(), user2);
		userMap.put(user3.getUserName(), user3);
		userMap.put(user4.getUserName(), user4);
		userMap.put(user5.getUserName(), user5);
		userMap.put(user6.getUserName(), user6);
		userMap.put(user7.getUserName(), user7);
		userMap.put(user8.getUserName(), user8);
		userMap.put(user9.getUserName(), user9);
		userMap.put(user10.getUserName(), user10);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(userMap, response.getWriter());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}












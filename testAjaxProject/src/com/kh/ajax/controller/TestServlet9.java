package com.kh.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.ajax.model.vo.User;

/**
 * Servlet implementation class TestServlet9
 */
@WebServlet("/test9.do")
public class TestServlet9 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet9() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> userList = new ArrayList<User>();
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
		
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		userList.add(user6);
		userList.add(user7);
		userList.add(user8);
		userList.add(user9);
		userList.add(user10);
		
		JSONArray result = new JSONArray();
		JSONObject userInfo = null;
		
		for(User user : userList) {
			userInfo = new JSONObject();
			userInfo.put("userNo", user.getUserNo());
			userInfo.put("userName", URLEncoder.encode(user.getUserName(), "UTF-8"));
			userInfo.put("userNation", URLEncoder.encode(user.getUserNation(), "UTF-8"));
			
			result.add(userInfo);
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(result.toJSONString());
		out.flush();
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














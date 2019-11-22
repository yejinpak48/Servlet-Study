package controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cycle")
public class LifeCycleServlet extends HttpServlet{
	
	private int initCount = 1;
	private int doGetCount = 1;
	private int destroyCount = 1;
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("init 메소드는 첫 요청 시 한 번만 호출됨 : " + initCount++);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		System.out.println("doGet메소드는 요청시마다 호출됨 : " + doGetCount++);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드는 톰캣 종료 시 호출됨 : " + destroyCount++);
	}
}












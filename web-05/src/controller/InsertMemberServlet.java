package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.MemberService;
import model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");

		//2. 전송값 꺼내서 변수에 기록하기
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String userName = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String[] hobbyArr = request.getParameterValues("hobby");
		
		String hobby = String.join(",", hobbyArr);
		
		//service로 전달하기 위해 Member객체 생성
		Member m = new Member();

		//Service의 메소드 호출
		MemberService ms = new MemberService();
		int result = ms.insertMember(m);
		
		
		//성공 실패 여부에 따라 메세지와 페이지 결정
		String msg = "";
		String page = "";
		
		if(result > 0) {
			msg = "회원가입에 성공하셨습니다.";
			page = "views/03_insertSuccess.jsp";
		}else {
			msg = "회원 가입에 실패하였습니다.";
			page = "views/03_insertFail.jsp";
		}
		
		//request에 메세지 담기
		request.setAttribute("msg", msg);
		
		
		//결정된 페이지로 포워딩
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

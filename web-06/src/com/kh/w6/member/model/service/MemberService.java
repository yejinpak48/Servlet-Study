package com.kh.w6.member.model.service;

import java.sql.Connection;

import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.dao.MemberDao;
import com.kh.w6.member.model.vo.Member;
import static com.kh.w6.common.JDBCTemplate.*;

public class MemberService {

	public Member loginCheck(Member reqMember) {
		Connection con = getConnection();
		
		MemberDao md = new MemberDao();
		
		int result = md.checkStatus(con, reqMember);
		
		Member loginUser = new Member();
		
		if(result == LoginServlet.LOGIN_OK) {
			loginUser = md.selectOne(con, reqMember);
			loginUser.setStatus(LoginServlet.LOGIN_OK);
		}else {
			if(result == LoginServlet.WRONG_PASSWORD) {
				loginUser.setStatus(LoginServlet.WRONG_PASSWORD);
			}else {
				loginUser.setStatus(LoginServlet.ID_NOT_EXIST);
			}
		}
		
		close(con);
		
		return loginUser;
	}

}


















package com.kh.jsp.member.model.service;

import static com.kh.jsp.common.JDBCTemplate.*;
import static com.kh.jsp.common.JDBCTemplate.getConnection;

import java.sql.Connection;

import com.kh.jsp.member.model.dao.MemberDao;
import com.kh.jsp.member.model.vo.Member;

public class MemberService {
	//로그인용 메소드
	public Member loginCheck(String userId, String userPwd) {
		Connection con = getConnection();
		
		System.out.println(con);
		
		Member loginUser = new MemberDao().loginCheck(con, userId, userPwd);
		
		close(con);
		
		return loginUser;
	}

	public int insertMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, m);
		
		if(result > 0) { 
			commit(con);
		} else { 
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int idCheck(String userId) {
		Connection con = getConnection();
		
		int result = new MemberDao().idCheck(con, userId);
		
		close(con);
		
		return result;
	}

}


















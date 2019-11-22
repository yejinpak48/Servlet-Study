package com.kh.w7.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.w7.member.model.dao.MemberDao;
import com.kh.w7.member.model.vo.Member;
import static com.kh.w7.common.JDBCTemplate.*;

public class MemberService {
	//로그인용 메소드
	public Member loginCheck(String userId, String password) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, userId, password);
		
		close(con);
		
		return loginUser;
	}
	//회원가입용 메소드
	public int insertMember(Member m) {
		Connection con = getConnection();
		
		int result = new MemberDao().insertMember(con, m);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//회원 목록 전체 조회
	public ArrayList<Member> selectAll() {
		Connection con = getConnection();
		
		ArrayList<Member> list = new MemberDao().selectAll(con);
		
		close(con);
		
		return list;
	}
	public ArrayList<Member> searchMember(String searchCondition, String searchValue) {
		Connection con = getConnection();
		
		ArrayList<Member> list = null;
		
		MemberDao md = new MemberDao();
		
		if(searchCondition.equals("findId")) {
			list = md.searchId(con, searchValue);
		}else if(searchCondition.equals("findName")){
			list = md.searchName(con, searchValue);
		}else {
			list = md.searchGender(con, searchValue);
		}
		
		close(con);
		
		return list;
	}

}

















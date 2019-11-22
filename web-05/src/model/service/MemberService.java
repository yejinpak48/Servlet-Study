package model.service;

import java.sql.Connection;

import model.dao.MemberDao;
import model.vo.Member;

import static common.JDBCTemplate.*;

public class MemberService {
	public int insertMember(Member m) {
		//Connection 생성
		Connection con = getConnection();
		
		//Dao메소드 호출
		int result = new MemberDao().insertMember(con, m);
		
		//성공 실패 여부에 따라 트랜젝션 처리
		if(result > 0){
			commit(con);
		}else{
			rollback(con);
		}
		
		//커넥션 닫기
		close(con);
		
		//insert결과 리턴
		return result;
	}
	
}

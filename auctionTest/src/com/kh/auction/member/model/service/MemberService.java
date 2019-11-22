package com.kh.auction.member.model.service;

import java.sql.Connection;
import static com.kh.auction.common.JDBCTemplet.*;

import com.kh.auction.member.model.dao.MemberDao;
import com.kh.auction.member.model.vo.Member;

public class MemberService {

	public Member loginCheck(Member reqMember) {
		Connection con = getConnection();
		
		Member loginUser = new MemberDao().loginCheck(con, reqMember);
		
		close(con);
		
		return loginUser;
	}

}

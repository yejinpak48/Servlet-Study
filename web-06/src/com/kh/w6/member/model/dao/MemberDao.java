package com.kh.w6.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.vo.Member;

import static com.kh.w6.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public int checkStatus(Connection con, Member reqMember) {
		PreparedStatement pstmt = null;
		int result = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("checkStatus");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getUserId());
			
			rset = pstmt.executeQuery();
			
			String userId = "";
			String password = "";
			
			if(rset.next()) {
				userId = rset.getString("USER_ID");
				password = rset.getString("USER_PWD");
			}
			
			if(reqMember.getUserId().equals(userId) &&
					reqMember.getPassword().equals(password)) {
				result = LoginServlet.LOGIN_OK;
			}else if(reqMember.getUserId().equals(userId) &&
					!reqMember.getPassword().equals(password)) {
				result = LoginServlet.WRONG_PASSWORD;
			}else {
				result = LoginServlet.ID_NOT_EXIST;
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return result;
	}


	public Member selectOne(Connection con, Member reqMember) {
		Member loginUser = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, reqMember.getUserId());
			pstmt.setString(2, reqMember.getPassword());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member();
				
				loginUser.setUserId(rset.getString("USER_ID"));
				loginUser.setPassword(rset.getString("USER_PWD"));
				loginUser.setUserName(rset.getString("USER_NAME"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setAge(rset.getInt("AGE"));
				loginUser.setEmail(rset.getString("EMAIL"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setAddress(rset.getString("ADDRESS"));
				loginUser.setHobby(rset.getString("HOBBY"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return loginUser;
	}

}





















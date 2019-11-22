package com.kh.jsp.notice.model.service;

import static com.kh.jsp.common.JDBCTemplate.close;
import static com.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jsp.notice.model.dao.NoticeDao;
import com.kh.jsp.notice.model.vo.Notice;

public class NoticeService {
	//공지사항 전체 조회용 메소드
	public ArrayList<Notice> selectList() {
		
		Connection con = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectList(con);
		
		close(con);
		
		return list;
	}
	//공지사항 작성용
	public int insertNotice(Notice n) {
		Connection con = getConnection();
		
		int result = new NoticeDao().insertNotice(con, n);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	//공지사항 상세 보기용 메소드
	public Notice selectOne(int num) {
		Connection con = getConnection();
		
		Notice n = new NoticeDao().selectOne(con, num);
		
		if(n != null) {
			int result = new NoticeDao().updateCount(con, num);
			
			if(result > 0) {
				commit(con);
			}else {
				rollback(con);
			}
		}
		
		close(con);
				
		return n;
	}

}























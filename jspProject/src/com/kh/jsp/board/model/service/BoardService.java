package com.kh.jsp.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.jsp.board.model.dao.BoardDao;
import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;

import static com.kh.jsp.common.JDBCTemplate.*;

public class BoardService {
	//게시물 목록 전체 조회용 메소드
	public ArrayList<Board> selectList() {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(con);
		
		close(con);
				
		return list;
	}
	//게시물 작성용 메소드
	public int insertBoard(Board b) {
		Connection con = getConnection();
		
		int result = new BoardDao().insertBoard(con, b);
		
		if(result > 0) {
			commit(con);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
	//전체 게시물 수 조회용 메소드
	public int getListCount() {
		Connection con = getConnection();
		
		int listCount = new BoardDao().getListCount(con);
		
		close(con);
		
		return listCount;
	}
	//페이징 처리 후 게시물 목록 조회용 메소드
	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
	}
	//썸네일 게시판 작성용 메소드
	public int insertThumbnail(Board b, ArrayList<Attachment> fileList) {
		Connection con = getConnection();
		
		int result = 0;
		
		int result1 = new BoardDao().insertThumbnailContent(con, b);
		
		if(result1 > 0) {
			int bid = new BoardDao().selectCurrval(con);
			
			for(int i = 0; i < fileList.size(); i++) {
				fileList.get(i).setBid(bid);
			}
		}
		
		int result2 = new BoardDao().insertAttachment(con, fileList);
		
		if(result1 > 0 && result2 > 0) {
			commit(con);
			result = 1;
		}else {
			rollback(con);
		}
		
		return result;
	}
	public ArrayList<HashMap<String, Object>> selectThumbnailList() {
		Connection con = getConnection();
		
		ArrayList<HashMap<String, Object>> list =
				new BoardDao().selectThumbnailList(con);
		
		close(con);
		
		return list;
	}
	public HashMap<String, Object> selectThumbnailMap(int num) {
		Connection con = getConnection();
		
		HashMap<String, Object> hmap = null;
		
		int result = new BoardDao().updateCount(con, num);
		
		if(result > 0) {
			commit(con);
			hmap = new BoardDao().selectThumbnailMap(con, num);
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return hmap;
	}
	public Attachment selectOneAttachment(int num) {
		Connection con = getConnection();
		
		Attachment file = new BoardDao().selectOneAttachment(con, num);
		
		close(con);
		
		return file;
	}
	public Board selectOne(int num) {
		Connection con = getConnection();
		Board b = null;
		
		int result = new BoardDao().updateCount(con, num);
		
		if(result > 0) {
			commit(con);
			b = new BoardDao().selectOne(con, num);
		}else {
			rollback(con);
		}
		
		close(con);
		
		return b;
	}
	public ArrayList<Board> insertReply(Board b) {
		Connection con = getConnection();
		ArrayList<Board> replyList = null;
		
		int result = new BoardDao().insertReply(con, b);
		
		if(result > 0) {
			commit(con);
			replyList = new BoardDao().selectReplyList(con, b.getBid());
		}else {
			rollback(con);
		}
		
		close(con);
		
		
		return replyList;
	}

}






















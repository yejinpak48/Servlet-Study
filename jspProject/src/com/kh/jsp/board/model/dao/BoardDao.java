package com.kh.jsp.board.model.dao;

import static com.kh.jsp.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.jsp.board.model.vo.Attachment;
import com.kh.jsp.board.model.vo.Board;

public class BoardDao {
	private Properties prop = new Properties();

	public BoardDao() {
		String fileName = 
				BoardDao.class.getResource("/sql/board/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Board> selectList(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectList");
		
		try {
			stmt = con.createStatement();
		
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBid(rset.getInt("BID"));
				b.setbType(rset.getInt("BTYPE"));
				b.setBno(rset.getInt("BNO"));
				b.setCategory(rset.getString("CNAME"));
				b.setbTitle(rset.getString("BTITLE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbWriter(rset.getString("NICK_NAME"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				b.setbDate(rset.getDate("BDATE"));
				b.setModifyDate(rset.getDate("MODIFY_DATE"));
				b.setStatus(rset.getString("STATUS"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		return list;
	}
	//게시물 작성용 메소드
	public int insertBoard(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(b.getCategory()));
			pstmt.setString(2, b.getbTitle());
			pstmt.setString(3, b.getbContent());
			pstmt.setString(4, b.getbWriter());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//게시물 수 조회용 메소드
	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectListCount");
		
		
		try {
			stmt = con.createStatement();

			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return listCount;
	}
	//페이징 처리 후 게시물 조회용 메소드
	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectListWithPaging");
		
		try {
			pstmt = con.prepareStatement(query);

			//조회를 시작할 행 번호와 마지막 행 번호 계산
			int startRow = (currentPage - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBid(rset.getInt("BID"));
				b.setbType(rset.getInt("BTYPE"));
				b.setBno(rset.getInt("BNO"));
				b.setCategory(rset.getString("CNAME"));
				b.setbTitle(rset.getString("BTITLE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbWriter(rset.getString("NICK_NAME"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				b.setbDate(rset.getDate("BDATE"));
				b.setStatus(rset.getString("STATUS"));
				
				list.add(b);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		
		
		return list;
	}
	//썸네일 게시판 내용 삽입용 메소드
	public int insertThumbnailContent(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertThumb");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getbTitle());
			pstmt.setString(2, b.getbContent());
			pstmt.setInt(3, Integer.parseInt(b.getbWriter()));
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	//Board테이블의 현재 sequence값을 가져오는 메소드
	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int bid = 0;
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				bid = rset.getInt("currval");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		return bid;
	}
	//첨부파일정보 insert용 메소드
	public int insertAttachment(Connection con, ArrayList<Attachment> fileList) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAttachment");
		
		try {
			for(int i = 0; i < fileList.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, fileList.get(i).getBid());
				pstmt.setString(2, fileList.get(i).getOriginName());
				pstmt.setString(3, fileList.get(i).getChangeName());
				pstmt.setString(4, fileList.get(i).getFilePath());
				
				int level = 0;
				if(i == 0) {
					level = 0;
				}else {
					level = 1;
				}
				
				pstmt.setInt(5, level);
				
				result += pstmt.executeUpdate();
					
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<HashMap<String, Object>> selectThumbnailList(Connection con) {
		Statement stmt = null;
		ArrayList<HashMap<String, Object>> list = null;
		HashMap<String, Object> hmap = null;
		ResultSet rset = null;
			
		String query = prop.getProperty("selectThumbnailMap");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<HashMap<String, Object>>();
			
			while(rset.next()) {
				hmap = new HashMap<String, Object>();
				
				hmap.put("bid", rset.getInt("BID"));
				hmap.put("bno", rset.getInt("BNO"));
				hmap.put("btitle", rset.getString("BTITLE"));
				hmap.put("bcontent", rset.getString("BCONTENT"));
				hmap.put("bwriter", rset.getString("NICK_NAME"));
				hmap.put("bcount", rset.getInt("BCOUNT"));
				hmap.put("bdate", rset.getDate("BDATE"));
				hmap.put("fid", rset.getInt("FID"));
				hmap.put("originName", rset.getString("ORIGIN_NAME"));
				hmap.put("changeName", rset.getString("CHANGE_NAME"));
				hmap.put("filePath", rset.getString("FILE_PATH"));
				hmap.put("uploadDate", rset.getString("UPLOAD_DATE"));
				
				list.add(hmap);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return list;
	}

	public int updateCount(Connection con, int num) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateCount");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			pstmt.setInt(2, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public HashMap<String, Object> selectThumbnailMap(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		HashMap<String, Object> hmap = null;
		Board b = null;
		Attachment at = null;
		ArrayList<Attachment> list = null;
		
		String query = prop.getProperty("selectThumbnailOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Attachment>();
			
			while(rset.next()) {
				b = new Board();
				b.setBid(rset.getInt("BID"));
				b.setBno(rset.getInt("BNO"));
				b.setbTitle(rset.getString("BTITLE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbWriter(rset.getString("NICK_NAME"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setbDate(rset.getDate("BDATE"));
				
				at = new Attachment();
				at.setFid(rset.getInt("FID"));
				at.setOriginName(rset.getString("ORIGIN_NAME"));
				at.setChangeName(rset.getString("CHANGE_NAME"));
				at.setFilePath(rset.getString("FILE_PATH"));
				at.setUploadDate(rset.getDate("UPLOAD_DATE"));
				
				list.add(at);
			}
			
			hmap = new HashMap<String, Object>();
			hmap.put("board", b);
			hmap.put("attachment", list);
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return hmap;
	}

	public Attachment selectOneAttachment(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Attachment file = null;
		
		String query = prop.getProperty("selectOneAttachment");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				file = new Attachment();
				
				file.setFid(rset.getInt("FID"));
				file.setBid(rset.getInt("BID"));
				file.setOriginName(rset.getString("ORIGIN_NAME"));
				file.setChangeName(rset.getString("CHANGE_NAME"));
				file.setFilePath(rset.getString("FILE_PATH"));
				file.setUploadDate(rset.getDate("UPLOAD_DATE"));
				file.setFileLevel(rset.getInt("FILE_LEVEL"));
				file.setDownloadCount(rset.getInt("DOWNLOAD_COUNT"));
				file.setStatus(rset.getString("STATUS"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rset);
		}
		
		
		return file;
	}

	public Board selectOne(Connection con, int num) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board b = null;
		
		String query = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, num);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setBid(rset.getInt("BID"));
				b.setbType(rset.getInt("BTYPE"));
				b.setBno(rset.getInt("BNO"));
				b.setCategory(rset.getString("CNAME"));
				b.setbTitle(rset.getString("BTITLE"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbWriter(rset.getString("NICK_NAME"));
				b.setbCount(rset.getInt("BCOUNT"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				b.setbDate(rset.getDate("BDATE"));
				b.setModifyDate(rset.getDate("MODIFY_DATE"));
				b.setStatus(rset.getString("STATUS"));
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return b;
	}

	public int insertReply(Connection con, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertReply");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, b.getbContent());
			pstmt.setString(2, b.getbWriter());
			pstmt.setInt(3, b.getBid());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Board> selectReplyList(Connection con, int bid) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = null;
		
		String query = prop.getProperty("selectReplyList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, bid);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setBid(rset.getInt("BID"));
				b.setbContent(rset.getString("BCONTENT"));
				b.setbWriter(rset.getString("NICK_NAME"));
				b.setRefBid(rset.getInt("REF_BID"));
				b.setReplyLevel(rset.getInt("REPLY_LEVEL"));
				b.setbDate(rset.getDate("BDATE"));
				
				list.add(b);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return list;
	}

}





















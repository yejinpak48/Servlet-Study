package test.com.kh.w6.member.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.kh.w6.common.JDBCTemplate;
import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.dao.MemberDao;
import com.kh.w6.member.model.service.MemberService;
import com.kh.w6.member.model.vo.Member;

//import lombok.extern.log4j.Log4j;

//@Log4j
public class LoginTest {
	private Connection con;
	private MemberDao md;
	private MemberService ms;
	private Member reqMember;

	@Before
	public void setUp() {
		con = JDBCTemplate.getConnection();
		assertNotNull(con);
		
		md = new MemberDao();
		assertNotNull(md);
		
		ms = new MemberService();
		assertNotNull(ms);
		
		reqMember = new Member();
		reqMember.setUserId("user01");
		reqMember.setPassword("pass01");
	}
	//Dao SelectOne 테스트
	@Test
	public void testSelectOne() {
		assertEquals(md.selectOne(con, reqMember).getUserName(), "김진호");
		//log.info("selectOne : success");
	}

	//Dao CheckStatus 테스트
	@Test
	public void testCheckStatus() {
		assertEquals(md.checkStatus(con, reqMember), LoginServlet.LOGIN_OK);
		//log.info("checkStatus : success");
	}
	
	//Service LoginCheck 테스트
	@Test
	public void testLoginCheck() {
		assertEquals(ms.loginCheck(reqMember).getUserName(), "김진호");
		//log.info("loginCheck : success");
	}








}









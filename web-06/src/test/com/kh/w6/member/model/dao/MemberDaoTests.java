package test.com.kh.w6.member.model.dao;

import static com.kh.w6.common.JDBCTemplate.getConnection;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.kh.w6.member.controller.LoginServlet;
import com.kh.w6.member.model.dao.MemberDao;
import com.kh.w6.member.model.vo.Member;

public class MemberDaoTests {
	private MemberDao md = new MemberDao();
	private Member m;
	
	@Ignore
	@Test
	public void testGetConnection() {
		assertNotNull(getConnection());
	}
	
	@Before
	public void setUp() {
		m = new Member();
		m.setUserId("test");
		m.setPassword("test");
	}
	
	@Test
	public void testCheckStatus() {
		assertEquals(md.checkStatus(getConnection(), m), LoginServlet.ID_NOT_EXIST);
	}
	
	
}


















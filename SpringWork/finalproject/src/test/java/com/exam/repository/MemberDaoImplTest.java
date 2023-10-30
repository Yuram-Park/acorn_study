package com.exam.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.exam.domain.Board;
import com.exam.domain.RegisterRequest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class MemberDaoImplTest {
	@Autowired
	private MemberDao memberDao;
	
	@Ignore @Test
	public void writeTest() throws Exception {
		RegisterRequest registerRequest = new RegisterRequest();
		registerRequest.setEmail("hong@test.com");
		registerRequest.setPassword("1111");
		registerRequest.setConfirmPassword("1111");
		registerRequest.setName("홍길동");
		memberDao.registerMember(registerRequest);
	}
	
	
//	@Ignore @Test
//	public void getListTest() throws Exception {
//		List<Board> list = memberDao.getList();
//		System.out.println(list);
//	}
//	
//	@Test
//	public void getReadTest() throws Exception {
//		int bNo = 6;
//		Board board = boardDao.read(bNo);
//		assertNotNull(board);
	}
}

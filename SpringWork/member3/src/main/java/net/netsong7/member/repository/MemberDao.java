package net.netsong7.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import net.netsong7.member.model.Member;


@Repository
public class MemberDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// 조회 기능
	public Member selectByEmail(String email) {
		return null;
	}
	
	public Collection<Member> selectAll(){
		return null;
	}
	
	// 삽입
	public void insert(Member member) {
		/*
		//jdbcTemplate 사용으로 connection-close 필요없어짐
		jdbcTemplate.update(new PreparedStatementCreator() {// 인터페이스로 무명클래스로 만들기!!

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql="INSERT INTO member (id, email, password, name, registerdate) values (seq_id.nextval, ?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return stmt;
			} 
		});*/
		
		// 람다 방식
		jdbcTemplate.update(
				(Connection con) -> {
				String sql="INSERT INTO member (id, email, password, name, registerdate) values (seq_id.nextval, ?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, member.getEmail());
				stmt.setString(2, member.getPassword());
				stmt.setString(3, member.getName());
				stmt.setTimestamp(4, new Timestamp(member.getRegisterDate().getTime()));
				return stmt;
			} 
		);
	}
		
	
	
	// 수정
	public void update(Member member) {
		
		
	}
}


/*
class PreparedStatementImpl implements PreparedStatementCreator{
	@Override
	public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
		String sql="INSERT INTO member (id, email, password, name, regdate) values (?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, "seq_id.nextval");
		stmt.setString(2, );
		return stmt;
	}	
}
*/
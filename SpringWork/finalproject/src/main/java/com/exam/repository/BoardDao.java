package com.exam.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.exam.domain.Board;

@Repository
public class BoardDao {
	private JdbcTemplate jdbcTemplate;
	
	public BoardDao() {}
	
	@Autowired
	public BoardDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public Collection<Board> getList() {
		String sql = "SELECT * FROM simpleBoard";
		List<Board> list = jdbcTemplate.query(sql, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board(rs.getString("bTitle"), rs.getString("bContent"), rs.getString("bWriter"));
				board.setbNo(rs.getInt("bNo"));
				board.setbRegdate(rs.getDate("bRegdate"));
				board.setbViewcnt(rs.getInt("bViewcnt"));
				return board;
			}
		});
		return list;
	}
	
	// 등록
	public void setWrite(Board board) {
		String sql="INSERT INTO simpleBoard (bNo, bTitle, bContent, bWriter) VALUES (seq_bNo.nextval, ?, ?, ?)";
		jdbcTemplate.update(sql, board.getbTitle(), board.getbContent(), board.getbWriter());
	}
}

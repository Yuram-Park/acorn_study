package mybean;

import java.sql.*;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	// DAO pattern
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
		}
		catch (Exception err) {
			System.out.println("BoardDao:" + err );
		}
	}
	
	public void freeConnection() {
		if(rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(stmt != null)
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(con != null)
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	// List.jsp
	public List getBoardList() { //List계열 -> 데이터를 쉽게 꺼내고 저장하기 위한
		String sql = "select b_num, b_subject, b_name, b_regdate, b_count from tblboard";
		Vector vector = new Vector(); // 전체 데이터를 담아서 return하기 위한(List의 자식)
		
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				Board board = new Board();
				board.setB_num(rs.getInt("b_num"));
				board.setB_subject(rs.getString("b_subject"));
				board.setB_name(rs.getString("b_name"));
				board.setB_regdate(rs.getString("b_regdate"));
				board.setB_count(rs.getInt("b_count"));		
				
				vector.add(board);
			}
		}
		catch(Exception e) {
			System.out.println("List.jsp:"+ e);
		}
		finally {
			freeConnection();
		}
		return vector;
	}
	
	
	//Delete.jsp
	public void getDelete() {
		String sql = "select b_pass from tblboard where b_num=?";
		
		try {
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery(sql);
			stmt.setString(1, rs.getString("b_num"));
			
			while (rs.next()) {
				
			}
		}
		catch(Exception e2) {
			System.out.println("Delete.jsp:" + e2);
		}
		finally {
			freeConnection();
		}
		
	}
				
		
	}


package mybean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDao {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	private DataSource ds;
	
	public BoardDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource)ctx.lookup("java:comp/env/jdbc/myoracle");
		}
		catch(Exception err) {
			System.out.println("BoardDao:" + err);
		}
		
	}
	
	public void freeConnection() {
		if(rs != null) try {rs.close();} catch (SQLException e) {e.printStackTrace();}
		if(stmt != null) try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
		if(con != null)	try {con.close();} catch (SQLException e) {	e.printStackTrace();}
	}
	
	// List.jsp, Update.jsp
	public List getBoardList(String keyField, String keyWord) {
		String sql = "null";
		
		if(keyWord == null || keyWord.isEmpty()) {
			sql = "select * from tblboard order by pos"; // 무조건 * 찍는 것은 성능 떨어짐..되도록이면 몇개 가져오는 걸로
		} else {
			sql = "select * from tblboard where " + keyField + " like '%" + keyWord + "%' order by b_num desc"; // like는 ? 들어갈 수 없어 변수로 넣어줌
		}
		
		Vector vector = new Vector();
		
		try {
			con = ds.getConnection(); 
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				Board board = new Board();
				board.setB_subject(rs.getString("b_subject"));
				board.setB_count(rs.getInt("b_count"));		
				board.setB_name(rs.getString("b_name"));
				board.setB_num(rs.getInt("b_num"));
				board.setB_regdate(rs.getString("b_regdate"));
				board.setPos(rs.getInt("pos"));
				board.setDepth(rs.getInt("depth"));
				board.setB_email(rs.getString("b_email"));
				board.setB_homepage(rs.getString("b_homepage"));
				board.setB_pass(rs.getString("b_pass"));
				
				vector.add(board);
			}
		}
		catch(Exception e) {
			System.out.println("getBoardList : " + e);
		}
		finally {
			freeConnection();
		}
		
		return vector;
	}
	
	public void updatePos(Connection con) {
		try {
			String sql = "update tblBoard set pos = pos + 1"; // 새 글 입력 전 이전 글 pos 증가
			stmt = con.prepareStatement(sql);
			stmt.executeUpdate();
		}
		catch(Exception err) {
			System.out.println("updatePos:" + err);
		}
	}
	
	// PostProc.jsp, ReplyProc.jsp
	public void setBoard(Board board) {
		String sql = "insert into tblboard(b_num," +
				"b_name, b_email, b_homepage, b_subject, b_content, " +
				"b_pass, b_count, b_ip, b_regdate, pos, depth) " +
				"values(seq_b_num.nextVal, ?,?,?,?,?,?, 0, ?, sysdate, 0, 0)";
		try {
			
			con = ds.getConnection(); 
			
			updatePos(con); // 데이터 연결 후에 pos update
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getB_name());
			stmt.setString(2, board.getB_email());
			stmt.setString(3, board.getB_homepage());
			stmt.setString(4, board.getB_subject());
			stmt.setString(5, board.getB_content());
			stmt.setString(6, board.getB_pass());
			stmt.setString(7, board.getB_ip());
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("setBoard : " + e);
		}
		finally {
			freeConnection();
		}
	}
	
	// Read.jsp, Update.jsp, Reply.jsp
	public Board getBoard(int b_num){
		String sql;
		Board result = new Board();
		
		try{
			con = ds.getConnection();
			
			sql = "select * from tblboard where b_num=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, b_num);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				result.setB_content(rs.getString("b_content"));
				result.setB_count(rs.getInt("b_count"));
				result.setB_email(rs.getString("b_email"));
				result.setB_homepage(rs.getString("b_homepage"));
				result.setB_ip(rs.getString("b_ip"));
				result.setB_name(rs.getString("b_name"));
				result.setB_num(rs.getInt("b_num"));
				result.setB_pass(rs.getString("b_pass"));
				result.setB_regdate(rs.getString("b_regdate"));
				result.setB_subject(rs.getString("b_subject"));
				result.setPos(rs.getInt("pos"));
				result.setDepth(rs.getInt("depth"));
			}
		}
		catch(Exception err){
			System.out.println("getBoard() : " + err);
		}
		finally{
			freeConnection();
		}
		
		return result;
	}
	
	// UpdateProc.jsp
	public void updateBoard(Board dto){
		String sql = "update tblboard set b_name=?, b_email=?, " +
			"b_subject=?, b_content=? where b_num=?";
		
		try{
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setString(1, dto.getB_name());
			stmt.setString(2, dto.getB_email());
			stmt.setString(3, dto.getB_subject());
			stmt.setString(4, dto.getB_content());
			stmt.setInt(5, dto.getB_num());
			
			stmt.executeUpdate();
		}
		catch(Exception err){
			System.out.println("updateBoard() : " + err);
		}
		finally{ freeConnection(); }
	}
	
	// Delete.jsp
	public void deleteBoard(int b_num){
		String sql = "delete from tblboard where b_num=?";
			
		try{
			con = ds.getConnection();
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, b_num);
			stmt.executeUpdate();
		}
		catch(Exception err){
			System.out.println("deleteBoard() : " + err);
		}
		finally{ freeConnection(); }
	}
	
	
	public void replyUpdatePos(Board board) { // 부모글보다 pos값 큰 글들의 pos값에 +1 해주기
		try {
			con = ds.getConnection();
			String sql = "update tblboard set pos = pos + 1 where pos > ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, board.getPos());
			stmt.executeUpdate();
		}
		catch (Exception err) {
			System.out.println("replyUpdatePos : " + err);
		} finally {
			freeConnection();
		}
	}
	
	// ReplyProc.jsp
	public void replyBoard(Board board) { // pos, depth는 부모글의 정보를 보내줘야함
		String sql = "insert into tblboard(b_num," +
				"b_name, b_email, b_homepage, b_subject, b_content, " +
				"b_pass, b_count, b_ip, b_regdate, pos, depth) " +
				"values(seq_b_num.nextVal, ?,?,?,?,?,?, 0, ?, sysdate, ?, ?)";
		try {
			
			con = ds.getConnection(); 
			
			// replyUpdatePos는 나중에 불러온 후 해야함
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getB_name());
			stmt.setString(2, board.getB_email());
			stmt.setString(3, board.getB_homepage());
			stmt.setString(4, board.getB_subject());
			stmt.setString(5, board.getB_content());
			stmt.setString(6, board.getB_pass());
			stmt.setString(7, board.getB_ip());
			stmt.setInt(8, board.getPos() + 1); // 부모 pos + 1
			stmt.setInt(9, board.getDepth() + 1); // 부모 depth + 1
			stmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("replyBoard : " + e);
		}
		finally {
			freeConnection();
		}
	}
	
	
	public String useDepth(int depth) { // depth 값만큼 들여쓰기 
		String result = "";
		for(int i=0; i<depth*3; i++) {
			result += "&nbsp;";
		}
		return result;
	}
}



















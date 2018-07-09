package kr.co.koscom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.koscom.common.DBUtil;
import kr.co.koscom.dto.BoardDTO;
import kr.co.koscom.dto.MemberDTO;

public class BoardDAOImpl implements BoardDAO {

	final String DBTYPE = "ORACLE";
	@Override
	public int addBoard(BoardDTO board) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO board value (sequence._SEQ.NEXVAL,DATE.getCurrentDate(),?,?)";
		int result = 0;		
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			// id, name, email
			ps.setString(1, board.getId());
			ps.setString(2, board.getContents());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("INSERT failed!!");
		} finally {
			DBUtil.close(conn, ps);
		}
		return result;
	}

	@Override
	public int deleteBoard(double sequence, String regDate) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE member where regDate = ? and sequence = ?";
		int result = 0;		
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			ps.setDouble(1, sequence);
			ps.setString(2, regDate);
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("DELETE failed!!");
		} finally {
			DBUtil.close(conn, ps);
		}
		return result;
	}

	@Override
	public BoardDTO getBoard() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// id, name, email
		String sql = "SELECT sequence, reqdate, id, contents FROM board";
		BoardDTO board = new BoardDTO();
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {    // to prevent "before start of result set error"
				board.setSequence(rs.getDouble(1)); 
				board.setRegDate(rs.getString(2));
				board.setId(rs.getString(3));
				board.setContents(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
		return board;
	}

	@Override
	public BoardDTO getBoardById(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// id, name, email
		String sql = "SELECT sequence, reqdate, id, contents FROM board where id = ?";
		BoardDTO board = new BoardDTO();
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ps.setString(1, id);
			if (rs.next()) {    // to prevent "before start of result set error"
				board.setSequence(rs.getDouble(1)); 
				board.setRegDate(rs.getString(2));
				board.setId(rs.getString(3));
				board.setContents(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
		return board;
	}
}

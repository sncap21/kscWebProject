package kr.co.koscom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.koscom.common.DBUtil;
import kr.co.koscom.dto.MemberDTO;

public class MemberDAOImpl implements MemberDAO {

	final String DBTYPE = "MYSQL";
	//final String DBTYPE = "ORACLE";
	@Override
	public int addMember(MemberDTO member) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO members value (?,?,?,?)";
		int result = 0;		
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			// id, name, email
			ps.setString(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getPassword());
			ps.setString(4, member.getEmail());
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
	public int deleteMember(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE members where id  = ?";
		int result = 0;		
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
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
	public MemberDTO getMember(String id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		// id, name, email
		String sql = "SELECT id, name, password, email FROM members where id =?";
		MemberDTO member = new MemberDTO();
		
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {    // to prevent "before start of result set error"
				member.setId(rs.getString(1)); 
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setEmail(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
		return member;
	}

	@Override
	public List<MemberDTO> getMemberList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		MemberDTO member = null;
		List<MemberDTO> memberList = new ArrayList<>();
		String sql = "SELECT id, name, password, email FROM members";
		try {
			conn = DBUtil.getConnect(DBTYPE);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				member = new MemberDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				memberList.add(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps, rs);
		}
		return memberList;
	}
}
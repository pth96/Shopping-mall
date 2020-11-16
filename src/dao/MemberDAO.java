package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.MemberDTO;

public class MemberDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void dbConnection() {
		con = DBConnection.getConnection();
	}
	
	public void dbClose() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	public void pstmtClose() {
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void rsClose() {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public int memberjoin(MemberDTO mDTO) {
		String sql = "INSERT INTO MEMBER(MID,MPASSWORD,MNAME,MBIRTH,MALLADDRESS,MPOSTNUM,MADDRESSROAD,MADDRESSJIBUN,MADDRESS,MADDRESS1,MPHONE,MEMAIL,MPOINT) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,1000000)";
		int joinResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpassword());
			pstmt.setString(3, mDTO.getMname());
			pstmt.setString(4, mDTO.getMbirth());
			pstmt.setString(5, mDTO.getMalladdress());
			pstmt.setString(6, mDTO.getMpostnum());
			pstmt.setString(7, mDTO.getMaddressroad());
			pstmt.setString(8, mDTO.getMaddressjibun());
			pstmt.setString(9, mDTO.getMaddress());
			pstmt.setString(10, mDTO.getMaddress1());
			pstmt.setString(11, mDTO.getMphone());
			pstmt.setString(12, mDTO.getMemail());
			joinResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
		return joinResult;
	}

	public boolean memberlogin(MemberDTO mDTO) {
		String sql = "SELECT * FROM MEMBER WHERE MID = ? AND MPASSWORD = ?";
		boolean login = false;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMid());
			pstmt.setString(2, mDTO.getMpassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				login = true;
			}else {
				login = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return login;
	}

	public MemberDTO memberview(String mid) {
		MemberDTO mview = null;
		String sql = "SELECT * FROM MEMBER WHERE MID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mview = new MemberDTO();
				mview.setMid(rs.getString("MID"));
				mview.setMpassword(rs.getString("MPASSWORD"));
				mview.setMname(rs.getString("MNAME"));
				mview.setMbirth(rs.getString("MBIRTH"));
				mview.setMalladdress(rs.getString("MALLADDRESS"));
				mview.setMpostnum(rs.getString("MPOSTNUM"));
				mview.setMaddressroad(rs.getString("MADDRESSROAD"));
				mview.setMaddressjibun(rs.getString("MADDRESSJIBUN"));
				mview.setMaddress(rs.getString("MADDRESS"));
				mview.setMaddress1(rs.getString("MADDRESS1"));
				mview.setMphone(rs.getString("MPHONE"));
				mview.setMemail(rs.getString("MEMAIL"));
				mview.setMpoint(rs.getInt("MPOINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return mview;
	}

	public int memberupdateprocess(MemberDTO mDTO) {
		String sql = "UPDATE MEMBER SET MNAME=?, MALLADDRESS=?, MPOSTNUM=?, MADDRESSROAD=?, MADDRESSJIBUN=?, MADDRESS=?, MADDRESS1=?, MPHONE=?, MEMAIL=? WHERE MID=?";
		int updateResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mDTO.getMname());
			pstmt.setString(2, mDTO.getMalladdress());
			pstmt.setString(3, mDTO.getMpostnum());
			pstmt.setString(4, mDTO.getMaddressroad());
			pstmt.setString(5, mDTO.getMaddressjibun());
			pstmt.setString(6, mDTO.getMaddress());
			pstmt.setString(7, mDTO.getMaddress1());
			pstmt.setString(8, mDTO.getMphone());
			pstmt.setString(9, mDTO.getMemail());
			pstmt.setString(10, mDTO.getMid());
			updateResult = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return updateResult;
	}

	public List<MemberDTO> memberlist(int startRow, int endRow) {
		String sql = "SELECT * FROM MEMBERLIST WHERE RN BETWEEN ? AND ?";
		MemberDTO member = null;
		List<MemberDTO> memberlist = new ArrayList<MemberDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberDTO();
				member.setMid(rs.getString("MID"));
				member.setMpassword(rs.getString("MPASSWORD"));
				member.setMname(rs.getString("MNAME"));
				member.setMbirth(rs.getString("MBIRTH"));
				member.setMalladdress(rs.getString("MALLADDRESS"));
				member.setMphone(rs.getString("MPHONE"));
				member.setMemail(rs.getString("MEMAIL"));
				memberlist.add(member);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			rsClose();
			pstmtClose();
		}
		return memberlist;
	}

	public int listCount() {
		String sql = "SELECT COUNT(MID) FROM MEMBERLIST";
		int listCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return listCount;
	}

	public int memberdelete(String mid) {
		String sql = "DELETE FROM MEMBER WHERE MID = ?";
		int mdResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			mdResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
		return mdResult;
	}
	}



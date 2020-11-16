package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import db.DBConnection;
import dto.BuyDTO;

public class BuyDAO {
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

	public int buy(BuyDTO bDTO) {
		String sql = "INSERT INTO BUY(BNUM,BMID,BPID,BFILENAME,BPNAME,BSIZE,BQUANTITY,BPPRICE,BDATE) VALUES(SEQ_BUYNUM.NEXTVAL,?,?,?,?,?,?,?,SYSDATE)";
		int cbResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
				pstmt.setString(1, bDTO.getBmid());
				pstmt.setString(2, bDTO.getBpid());
				pstmt.setString(3, bDTO.getBfilename());
				pstmt.setString(4, bDTO.getBpname());
				pstmt.setString(5, bDTO.getBsize());
				pstmt.setInt(6, bDTO.getBquantity());
				pstmt.setInt(7, bDTO.getBpprice());
		
			cbResult = pstmt.executeUpdate();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return cbResult;
	}

	public void deletecart(String mid) {
		String sql = "DELETE FROM CART WHERE CMID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
		
	}

	public void quantity(BuyDTO bDTO) {
		String sql = "UPDATE PRODUCT SET PQUANTITY = PQUANTITY -? WHERE PID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bDTO.getBquantity());
			pstmt.setString(2, bDTO.getBpid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
		
	}

	public void point(int total, String mid) {
		String sql = "UPDATE MEMBER SET MPOINT = MPOINT -? WHERE MID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, total);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
	}

	public List<BuyDTO> salelist(int startRow, int endRow) {
		String sql = "SELECT * FROM (SELECT B.*, ROW_NUMBER() OVER(ORDER BY BNUM DESC) AS RN FROM BUY B ) WHERE RN BETWEEN ? AND ?";
		List<BuyDTO> salelist = new ArrayList<BuyDTO>();
		BuyDTO sale = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new BuyDTO();
				sale.setBnum(rs.getInt("BNUM"));
				sale.setBmid(rs.getString("BMID"));
				sale.setBpid(rs.getString("BPID"));
				sale.setBpname(rs.getString("BPNAME"));
				sale.setBsize(rs.getString("BSIZE"));
				sale.setBquantity(rs.getInt("BQUANTITY"));
				sale.setBpprice(rs.getInt("BPPRICE"));
				sale.setBdate(rs.getString("BDATE"));
				salelist.add(sale);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return salelist;
	}

	public int listCount() {
		String sql = "SELECT COUNT(BNUM) FROM BUY";
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

	public List<BuyDTO> buylist(int startRow, int endRow, String mid) {
		String sql = "SELECT * FROM (SELECT B.*, ROW_NUMBER() OVER(ORDER BY BDATE DESC) AS RN FROM BUY B WHERE BMID  = ? ) WHERE RN BETWEEN ? AND ?";
		List<BuyDTO> salelist = new ArrayList<BuyDTO>();
		BuyDTO sale = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sale = new BuyDTO();
				sale.setBnum(rs.getInt("BNUM"));
				sale.setBpid(rs.getString("BPID"));
				sale.setBfilename(rs.getString("BFILENAME"));
				sale.setBpname(rs.getString("BPNAME"));
				sale.setBsize(rs.getString("BSIZE"));
				sale.setBquantity(rs.getInt("BQUANTITY"));
				sale.setBpprice(rs.getInt("BPPRICE"));
				sale.setBdate(rs.getString("BDATE"));
				salelist.add(sale);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return salelist;
	}

	public int blistCount(String mid) {
		String sql = "SELECT COUNT(BNUM) FROM BUY WHERE BMID = ? ";
		int blistCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				blistCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return blistCount;
	}

	public int buycancel(int bnum) {
		String sql = "DELETE FROM BUY WHERE BNUM = ?";
		int buycancel = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bnum);
			buycancel = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return buycancel;
	}

	public void buyquantitycancel(int bquantity, String bpid) {
		String sql = "UPDATE PRODUCT SET PQUANTITY = PQUANTITY + ? WHERE PID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bquantity);
			pstmt.setString(2, bpid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
	}

	public void buypointcancel(int bpprice, String mid) {
		String sql = "UPDATE MEMBER SET MPOINT = MPOINT+? WHERE MID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bpprice);
			pstmt.setString(2, mid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
	}

}

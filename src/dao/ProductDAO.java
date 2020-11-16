package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;

import dto.ProductDTO;

public class ProductDAO {
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

	public int productregist(ProductDTO pDTO) {
		String sql = "INSERT INTO PRODUCT(PID,PNAME,PPRICE,PCONTENTS,PGENDER,PQUANTITY,PHITS,PFILENAME,PDATE) VALUES(?,?,?,?,?,?,0,?,SYSDATE)";
		int prResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pDTO.getPid());
			pstmt.setString(2, pDTO.getPname());
			pstmt.setInt(3, pDTO.getPprice());
			pstmt.setString(4, pDTO.getPcontents());
			pstmt.setString(5, pDTO.getPgender());
			pstmt.setInt(6, pDTO.getPquantity());
			pstmt.setString(7, pDTO.getPfilename());
			prResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return prResult;
	}

	public int listCount() {
		String sql = "SELECT COUNT(PID) FROM PRODUCTLIST";
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
	
	public List<ProductDTO> productlist(int startRow, int endRow, String pgender) {
		String sql = "SELECT * FROM (SELECT B.*, ROW_NUMBER() OVER(ORDER BY PDATE DESC) AS RN FROM PRODUCT B WHERE PGENDER = ?) WHERE RN BETWEEN ? AND ?";
		List<ProductDTO> productlist = new ArrayList<ProductDTO>();
		ProductDTO pDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pgender);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pDTO = new ProductDTO();
				pDTO.setPid(rs.getString("PID"));
				pDTO.setPname(rs.getString("PNAME"));
				pDTO.setPprice(rs.getInt("PPRICE"));
				pDTO.setPcontents(rs.getString("PCONTENTS"));
				pDTO.setPgender(rs.getString("PGENDER"));
				pDTO.setPquantity(rs.getInt("PQUANTITY"));
				pDTO.setPhits(rs.getInt("PHITS"));
				pDTO.setPfilename(rs.getString("PFILENAME"));
				pDTO.setPdate(rs.getString("PDATE"));
				productlist.add(pDTO);		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return productlist;
		
	}

	public ProductDTO productview(String pid) {
		String sql = "SELECT * FROM PRODUCT WHERE PID = ?";
		ProductDTO productview = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				productview = new ProductDTO();
				productview.setPid(rs.getString("PID"));
				productview.setPname(rs.getString("PNAME"));
				productview.setPprice(rs.getInt("PPRICE"));
				productview.setPcontents(rs.getString("PCONTENTS"));
				productview.setPgender(rs.getString("PGENDER"));
				productview.setPquantity(rs.getInt("PQUANTITY"));
				productview.setPhits(rs.getInt("PHITS"));
				productview.setPfilename(rs.getString("PFILENAME"));
				productview.setPdate(rs.getString("PDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		
		return productview;
	}

	public void phitsup(String pid) {
		String sql = "UPDATE PRODUCT SET PHITS = PHITS + 1 WHERE PID = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		
	}

	public List<ProductDTO> adminlist(int startRow, int endRow) {
		String sql = "SELECT * FROM PRODUCTLIST WHERE RN BETWEEN ? AND ? ORDER BY PDATE DESC";
		List<ProductDTO> adminlist = new ArrayList<ProductDTO>();
		ProductDTO pDTO = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pDTO = new ProductDTO();
				pDTO.setPid(rs.getString("PID"));
				pDTO.setPname(rs.getString("PNAME"));
				pDTO.setPprice(rs.getInt("PPRICE"));
				pDTO.setPcontents(rs.getString("PCONTENTS"));
				pDTO.setPgender(rs.getString("PGENDER"));
				pDTO.setPquantity(rs.getInt("PQUANTITY"));
				pDTO.setPhits(rs.getInt("PHITS"));
				pDTO.setPfilename(rs.getString("PFILENAME"));
				pDTO.setPdate(rs.getString("PDATE"));
				adminlist.add(pDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return adminlist;
	}

	public int productupdateprocess(ProductDTO pDTO) {
		String sql = "UPDATE PRODUCT SET PNAME=?, PPRICE=?, PCONTENTS=?, PGENDER=?, PQUANTITY=?, PFILENAME=? WHERE PID=?";
		int pupResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pDTO.getPname());
			pstmt.setInt(2, pDTO.getPprice());
			pstmt.setString(3, pDTO.getPcontents());
			pstmt.setString(4, pDTO.getPgender());
			pstmt.setInt(5, pDTO.getPquantity());
			pstmt.setString(6, pDTO.getPfilename());
			pstmt.setString(7, pDTO.getPid());
			pupResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return pupResult;
	}

	public int plistCount(String pgender) {
		String sql = "SELECT COUNT(PID) FROM PRODUCT B where PGENDER = ?";
		int plistCount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pgender);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				plistCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
			rsClose();
		}
		return plistCount;
	}

	public List<ProductDTO> listserch(int startRow, int endRow, String keyword) {
		String sql = "SELECT * FROM (SELECT B.*, ROW_NUMBER() OVER(ORDER BY PDATE DESC) AS RN FROM PRODUCT B WHERE PNAME LIKE ? OR PID LIKE ? ) WHERE RN BETWEEN ? AND ?";
		ProductDTO serch = null;
		List<ProductDTO> listserch = new ArrayList<ProductDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+keyword+'%');
			pstmt.setString(2, '%'+keyword+'%');
			pstmt.setInt(3, startRow);
			pstmt.setInt(4, endRow);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				serch = new ProductDTO();
				serch.setPid(rs.getString("PID"));
				serch.setPname(rs.getString("PNAME"));
				serch.setPprice(rs.getInt("PPRICE"));
				serch.setPcontents(rs.getString("PCONTENTS"));
				serch.setPgender(rs.getString("PGENDER"));
				serch.setPquantity(rs.getInt("PQUANTITY"));
				serch.setPhits(rs.getInt("PHITS"));
				serch.setPfilename(rs.getString("PFILENAME"));
				serch.setPdate(rs.getString("PDATE"));
				listserch.add(serch);		
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return listserch;
	}

	public int slistCount(String keyword) {
		String sql = "SELECT COUNT(PID) FROM PRODUCT B where PID LIKE ? OR PNAME LIKE ?";
		int slistcount = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, '%'+keyword+'%');
			pstmt.setString(2, '%'+keyword+'%');
			rs = pstmt.executeQuery();
			if(rs.next()) {
				slistcount = rs.getInt(1);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return slistcount;
	}

	public List<ProductDTO> hitslist() {
		String sql = "SELECT * FROM (SELECT B.*, ROW_NUMBER() OVER(ORDER BY PHITS DESC) AS RN FROM PRODUCT B ) WHERE RN BETWEEN 1 AND 12";
		ProductDTO hits = null;
		List<ProductDTO> hitslist = new ArrayList<ProductDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				hits = new ProductDTO();
				hits.setPid(rs.getString("PID"));
				hits.setPname(rs.getString("PNAME"));
				hits.setPprice(rs.getInt("PPRICE"));
				hits.setPcontents(rs.getString("PCONTENTS"));
				hits.setPgender(rs.getString("PGENDER"));
				hits.setPquantity(rs.getInt("PQUANTITY"));
				hits.setPhits(rs.getInt("PHITS"));
				hits.setPfilename(rs.getString("PFILENAME"));
				hits.setPdate(rs.getString("PDATE"));
				hitslist.add(hits);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
		return hitslist;
	}

	
	



}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBConnection;
import dto.CartDTO;
import dto.CartListDTO;


public class CartDAO {
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

	public int cart(CartDTO cDTO) {
		String sql = "INSERT INTO CART(CPID,CMID,CPFILENAME,CPSIZE,CPBNUM,CPPRICE) VALUES(?,?,?,?,?,?*?)";
		int cartResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cDTO.getCpid());
			pstmt.setString(2, cDTO.getCmid());
			pstmt.setString(3, cDTO.getCpfilename());
			pstmt.setString(4, cDTO.getCpsize());
			pstmt.setInt(5, cDTO.getCpbnum());
			pstmt.setInt(6, cDTO.getCpprice());
			pstmt.setInt(7, cDTO.getCpbnum());
			cartResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return cartResult;
	}

	public List<CartListDTO> cartlist(String mid) {
		String sql = "SELECT CPFILENAME,PID,MID,MPOINT,PNAME,CPSIZE,PPRICE,CPBNUM,CPPRICE FROM MEMBER M, PRODUCT P, CART C WHERE M.MID = C.CMID AND P.PID=C.CPID AND C.CMID = ?";
		CartListDTO cart = null;
		List<CartListDTO> cartlist = new ArrayList<CartListDTO>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cart = new CartListDTO();
				cart.setCpfilename(rs.getString("CPFILENAME"));
				cart.setPid(rs.getString("PID"));
				cart.setMid(rs.getString("MID"));
				cart.setMpoint(rs.getInt("MPOINT"));
				cart.setPname(rs.getString("PNAME"));
				cart.setCpsize(rs.getString("CPSIZE"));
				cart.setPprice(rs.getInt("PPRICE"));
				cart.setCpbnum(rs.getInt("CPBNUM"));
				cart.setCpprice(rs.getInt("CPPRICE"));
				cartlist.add(cart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
			rsClose();
		}
	
		return cartlist;
	}

	public int cartdelete(String pid, String mid) {
		String sql = "DELETE FROM CART WHERE CPID=? AND CMID=?";
		int cdResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pid);
			pstmt.setString(2, mid);
			cdResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}

		return cdResult;
	}

	public int cartalldelete(String mid) {
		String sql = "DELETE FROM CART WHERE CMID = ?";
		int cadResult = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mid);
			cadResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pstmtClose();
		}
		return cadResult;
	}

}

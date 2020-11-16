package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;

public class CartDeleteService {

	public int cartdelete(HttpServletRequest request, HttpServletResponse response, String mid) {
		String pid = request.getParameter("pid");
		CartDAO cDAO = new CartDAO();
		cDAO.dbConnection();
		int cdResult = cDAO.cartdelete(pid,mid);
		cDAO.dbClose();
		return cdResult;
	}

}

package service;

import dao.CartDAO;

public class CartAllDeleteService {

	public int cartalldelete(String mid) {
		CartDAO cDAO = new CartDAO();
		cDAO.dbConnection();
		int cadResult = cDAO.cartalldelete(mid);
		cDAO.dbClose();
		return cadResult;
	}

}

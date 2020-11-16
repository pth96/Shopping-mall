package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuyDAO;

public class BuyCancelService {

	public int buycancel(HttpServletRequest request, HttpServletResponse response, String mid) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		int bquantity = Integer.parseInt(request.getParameter("bquantity"));
		int bpprice = Integer.parseInt(request.getParameter("bpprice"));
		String bpid = request.getParameter("bpid");

		
		BuyDAO bDAO = new BuyDAO();
		bDAO.dbConnection();
		bDAO.buyquantitycancel(bquantity,bpid);
		bDAO.buypointcancel(bpprice,mid);
		int buycancel = bDAO.buycancel(bnum);
		bDAO.dbClose();
		return buycancel;
	}

}

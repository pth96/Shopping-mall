package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dto.CartDTO;

public class CartService {

	public int cart(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		String mid = request.getParameter("mid");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String pfilename = request.getParameter("pfilename");
		String psize = request.getParameter("psize");
		int pbnum = Integer.parseInt(request.getParameter("pbnum"));
		
		CartDTO cDTO = new CartDTO();
		cDTO.setCpid(pid);
		cDTO.setCmid(mid);
		cDTO.setCpprice(pprice);
		cDTO.setCpfilename(pfilename);
		cDTO.setCpsize(psize);
		cDTO.setCpbnum(pbnum);
		
		CartDAO cDAO = new CartDAO();
		cDAO.dbConnection();
		int cartResult = cDAO.cart(cDTO);
		cDAO.dbClose();
		
		
		return cartResult;
	}
	
}

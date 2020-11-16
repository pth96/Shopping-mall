package service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import dto.CartListDTO;

public class CartListService {

	public List<CartListDTO> cartlist(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		
		CartDAO cDAO = new CartDAO();
		cDAO.dbConnection();
		List<CartListDTO> cartlist = cDAO.cartlist(mid);
		cDAO.dbClose();
		return cartlist;
	}

}

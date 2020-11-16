package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;



public class ProductViewService {

	public ProductDTO productview(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		
		ProductDAO pDAO = new ProductDAO();
		pDAO.dbConnection();
		pDAO.phitsup(pid);
		ProductDTO productview = pDAO.productview(pid);
		pDAO.dbClose();
		return productview;
	}

	
}

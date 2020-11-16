package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class ProductUpdateService {

	public ProductDTO productupdate(HttpServletRequest request, HttpServletResponse response) {
	    String pid = request.getParameter("pid");
	    
	    ProductDAO pDAO = new ProductDAO();
	    pDAO.dbConnection();
	    ProductDTO productupdate = pDAO.productview(pid);
	    pDAO.dbClose();
		return productupdate;
	}

}

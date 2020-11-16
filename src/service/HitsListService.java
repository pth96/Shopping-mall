package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;

public class HitsListService {

	public List<ProductDTO> hitslist(HttpServletRequest request, HttpServletResponse response) {
	ProductDAO pDAO = new ProductDAO();
	pDAO.dbConnection();
	List<ProductDTO> hitslist = pDAO.hitslist();
	pDAO.dbClose();
		return hitslist;
	}

}

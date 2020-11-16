package service;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.PageDTO;
import dto.ProductDTO;

public class ListSerchService {
	private static final int PAGE_LIMIT = 4;
	private static final int BLOCK_LIMIT = 5;

	public List<ProductDTO> serchlist(HttpServletRequest request, HttpServletResponse response) {
		
		String keyword = request.getParameter("keyword");
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ProductDAO pDAO = new ProductDAO();
		pDAO.dbConnection();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		List<ProductDTO> listserch = new ArrayList<ProductDTO>();
		listserch  = pDAO.listserch(startRow,endRow,keyword);
		pDAO.dbClose();
		
		return listserch;
	}

	public PageDTO paging(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("keyword");
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		ProductDAO pDAO = new ProductDAO();
		pDAO.dbConnection();
		int slistCount = pDAO.slistCount(keyword);
		pDAO.dbClose();
		int maxPage = (int)(Math.ceil((double)slistCount/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT))) - 1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;

		if (endPage > maxPage) {
			endPage = maxPage;
		}
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		paging.setMaxPage(maxPage);
		return paging;
	
	}
	

}

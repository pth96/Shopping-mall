package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuyDAO;
import dto.BuyDTO;
import dto.PageDTO;


public class SaleListService {
	private static final int PAGE_LIMIT = 5;
	private static final int BLOCK_LIMIT = 5;

	public List<BuyDTO> salelist(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BuyDAO bDAO = new BuyDAO();
		bDAO.dbConnection();
		int startRow = (page-1) * PAGE_LIMIT + 1;
		int endRow = page * PAGE_LIMIT;
		List<BuyDTO> salelist = bDAO.salelist(startRow,endRow);
		bDAO.dbClose();
		
		return salelist;
	}

	public PageDTO paging(HttpServletRequest request, HttpServletResponse response) {
		int page = 1;
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BuyDAO bDAO = new BuyDAO();
		bDAO.dbConnection();
		int listCount = bDAO.listCount();
		bDAO.dbClose();
		int maxPage = (int)(Math.ceil((double)listCount/PAGE_LIMIT));
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

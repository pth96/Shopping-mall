package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BuyDTO;
import dto.PageDTO;
import service.SaleListService;


@WebServlet("/salelist")
public class SaleListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SaleListController() {
        super();
       
    }

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	SaleListService slService = new SaleListService();
    	List<BuyDTO> salelist = slService.salelist(request,response);
        PageDTO paging = slService.paging(request, response);
    	
    	request.setAttribute("salelist", salelist);
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("SaleList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BuyDTO;
import dto.PageDTO;
import service.BuyListService;


@WebServlet("/buylist")
public class BuyListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public BuyListController() {
        super();
       
    }

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BuyListService blService = new BuyListService();
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	
    	List<BuyDTO> buylist = blService.buylist(request, response, mid);
        PageDTO paging = blService.paging(request, response, mid);
    	
    	request.setAttribute("buylist", buylist);
    	request.setAttribute("paging", paging);
    	request.setAttribute("mid", mid);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("BuyList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

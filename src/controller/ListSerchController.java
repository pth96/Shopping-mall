package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PageDTO;
import dto.ProductDTO;
import service.ListSerchService;


@WebServlet("/listserch")
public class ListSerchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ListSerchController() {
        super();
      
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	ListSerchService lsService = new ListSerchService();
    	List<ProductDTO> listserch = new ArrayList<ProductDTO>();
    	String keyword = request.getParameter("keyword");
    	listserch = lsService.serchlist(request,response);
    	PageDTO paging = lsService.paging(request, response);
    	
    	request.setAttribute("listserch", listserch);
    	request.setAttribute("paging", paging);
    	request.setAttribute("keyword", keyword);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ListSerch.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

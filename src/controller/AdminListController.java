package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PageDTO;
import dto.ProductDTO;
import service.AdminListService;


@WebServlet("/adminlist")
public class AdminListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdminListController() {
        super();
      
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	AdminListService alService = new AdminListService();
    	List<ProductDTO> adminlist = alService.adminlist(request,response);
        PageDTO paging = alService.paging(request, response);
    	
    	request.setAttribute("adminlist", adminlist);
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("AdminList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}

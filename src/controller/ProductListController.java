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
import service.ProductListService;

@WebServlet("/productlist")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ProductListController() {
        super();
    
    }

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	ProductListService plistService = new ProductListService();
    	List<ProductDTO> productlist = plistService.productlist(request,response);
        PageDTO paging = plistService.paging(request, response);
    	String pgender = request.getParameter("pgender");
    	request.setAttribute("productlist", productlist);
    	request.setAttribute("paging", paging);
    	request.setAttribute("pgender", pgender);
    	
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("ProductList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

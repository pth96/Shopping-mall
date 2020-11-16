package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.ProductUpdateService;


@WebServlet("/productupdate")
public class ProductUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProductUpdateController() {
        super();
      
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	ProductUpdateService puService = new ProductUpdateService();
    	ProductDTO productupdate = new ProductDTO();
    	productupdate = puService.productupdate(request,response);
    	
    	request.setAttribute("productupdate", productupdate);
    	RequestDispatcher dispatcher =
    			request.getRequestDispatcher("ProductUpdate.jsp");
    	dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

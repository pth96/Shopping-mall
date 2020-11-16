package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductRegistService;


@WebServlet("/prregist")
public class ProductRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ProductRegistController() {
        super();
       
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	ProductRegistService prService = new ProductRegistService();
    	int prResult = prService.productregist(request,response);
    	
    	if(prResult > 0) {
    		response.sendRedirect("Admin.jsp");
    	}else {
    		response.sendRedirect("ProductRegistrationFail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

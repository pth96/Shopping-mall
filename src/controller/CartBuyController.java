package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartBuyService;


@WebServlet("/cartbuy")
public class CartBuyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartBuyController() {
        super();
      
    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	CartBuyService cbService = new CartBuyService();
    	int cbResult = cbService.cartbuy(request,response);
    	
    	if(cbResult > 0) {
    		response.sendRedirect("Main.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

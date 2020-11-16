package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CartService;

@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CartController() {
        super();
       
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	CartService cService = new CartService();
    	int cartResult = cService.cart(request,response);
    	
    	if(cartResult > 0) {
    		response.sendRedirect("Main.jsp");
    	}else {
    		response.sendRedirect("CartFail.jsp");
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}

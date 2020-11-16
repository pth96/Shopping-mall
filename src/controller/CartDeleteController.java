package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CartDeleteService;


@WebServlet("/cartdelete")
public class CartDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public CartDeleteController() {
        super();
       
    }

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	CartDeleteService cdService = new CartDeleteService();
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	int cdResult = cdService.cartdelete(request,response,mid);
    	
    	if(cdResult > 0) {
    		response.sendRedirect("cartlist?mid="+mid);
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

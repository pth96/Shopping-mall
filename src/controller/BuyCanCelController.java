package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BuyCancelService;


@WebServlet("/buycancel")
public class BuyCanCelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuyCanCelController() {
        super();
        
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	BuyCancelService bcService = new BuyCancelService();
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	int buycancel = bcService.buycancel(request, response, mid);
    	
    	
    	if(buycancel > 0) {
    		response.sendRedirect("buylist?mid=?"+mid);
    	}
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

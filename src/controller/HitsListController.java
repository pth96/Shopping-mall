package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.ProductDTO;
import service.HitsListService;


@WebServlet("/hitslist")
public class HitsListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public HitsListController() {
        super();
        
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	HitsListService hlservice = new HitsListService();
    	List<ProductDTO> hitslist = hlservice.hitslist(request,response);
    	
        request.setAttribute("hitslist", hitslist);
    	
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("HitsList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

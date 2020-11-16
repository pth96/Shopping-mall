package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberDeleteService;


@WebServlet("/memberdelete")
public class MemberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberDeleteController() {
        super();
        
    }

	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberDeleteService mdService = new MemberDeleteService();
    	HttpSession session = request.getSession();
    	String mid = (String) session.getAttribute("loginId");
    	int mdResult = mdService.memberdelete(request,response,mid);
    	
    	if(mdResult > 0) {
    		session.invalidate();
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

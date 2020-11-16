package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.MemberViewService;


@WebServlet("/memberview")
public class MemberViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public MemberViewController() {
        super();
     
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberViewService mView = new MemberViewService();
    	MemberDTO memberview = mView.memberview(request,response);
    	
    	request.setAttribute("memberview", memberview);
    	RequestDispatcher dispatcher =
  			  request.getRequestDispatcher("MemberView.jsp");
  	  dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

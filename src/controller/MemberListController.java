package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import dto.PageDTO;
import service.MemberListService;


@WebServlet("/memberlist")
public class MemberListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MemberListController() {
        super();
      
    }

    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberListService mlistService = new MemberListService();
    	List<MemberDTO> memberlist = mlistService.memberlist(request,response);
        PageDTO paging = mlistService.paging(request, response);
    	
    	request.setAttribute("memberlist", memberlist);
    	request.setAttribute("paging", paging);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("MemberList.jsp");
		dispatcher.forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}

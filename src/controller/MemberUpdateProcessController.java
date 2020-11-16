package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberUpdateProcessService;


@WebServlet("/memberupdateprocess")
public class MemberUpdateProcessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberUpdateProcessController() {
        super();

    }


    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	MemberUpdateProcessService muppService = new MemberUpdateProcessService();
    	String mid = muppService.memberupdateprocess(request,response);
    	
    	if(mid != null) {
    		response.sendRedirect("memberview?mid="+mid);
    	}else {
    		response.sendRedirect("MemberUpdateFail.jsp");
    	}
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}

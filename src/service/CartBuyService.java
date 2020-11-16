package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BuyDAO;
import dto.BuyDTO;

public class CartBuyService {

	public int cartbuy(HttpServletRequest request, HttpServletResponse response) {
		String[] pid = request.getParameterValues("pid");
		String mid = request.getParameter("mid");
		String[] pname = request.getParameterValues("pname");
		String[] psize = request.getParameterValues("psize");
		String[] pfilename =request.getParameterValues("pfilename");
		String[] a = request.getParameterValues("cpprice");
		int[] cprice = new int[a.length];
		String[] b = request.getParameterValues("pbnum");
		int[] bquantity = new int[b.length];
		int total = Integer.parseInt(request.getParameter("total"));
		
		BuyDTO bDTO = new BuyDTO();
		BuyDAO bDAO = new BuyDAO();
		bDAO.dbConnection();
		int cbResult = 0;
		bDAO.deletecart(mid);
		bDAO.point(total,mid);
		for(int i=0; i<pid.length; i++) {
			
			cprice[i] = Integer.parseInt(a[i]);
			bquantity[i] = Integer.parseInt(b[i]);
			bDTO.setBpid(pid[i]);
			bDTO.setBmid(mid);
			bDTO.setBfilename(pfilename[i]);
			bDTO.setBpname(pname[i]);
			bDTO.setBpprice(cprice[i]);
			bDTO.setBquantity(bquantity[i]);
			bDTO.setBsize(psize[i]);
			bDAO.quantity(bDTO);
		    cbResult = bDAO.buy(bDTO);
		   
		}
		
	
		bDAO.dbClose();
		return cbResult;
	}

}

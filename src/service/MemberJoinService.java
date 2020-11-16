package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberJoinService {

	public int memberjoin(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		String mname = request.getParameter("mname");
		String mbirth = request.getParameter("mbirth");
		String malladdress = "("+request.getParameter("mpostnum")+")"+" "+request.getParameter("maddressroad")+" "+ request.getParameter("maddress")+" "+request.getParameter("maddress1");
		String mpostnum = request.getParameter("mpostnum");
		String maddressroad = request.getParameter("maddressroad");
		String maddressjibun = request.getParameter("maddressjibun");
		String maddress = request.getParameter("maddress");
		String maddress1 = request.getParameter("maddress1");
		String mphone = request.getParameter("mphone");
		String memail = request.getParameter("memail");
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMpassword(mpassword);
		mDTO.setMname(mname);
		mDTO.setMbirth(mbirth);
		mDTO.setMalladdress(malladdress);
		mDTO.setMpostnum(mpostnum);
		mDTO.setMaddressroad(maddressroad);
		mDTO.setMaddressjibun(maddressjibun);
		mDTO.setMaddress(maddress);
		mDTO.setMaddress1(maddress1);
		mDTO.setMphone(mphone);
		mDTO.setMemail(memail);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int joinResult = mDAO.memberjoin(mDTO);
		mDAO.dbClose();
		return joinResult;
	}

}

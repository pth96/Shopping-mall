package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberLoginService {

	public String memberlogin(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		
		MemberDTO mDTO = new MemberDTO();
		mDTO.setMid(mid);
		mDTO.setMpassword(mpassword);
		
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		boolean loginResult = mDAO.memberlogin(mDTO);
		mDAO.dbClose();
		
		String loginId = null;
		if(loginResult == true) {
			loginId = mid;
		}else {
			loginId = null;
		}
		return loginId;
	}

}

package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberViewService {

	public MemberDTO memberview(HttpServletRequest request, HttpServletResponse response) {
		String mid = request.getParameter("mid");
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		MemberDTO mview = mDAO.memberview(mid);
		mDAO.dbClose();
		return mview;
	}

}

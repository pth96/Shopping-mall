package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class MemberDeleteService {

	public int memberdelete(HttpServletRequest request, HttpServletResponse response, String mid) {
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		int mdResult = mDAO.memberdelete(mid);
		mDAO.dbConnection();
		return mdResult;
	}

}

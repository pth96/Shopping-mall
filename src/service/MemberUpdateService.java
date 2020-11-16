package service;

import dao.MemberDAO;
import dto.MemberDTO;

public class MemberUpdateService {

	public MemberDTO memberupdate(String mid) {
		MemberDAO mDAO = new MemberDAO();
		mDAO.dbConnection();
		MemberDTO memberupdate = mDAO.memberview(mid);
		mDAO.dbClose();
		
		return memberupdate;
	}

	
	}



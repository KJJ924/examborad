package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.SingUpDto;

public class login implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String userId =request.getParameter("userId");
		String userPw =request.getParameter("userPw");
		
		TestBoardDao dao = new TestBoardDao();
		int check = dao.login(userId, userPw);
		ActionForward forward = new ActionForward();
		
		if(check==1){
			forward.setPath("board.do");
			HttpSession session = request.getSession();
			session.setAttribute("UserID", userId);
			
		}else {
			forward.setPath("login.jsp");
		}
		
		request.setAttribute("check", check);
		forward.setRedirect(true);
		return forward;
	}

}

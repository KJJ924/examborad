package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.SingUpDto;

public class singup implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
	String userId =request.getParameter("userId");
	String userPw =request.getParameter("userPw");
	
	HttpSession session = request.getSession();
	session.setAttribute("UserID", userId);
	TestBoardDao dao = new TestBoardDao();
		 dao.insertUserInfo(userId, userPw);
		
		ActionForward forward = new ActionForward();
		forward.setPath("login.jsp");
		return forward;
	}

}

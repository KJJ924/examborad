package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.testboard.dao.TestBoardDao;

public class DeleteData implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int pid	= Integer.parseInt(request.getParameter("id"));
		TestBoardDao dao = new TestBoardDao();
		dao.Delete(pid);
		ActionForward forward = new ActionForward();
		forward.setPath("board.do");
		
		return forward;
	}

}

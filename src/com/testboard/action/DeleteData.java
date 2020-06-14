package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.testboard.dao.TestBoardDao;

public class DeleteData implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String pid	= request.getParameter("id");
		String commentid= request.getParameter("commentid");
		System.out.println(commentid);
		TestBoardDao dao = new TestBoardDao();
		int check= dao.Delete(pid,commentid);
		
		ActionForward forward = new ActionForward();
		if(check==2)
		forward.setPath("board.do");
		if(check==1)
		forward.setPath("detail.do?id=26");
		return forward;
	}

}

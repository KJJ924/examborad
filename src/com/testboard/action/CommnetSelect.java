package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.CommentDto;

public class CommnetSelect implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int comment_num= Integer.parseInt(request.getParameter("comment_num"));
		
		TestBoardDao dao = new TestBoardDao();
		CommentDto dto =dao.selectComment(comment_num);
		
		ActionForward forward = new ActionForward();
		forward.setPath("WEB-INF/commentUpdateForm.jsp");
		forward.setRedirect(true);
		request.setAttribute("commentdto", dto);
		return forward;
	}

}

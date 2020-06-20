package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.CommentDto;

public class openCommnetReplyForm implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		TestBoardDao dao = new TestBoardDao();
		CommentDto dto = dao.selectComment(comment_num);
		
		ActionForward forward = new ActionForward();
		
		request.setAttribute("dto", dto);
		forward.setPath("/WEB-INF/commentReplyForm.jsp");
		forward.setRedirect(true);
		
		
		return forward;
	}

}

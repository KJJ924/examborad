package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;

public class CommnetUpdate implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		//"comment_num="+id+"&comment_content="+content;
		
		String comment_content = request.getParameter("comment_content");
		int comment_num = Integer.parseInt(request.getParameter("comment_num"));
		
		TestBoardDao dao = new TestBoardDao();
		
		dao.updateComment(comment_content, comment_num);
		
		
		return null;
	}

}

package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.ExamBoardDto;

public class CommentInsert implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		// comment_pnum=26&comment_userid=dkansk924&comment_content=ll
		
		String pageNumber= request.getParameter("comment_pnum");
		String userid = request.getParameter("comment_userid");
		String content = request.getParameter("comment_content");
		System.out.println(pageNumber);
		TestBoardDao dao = new TestBoardDao();
		
		dao.insertCommnet(pageNumber, userid, content);
		
		return null;
	}

}

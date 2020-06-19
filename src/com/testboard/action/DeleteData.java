package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.testboard.dao.TestBoardDao;

public class DeleteData implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		//게시글 pageid값
		String pid	= request.getParameter("id");
		
		//댓글 id값과 댓글이 작성된 page id값
		String commentid= request.getParameter("commentid");
		String pageNum =request.getParameter("pageNum");
		
		TestBoardDao dao = new TestBoardDao();
		int check= dao.Delete(pid,commentid);
		
		ActionForward forward = new ActionForward();
		
		//게시글 지우기
		if(check==2)
		forward.setPath("board.do");
		
		//comment 지우기
		if(check==1)
		forward.setPath("detail.do?id="+pageNum);
		
		
		return forward;
	}

}

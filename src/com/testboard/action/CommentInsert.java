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
		
		ActionForward forward = new ActionForward();
		//foraward 를 리턴 해줄필요 없는데  컨트롤러 분리안해서 해야됨 나중에  리턴 필요없는 insert나 삭제 수정같은경우 컨트롤러 따로 분리해서 만들것
		forward.setPath("detail.do?id="+pageNumber);
		forward.setRedirect(false);
		return forward;
	}

}

package com.testboard.action;

import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.CommentDto;
import com.testboard.entity.ExamDetailDto;

public class ShowDetailBorad implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int pid = Integer.parseInt(request.getParameter("id"));
		System.out.println(pid);
		TestBoardDao dao = new TestBoardDao();
		ArrayList<CommentDto> commentdto = dao.getComment(pid); 
		ExamDetailDto dto = dao.getDetail(pid);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/DetailBoard.jsp");
		forward.setRedirect(true);
		request.setAttribute("dto", dto);
		request.setAttribute("commentdto", commentdto);
		
		return forward;
	}

}

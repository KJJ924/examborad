package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.ExamBoardDto;

public class ShowDetailBorad implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		int pid = Integer.parseInt(request.getParameter("id"));
		System.out.println(pid);
		TestBoardDao dao = new TestBoardDao();
		ExamBoardDto dto = dao.getDetail(pid);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/DetailBoard.jsp");
		request.setAttribute("dto", dto);
		
		return forward;
	}

}

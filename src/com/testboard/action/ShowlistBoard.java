package com.testboard.action;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.ExamBoardDto;
import com.testboard.entity.ExamListDto;

public class ShowlistBoard implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		TestBoardDao dao = new TestBoardDao();
		List<ExamListDto> list =  dao.getlist();
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/Examboard.jsp");
		request.setAttribute("list", list);
		
		return forward;
	}

}

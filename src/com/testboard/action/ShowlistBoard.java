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
		String filed = "title";
		String filed_= request.getParameter("f");
		if(filed_!=null)
			filed=filed_;
		
		String query="";
		String query_=request.getParameter("q");
		if(query_!=null)
			query=query_;
		TestBoardDao dao = new TestBoardDao();
		List<ExamListDto> list =  dao.getlist(1, query, filed);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/Examboard.jsp");
		request.setAttribute("list", list);
		
		return forward;
	}

}

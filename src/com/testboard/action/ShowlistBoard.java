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
		if(filed_!=null && !filed_.equals(""))
			filed=filed_;
		
		String query="";
		String query_=request.getParameter("q");
		if(query_!=null&& !query_.equals(""))
			query=query_;
		
		int strNum=1;
		String strNum_ = request.getParameter("p");
		if(strNum_!=null && !strNum_.equals(""))
			strNum=Integer.parseInt(strNum_);
		System.out.println(strNum);
		TestBoardDao dao = new TestBoardDao();
		List<ExamListDto> list =  dao.getlist(strNum, query, filed);
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/Examboard.jsp");
		request.setAttribute("list", list);
		forward.setRedirect(true);
		
		return forward;
	}

}

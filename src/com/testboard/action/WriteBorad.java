package com.testboard.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;

public class WriteBorad implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		String name=request.getParameter("name");
		String title=request.getParameter("title");
	
		if(name==null) {
			name=(String) session.getAttribute("UserID");
		}
		String content=request.getParameter("content");
		TestBoardDao dao= new TestBoardDao();
		dao.setInsert(name,title,content);
		ActionForward forward = new ActionForward();
		forward.setPath("/board.do");
		return forward;
	}

}

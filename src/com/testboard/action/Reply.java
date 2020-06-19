package com.testboard.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;

public class Reply implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
	
		String name = (String)session.getAttribute("UserID");
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		int bGroup= Integer.parseInt(request.getParameter("bGroup"));
		int bStep= Integer.parseInt(request.getParameter("bStep"));
		int bIndent= Integer.parseInt(request.getParameter("bIndent"));
		
		TestBoardDao dao= new TestBoardDao();
		dao.reply(name,title,content,bGroup,bStep,bIndent);
		ActionForward forward = new ActionForward();
		forward.setPath("board.do");
		forward.setRedirect(false);
		return forward;
	}

}

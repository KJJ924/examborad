package com.testboard.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.dao.TestBoardDao;

public class ModifyData implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
				try {
					request.setCharacterEncoding("utf-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			String title=request.getParameter("title");
			String content=	request.getParameter("content");
			int pid =Integer.parseInt(request.getParameter("id"));
			TestBoardDao dao = new TestBoardDao();
			dao.modifyData(title,content,pid);
			
			ActionForward forward = new ActionForward();
			
			forward.setPath("detail.do?id="+pid);
			forward.setRedirect(false);
		return forward;
	}

}

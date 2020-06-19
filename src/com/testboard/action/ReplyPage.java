package com.testboard.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;
import com.testboard.entity.ReplyDto;


public class ReplyPage implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		//"replyPage.do?bGroup=${dto.bGroup}&UserID=${UserID}&bStep=${dto.bStep}&bIndent=${dto.bIndent}"
		
		int bGroup =Integer.parseInt(request.getParameter("bGroup"));
		int bStep = Integer.parseInt(request.getParameter("bStep"));
		int bIndent=Integer.parseInt(request.getParameter("bIndent")); 
	
		
		ReplyDto dto = new ReplyDto(bGroup, bStep, bIndent);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/WEB-INF/replyBoard2.jsp");
		request.setAttribute("replydto", dto);
		forward.setRedirect(true);
		return forward;
	}

}

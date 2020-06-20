package com.testboard.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.testboard.dao.TestBoardDao;

public class CommentReply implements IAction {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
//"content="+content+"&comment_pnum="+comment_pnum+"&comment_group="+comment_group+"&comment_step="+comment_step+"&comment_indent="+comment_indent;
		
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String UserID= (String)session.getAttribute("UserID");
		String content =request.getParameter("content");
		int comment_pnum =Integer.parseInt(request.getParameter("comment_pnum"));
		int comment_group =Integer.parseInt(request.getParameter("comment_group"));
		int comment_step =Integer.parseInt(request.getParameter("comment_step"));
		int comment_indent =Integer.parseInt(request.getParameter("comment_indent"));
		
		TestBoardDao dao = new TestBoardDao();
		dao.commentReply(content,comment_pnum,comment_group,comment_step,comment_indent,UserID);
		
		return null;
	}

}

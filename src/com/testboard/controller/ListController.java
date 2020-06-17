package com.testboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.testboard.action.ActionForward;
import com.testboard.action.IAction;
import com.testboard.command.TestBoardCommand;

/**
 * Servlet implementation class ListController
 */
@WebServlet("*.do")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doAll(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doAll(request, response);
	}

	protected void doAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
					IAction action = null;
					ActionForward forward =null;
					String path=null;
					String uri =request.getRequestURI();
					String conPath= request.getContextPath();
					String strAction=uri.substring(conPath.length());
				System.out.println(strAction);
					TestBoardCommand command = TestBoardCommand.getInstanse();
					
					action = command.getAction(strAction);
					
				
					forward= action.execute(request, response);
					if(forward==null) {
						System.out.println("끝");
					}
					if(forward!=null) {
					path=forward.getPath();
				
					
					if (forward.isRedirect()) {	
						System.out.println("2번통과");
						RequestDispatcher rd = request.getRequestDispatcher(path);
						rd.forward(request, response);
					} else {					
					
						System.out.println("1번통과");
						response.sendRedirect(path);
					}
				}
					
	}
}

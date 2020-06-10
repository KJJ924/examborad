package com.testboard.command;

import com.testboard.action.IAction;
import com.testboard.action.ShowlistBoard;

public class TestBoardCommand {
 private static TestBoardCommand instanse=null;
  private TestBoardCommand() {
	// TODO Auto-generated constructor stub
}
  public static TestBoardCommand getInstanse() {
	 if (instanse==null) {
		 instanse = new TestBoardCommand();
	 }
	 return instanse;
  }
public IAction getAction(String strAction) {
	IAction action=null;
	 switch (strAction) {
	case "/board.do": 
		action= new ShowlistBoard();
		break;
	case "/boa2rd.do": 
		action= null;
		break;	
	}
	return action;
 
}
}

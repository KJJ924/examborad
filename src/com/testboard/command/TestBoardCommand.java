package com.testboard.command;

import com.testboard.action.IAction;
import com.testboard.action.ShowDetailBorad;
import com.testboard.action.ShowlistBoard;
import com.testboard.action.WriteBorad;

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
	case "/detail.do": 
		action= new ShowDetailBorad();
		break;	
	case "/write.do": 
		action= new WriteBorad();
		break;
	}
	return action;
 
}
}

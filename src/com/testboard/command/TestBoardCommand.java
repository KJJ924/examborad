package com.testboard.command;

import com.testboard.action.CommentInsert;
import com.testboard.action.CommnetSelect;
import com.testboard.action.CommnetUpdate;
import com.testboard.action.DeleteData;
import com.testboard.action.IAction;
import com.testboard.action.ModifyData;
import com.testboard.action.ShowDetailBorad;
import com.testboard.action.ShowlistBoard;
import com.testboard.action.WriteBorad;
import com.testboard.action.login;
import com.testboard.action.singup;

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
	case "/delete.do": 
		action= new DeleteData();
		break;
	case "/modify.do": 
		action= new ModifyData();
		break;
	case "/singup.do": 
		action= new singup();
		break;
	case "/login.do": 
		action= new login();
		break;
	case "/commentinsert.do": 
		action= new CommentInsert();
		break;
	case "/openCommnetForm.do":
		action =new CommnetSelect();
		break;
		
	case "/commentupdate.do":
		action =new CommnetUpdate();
		break;
		
	}
	return action;
 
}
}

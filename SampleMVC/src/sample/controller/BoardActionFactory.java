package sample.controller;

import sample.action.Action;
import sample.action.board.*;


public class BoardActionFactory {
	private static BoardActionFactory instance =
			new BoardActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static BoardActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("board_list")) {
			action = new BoardListAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_write_pro")) {
			action = new BoardWriteProAction();
		}else if(command.equals("board_modify")) {
			action = new BoardModifyAction();
		}else if(command.equals("board_modify_pro")) {
			action = new BoardModifyProAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("board_delete_pro")) {
			action = new BoardDeleteProAction();
		}
		
		return action;
	}
}

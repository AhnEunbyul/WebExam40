package sample.controller;

import sample.action.Action;
import sample.action.qa.qaIndexAction;
import sample.action.qa.qaViewAction;
import sample.action.qa.qaWriteAction;

public class qaActionFactory {

	private static qaActionFactory instance =
			new qaActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static qaActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("qa_index")) {
			action = new qaIndexAction();
		}else if(command.equals("qa_write")) {
			action = new qaWriteAction();
		}else if(command.equals("qa_view")) {
			action = new qaViewAction();
		}
		
		return action;
	}

}

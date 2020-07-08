package sample.controller;

import sample.action.Action;
import sample.action.member.indexAction;
import sample.action.member.memberIdCheckAction;
import sample.action.member.memberInsertAction;
import sample.action.member.memberInsertProAction;
import sample.action.member.memberLoginAction;
import sample.action.member.memberLoginProAction;
import sample.action.member.memberLogoutAction;

public class memberActionFactory {
	private static memberActionFactory instance =
			new memberActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static memberActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("index")) {
			action = new indexAction();
		}else if(command.equals("member_insert")) {
			action = new memberInsertAction();
		}else if(command.equals("member_insert_pro")) {
			action = new memberInsertProAction();
		}else if(command.equals("member_login")) {
			action = new memberLoginAction();
		}else if(command.equals("member_login_pro")) {
			action = new memberLoginProAction();
		}else if(command.equals("member_logout")) {
			action = new memberLogoutAction();
		}else if(command.equals("member_idcheck")) {
			action = new memberIdCheckAction();
		}
		
		return action;
	}
	

}

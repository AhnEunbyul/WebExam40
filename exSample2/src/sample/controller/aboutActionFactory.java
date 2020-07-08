package sample.controller;

import sample.action.Action;
import sample.action.about.aboutAction;
import sample.action.about.aboutMyselfAction;
import sample.action.about.aboutProfileAction;


public class aboutActionFactory {
	private static aboutActionFactory instance =
			new aboutActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static aboutActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("about")) {
			action = new aboutAction();
		}else if(command.equals("about_profile")) {
			action = new aboutProfileAction();
		}else if(command.equals("about_myself")) {
			action = new aboutMyselfAction();
		}
		
		return action;
	}
}

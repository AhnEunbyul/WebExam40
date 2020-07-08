package sample.controller;

import sample.action.Action;
import sample.action.port.portWebDeleteAction;
import sample.action.port.portWebDeleteProAction;
import sample.action.port.portWebInViewAction;
import sample.action.port.portWebModifyAction;
import sample.action.port.portWebModifyProAction;
import sample.action.port.portWebSearchAction;
import sample.action.port.portWebViewAction;
import sample.action.port.portWebWriteAction;
import sample.action.port.portWebWriteProAction;


public class portActionFactory {
	private static portActionFactory instance =
			new portActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static portActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("port_web")) {
			action = new portWebViewAction();
		}else if(command.equals("port_web_view")) {
			action = new portWebInViewAction();
		}else if(command.equals("port_web_write")) {
			action = new portWebWriteAction();
		}else if(command.equals("port_web_write_pro")) {
			action = new portWebWriteProAction();
		}else if(command.equals("port_web_modify")) {
			action = new portWebModifyAction();
		}else if(command.equals("port_web_modify_pro")) {
			action = new portWebModifyProAction();
		}else if(command.equals("port_web_delete")) {
			action = new portWebDeleteAction();
		}else if(command.equals("port_web_delete_pro")) {
			action = new portWebDeleteProAction();
		}else if(command.equals("port_search")) {
			action = new portWebSearchAction();
		}
		
		return action;
	}
}
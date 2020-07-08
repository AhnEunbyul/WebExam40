package sample.controller;

import sample.action.Action;
import sample.action.guest.*;

public class GuestActionFactory { //넘어오는 데이터들을 여기서 다 받는다
	private static GuestActionFactory instance =
			new GuestActionFactory(); // 이렇게 만들어놔야 컨트롤러에서 얘를 호출할 수 있음
	
	public static GuestActionFactory getInstance() { // 자기가 자기 객체 생성
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("guest_list")) {
			action = new GuestListAction();
		}else if(command.equals("guest_view")) {
			action = new GuestViewAction();
		}else if(command.equals("guest_write")) {
			// 등록폼
			action = new GuestWriteAction();
		}else if(command.equals("guest_write_pro")) {
			// 등록처리
			action = new GuestWriteProAction();
		}else if(command.equals("guest_modify")) {
			action = new GuestModifyAction();
		}else if(command.equals("guest_modify_pro")) {
			action = new GuestModifyProAction();
		}else if(command.equals("guest_delete")) {
			action = new GuestDeleteAction();
		}
		
		return action;
	}
}

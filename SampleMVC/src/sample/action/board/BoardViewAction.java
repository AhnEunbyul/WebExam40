package sample.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.board.BoardDAO;
import sample.model.board.BoardVO;

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDAO dao = BoardDAO.getInstance();
		
		
		// 쿠키검사
		boolean check = false; // 내가 넘겨준 쿠키가 있는지 없는지에 대한 체크!
		Cookie info = null;
		Cookie[] cookies = request.getCookies(); // request를 이용해 모든 쿠키의 값을 가져옴
		
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("guest" + idx)) {
				check = true;
			}
			// out.print(info.getName() + ":" + info.getValue() + "<br>");
		}

		String newValue = "" + System.currentTimeMillis();
		if (!check) { // 쿠키가 존재하지 않으면
			dao.boardCntUp(idx); // 조회수 증가
			info = new Cookie("guest" + idx, newValue);
			// idx 중요함!!!!! 주로 guest 부분은 자기 도메인으로 하는 경우가 많음.
			info.setMaxAge(60 * 60); // 세션(쿠키)를 유지하는 시간표시. 1시간표시. (하루일 경우 : 24*60*60)
			response.addCookie(info);
		}
		BoardVO vo = dao.boardSelect(idx);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispater = request.getRequestDispatcher("Board/board_view.jsp");
		dispater.forward(request, response);
	}

}

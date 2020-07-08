package sample.action.port;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;

public class portWebInViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		portDAO dao = portDAO.getInstance();
		
		// 쿠키검사
		boolean check = false;
		Cookie info = null;
		Cookie[] cookies = request.getCookies();
		
		for (int i = 0; i < cookies.length; i++) {
			info = cookies[i];
			if (info.getName().equals("user" + idx)) {
				check = true;
			}
		}

		String newValue = "" + System.currentTimeMillis();
		if (!check) { // 쿠키가 존재하지 않으면
			dao.portCntUp(idx); // 조회수 증가
			info = new Cookie("user" + idx, newValue);
			info.setMaxAge(60 * 60);
			response.addCookie(info);
		}
		
		
		portVO vo = dao.portSelect(idx);

		request.setAttribute("vo", vo);

		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfolioview.jsp");
		dispater.forward(request, response);

	}

}

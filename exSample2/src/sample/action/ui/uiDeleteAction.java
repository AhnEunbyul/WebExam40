package sample.action.ui;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.ui.uiDAO;
import sample.model.ui.uiVO;

public class uiDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		uiVO vo = new uiVO();
		
		uiDAO dao = uiDAO.getInstance();
		
		vo = dao.ui_select(idx);
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispater = request.getRequestDispatcher("ui/ui_delete.jsp");
		dispater.forward(request, response);
	}

}
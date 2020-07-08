package sample.action.ui;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.ui.uiDAO;
import sample.model.ui.uiVO;

public class uiIndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uiDAO dao = uiDAO.getInstance();
		
		List<uiVO> list = dao.ui_list();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispater = request.getRequestDispatcher("ui/ui.jsp");
		dispater.forward(request, response);
	}

}

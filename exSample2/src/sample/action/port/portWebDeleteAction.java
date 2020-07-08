package sample.action.port;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;

public class portWebDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		portVO vo = new portVO();
		
		portDAO dao = portDAO.getInstance();
		
		vo = dao.portSelect(idx);
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfolioDelete.jsp");
		dispater.forward(request, response);
	}

}

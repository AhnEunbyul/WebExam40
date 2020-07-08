package sample.action.port;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;

public class portWebModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		portDAO dao = portDAO.getInstance();
		
		portVO vo = dao.portSelect(idx);
		
		System.out.println(idx+"aaa");
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfoliomodify.jsp");
		dispater.forward(request, response);
	}

}

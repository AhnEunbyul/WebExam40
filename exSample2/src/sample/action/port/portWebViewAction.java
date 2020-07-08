package sample.action.port;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;

public class portWebViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		portDAO dao = portDAO.getInstance();
		
		List<portVO> list = dao.port_web_List();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfolio.jsp");
		dispater.forward(request, response);

	}

}

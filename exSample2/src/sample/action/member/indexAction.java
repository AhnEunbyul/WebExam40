package sample.action.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.qa.qaDAO;
import sample.model.qa.qaVO;

public class indexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		qaDAO qadao = qaDAO.getInstance();
		
		List<qaVO> list = qadao.qa_list();
		
		request.setAttribute("list", list);
		
		RequestDispatcher dispater = request.getRequestDispatcher("index.jsp");
		dispater.forward(request, response);

	}

}

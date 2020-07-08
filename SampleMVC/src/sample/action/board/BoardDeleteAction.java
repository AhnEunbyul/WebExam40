package sample.action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.board.BoardDAO;
import sample.model.board.BoardVO;


public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		
		BoardDAO dao = BoardDAO.getInstance();
		
		request.setAttribute("idx", idx);
		request.setAttribute("pass", pass);
		int row = dao.boardDelete(idx,pass);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = request.getRequestDispatcher("Board/board_delete.jsp");
		dispater.forward(request, response);
		

	}

}

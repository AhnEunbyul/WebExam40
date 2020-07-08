package sample.action.guest;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.guest.GuestDAO;
import sample.model.guest.GuestVO;

public class GuestListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestCount();
		List<GuestVO> list = dao.guestList();
	
		request.setAttribute("row", row);
		request.setAttribute("list", list);
		
		RequestDispatcher dispater = request.getRequestDispatcher("Guest/guest_list.jsp");
		dispater.forward(request, response);
	}

}

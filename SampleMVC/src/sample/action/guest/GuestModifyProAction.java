package sample.action.guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.guest.GuestDAO;
import sample.model.guest.GuestVO;

public class GuestModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		GuestVO vo = new GuestVO();
		
		vo.setIdx(Integer.parseInt(request.getParameter("idx")));
		vo.setName(request.getParameter("name"));
		vo.setSubject(request.getParameter("subject"));
		vo.setContents(request.getParameter("contents"));
		
		GuestDAO dao = GuestDAO.getInstance();
		int row = dao.guestModify(vo);
		
		request.setAttribute("row", row);
		
		response.sendRedirect("Guest?command=guest_list");

	}

}

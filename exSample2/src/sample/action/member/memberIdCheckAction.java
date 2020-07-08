package sample.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.member.memberDAO;

public class memberIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		memberDAO dao = memberDAO.getInstance();
		
		String userid = request.getParameter("userid");
		
		boolean check = dao.idCheck(userid);
		
		request.setAttribute("check", check);
		
		RequestDispatcher dispater = request.getRequestDispatcher("member/idcheck.jsp");
		dispater.forward(request, response);
	}

}

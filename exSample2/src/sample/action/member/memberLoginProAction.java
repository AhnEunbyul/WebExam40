package sample.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.member.memberDAO;

public class memberLoginProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		
		memberDAO dao = memberDAO.getInstance();
		
		int row = dao.login(userid, pwd);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = request.getRequestDispatcher("member/loginPro.jsp");
		dispater.forward(request, response);
	}

}

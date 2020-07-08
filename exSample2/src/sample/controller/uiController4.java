package sample.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.model.ui.uiDAO;

/**
 * Servlet implementation class uiController4
 */
@WebServlet("/ui4") // 삭제 서블릿
public class uiController4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uiController4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pwd = request.getParameter("pwd");
		uiDAO dao = uiDAO.getInstance();
		
		int row = dao.ui_delete(idx,pwd);
		
		request.setAttribute("row", row);
		
		RequestDispatcher dispater = request.getRequestDispatcher("ui/ui_delete_pro.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

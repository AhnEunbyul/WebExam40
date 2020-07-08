package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PdsDAO;
import model.PdsVO;

/**
 * Servlet implementation class PdsDeleteServlet
 */
@WebServlet("/pds_delete")
public class PdsDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		PdsVO vo = new PdsVO();
		
		PdsDAO dao = PdsDAO.getInstance();
		
		vo = dao.pdsView(idx);
		
		request.setAttribute("vo", vo);
		RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_delete.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int idx = Integer.parseInt(request.getParameter("idx"));
		String pass = request.getParameter("pass");
		
		PdsDAO dao = PdsDAO.getInstance();
		
		int row = dao.pdsDelete(idx,pass);
		
		request.setAttribute("row", row);
		RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_delete_pro.jsp");
		dispater.forward(request, response);
	}

}

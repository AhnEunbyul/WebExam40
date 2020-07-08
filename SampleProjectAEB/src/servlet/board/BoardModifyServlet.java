package servlet.board;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.board.*;







/**

 * Servlet implementation class BoardModifyServlet

 */

@WebServlet("/board_modify")

public class BoardModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public BoardModifyServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));

		

		BoardDAO dao = new BoardDAO();

		BoardVO vo = dao.boardSelect(idx);

		

		request.setAttribute("vo", vo);

		

		RequestDispatcher dispater = request.getRequestDispatcher("Board/board_modify.jsp");

		dispater.forward(request, response);

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		

		BoardVO vo = new BoardVO();

		

		vo.setIdx(Integer.parseInt(request.getParameter("idx")));

		vo.setEmail(request.getParameter("email"));

		vo.setSubject(request.getParameter("subject"));

		vo.setContents(request.getParameter("contents"));

		vo.setPass(request.getParameter("pass"));

		

		BoardDAO dao = new BoardDAO();

		int row = dao.boardModify(vo);

		

		request.setAttribute("row", row);

		

		RequestDispatcher dispater = request.getRequestDispatcher("Board/board_modify_pro.jsp");

		dispater.forward(request, response);

		

	}



}
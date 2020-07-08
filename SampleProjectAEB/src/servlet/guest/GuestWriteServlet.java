package servlet.guest;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.guest.GuestDAO;

import model.guest.GuestVO;



/**

 * Servlet implementation class GuestWriteServlet

 */

@WebServlet("/guest_write")

public class GuestWriteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public GuestWriteServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dis = request.getRequestDispatcher("Guest/guest_write.jsp");

		dis.forward(request, response);

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		GuestVO vo = new GuestVO();

		GuestDAO dao = new GuestDAO();

		

		vo.setName(request.getParameter("name"));

		vo.setSubject(request.getParameter("subject"));

		vo.setContents(request.getParameter("contents"));

		

		int row = dao.guestWrite(vo);

		

		request.setAttribute("row", row);

		RequestDispatcher dis = request.getRequestDispatcher("Guest/guest_write_pro.jsp");

		dis.forward(request, response);

	}



}

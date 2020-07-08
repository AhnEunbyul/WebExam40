package servlet.guest;



import java.io.IOException;

import java.util.List;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.guest.GuestDAO;

import model.guest.GuestVO;

import util.PageIndex;



/**

 * Servlet implementation class GuestListServlet

 */

@WebServlet("/guest_list")

public class GuestListServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public GuestListServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		

		GuestDAO dao = new GuestDAO();

		

		int totcount = dao.guestCount();

		

		int nowpage = 1;

		int maxlist = 10;

		int totpage = 1;

		

		if(totcount%maxlist == 0) {

			totpage = totcount/maxlist;

		}else {

			totpage = totcount/maxlist + 1;

		}

		

		if(request.getParameter("page") != null) {

			nowpage = Integer.parseInt(request.getParameter("page"));

		}

		int page_start = (nowpage - 1) * maxlist;

		int page_end = nowpage * maxlist;

		int listcount = totcount - ((nowpage - 1) * maxlist);

		

		List<GuestVO> list = dao.GuestList(page_start, page_end);

		

		String pageSkip = PageIndex.pageList(nowpage, totpage, "guest_list","");

		

		request.setAttribute("totcount", totcount);

		request.setAttribute("list", list); // 게시글 목록

		request.setAttribute("listcount", listcount); // 페이지 수

		request.setAttribute("page", nowpage);

		request.setAttribute("totpage", totpage);

		request.setAttribute("pageSkip", pageSkip);

		

		RequestDispatcher dis = request.getRequestDispatcher("Guest/guest_list.jsp");

		dis.forward(request, response);

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub

		doGet(request, response);

	}



}
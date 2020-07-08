package servlet.guest;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.guest.GuestDAO;

import model.guest.GuestVO;

import util.SqlMark;



/**

 * Servlet implementation class GuestViewServlet

 */

@WebServlet("/guest_view")

public class GuestViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public GuestViewServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idx = Integer.parseInt(request.getParameter("idx"));

		GuestDAO dao = new GuestDAO();

		

		//쿠키존재여부검사

		boolean bool = false;

		Cookie info = null;

		Cookie[] cookies = request.getCookies();

		

		for(int x = 0; x < cookies.length; x++){

			info = cookies[x];

			if(info.getName().equals("guest"+idx)){

				bool = true;

				break;

			}

		}

		

		String newValue=""+System.currentTimeMillis();

		

		if(!bool){ // 쿠키가 존재 하지않으면

			dao.guestReadcnt(idx);

			info = new Cookie("guest"+idx , newValue);

			info.setMaxAge(60*60); // 세션을 유지하는 시간(초) 

			response.addCookie(info);

		}

		

		

		GuestVO guestvo = dao.guestSelect(idx);

		String content = SqlMark.lineBreak(guestvo.getContents());

		guestvo.setContents(content);

		

		request.setAttribute("guestvo", guestvo);

		

		RequestDispatcher dis = request.getRequestDispatcher("Guest/guest_view.jsp");

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
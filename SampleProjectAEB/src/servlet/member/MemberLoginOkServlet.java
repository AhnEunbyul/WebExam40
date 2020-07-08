package servlet.member;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import model.member.MemberDAO;

import model.member.MemberVO;



/**

 * Servlet implementation class MemberLoginOkServlet

 */

@WebServlet("/userlogin_ok")

public class MemberLoginOkServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public MemberLoginOkServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");

		request.setAttribute("userid", userid);

		RequestDispatcher dis = request.getRequestDispatcher("Member/userlogin_ok.jsp");

		dis.forward(request, response);

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userid = request.getParameter("userid");

		String passwd = request.getParameter("passwd");

		

		MemberDAO dao = new MemberDAO();

		

		int row = dao.memberLogin(userid,passwd);

		MemberVO vo = dao.MemberSearch(userid);

		

		request.setAttribute("row", row);

		request.setAttribute("userid", userid);

		request.setAttribute("vo", vo);

		

		RequestDispatcher dis = request.getRequestDispatcher("Member/userlogin_ok_pro.jsp");

		dis.forward(request, response);

		

		

	}



}
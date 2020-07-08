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

 * Servlet implementation class MemberDeleteServlet

 */

@WebServlet("/userinfo_delete")

public class MemberDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public MemberDeleteServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		

		MemberDAO dao = new MemberDAO();

		String userid = (String)request.getSession().getAttribute("userid");

		

		MemberVO vo2 = dao.MemberSearch(userid);

		

		request.setAttribute("vo2", vo2);

		

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_delete.jsp");

		dis.forward(request, response);

		

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		

		MemberDAO dao = new MemberDAO();

		

		String passwd = request.getParameter("passwd");

		String userid = (String)request.getSession().getAttribute("userid");

		

		int row = dao.memberDelete(userid, passwd);

		

		request.setAttribute("row", row);

		

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_delete_pro.jsp");

		dis.forward(request, response);

	}



}
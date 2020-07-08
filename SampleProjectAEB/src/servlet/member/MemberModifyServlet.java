package servlet.member;



import java.io.IOException;



import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import javax.websocket.Session;



import model.member.MemberDAO;

import model.member.MemberVO;



/**

 * Servlet implementation class MemberModifyServlet

 */

@WebServlet("/userinfo_modify")

public class MemberModifyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public MemberModifyServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDAO dao = new MemberDAO();

		String userid = (String)request.getSession().getAttribute("userid");

		

		MemberVO vo = dao.MemberSearch(userid);

		

		request.setAttribute("vo", vo);

		

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_modify.jsp");

		dis.forward(request, response);

		

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		

		MemberDAO dao = new MemberDAO();

		

		String passwd = request.getParameter("passwd");

		String tel = request.getParameter("tel");

		String email = request.getParameter("email");

		String userid = (String)request.getSession().getAttribute("userid");

		

		int row = dao.memberUpdate(passwd, tel,email,userid);

		

		request.setAttribute("row", row);

		

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_modify_pro.jsp");

		dis.forward(request, response);

		

		

		

	}



}
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

 * Servlet implementation class MemberInsertServlet

 */

@WebServlet("/userinfo_insert2")

public class MemberInsertServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

       

    /**

     * @see HttpServlet#HttpServlet()

     */

    public MemberInsertServlet() {

        super();

        // TODO Auto-generated constructor stub

    }



	/**

	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)

	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_insert2.jsp");

		dis.forward(request, response);

		

	}



	/**

	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)

	 */

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		MemberDAO dao = new MemberDAO();

		MemberVO vo = new MemberVO();

		

		vo.setName(request.getParameter("name"));

		vo.setUserid(request.getParameter("userid"));

		vo.setPasswd(request.getParameter("passwd"));

		vo.setTel(request.getParameter("tel"));

		vo.setEmail(request.getParameter("email"));



		boolean flag = dao.memberInsert(vo);

		

		request.setAttribute("flag", flag);

		RequestDispatcher dis = request.getRequestDispatcher("Member/userinfo_list_pro.jsp");

		dis.forward(request, response);

	}



}
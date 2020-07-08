package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import model.MemberDAO;
import model.MemberVO;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/MemberInsert")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/member.jsp");
		dis.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		MemberVO vo = new MemberVO();
		//비밀번호 암호화 해서 보내기
		String passwd = request.getParameter("pwd");
		String repasswd = request.getParameter("repwd");
		
		BASE64Encoder Base64Encode = new BASE64Encoder();
		
		String pwd = Base64Encode.encode(passwd.getBytes());
		String repwd = Base64Encode.encode(repasswd.getBytes());
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(pwd);
		vo.setRepwd(repwd);
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("email"));
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int row = dao.insert(vo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("row", row);

		RequestDispatcher dis = request.getRequestDispatcher("member/member_pro.jsp");
		dis.forward(request, response);
	}

}

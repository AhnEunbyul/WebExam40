package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import KISA.SHA256;
import model.UserDAO;
import model.UserVO;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class UserInsertServlet
 */
@WebServlet("/user_insert")
public class UserInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispater = request.getRequestDispatcher("User/user_insert.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO vo = new UserVO();
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");
		String tel = request.getParameter("tel");
		String email = "";
		
		if(request.getParameter("email1") != null) {
			if(request.getParameter("email2") != null)
			email = request.getParameter("email1")+"@"+request.getParameter("email2");
		}
		
		SHA256 s256 = new SHA256(passwd.getBytes());
		BASE64Encoder Base64Encoder = new BASE64Encoder();
		
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPasswd(Base64Encoder.encode(s256.GetHashCode()));
		vo.setTel(tel);
		vo.setEmail(email);
		
		boolean check = dao.userInsert(vo);
		
		response.sendRedirect("user_list");
	
	}

}

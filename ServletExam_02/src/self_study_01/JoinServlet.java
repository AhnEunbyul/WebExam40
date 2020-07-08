package self_study_01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String first_id = request.getParameter("first_id");
		String last_id = request.getParameter("last_id");
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String re_pw = request.getParameter("re_pw");
		String email = request.getParameter("email");
		String last_email = request.getParameter("last_email");
		String SelectEmail = request.getParameter("SelectEmail");
		String addrNum = request.getParameter("addrNum");
		String first_addr = request.getParameter("first_addr");
		String last_addr = request.getParameter("last_addr");
		String phone = request.getParameter("phone");
		String job = request.getParameter("job");
		String smsCheck = request.getParameter("smsCheck");
		String coffee [] = request.getParameterValues("coffee");
		String coffeeStr = coffee[0];
		for (int i = 1; i < coffee.length; i++) {
			coffeeStr = coffeeStr + "," + coffee[i];
		}
		
		request.setAttribute("name", name);
		request.setAttribute("first_id", first_id);
		request.setAttribute("last_id", last_id);
		request.setAttribute("userid", userid);
		request.setAttribute("pw", pw);
		request.setAttribute("re_pw", re_pw);
		request.setAttribute("email", email);
		request.setAttribute("last_email", last_email);
		request.setAttribute("SelectEmail", SelectEmail);
		request.setAttribute("addrNum", addrNum);
		request.setAttribute("first_addr", first_addr);
		request.setAttribute("last_addr", last_addr);
		request.setAttribute("phone", phone);
		request.setAttribute("job", job);
		request.setAttribute("smsCheck", smsCheck);
		request.setAttribute("coffeeStr", coffeeStr);
		
		RequestDispatcher dispater = request.getRequestDispatcher("join_pro.jsp");
		
		dispater.forward(request, response);
		
		
	}

}

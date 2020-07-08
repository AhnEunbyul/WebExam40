package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
// 회원등록 폼

/**
 * Servlet implementation class MemInsertServlet
 */
@WebServlet("/insert.do")
public class MemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemInsertServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Member/userinfo_insert.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = null;
		if(request.getParameter("name") != null){
			name = request.getParameter("name");
		}
		String userid = request.getParameter("userid");			// 아이디
		String passwd = request.getParameter("passwd");			// 비밀번호
		String gubun = request.getParameter("gubun");			// 주소구분
		String tel = request.getParameter("tel");				// 전화
		String email = request.getParameter("email");			// 이메일
		String fa[] = request.getParameterValues("fa");			// 관심분야
		String str = null; // 아무것도 안 들어올 것은 대비해서 만듦
		if(fa != null){
			str = fa[0];
			for(int i = 1; i < fa.length; i++){
				str = str + "," + fa[i];	// 넘어온 자료들을 ,로 구분시켜줌
			}
		}
		String job = request.getParameter("job");				// 직업
		String intro = request.getParameter("intro");			// 자기소개
		
		// DB에 저장
		request.setAttribute("name", name);
		request.setAttribute("userid", userid); 
		request.setAttribute("passwd", passwd); 
		request.setAttribute("gubun", gubun); 
		request.setAttribute("tel", tel); 
		request.setAttribute("email", email);
		request.setAttribute("fa", fa); 
		request.setAttribute("job", job); 
		request.setAttribute("intro", intro); 
		
		RequestDispatcher dispater = request.getRequestDispatcher("Member/userinfo_modify.jsp");
		// 알림창을 만들기 위해 일부로 만든 장치
		dispater.forward(request, response);
	}

}

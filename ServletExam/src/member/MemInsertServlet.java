package member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;
// ȸ����� ��

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
		String userid = request.getParameter("userid");			// ���̵�
		String passwd = request.getParameter("passwd");			// ��й�ȣ
		String gubun = request.getParameter("gubun");			// �ּұ���
		String tel = request.getParameter("tel");				// ��ȭ
		String email = request.getParameter("email");			// �̸���
		String fa[] = request.getParameterValues("fa");			// ���ɺо�
		String str = null; // �ƹ��͵� �� ���� ���� ����ؼ� ����
		if(fa != null){
			str = fa[0];
			for(int i = 1; i < fa.length; i++){
				str = str + "," + fa[i];	// �Ѿ�� �ڷ���� ,�� ���н�����
			}
		}
		String job = request.getParameter("job");				// ����
		String intro = request.getParameter("intro");			// �ڱ�Ұ�
		
		// DB�� ����
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
		// �˸�â�� ����� ���� �Ϻη� ���� ��ġ
		dispater.forward(request, response);
	}

}

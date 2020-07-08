package sample.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sample.model.ui.uiDAO;
import sample.model.ui.uiVO;
import sample.util.DBManager;

/**
 * Servlet implementation class uiController2
 */
@WebServlet("/ui2")
public class uiController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uiController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;

		conn = DBManager.getConnection();

		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("upload");
		//String path = "C:/Users/USER/eclipse-workspace/WebExam40/exSample2/WebContent/images";
		// 슬래시 유무에 따라 파일 저장 장소가 달라짐!"
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024; // 최대 사이즈(10메가)

		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());

		String mgn_name = multi.getParameter("mgn_name");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename = multi.getFilesystemName("filename");
		String pwd = multi.getParameter("pwd");
		// 실제 파일 이름만 받는 것

		uiVO vo = new uiVO();

		vo.setMgn_name(mgn_name);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setFilename(filename);
		vo.setPwd(pwd);

		uiDAO dao = uiDAO.getInstance();

		int row = dao.ui_write(vo);

		request.setAttribute("row", row);
					
		RequestDispatcher dispater = 
				request.getRequestDispatcher("ui/ui_write_pro.jsp");
		
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}

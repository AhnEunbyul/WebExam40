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

import sample.model.port.portDAO;
import sample.model.port.portVO;
import sample.util.DBManager;

/**
 * Servlet implementation class portController3
 */
@WebServlet("/port3")
public class portController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public portController3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int row = 0;

		Connection conn = null;

		conn = DBManager.getConnection();
		
		System.out.println("wadcawcd");
		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("upload");
		// 슬래시 유무에 따라 파일 저장 장소가 달라짐!
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());

		portVO vo = new portVO();

		vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
		vo.setSubject(multi.getParameter("subject"));
		vo.setContents(multi.getParameter("contents"));
		vo.setPwd(multi.getParameter("pwd"));

		if (multi.getFilesystemName("appfile") == null) {
			vo.setFilename(multi.getFilesystemName("filename"));
		} else {
			vo.setFilename(multi.getFilesystemName("appfile"));
		}

		portDAO dao = portDAO.getInstance();

		row = dao.portModify(vo);
	
		request.setAttribute("row", row);
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfoliomodify_pro.jsp");
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

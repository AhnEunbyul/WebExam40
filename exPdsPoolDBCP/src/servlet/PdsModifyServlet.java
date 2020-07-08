package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.PdsDAO;
import model.PdsVO;

/**
 * Servlet implementation class PdsModifyServlet
 */
@WebServlet("/modify.do")
public class PdsModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdsModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		PdsDAO dao = PdsDAO.getInstance();
		PdsVO vo = dao.pdsView(idx);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_modify.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int row = 0;
		
		try {
			ServletContext context = getServletContext();
			String path = context.getRealPath("upload");
												// 슬래시 유무에 따라 파일 저장 장소가 달라짐!
			String encType = "UTF-8";
			int maxSize = 2*1024*1024;
			MultipartRequest multi = new MultipartRequest(
					request, path, maxSize, encType, 
					new DefaultFileRenamePolicy()
					);
			
			PdsVO vo = new PdsVO();
			
			vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
			vo.setEmail(multi.getParameter("email"));
			vo.setSubject(multi.getParameter("subject"));
			vo.setContents(multi.getParameter("contents"));
			vo.setPass(multi.getParameter("pass"));
			
			if(multi.getFilesystemName("upfilename") == null) {
				vo.setFilename(multi.getFilesystemName("filename"));
			}else {
				vo.setFilename(multi.getFilesystemName("upfilename"));
			}
			
			PdsDAO dao = PdsDAO.getInstance();
			
			row = dao.pdsModify(vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("row", row);
		RequestDispatcher dispater = request.getRequestDispatcher("Pds/pds_modify_pro.jsp");
		dispater.forward(request, response);
	}

}

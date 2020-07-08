package sample.action.port;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;
import sample.util.DBManager;

public class portWebWriteProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Connection conn = null;
		
		conn = DBManager.getConnection();

		ServletContext context = request.getSession().getServletContext();
		String path = context.getRealPath("upload");
		// 슬래시 유무에 따라 파일 저장 장소가 달라짐!
		String encType = "UTF-8";
		int maxSize = 10 * 1024 * 1024; // 최대 사이즈(10메가)
		
		MultipartRequest multi = new MultipartRequest(request, path, maxSize, encType, new DefaultFileRenamePolicy());
		
		String mgn_name = multi.getParameter("mgn_name");
		String subject = multi.getParameter("subject");
		String contents = multi.getParameter("contents");
		String filename = multi.getFilesystemName("filename");
		String pwd = multi.getParameter("pwd");
		// 실제 파일 이름만 받는 것

		portVO vo = new portVO();

		vo.setMgn_name(mgn_name);
		vo.setSubject(subject);
		vo.setContents(contents);
		vo.setFilename(filename);
		vo.setPwd(pwd);

		portDAO dao = portDAO.getInstance();

		int row = dao.port_web_write(vo);

		request.setAttribute("row", row);
			
		
		
//		vo.setMgn_name(request.getParameter("mgn_name"));
//		vo.setSubject(request.getParameter("subject"));
//		vo.setContents(request.getParameter("contents"));

		
//		request.setAttribute("row", row);
		
		RequestDispatcher dispater = 
				request.getRequestDispatcher("portfolio/portfoliowrite_pro.jsp");
		
		dispater.forward(request, response);

	}



}

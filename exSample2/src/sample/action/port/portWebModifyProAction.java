package sample.action.port;

import java.io.IOException;

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

public class portWebModifyProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int row = 0;
		
		try {
			ServletContext context = request.getSession().getServletContext();
			String path = context.getRealPath("upload");
												// 슬래시 유무에 따라 파일 저장 장소가 달라짐!
			String encType = "UTF-8";
			int maxSize = 10*1024*1024;
			MultipartRequest multi = new MultipartRequest(
					request, path, maxSize, encType, 
					new DefaultFileRenamePolicy()
					);
			
			portVO vo = new portVO();
			
			vo.setIdx(Integer.parseInt(multi.getParameter("idx")));
			vo.setSubject(multi.getParameter("subject"));
			vo.setContents(multi.getParameter("contents"));
			vo.setPwd(multi.getParameter("pwd"));
			
			if(multi.getFilesystemName("appfile") == null) {
				vo.setFilename(multi.getFilesystemName("filename"));
			}else {
				vo.setFilename(multi.getFilesystemName("appfile"));
			}
			
			portDAO dao = portDAO.getInstance();
			
			row = dao.portModify(vo);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("row", row);
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfoliomodify_pro.jsp");
		dispater.forward(request, response);
	}

}

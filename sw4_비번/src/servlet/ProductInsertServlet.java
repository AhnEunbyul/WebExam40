package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prdDAO;
import model.prdVO;

/**
 * Servlet implementation class ProductInsertServlet
 */
@WebServlet("/insert.do")
public class ProductInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispater = request.getRequestDispatcher("prdInsert.jsp");
		dispater.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		prdVO vo = new prdVO();
		
		String code = request.getParameter("code");
		String pname = request.getParameter("pname");
		int cost = Integer.parseInt(request.getParameter("cost"));
		int pnum = Integer.parseInt(request.getParameter("pnum"));
		int jnum = Integer.parseInt(request.getParameter("jnum"));
		int sale = Integer.parseInt(request.getParameter("sale"));
		String gcode = request.getParameter("gcode");
		
		vo.setCode(code);
		vo.setPname(pname);
		vo.setCost(cost);
		vo.setPname(pname);
		vo.setPnum(pnum);
		vo.setJnum(jnum);
		vo.setSale(sale);
		vo.setGcode(gcode);
		
		prdDAO dao = new prdDAO();
		
		int row = dao.insertPrd(vo);
		
		if(row == 0) {
			System.out.println("등록에 실패하였습니다.");
		} else {
			System.out.println("등록이 완료되었습니다.");
		}
		
		request.setAttribute("vo", vo);
		request.setAttribute("row", row);
		
		
		response.sendRedirect("navi.do");
				
	}

}

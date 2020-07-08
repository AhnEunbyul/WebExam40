package sample.action.port;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.port.portDAO;
import sample.model.port.portVO;
import sample.util.PageIndex;

public class portWebSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		portDAO dao = portDAO.getInstance();
		
		int cnt = dao.portCount();
		
		request.setAttribute("total", cnt); // cnt를 jsp에서 부를땐 total
		
		request.setCharacterEncoding("UTF-8");
		
		String s_query = "", addtag = "", query = "", key = "";
		
		int totcount = 0;
		
		if(request.getParameter("key") != null) {
			key = request.getParameter("key");
			query = request.getParameter("search");
			s_query = query + " like '%" + key + "%'";
			addtag = "&search=" + query + "&key=" + key;
			totcount = dao.portCount(s_query);
		}else {
			totcount = dao.portCount();
		}
		
		int nowpage = 1;	// 디폴트 값으로 현재 페이지가 1
		int maxlist = 10;	// 페이지 당 글 수
		int totpage = 1;	// 총 페이지 수
		
		if(totcount%maxlist == 0) {
			totpage = totcount/maxlist;
		}else {
			totpage = totcount/maxlist + 1;
		}
		
		if(request.getParameter("page") != null) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println(nowpage);
		
		int page_start = (nowpage - 1) * maxlist;
		int page_end = nowpage * maxlist;
		int listcount = totcount - ((nowpage - 1) * maxlist);
		
		List<portVO> list = null;
		
		if(key.equals("")) {
			list = dao.portList(page_start, page_end);
		}else {
			list = dao.portList(s_query, page_start, page_end);
		}
		
		String pageSkip = PageIndex.pageList(nowpage, totpage, "port?command=port_web", addtag);
		
		request.setAttribute("totcount", totcount);
		request.setAttribute("list", list);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", nowpage);
		request.setAttribute("pageSkip", pageSkip);
		request.setAttribute("search", query);
		request.setAttribute("key", key);
		
		RequestDispatcher dispater = request.getRequestDispatcher("portfolio/portfolio.jsp");
		dispater.forward(request, response);
	}

}

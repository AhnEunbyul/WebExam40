package sample.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.action.Action;
import sample.model.member.memberDAO;
import sample.model.member.memberVO;
import sun.misc.BASE64Encoder;

public class memberInsertProAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		memberVO vo = new memberVO();
		//비밀번호 암호화 해서 보내기
		String passwd = request.getParameter("pwd");
		String repasswd = request.getParameter("repwd");
		
		BASE64Encoder Base64Encode = new BASE64Encoder();
		
		String pwd = Base64Encode.encode(passwd.getBytes());
		String repwd = Base64Encode.encode(repasswd.getBytes());
		
		vo.setName(request.getParameter("name"));
		vo.setUserid(request.getParameter("userid"));
		vo.setPwd(pwd);
		vo.setRepwd(repwd);
		vo.setPhone(request.getParameter("phone"));
		vo.setEmail(request.getParameter("em"));
		
		memberDAO dao = memberDAO.getInstance();
		
		int row = dao.insert(vo);
		
		request.setAttribute("vo", vo);
		request.setAttribute("row", row);

		RequestDispatcher dispater = request.getRequestDispatcher("member/member_pro.jsp");
		dispater.forward(request, response);

	}

}

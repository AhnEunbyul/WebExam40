package email;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailSendingServlet
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
    private String host;
    private String port;
    private String user;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // reads form fields
        String recipient = request.getParameter("recipient");	// 수령인
        String subject = request.getParameter("subject");		// 제목
        String content = request.getParameter("content");		// 내용
 
        String resultMessage = "";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
            resultMessage = "メールが成功的に送られました！";				// 성공적으로 이메일이 보내진 메시지
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "エラーメッセージ： " + ex.getMessage();
        } finally {
            request.setAttribute("Message", resultMessage);		// 오류 발생 및 오류 메시지
            getServletContext().getRequestDispatcher("/Result.jsp").forward(
                    request, response);
        }
    }

}
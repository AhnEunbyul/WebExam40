<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.activation.*"%>
<%@ page import="javax.mail.*"%>
<%@ page import="javax.mail.internet.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%!public class MyAuthentication extends Authenticator { //아이디 패스워드 인증받기 함수
		PasswordAuthentication pa;
		public MyAuthentication() {
			pa = new PasswordAuthentication("eun_byul35@naver.com", "wnrsmsek123!");
		}
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return pa;
		}
	}%>
<%
	// SMTP 서버 주소
	
	String smtpHost = "smtp.naver.com";
	
	//받는 사람의 정보
	String toName = "안은별";
	String toEmail = "eun_byul35@naver.com";
	//보내는 사람의 정보
	String fromName = "안은별";
	String fromEmail = "eun_byul35@naver.com";
	try {
		Properties props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable","true");
		// 메일 인증
		Authenticator myauth = new MyAuthentication();
		Session sess = Session.getInstance(props, myauth);
		InternetAddress addr = new InternetAddress();
		addr.setPersonal(fromName, "UTF-8");
		addr.setAddress(fromEmail);
		Message msg = new MimeMessage(sess);
		msg.setFrom(addr);
		msg.setSubject(MimeUtility.encodeText("회원가입 인증메일 입니다.", "utf-8", "B"));
		msg.setContent("인증되셨습니다.", "text/html;charset=utf-8");
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
		Transport.send(msg);
	} catch (Exception e) {
		e.printStackTrace();
		out.println("<script>alert('메일 전송에 실패했습니다.\\n다시 시도해주세요.');</script>");
		return;
	}
	out.println("<script>alert('메일이 전송되었습니다.');<script>");
%>
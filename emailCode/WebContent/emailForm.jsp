<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>メールアドレスお送りいたします</title>
</head>
<body>
    <form name="emailForm" action="EmailSendingServlet" method="post">
        <table border="0" width="35%" align="center">
            <caption><h2>新しいメールお送り</h2></caption>
            <tr>
                <td width="50%">受取人 </td>
                <td><input type="text" name="recipient" size="50"/></td>
            </tr>
            <tr>
                <td>題目 </td>
                <td><input type="text" name="subject" size="50"/></td>
            </tr>
            <tr>
                <td>内容 </td>
                <td><textarea rows="10" cols="39" name="content"></textarea> </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Send"/></td>
            </tr>
        </table>
         
    </form>
</body>
</html>
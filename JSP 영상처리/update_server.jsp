<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

<%@ include file="dbconn.jsp" %>
<%
String m_id = request.getParameter("m_id");
String m_name = request.getParameter("m_name");
String m_age = request.getParameter("m_age");

// conn�� ���� ����
ResultSet rs = null;  // ��ȸ����� ����
Statement stmt = conn.createStatement(); // SQL�� ���� Ʈ���غ�

String sql = "SELECT m_id FROM member_tbl WHERE m_id='";
sql += m_id + "'";
rs = stmt.executeQuery(sql); // Ʈ���� ���� �Ǿ �ٸ��ǳ� �ξ� �ֱ�.

String m_id2 ="";
while (rs.next()) {
	m_id2 = rs.getString("m_id");
}
if (!m_id.equals(m_id2)) {
	out.println("���� ���̵��Դϴ�..");
	stmt.close();
	conn.close();
}else{
	String sql1 = "UPDATE member_tbl SET m_name='";
	sql1 += m_name + "', m_age='" + m_age + "' ";
	sql1 += "WHERE m_id = '"+ m_id + "'";
	stmt.executeUpdate(sql1); // Ʈ���� ���� �Ǿ �ٸ��ǳ� �ξ� �ֱ�.

	stmt.close();
	conn.close();
	out.println("ȸ�������� �����Ǿ����ϴ�.");
}

%>
<form method="post" action="Project_Login.jsp">
	<p> <input type="submit" value="�α���������">
</form>

</body>
</html>
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
String m_age = request.getParameter("m_age");

ResultSet rs = null;  // ��ȸ����� ����
Statement stmt = conn.createStatement(); // SQL�� ���� Ʈ���غ�

String sql = "SELECT m_id,m_age FROM member_tbl WHERE m_id='";
sql += m_id + "'";
rs = stmt.executeQuery(sql); // Ʈ���� ���� �Ǿ �ٸ��ǳ� �ξ� �ֱ�.

String m_age2 ="";
while (rs.next()) {
	m_age2 = rs.getString("m_age");
}
if (m_age2.equals("")) {
	out.println("���� �Ƶ��Դϴ�.");
} else if (!m_age.equals(m_age2)) {
	out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
} else {
	out.println("<h3>�α����� �Ϸ�Ǿ����ϴ�.<h3>.");	
	out.println("<h1><a href='4-02_color_client.jsp'> ����ó�� ���� </a></h1> ");
	out.println("<h3><a href='update_client.jsp'>ȸ���������� </a></h1> ");
	// ���� ������ ����.
	session.setAttribute("m_id", m_id);
	session.setAttribute("m_age", m_age);
}
stmt.close();
conn.close();

%>
</body>
</html>
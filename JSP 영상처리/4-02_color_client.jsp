<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>����ó�� Ŭ���̾�Ʈ</title>
</head>
<body>
<%
// ������ Ȯ���ؼ� ��� ���� ��Ű��
String m_id = (String)session.getAttribute("m_id");
String m_age = (String)session.getAttribute("m_age");

if (m_id == null || m_age == null) {
	out.println("���� ��ΰ� �ƴ�... <br><br>");
	return;
}
%>

<form name='fileForm' method='post' action='4-02_color_server.jsp'
	enctype='multipart/form-data'>
	<p> <select name="algo">
		<option value=""> ~~ ���� �ϼ��� ~~~ </option>
		<optgroup label="ȭ���� ó��">
		<option value="100"> ���� ���� ó�� </option>
		<option value="101"> ���� ó�� </option>
		<option value="102"> ���/��Ӱ�</option>
		<option value="103"> ���ó��</option>
		</optgroup>
		<optgroup label="������ ó��">
		<option value="201"> Ȯ���ϱ� </option>
		<option value="202"> ����ϱ� </option>
		<optgroup label="ȭ�ҿ���ó��">
		<option value="301"> ���� </option>
		<option value="302"> ������ </option>
		</optgroup>
	</select>
	<p> value: <input type='text' value = 50 name='addVal'>
	<p> File: <input type='file' name='filename'>
	<p> <input type='submit' value='����ó��(Į��)'>	
</form>
</body>
</html>
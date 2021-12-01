<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="EUC-KR">
<title>영상처리 클라이언트</title>
</head>
<body>
<%
// 세션을 확인해서 통과 여부 시키기
String m_id = (String)session.getAttribute("m_id");
String m_age = (String)session.getAttribute("m_age");

if (m_id == null || m_age == null) {
	out.println("정상 경로가 아님... <br><br>");
	return;
}
%>

<form name='fileForm' method='post' action='4-02_color_server.jsp'
	enctype='multipart/form-data'>
	<p> <select name="algo">
		<option value=""> ~~ 선택 하세요 ~~~ </option>
		<optgroup label="화소점 처리">
		<option value="100"> 동일 영상 처리 </option>
		<option value="101"> 반전 처리 </option>
		<option value="102"> 밝게/어둡게</option>
		<option value="103"> 흑백처리</option>
		</optgroup>
		<optgroup label="기하학 처리">
		<option value="201"> 확대하기 </option>
		<option value="202"> 축소하기 </option>
		<optgroup label="화소영역처리">
		<option value="301"> 블러링 </option>
		<option value="302"> 엠보싱 </option>
		</optgroup>
	</select>
	<p> value: <input type='text' value = 50 name='addVal'>
	<p> File: <input type='file' name='filename'>
	<p> <input type='submit' value='영상처리(칼라)'>	
</form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록 보기</title>
</head>
<body>

<table border=1>

<tr>
<td>번호</td> <td>이름</td> <td>제목</td> <td>게시 날짜</td> 
</tr>
<c:forEach items="${list}" var="list">

<tr>
<td>${list.seqno}</td>
 <td>${list.mwriter}</td>
  <td><a href="/board/mView?seqno=${list.seqno}">${list.mtitle}</a></td>
<td>${list.mregDate}</td>
</tr>



</c:forEach>

</table>



</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용 보기</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<script>
$(document).ready(function(){
	
	$("#btn_modify").click(function(){
		
		
		location.href="/board/mModify?seqno=${list.seqno}"
		
	})//$("#btn_modify").on("click",function() 
	$("#btn_delete").click(function(){
		
		if(confirm("진짜로 지울?")==true){
		
		location.href="/board/mDelete?seqno=${list.seqno}"
		
		}
	})//$("#btn_delete").on("click",function()

		//$(".WriteForm").attr("action", "/board/mWrite").submit();
		
}) //End of  $(document).ready(function()





</script>

<!-- <script>
   var delConfirm = confirm('당신의 파일이 삭제됩니다.');
   if (delConfirm) {
      alert('삭제되었습니다.');
   }
   else {
      alert('삭제가 취소되었습니다.');
   }
</script> -->

<body>

이름 : ${list.mwriter} <br>
제목 : ${list.mtitle} <br>
<%-- 날짜 :<fmt:formatDate value="${list.mregDate}" type="both" pattern="z a h:mm"/><br>  --%>
내용<br>
<pre> ${list.mcontent} </pre>

<button id="btn_modify">수정</button> <button id="btn_delete">삭제</button>

</body>
</html>
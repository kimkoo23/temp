<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 등록</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script>
$(document).ready(function(){
	
	$("#btn_write").on("click",function(){
		
		if($("#mwriter").val()==""){alert("이름을 입력하세요!!!");  $("#mwriter").focus(); return false;   }
		if($("#mtitle").val()==""){alert("제목을 입력하세요!!!");  $("#mtitle").focus(); return false;   }
		if($("#mcontent").val()==""){alert("내용을 입력하세요!!!");  $("#mcontent").focus(); return false;   }
		
		
		$(".WriteForm").attr("action", "/board/mWrite").submit();
		
	})// End of $("btm_write").on("click",function()  not null 로 받아야하는값들 if문
}) //End of  $(document).ready(function()

</script>

</head>
<body>

<form name="WriteForm" class="WriteForm" method="POST">

이름 : <input type="text" id="mwriter" name="mwriter"  placeholder="여기에 이름을 입력하세요"> <br>
제목 : <input type="text" id="mtitle" name="mtitle"  placeholder="여기에 제목을 입력하세요"><br>
<input type="hidden" name="userid" value="kim">
내용 : <br>
<textarea id="mcontent" name="mcontent" cols="100" row="500" placeholder="여기에 내용을 입력하세요"> 
</textarea>

<button id="btn_write">여기를 클릭 하세요!!!</button>

</form>

</body>
</html>
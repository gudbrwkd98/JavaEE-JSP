<%@page import="com.webapp1216.board.model.NoticeDAO"%>
<%@page import="com.webapp1216.board.model.Notice"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%

	Notice notice = (Notice)session.getAttribute("notice"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
  width: 100%;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 6px;
  margin-bottom: 16px;
  resize: vertical;
}

input[type=button] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>


$(function() {
	var bt_edit=$("input[type='button']")[0];
	var bt_del=$("input[type='button']")[1];
	var bt_list=$("input[type='button']")[2];

	
	$(bt_edit).click(function(){
		edit();			
	});
	$(bt_del).click(function(){
			del();
	});
});

function edit(){
	if(confirm("수정하시겠어요?")){
	$("form").attr({
		action:"/board/edit",
		method:"post"
	});
	$("form").submit();
	}
	
}

function del(){
	$("form").attr({
		action:"/board/delete", //실존하는 파일이 아닌 가상의 매핑주소이다
		method:"get"
	});
	$("form").submit();
	
}




</script>

<body>

<h3>Contact Form</h3>

<div class="container">
		<form>
			<input type="text" name="notice_id" value="<%=notice.getNotice_id()%>" hidden>
			<input type="text" name="title" placeholder="Your last name.." value="<%=notice.getTitle()%>">
			<input type="text" name="writer" placeholder="Your name.." value="<%=notice.getWriter()%>"> 
			<textarea name="content" placeholder="Write something.." style="height: 200px"><%=notice.getContent() %></textarea>
			<input type="button" value="수정하기"> 
			<input type="button" value="삭제하기">
			<input type="button" value="목록보기" onClick="location.href='/board/list'">
		</form>

</div>

</body>
</html>
<%@page import="blood.model.BloodAdvisor"%>
<%@ page contentType="text/html;charset=utf-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<script>
function send(){
	var form = document.querySelector("form");
	form.action="/blood.do";
	form.method="get";
	form.submit();
	
}

</script>
<body>
	<form>
	<select name="blood">
		<option>혈액행을 선택하세요</option>
		<option>A형</option>
		<option>B형</option>
		<option>O형</option>
		<option>AB형</option>
	</select>
	<button type="button" onClick="send()">분석 결과 보기</button>
	</form>
	
</body>
</html>
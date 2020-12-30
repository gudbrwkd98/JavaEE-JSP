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
	form.action="/movie.do";
	form.method="get";
	form.submit();
	
}

</script>
<body>
	<form>
	<select name="movie">
		<option value="미션임파서블5">미션임파서블5</option>
		<option value="스타워즈">스타워즈</option>
		<option value="존윅">존윅</option>
		<option value="분노의질주3">분노의질주3</option>
	</select>
	<button type="button" onClick="send()">영화에 대한 판단 결과</button>
	</form>
	
</body>
</html>
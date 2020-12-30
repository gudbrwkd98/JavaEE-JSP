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
<body>
영화에 대한 판단 결과<p>
<%=session.getAttribute("msg") %>
<a href="/movie/movie_form.jsp">선택 폼으로 가기</a>
</body>
</html>
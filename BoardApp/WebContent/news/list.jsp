<%@page import="board.model.News"%>
<%@page import="java.util.List"%>
<%@page import="board.model.NewsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	NewsDAO dao = new NewsDAO();
	List<News> list = dao.selectAll();
	int totalRecord= list.size();//총 레코드 수 
	int pageSize = 10; //한페이지에 보여질  레코드 수
	int totalPage = (int)(Math.ceil((float)totalRecord/pageSize));
	int blockSize = 10 ; //블럭당 보여질 페이지 수
	int currentPage=1; //현재 페이지(디폴트 첫페이지 이다)
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int firstPage = currentPage-(currentPage-1)%blockSize;
	int lastPage = firstPage + (blockSize-1);
	
	int curPos = (currentPage-1)*pageSize;
	int num = totalRecord - curPos; //페이지당 시작번호
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
table{
	width:100%;
	border:1px solid #cccccc;
}
td{
	border:1px solid #cccccc;
}
a{
text-decoration: none;
}
.pageNum{
font-size: 20pt;
color:blue;
font-weight: bold;
}
.inactive{
	color:#cccccc;
}
</style>
<script>
function showColor(obj) {
	obj.style.background="dodgerblue";
}

function hideColor(obj) {
	obj.style.background="";
}
</script>
</head>
<body>
	<table>
		<tr>
			<td width="5%">No</td>
			<td width="70%">제목</td>
			<td width="10%">작성자</td>
			<td widht="10%">등록일</td>
			<td width="5%">조회수</td>
		</tr>
		<%for(int i = 1 ; i <=pageSize; i++){ 
			if(num <= 0)break;
			News news = list.get(curPos++);
		%>
		
		<tr onmouseover="showColor(this)" onMouseOut="hideColor(this)">
			<td><%=num-- %></td>
			<%if(news.getWriter().length()<1) { //작성자의 문자열 길이가 0이라면..%>
			<td><span class="inactive"><%=news.getTitle() %></span></td>
			<%}else{ %>
			<td><a href="detail.jsp?news_id=<%=news.getNews_id()%>"><%=news.getTitle() %> </a><%if(news.getCnt() <= 0 ){}else{ %> (<%=news.getCnt() %>) <%} %></td>
			<%} %>
			<td><%=news.getWriter() %></td>
			<td><%=news.getRegdate() %></td>
			<td><%=news.getHit() %></td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" align="center">
				<a href="list.jsp?currentPage=<%=firstPage-1%>">←</a>
				<%for(int i = 1 ; i<=blockSize;i++){%>
					<%if(i>totalPage)break; //총 페이지수를 넘어서면... %>
					<a href="list.jsp?currentPage=<%=i%>" <%if(currentPage == i){ %> class ="pageNum" <%} %>>[<%=i %>]</a>
				<%} %>
				<a href="list.jsp?currentPage=<%=lastPage+1%>">→ </a>
			</td>
		</tr>
		
		<tr>
			<td colspan="5">
				<button onClick="location.href='regist_form.jsp'">글쓰기</button>
			</td>
		</tr>
	</table>
</body>
</html>
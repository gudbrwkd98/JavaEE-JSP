<%@page import="java.util.List"%>
<%@page import="board.model.QnADAO"%>
<%@page import="board.model.QnA"%>
<%@page import="board.model.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.NoticeDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="db.DBManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%
	QnADAO qnaDAO = new QnADAO();// TODO Auto-generated catch block();
	List<QnA> list = qnaDAO.selectALL();
	int totalRecord = list.size(); //총레코드 수
	int pageSize = 10 ; // 한페이지당 보여질 레코드 수
	int totalPage = ((int)Math.ceil((float)totalRecord/pageSize)); //총페이지 수
	int blockSize = 10; //한 블럭당 보여질 페이지의 수 
	int currentPage = 1 ; //현재 페이지 
	
	if(request.getParameter("currentPage") != null){
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	int firstPage = currentPage-(currentPage-1)%blockSize;
	int lastPage = firstPage + (blockSize-1);
	int num = totalRecord-(currentPage-1)*pageSize;
	int curPos = (currentPage-1)*pageSize;
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}
th, td {
  text-align: left;
  padding: 16px;
}
tr:nth-child(even) {
  background-color: #f2f2f2;
}
img{
	box-sizing:border-box;
}
a{
	text-decoration:none;
}

.pageNum{
font-size: 20px;
color:red;

}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function(){
	$("button").on("click",function(){
		//자바스크립트에서 링크 구현? 
		location.href="/qna/regist_form.jsp";
	});
}); //onload
</script>
</head>
<body>

<table>
  <tr>
    <th>No</th>
    <th>제목</th>
    <th>작성자</th>
	<th>등록일</th>
	<th>조회수</th>
  </tr>

	<%for(int i=0;i<pageSize;i++){%>
	<%if(num<=0)break;%>
	<%
		//break 문을 만나지않았다는 것은 레코드가 있다는 것이므로 break문아래에 데이터 추출
		QnA qna = list.get(curPos++); //1page 0~9 2page: 10~19..
	%>
  <tr>
    <td><%=num-- %></td>
    <td>
    	<%if(qna.getDepth()>0) {%>
    	<img alt="" src="/image/comment.png" width="10px" height="10px" style="margin-left:<%=(10*qna.getDepth())+"px"%>">
    	<%}%>
		<a href="/qna/detail.jsp?notice_id=<%=qna.getQna_id()%>"><%=qna.getTitle()%></a>
	</td>
    <td><%= qna.getWriter()%></td>
	<td><%=qna.getRegdate().toString().substring(10)%></td>
	<td><%=qna.getHit()%></td>
  </tr>
	<%}%>
	<tr>
	<td colspan="5" style="text-align: center;">
	 <%if(firstPage-1 !=0){ %>
  	<a href="/qna/list2.jsp?currentPage=<%=firstPage-1%>">&#9664;</a>
  	<%}else{ %>
  	<a href="javascript:alert('처음페이지 입니다');">&#9664;</a>
  	<%} %>
  	
	<% for(int i = firstPage; i<= lastPage; i++){ %>
		<%if(totalPage < i)break; %>
	<a href="/qna/list.jsp?currentPage=<%=i%>" <%if(currentPage==i){ %> class="pageNum" <%} %>>[<%=i %>]</a>
	<%} %>
	
		<%if((lastPage+1)<totalPage){ %>
	<a href="/qna/list2.jsp?currentPage=<%=lastPage+1%>">&#9654;</a>
  	<%}else{ %>
  		<a href="javascript:alert('마지막페이지 입니다');">&#9654;</a>
  	<%} %>
	</td>
	</tr>

  <tr> 
	<td colspan="5" > 
		<button>글등록</button>
	</td>
  </tr>
  <tr>
	<td colspan="5" style="text-align:center"> 
		<%@ include file="/inc/footer.jsp"%>
	</td>
  </tr>

</table>

</body>
</html>
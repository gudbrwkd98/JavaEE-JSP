<%@page import="board.model.QnA"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.model.QnADAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<% 

	QnADAO dao = new QnADAO();
	List<QnA> list = dao.selectALL();
	int totalRecord=list.size(); //총 레코드 수 
  	int pageSize = 10 ; //한 페이지당 보여질 레코드 수 
	int totalPage = ((int)Math.ceil((float)totalRecord/pageSize)); //총 페이지 수
	int blockSize =10; //한 블럭당 보여질 페지이지 수
	int currentPage = 1 ; // 현재 페이지
	//아래의 코드는 아무때나 하는게아니다 ! 즉 누군가가 파라미터를 넘겻을때만 즉 페이지 넘버를 클릭한 경우를 전제로 
	//숫자화 시키는 코드다 
	if(request.getParameter("currentPage")!=null){
	currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	int firstPage = ((currentPage-1)/10)*10+1; //반복문의 시작값 currentpage - (currentPage-1)%blocksize
	int lastPage = ((currentPage-1)/10)*10+10; // 반복문의 끝값 firstPage + (blockSize-1)
	int num = totalRecord-(currentPage-1)*pageSize;//페이지당 시작 번호 
	int curPos = (currentPage-1)*pageSize;//페이지당 List에서의 시작 index
%>
<%="총 레코드 수는 " + totalRecord+ "<br>" %>
<%="페이지 사이즈  " + pageSize+ "<br>" %>
<%="페이지 숫자  " +totalPage + "<br>" %>
<%="firstPage 숫자  " +firstPage + "<br>" %>
<%="lastPage 숫자  " +lastPage + "<br>" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
font-size: 20pt;
color :red;
font-weight: bold;
}
</style>
<script>
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

<%for(int i = 1 ; i<pageSize; i++){ %>
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
    <td><%=qna.getWriter() %></td>
	<td><%=qna.getRegdate() %></td>
	<td><%=qna.getHit() %></td>
  </tr>
  <%} %>
  <tr>
  <td colspan="5" style="text-align: center">
  	<%if(firstPage-1 !=0){ %>
  	<a href="/qna/list2.jsp?currentPage=<%=firstPage-1%>">&#9664;</a>
  	<%}else{ %>
  	<a href="javascript:alert('처음페이지 입니다');">&#9664;</a>
  	<%} %>
	<%for(int i = firstPage; i <= lastPage; i++){ %>
	<%if(totalPage < i)break; %>
	<a href="/qna/list2.jsp?currentPage=<%=i%>" <%if(currentPage==i){ %> class="pageNum" <%} %>> [<%=i %>]</a>
	
	<%} %>
	
	<%if((lastPage+1)<totalPage){ %>
	<a href="/qna/list2.jsp?currentPage=<%=lastPage+1%>">&#9654;</a>
  	<%}else{ %>
  		<a href="javascript:alert('마지막페이지 입니다');">&#9654;</a>
  	<%} %>
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
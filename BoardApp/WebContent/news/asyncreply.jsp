<%@page import="board.model.Comments"%>
<%@page import="java.util.List"%>
<%@page import="board.model.CommentsDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	//여기서 쿼리실행할 것은 아니지만, 계획을 세우기 위해 ....
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="comments" class="board.model.Comments"/>
<jsp:setProperty property="*" name="comments"/>
<%
	
 CommentsDAO dao = new CommentsDAO();
String resultMsg= null;
	int result = dao.insert(comments);
	StringBuilder sb = new StringBuilder();
if(result==0){
	sb.append("{");
	sb.append("\"resultCode\":"+result+", ");
	sb.append("}");
}else{
	//목록 조회
	List<Comments> list = dao.selectAll(comments.getNews_id());
	sb.append("{");
	sb.append("\"resultCode\":"+result+", ");
	sb.append("\"commentsList\" : [");
	for(int i = 0 ; i<list.size();i++){
	Comments obj = list.get(i);
	sb.append("{");
	sb.append("\"comments_id\":"+obj.getNews_id()+",");
	sb.append("\"author\":\""+obj.getAuthor()+"\",");
	sb.append("\"msg\":\""+obj.getMsg()+"\",");
	sb.append("\"cdate\":\""+obj.getCdate()+"\"");
	if(i<list.size()-1){
	sb.append("},");
	}else{
		sb.append("}");
	}
	}
	sb.append("]");
	sb.append("}");
}
	out.print(sb.toString());

%>
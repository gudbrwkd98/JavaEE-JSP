<%@page import="com.model2.domain.Comment"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/json;charset=utf-8"%>
<%
	List<Comment> commentList = (List) request.getAttribute("commentList");
	StringBuilder sb = new StringBuilder();
	sb.append("{");
	sb.append("\"list\":[");
	for(int i = 0; i<commentList.size();i++){
		Comment comment = commentList.get(i);
	sb.append("{");
	sb.append("\"msg\":\" "+comment.getMsg()+"\",");
	sb.append("\"author\":\" "+comment.getAuthor()+"\",");
	sb.append("\"cdate\":\" "+comment.getCdate()+"\"");
	if(i<commentList.size()-1){
		sb.append("},");
	}else{
	sb.append("}");
		}
	}
	sb.append("]");
	sb.append("}");
	out.print(sb); //응답컨텐츠
%>
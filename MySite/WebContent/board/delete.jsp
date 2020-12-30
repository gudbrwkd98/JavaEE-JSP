<%@page import="board.model.MybatisBoardDAO"%>
<%@page import="common.file.FileManager"%>
<%@page import="board.model.BoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	int board_id = Integer.parseInt(request.getParameter("board_id"));
	String filename = request.getParameter("filename");
	
	MybatisBoardDAO dao = new MybatisBoardDAO();
	
	String path = application.getRealPath("/data");
	
	
	if(FileManager.deleteFile(path+"/"+filename)){
	
	if(dao.delete(board_id)!=0){
		out.print(getMsgURL("성공", "/board/list.jsp"));
	}else{
		out.print(getMsgBack("실패"));
	}
	}else{
		out.print(getMsgBack("파일 삭제 실패"));
	}
%>
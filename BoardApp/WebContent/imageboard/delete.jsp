<%@page import="java.io.File"%>
<%@page import="board.model.ImageBoard"%>
<%@page import="board.model.ImageBoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ page import="db.DBManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.ResultSet"%>
<%@ include file="/inc/lib.jsp" %>
<%
	ImageBoardDAO boradDAO = new ImageBoardDAO();


	int board_id = Integer.parseInt(request.getParameter("board_id"));
	String filename = request.getParameter("filename");
	File file = new File("C:/workspace/javaEE_workspace/BoardApp/WebContent/data/"+filename);
	if(file.delete()){
		int result = boradDAO.delete(board_id); //vo,dto 
		if(result == 0){
			out.print(getMsgBack("실패"));
			}else{
			out.print(getMsgURL("성공","/imageboard/list.jsp"));
			}
	}else{
		out.print(getMsgBack("삭제 실패"));
	}
	
	//등록
	
	


	%>
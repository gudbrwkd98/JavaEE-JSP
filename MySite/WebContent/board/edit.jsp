<%@page import="board.model.MybatisBoardDAO"%>
<%@page import="common.file.FileManager"%>
<%@page import="board.model.Board"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="board.model.BoardDAO"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%
	MybatisBoardDAO dao = new MybatisBoardDAO();
	//파일 업로드인 경우 파라미터 처리는 파일업로드 컴포넌트를 통해서 한다!
	//왜? multipart/form-data 에 의한 전송 파라미터 파싱한 주체 업로드 컴포넌트라서...
	DiskFileItemFactory factory = new DiskFileItemFactory();
	String path = application.getRealPath("/data");
	factory.setRepository(new File("C:/workspace/javaEE_workspace/MySite/WebContent/data"));
	factory.setSizeThreshold(2*1024*1024);
	factory.setDefaultCharset("utf-8");
	
	//파라미터 객체 뽑아내기
	ServletFileUpload upload = new ServletFileUpload(factory);
	List<FileItem> items = upload.parseRequest(request);
	Board board = new Board();
	for(FileItem item: items){
		if(item.isFormField()){
			if(item.getFieldName().equals("board_id")){
				board.setBoard_id(Integer.parseInt(item.getString()));
			}else if(item.getFieldName().equals("filename")){
				board.setFilename(item.getString());
			}else if(item.getFieldName().equals("title")){
				board.setTitle(item.getString());
			}else if(item.getFieldName().equals("writer")){
				board.setWriter(item.getString());
			}else if(item.getFieldName().equals("content")){
				board.setContent(item.getString());
			} 
		}else{
			if(item.getName().length()>0){//파일명이있다면 즉 업로드한다면..
				
				//기존파일은 삭제하자
				if(FileManager.deleteFile(path+"/"+board.getFilename())){
				//새로운파일처리
				String newName = System.currentTimeMillis()+"."+FileManager.getExtend(item.getName());
				item.write(new File(path+"/"+newName));
				board.setFilename(newName);//새로 만들어진이름을 vo에 넣어줘야 db에도 업데이트된다
				}else{
					
				}
			}
		}
	}
	
	if(dao.update(board)==0){
		out.print(getMsgBack("실패"));
	}else{
		out.print(getMsgURL("성공", "/board/detail.jsp?board_id="+board.getBoard_id()));
	}
	
	
	
	


%>
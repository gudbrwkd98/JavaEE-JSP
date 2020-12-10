<%@ page contentType="text/html;charset=utf-8"%>
<%!
	//앞으로 재사용성이 높은 jsp 코드를 이 파일에 메서드로 모아놓겠다!!
	//선언부에는 멤버변수와 메서드를 정의할수있다
	public String getMsgBack(String msg){
	StringBuilder sb = new StringBuilder();
	sb.append("<script>");
	sb.append("alert('"+msg+"');");
	sb.append("history.back();");
	sb.append("</script>");

	return sb.toString();
	}

	public String getMsgURL(String msg,String url){

	StringBuilder sb = new StringBuilder();
	sb.append("<script>");
	sb.append("alert('"+msg+"');");
	sb.append("location.href='"+url+"';");
	sb.append("</script>");

	return sb.toString();

	}
%>
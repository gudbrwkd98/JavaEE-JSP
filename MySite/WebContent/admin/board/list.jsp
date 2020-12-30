<%@page import="admin.model.Admin"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	Admin admin = (Admin)session.getAttribute("ad");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <%@ include file="/admin/inc/head.jsp" %>
</head>
<body>
 <%@ include file="/admin/inc/topnavi.jsp" %>
  <div><%=admin.getMid()%>님 로그인 중
	<a href="/admin/logout.jsp">로그아웃</a>
</div>
<div class="container">
  <h2>Striped Rows</h2>
 

  
  <p>The .table-striped class adds zebra-stripes to a table:</p>            
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Firstname</th>
        <th>Lastname</th>
        <th>Email</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>John</td>
        <td>Doe</td>
        <td>john@example.com</td>
      </tr>
      <tr>
        <td>Mary</td>
        <td>Moe</td>
        <td>mary@example.com</td>
      </tr>
      <tr>
        <td>July</td>
        <td>Dooley</td>
        <td>july@example.com</td>
      </tr>
    </tbody>
  </table>
</div>

</body>
</html>

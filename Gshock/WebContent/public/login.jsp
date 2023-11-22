 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/templates/public/inc/header.jsp" %>   
     <div class="container">
     

     
	<h1 class="type">Tài khoản</h1>
	<h2>Đăng nhập</h2>
	 <%
     	String err= request.getParameter("err");
     if("2".equals(err)){
 		out.print("<p style='color:red;'>Đăng nhập trước khi Bình Luận</p>");
 	}
     %>
	<div class="border" style="border-radius:5px;margin:20px 0">
		<form id="form-login" method="post" style="padding:20px">
	  <div class="mb-3">
	    <label for="username" class="form-label">Username</label>
	    <input type="text" name="username" class="form-control" id="username" aria-describedby="emailHelp">
	    <div id="Username" class="form-text">Email or Username </div>
	  </div>
	  <div class="mb-3">
	    <label for="password" class="form-label">Password</label>
	    <input type="password" class="form-control" name="password" id="password">
	  </div>

	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>	
    </div>

 <%@include file="/templates/public/inc/footer.jsp" %>   
</body>

</html>
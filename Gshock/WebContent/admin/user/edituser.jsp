
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
   <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>

<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Sửa người dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        		<%
        			  String username = request.getParameter("username");
        		 	  String fullname = request.getParameter("fullname");
        		 	  String numberphone = request.getParameter("numberphone");
       		 	  	  String email = request.getParameter("email");
       		 	  	  String role = request.getParameter("role");
       				  String msg = request.getParameter("msg");
       				  User user =(User)request.getAttribute("user");
       				 if(user!=null){
       					username = user.getUsername();
       					fullname= user.getFullname();
       					numberphone = Integer.toString(user.getNumberphone());
       					email= user.getEmail();
       					role = Integer.toString(user.getRole());
       					
       				 }
			    	   			  
					  String err = request.getParameter("err");
					  if("1".equals(err)){
					  out.print("<p style=\"color:red;font-weight:bold\">Sửa thất bại</p>")	;
					  }
					
					  
				%>
        <hr />
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form id="form" action="" role="form" method="post"  >
                                    <div class="form-group">
                                        <label for="name">Username</label>
                                        <input type="text" id="username" value="<%if(username!=null){out.print(username);}%>" name="username" class="form-control" />
                                    </div>                                                                 
                                    <div class="form-group">
                                        <label for="password">Password</label>
                                        <input type="password" id="password" value="" name="password" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Xác nhận Password</label>
                                        <input type="password" id="repassword" value="" name="repassword" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="name">Fullname</label>
                                        <input type="text" id="fullname" value="<%if(fullname!=null){out.print(fullname);}%>" name="fullname" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="name">Email</label>
                                        <input type="text" id="email" value="<%if(email!=null){out.print(email);}%>" name="email" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="numberphone">Numberphone</label>
                                        <input type="text" id="numberphone" value="<%if(numberphone!=null){out.print(numberphone);}%>" name="numberphone" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="role">Role</label>
                                        <input type="text" id="role" value="<%if(role!=null){out.print(role);}%>" name="role" class="form-control" />
                                    </div>
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End Form Elements -->
            </div>
        </div>
        <!-- /. ROW  -->
    </div>
    <!-- /. PAGE INNER  -->
</div>

<script>
$().ready(function(){
		var validator = $("#form").validate({			
			rules:{
				username:{
					required:true,
				},
				password:{
					required:true,
				},
				repassword:{
					required:true,
					equalTo:"#password"
				},
				fullname:{
					required:true,
				},
				email:{
					required:true,
				},	
				numberphone:{
					required:true,
					number:true,
				},	
				role:{
					required:true,
					number:true,
				},	
			},
			messages:{
				username:{
					required:" (tên đăng nhập không dược trống)",
				},
				password:{
					required:" (mật khẩu không dược trống)",
				},
				repassword:{
					required:"(Xác nhận lại mật khẩu)",
					equalTo:"(Mật khẩu chưa đúng)",
				},
				fullname:{
					required:"(tên  không dược trống)",
				},
				email:{
					required:" (email không dược trống)",
				},
				numberphone:{
					required:"(numberphone không dược trống)",
					number:"(Nhập số)",
				},
				role:{
					required:"(role  không dược trống)",
					number:"Mời nhập số",
				},
			},
		});
	});
</script>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
 
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>

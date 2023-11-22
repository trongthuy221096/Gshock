<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>

<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm Payment</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        		<%
        			  String name = request.getParameter("name");
       		 	  	  String userid = request.getParameter("userid");
       		 	  	  String numbercard = request.getParameter("numbercard");
       				  String msg = request.getParameter("msg");
       				 
			    	  if("1".equals(msg)){			    		  
			    		 out.print("<p style=\"color:green;font-weight:bold\">Thêm người dùng thành công</p>");
			    	  }    			  
					  String err = request.getParameter("err");
					  if("1".equals(err)){
					  out.print("<p style=\"color:red;font-weight:bold\">Thêm thất bại</p>")	;
					  }
					  if("2".equals(err)){
						  out.print("<p style=\"color:red;font-weight:bold\">Username tồn tại</p>")	;
						  }
					  if("3".equals(err)){
						  out.print("<p style=\"color:red;font-weight:bold\">Điền đầy đủ thông tin</p>")	;
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
                                        <label for="name">Name</label>
                                        <input type="text" id="name" value="<%if(name!=null){out.print(name);}%>" name="name" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="numbercard">NumberCard</label>
                                        <input type="text" id="numbercard" value="<%if(numbercard!=null){out.print(numbercard);}%>" name="numbercard" class="form-control" />
                                    </div>                                                                 
                                    <div class="form-group">
                                        <label for="name">Password</label>
                                        <input type="password" id="password" value="" name="password" class="form-control" />
                                    </div>                                                                  
                                     <div class="form-group">
                                        <label for="userid">UserID</label>
                                        <input type="text" id="userid" value="<%if(userid!=null){out.print(userid);}%>" name="userid" class="form-control" />
                                    </div>                                   
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Thêm</button>
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
				name:{
					required:true,
				},
				numbercard:{
					required:true,
					number:true,
				},
				userid:{
					required:true,
					number:true,
				},	
			},
			messages:{
				name:{
					required:"Mời Bạn nhập thông tin",
				},
				numbercard:{
					required:"Mời Bạn nhập thông tin",
					number:"Mời bạn nhập số",
				},
				userid:{
					required:"Mời Bạn nhập thông tin",
					number:"Mời bạn nhập số",
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

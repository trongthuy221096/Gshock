<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý người dùng</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
         <%
      
        String msg = request.getParameter("msg");
        String err = request.getParameter("err");
        if("1".equals(msg)){			    		  
   		 out.print("<p style=\"color:green;font-weight:bold\">Thêm người dùng thành công</p>");
   	 	 }
        if("3".equals(msg)){			    		  
      		 out.print("<p style=\"color:green;font-weight:bold\">Xóa người dùng thành công</p>");
      	 	 }
        if("2".equals(msg)){			    		  
      		 out.print("<p style=\"color:green;font-weight:bold\">Sửa người dùng thành công</p>");
      	 	 }
        if("1".equals(err)){			    		  
      		 out.print("<p style=\"color:red;font-weight:bold\">ID không tồn tại</p>");
      	 	 }
        if("2".equals(err)){			    		  
     		 out.print("<p style=\"color:red;font-weight:bold\">Sửa thất bại</p>");
     	 	 }
        if("3".equals(err)){			    		  
     		 out.print("<p style=\"color:red;font-weight:bold\">Xóa thất bại</p>");
     	 	 }
        if("4".equals(err)){			    		  
    		 out.print("<p style=\"color:red;font-weight:bold\">Bạn ko có quyền thêm</p>");
    	 	 } 
        if("5".equals(err)){			    		  
    		 out.print("<p style=\"color:red;font-weight:bold\">Bạn ko có quyền sửa</p>");
    	 	 } 
        if("6".equals(err)){			    		  
    		 out.print("<p style=\"color:red;font-weight:bold\">Bạn ko có quyền xóa</p>");
    	 	 } 
        if("7".equals(err)){			    		  
   		 out.print("<p style=\"color:red;font-weight:bold\">Không tìm thấy</p>");
   	 	 }
        %>
        <div class="row">
            <div class="col-md-12">
                <!-- Advanced Tables -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="table-responsive">
                            <div class="row">
                                <div class="col-sm-6">
                                    <a href="<%=request.getContextPath()%>/admin/user/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit"  value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" name="search" class="form-control input-sm" placeholder="Nhập vào username" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Username</th>
                                        <th>Fullname</th>
                                        <th>Email</th>
                                         <th>NumberPhone</th>
                                        <th>Role</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%                                                               		
                                		ArrayList<User> listUser = (ArrayList<User>) request.getAttribute("listUser");
                                		int currentpage = 0;
	                               		int numberOfPage = 0;
	                               		int numberOfUser = 0;
	                               		int offset=0;
	                               		int offset2=0;
	                               		if(request.getAttribute("currentpage")!=null){
	                               			currentpage = (int)request.getAttribute("currentpage");
	                               		}
	                               		if(request.getAttribute("numberOfPage")!=null){
	                               			numberOfPage = (int)request.getAttribute("numberOfPage");
	                               		}
	                               		if(request.getAttribute("numberOfUser")!=null){
	                               			numberOfUser = (int)request.getAttribute("numberOfUser");
	                               		}
	                               		if(request.getAttribute("offset")!=null){
	                               			offset = (int)request.getAttribute("offset");
	                               			offset2 = offset+listUser.size(); 
	                               		}	                                                         	
	                               		                               		
                                		if(listUser!=null && listUser.size()>0){
                                		for(User user:listUser){
                                	%>
                                    <tr>
                                        <td><%=user.getId()%></td>
                                        <td class="center"><%=user.getUsername() %></td>
                                        <td class="center"><%=user.getFullname() %></td>
                                        <td class="center"><%=user.getEmail()%></td>
                                        <td class="center"><%=user.getNumberphone()%></td>
                                        <td class="center"><%=user.getRole()%></td>
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/user/edit?id=<%=user.getId()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath()%>/admin/user/del?id=<%=user.getId()%>" onclick="return confirm('Bạn có chắc muốn xóa')" title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                       
                                    </tr>
                                    <%}} %>						
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
									<div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=offset %> đến <%=offset2 %> của <%=numberOfUser %> người dùng</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/user?page=<%=currentpage-1%>">Trang trước</a></li>
                                              <%                                          		
                                           		if(listUser!=null && listUser.size()>0){
                                           			for(int i = 1 ; i <= numberOfPage;i++ ){
                                           %>
                                            <li class="paginate_button <%if(currentpage==i){out.print(" active ");} %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/user?page=<%=i%>"><%=i %></a></li>
											<%}} %>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/user?page=<%=currentpage+1%>">Trang tiếp</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
                <!--End Advanced Tables -->
            </div>
        </div>
    </div>
</div>
<script>
    document.getElementById("user").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
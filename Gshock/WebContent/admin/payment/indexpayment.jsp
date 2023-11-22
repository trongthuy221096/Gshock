<%@page import="model.bean.Payment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý Payment</h2>
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
                                    <a href="<%=request.getContextPath()%>/admin/payment/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                   
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Name</th>
                                        <th>NumberCard</th>
                                        <th>UserID</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                           				<%                                                               		
                                		ArrayList<Payment> listPay = (ArrayList<Payment>) request.getAttribute("listPay");
                                		int currentpage = 0;
	                               		int numberOfPage = 0;
	                               		int numberOfPay = 0;
	                               		int offset=0;
	                               		if(request.getAttribute("currentpage")!=null){
	                               			currentpage = (int)request.getAttribute("currentpage");
	                               		}
	                               		if(request.getAttribute("numberOfPage")!=null){
	                               			numberOfPage = (int)request.getAttribute("numberOfPage");
	                               		}
	                               		if(request.getAttribute("numberOfPay")!=null){
	                               			numberOfPay = (int)request.getAttribute("numberOfPay");
	                               		}
	                               		if(request.getAttribute("offset")!=null){
	                               			offset = (int)request.getAttribute("offset");
	                               		}	                                                         	
	                               		int offset2 = offset+listPay.size();                               		
                                		if(listPay!=null && listPay.size()>0){
                                		for(Payment pay:listPay){
                                	%>
                                    <tr>
                                        <td><%=pay.getId() %></td>
                                        <td class="center"><%=pay.getName()%></td>
                                        <td class="center"><%=pay.getNumbercard() %></td>
                                        <td class="center"><%=pay.getUserid()%></td>
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/payment/edit?id=<%=pay.getId()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath()%>/admin/payment/del?id=<%=pay.getId()%>" onclick="return confirm('Bạn có chắc muốn xóa')" title="" class="btn btn-danger"><i class="fa fa-pencil" ></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%}} %>								
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=offset %> đến <%=offset2 %> của <%=numberOfPay %> Payment</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/payment?page=<%=currentpage-1%>">Trang trước</a></li>
                                              <%                                          		
                                           		if(listPay!=null && listPay.size()>0){
                                           			for(int i = 1 ; i <= numberOfPage;i++ ){
                                           %>
                                            <li class="paginate_button <%if(currentpage==i){out.print(" active ");} %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/payment?page=<%=i%>"><%=i %></a></li>
											<%}} %>
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/payment?page=<%=currentpage+1%>">Trang tiếp</a></li>
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
    document.getElementById("payment").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
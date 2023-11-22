<%@page import="model.bean.Oder"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý ShopOder</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
         <%
         	ArrayList<Oder> listOder = (ArrayList<Oder>) request.getAttribute("listOder"); 
        	String err= request.getParameter("err");
         	String msg= request.getParameter("msg");
         	int currentpage =0 ;
         	int item =0 ;
         	int numberOfPage=0;
         	int numberOfOder= 0;
         	int  offset = 0;
         	if(request.getAttribute("currentpage")!=null){
       			currentpage = (int)request.getAttribute("currentpage");
       		}
       		if(request.getAttribute("numberOfPage")!=null){
       			numberOfPage = (int)request.getAttribute("numberOfPage");
       		}
       		if(request.getAttribute("numberOfUser")!=null){
       			numberOfOder = (int)request.getAttribute("numberOfOder");
       		}
       		if(request.getAttribute("offset")!=null){
       			offset = (int)request.getAttribute("offset");
       		}	                                                         	
       		int offset2 = offset+listOder.size();                 
        	if("1".equals(err)){
        		out.print("<p style='color:red;'>ID ko tồn tại</p>");
        	}
        	if("2".equals(err)){
        		out.print("<p style='color:red;'>Có lỗi khi xóa</p>");
        	}
        	if("3".equals(err)){
        		out.print("<p style='color:red;'>Bạn chưa nhập vào ô tìm kiếm</p>");
        	}
        	
        	if("1".equals(msg)){
        		out.print("<p style='color:green;'>Thêm thành công</p>");
        	}
        	if("2".equals(msg)){
        		out.print("<p style='color:green;'>Sửa thành công</p>");
        	}
        	if("3".equals(msg)){
        		out.print("<p style='color:green;'>Xóa thành công</p>");
        	}if("4".equals(msg)){
        		out.print("<p style='color:green;'>Xuất thành công</p>");
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
                                    
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit"  value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" name="name-search" class="form-control input-sm" placeholder="Nhập đơn hàng" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Fullname</th>
                                        <th>Numberphone</th>
                                        <th>Email</th>
                                        <th>Adress</th>
                                        <th>CodeOder</th>
                                        <th>UserID</th>
         								<th>Payment</th>
                                        <th>Text</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <% 
                                	if(listOder!=null && listOder.size()>0){
                                		for(Oder oder:listOder){
                                %>
                                    <tr>
                                        <td><%=oder.getId() %></td>
                                        <td class="center"><%=oder.getName() %></td>
                                        <td class="center"><%=oder.getNumberphone() %></td>
                                        <td class="center"><%=oder.getEmail() %></td>                                     
                                        <td class="center"><%=oder.getAdress()%></td>
                                        <td class="center"><%=oder.getCodeoder() %></td>
                                        <td class="center"><%=oder.getUserid() %></td>
                                        <td class="center"><%=oder.getPayment() %></td>                                           
                                        <td class="center"><%=oder.getText() %></td>                                    
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/getexcel?id=<%=oder.getId()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Xuất</a>
                                        </td>
                                    </tr>
                                    <%}} %>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=offset %> đến <%=offset2 %> của <%=numberOfOder %> Đơn hàng</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/oder?page=<%=currentpage-1%>">Trang trước</a></li>
                                            <%for(int i = 1; i<=numberOfPage;i++ ){%>
                                            <li class="paginate_button <%if(currentpage==i){out.print(" active ");} %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/oder?page=<%=i%>"><%=i%></a></li>	
                                            <%} %>							
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/oder?page=<%=currentpage+1%>">Trang tiếp</a></li>
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
    document.getElementById("oder").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
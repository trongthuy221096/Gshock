<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
         <%
         	ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat"); 
        	String err= request.getParameter("err");
         	String msg= request.getParameter("msg");
         	int currentpage =0 ;
         	int numberOfCat =0 ;
         	int numberOfPage=0;
         	int  offset = 0;
         	if( request.getAttribute("currentpage")!=null && request.getAttribute("numberOfCat")!=null && request.getAttribute("numberOfPage")!=null &&request.getAttribute("numberOfPage") !=null  ){
         		currentpage = (int) request.getAttribute("currentpage");
         		numberOfCat = (int) request.getAttribute("numberOfCat");
         		numberOfPage = (int) request.getAttribute("numberOfPage");
         		offset = (int)request.getAttribute("offset");
         	}
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
        		out.print("<p style='color:grenn;'>Thêm thành công</p>");
        	}
        	if("2".equals(msg)){
        		out.print("<p style='color:grenn;'>Sửa thành công</p>");
        	}
        	if("3".equals(msg)){
        		out.print("<p style='color:grenn;'>Xóa thành công</p>");
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
                                    <a href="<%=request.getContextPath()%>/admin/cat/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="<%=request.getContextPath()%>/admin/cat/search">
                                   
                                        <input type="submit" name="search" value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input name="name-search" type="search" class="form-control input-sm" placeholder="Nhập tên danh mục" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên danh mục</th>
                                        <th>Parent_ID</th>
                                        <th>Picture</th>                                        
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                	if(listCat!=null && listCat.size()>0){
                                		for(Category cat:listCat){                               	
                                %>
                                    <tr>
                                        <td><%=cat.getId() %></td>
                                        <td class="center"><%=cat.getName() %></td>
                                        <td class="center"><%=cat.getParent()%></td>  
                                        <td class="center">
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=cat.getPicture()%>" alt=""/>
                                        </td>                                      
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/cat/edit?id=<%=cat.getId()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath()%>/admin/cat/dell?id=<%=cat.getId()%>" onclick="return confirm('Bạn có chắc muốn xóa?') " title="" class="btn btn-danger"><i class="fa fa-pencil"></i> Xóa</a>
                                        </td>
                                    </tr>
                                    <%}}else{ %>
                                    <tr >
                                        <td class="center">Chưa có danh sách nào</td>
                                    </tr>
                                    <%} %>								
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=offset%> đến <%=offset+listCat.size()%> của <%=numberOfCat%> truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/cat?page=<%=currentpage-1%>">Trang trước</a></li>
                                            <%for(int i = 1; i<=numberOfPage;i++ ){%>
                                            <li class="paginate_button <%if(currentpage==i){out.print(" active ");} %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/cat?page=<%=i%>"><%=i%></a></li>	
                                            <%} %>							
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/cat?page=<%=currentpage+1%>">Trang tiếp</a></li>
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
    document.getElementById("category").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
 <%@page import="model.bean.Watch"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Quản lý Đồng hồ</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <%
         	ArrayList<Watch> listWatch = (ArrayList<Watch>) request.getAttribute("listWatch"); 
        	String err= request.getParameter("err");
         	String msg= request.getParameter("msg");
         	int currentpage =0 ;
         	int numberOfWatch =0 ;
         	int numberOfPage=0;
         	int  offset = 0;
         	if(request.getAttribute("currentpage")!=null){
       			currentpage = (int)request.getAttribute("currentpage");
       		}
       		if(request.getAttribute("numberOfPage")!=null){
       			numberOfPage = (int)request.getAttribute("numberOfPage");
       		}
       		if(request.getAttribute("numberOfWatch")!=null){
       			numberOfWatch = (int)request.getAttribute("numberOfWatch");
       		}
       		if(request.getAttribute("offset")!=null){
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
        		out.print("<p style='color:green;'>Thêm thành công</p>");
        	}
        	if("2".equals(msg)){
        		out.print("<p style='color:green;'>Sửa thành công</p>");
        	}
        	if("3".equals(msg)){
        		out.print("<p style='color:green;'>Xóa thành công</p>");
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
                                    <a href="<%=request.getContextPath()%>/admin/watch/add" class="btn btn-success btn-md">Thêm</a>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <form method="post" action="">
                                        <input type="submit"  value="Tìm kiếm" class="btn btn-warning btn-sm" style="float:right" />
                                        <input type="search" name="search" class="form-control input-sm" placeholder="Nhập vào tên/tính năng/chất liệu" style="float:right; width: 300px;" />
                                        <div style="clear:both"></div>
                                    </form><br />
                                </div>
                            </div>

                            <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>name</th>
                                        <th>Detail_text</th>
                                        <th>feature</th>
                                        <th>parameters</th>
                                        <th>picture</th>
                                        <th>sell</th>
                                        <th>sell_off</th>
                                        <th>cat_id</th>
                                         <th>number_vote</th>
                                        <th>result_vote</th>
                                        <th width="160px">Chức năng</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <%
                                if(listWatch!=null && listWatch.size()>0){
                                	for(Watch watch :listWatch){
                                %>
                                    <tr>
                                        <td><%=watch.getId()%></td>
                                        <td class="center"><%=watch.getName()%></td>
                                        <td class="center"><%=watch.getDetailtext()%></td>
                                        <td class="center"><%=watch.getFeature() %></td>
                                        <td class="center"><%=watch.getParameters()%></td>                                     
                                        <td class="center">
											<img width="200px" height="200px" src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>" alt="<%=watch.getName()%>"/>
                                        </td>
                                        <td class="center"><%=watch.getSell()%></td>
                                         <td class="center"><%=watch.getSelloff()%></td>
                                        <td class="center"><%=watch.getCatid()%></td>
                                        <td class="center"><%=watch.getNumbervote() %></td> 
                                        <td class="center"><%=watch.getResultvote()%></td>                                      
                                        <td class="center">
                                            <a href="<%=request.getContextPath()%>/admin/watch/edit?id=<%=watch.getId()%>" title="" class="btn btn-primary"><i class="fa fa-edit "></i> Sửa</a>
                                            <a href="<%=request.getContextPath()%>/admin/watch/del?id=<%=watch.getId()%>" title="" class="btn btn-danger" onclick="return confirm('Bạn có chắc muốn xóa ?')"><i class="fa fa-pencil"></i> Xóa</a>
                                       		
                                       		<a href="<%=request.getContextPath()%>/admin/picture/add?id=<%=watch.getId()%>" class="btn btn-success btn-md" style="margin:10px 0 ">Thêm ảnh</a>
                                        </td>
                                    </tr>
								<%}} %>
                                </tbody>
                            </table>
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="dataTables_info" id="dataTables-example_info" style="margin-top:27px">Hiển thị từ <%=offset %> đến <%=offset+listWatch.size() %> của <%=numberOfWatch %> truyện</div>
                                </div>
                                <div class="col-sm-6" style="text-align: right;">
                                    <div class="dataTables_paginate paging_simple_numbers" id="dataTables-example_paginate">
                                        <ul class="pagination">
                                            <li class="paginate_button previous " aria-controls="dataTables-example" tabindex="0" id="dataTables-example_previous"><a href="<%=request.getContextPath()%>/admin/watch?page=<%=currentpage-1%>">Trang trước</a></li>
                                            <%for(int i = 1; i<=numberOfPage;i++ ){%>
                                            <li class="paginate_button <%if(currentpage==i){out.print(" active ");} %>" aria-controls="dataTables-example" tabindex="0"><a href="<%=request.getContextPath()%>/admin/watch?page=<%=i%>"><%=i%></a></li>	
                                            <%} %>							
                                            <li class="paginate_button next" aria-controls="dataTables-example" tabindex="0" id="dataTables-example_next"><a href="<%=request.getContextPath()%>/admin/watch?page=<%=currentpage+1%>">Trang tiếp</a></li>
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
    document.getElementById("watchs").classList.add('active-menu');
</script>
<!-- /. PAGE INNER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
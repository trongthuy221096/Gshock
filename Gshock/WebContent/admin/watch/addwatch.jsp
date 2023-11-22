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
                <h2>Thêm Đồng hồ</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
             <%
         	ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat"); 
              String name = request.getParameter("name");
		 	  String detailtext = request.getParameter("detailtext");
		 	  String feature = request.getParameter("feature");
		 	  String parameters = request.getParameter("parameters");
		 	  String sell = request.getParameter("sell");
			  String selloff = request.getParameter("selloff");
			  String err= request.getParameter("err");
			  int catid=0;
	        	if(request.getParameter("category")!=null){
	        		catid = Integer.parseInt(request.getParameter("category"));
	        	}
	        	if("1".equals(err)){
	        		out.print("<p style='color:red;'>ID ko tồn tại</p>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<p style='color:red;'>ID ko tồn tại</p>");
	        	}
			 
        	
        %>
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form role="form" method="post" enctype="multipart/form-data" id="form">
                                    <div class="form-group">
                                        <label for="name">Tên Đồng hồ</label>
                                        <input type="text" id="name" value="<%if(name!=null){out.print(name);}%>" name="name" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="detailtext">Mô tả</label>
                                        <textarea id="detailtext" class="form-control" rows="3" name="detailtext"><%if(detailtext!=null){out.print(detailtext);}%></textarea>
                                    </div>
                                     <div class="form-group">
                                        <label for="feature">Tính năng</label>
                                        <textarea id="feature" class="form-control" rows="3" name="feature"><%if(feature!=null){out.print(feature);}%></textarea>
                                    </div>
                                     <div class="form-group">
                                        <label for="parameters">Thông số kỹ thuật</label>
                                        <textarea id="parameters" class="form-control" rows="3" name="parameters"><%if(parameters!=null){out.print(parameters);}%></textarea>
                                    </div>
                                     <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" />
                                    </div>
                                      <div class="form-group">
                                        <label for="sell">Giá bán</label>
                                        <input type="text" id="sell" value="<%if(sell!=null){out.print(sell);}%>" name="sell" class="form-control" />
                                    </div>
                                      <div class="form-group">
                                        <label for="selloff">Giá đang giảm</label>
                                        <input type="text" id="selloff" value="<%if(selloff!=null){out.print(selloff);}%>" name="selloff" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="category">Danh mục Đồng hồ</label>
                                        <select id="category" name="category" class="form-control">                    
	                                        <%if(listCat!=null && listCat.size()>0){ 
	                                        	for(Category cat :listCat){	                                        		
	                                        %>
	                                         <option value="<%=cat.getId()%> <%if(catid == cat.getId()){out.print(" selected ");}%>"><%=cat.getName()%></option>
	                                      <%}} %>
                                        </select>
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
				detailtext:{
					required:true,
				},
				feature:{
					required:true,
				},
				parameters:{
					required:true,
				},
				sell:{
					required:true,
					number:true,
				},	
				selloff:{
					required:true,
					number:true,
				},
				category:{
					required:true,
					number:true,
				},
			},
			messages:{
				name:{
					required:" (tên không dược trống)",
				},
				detailtext:{
					required:" (detailtext không dược trống)",
				},
				feature:{
					required:"(feature không dược trống)",
				},
				parameters:{
					required:"(parameters  không dược trống)",
				},
				sell:{
					required:"(sell  không dược trống)",
					number:"Mời nhập số",
				},
				selloff:{
					required:"(selloff  không dược trống)",
					number:"Mời nhập số",
				},
				category:{
					required:"(category  không dược trống)",
					number:"Mời nhập số",
				},
			},
		});
	});
</script>
<script>
    document.getElementById("watchs").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>Thêm danh mục</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <%
        	String err= request.getParameter("err");
        	if("1".equals(err)){
        		out.print("<p style='color:red;'>Bạn chưa nhập tên danh mục</p>");
        	}
        	if("2".equals(err)){
        		out.print("<p style='color:red;'>Có lỗi khi thêm</p>");
        	}
        	int id =0;
        	if(request.getParameter("id")!=null){
        	 id =Integer.parseInt( request.getParameter("id"));}
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
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" />
                                    </div>
                                    <div class="form-group">
                                        <label for="wid">watch-id</label>
                                        <input type="text" id="wid" value="<%=id %>" name="wid" class="form-control" />
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
				picture:{
					required:true,
				},
				wid:{
					required:true,
					number:true,
				},
			},
			messages:{
				picture:{
					required:"Mời Bạn nhập thông tin",
				},
				wid:{
					required:"Mời Bạn nhập thông tin",
					number:"Mời bạn nhập số",
				},
			},
		});
	});
</script>
<script>
    document.getElementById("category").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
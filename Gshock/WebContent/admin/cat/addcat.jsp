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
                                        <label for="name">Tên danh mục</label>
                                        <input type="text" id="name" value="" name="name" class="form-control" />
                                    </div>
                                    <div class="form-group">
                                        <label for="name">Parent</label>
                                        <input type="text" id="parent" value="" name="parent" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="picture">Hình ảnh</label>
                                        <input type="file" name="picture" />
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
				parent:{
					required:true,
					number:true,
				},
			},
			messages:{
				name:{
					required:"(tên không đc để trống)",
				},					
				parent:{
					required:"(parent không đc để trống)",
					number:"(Nhập đúng định dạng)",
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
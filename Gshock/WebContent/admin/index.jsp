<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/templates/admin/inc/header.jsp" %>
<%@ include file="/templates/admin/inc/leftbar.jsp" %>
<div id="page-wrapper">
    <div id="page-inner">
        <div class="row">
            <div class="col-md-12">
                <h2>TRANG QUẢN TRỊ VIÊN</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
        <%
        	int numberOfCat=0;
       		int numberOfWatch=0;
        	int numberOfUser=0;
        	if(request.getAttribute("numberOfCat")!=null){
        		numberOfCat = (int)request.getAttribute("numberOfCat");
        	}
        	if(request.getAttribute("numberOfWatch")!=null){
        		numberOfWatch = (int)request.getAttribute("numberOfWatch");
        	}
        	if(request.getAttribute("numberOfUser")!=null){
        		numberOfUser = (int)request.getAttribute("numberOfUser");
        	}
        %>
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-green set-icon">
                    <i class="fa fa-bars"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/cat" title="">Quản lý danh mục</a></p>
                        <p class="text-muted">Có <%=numberOfCat %> danh mục</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-blue set-icon">
                    <i class="fa fa-bell-o"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/watch" title="">Quản lý Watchs></p>
                        <p class="text-muted">Có <%=numberOfWatch %> Watchs</p>
                    </div>
                </div>
            </div>
            <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="panel panel-back noti-box">
                    <span class="icon-box bg-color-brown set-icon">
                    <i class="fa fa-rocket"></i>
                </span>
                    <div class="text-box">
                        <p class="main-text"><a href="<%=request.getContextPath()%>/admin/user" title="">Quản lý người dùng</a></p>
                        <p class="text-muted">Có <%=numberOfUser %> User</p>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
<script>
    document.getElementById("index").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
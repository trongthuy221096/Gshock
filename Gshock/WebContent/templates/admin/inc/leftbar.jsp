<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li class="text-center">
                <img src="<%=request.getContextPath()%>/templates/admin/assets/img/find_user.png" class="user-image img-responsive" />
            </li>
            <li>
                <a id="index" href="<%=request.getContextPath()%>/admin/index"><i class="fa fa-dashboard fa-3x"></i> Trang chủ</a>
            </li>
            <li>
                <a id="category" href="<%=request.getContextPath()%>/admin/cat"><i class="fa fa-list fa-3x"></i>Quản lý danh mục</a>
            </li>
            <li>
                <a id="watchs" href="<%=request.getContextPath()%>/admin/watch"><i class="fa fa-music fa-3x"></i> Quản lý Watchs</a>
            </li>
            <li>
                <a id="user" href="<%=request.getContextPath()%>/admin/user"><i class="fa fa-user fa-3x"></i> Quản lý người dùng</a>
            </li>
            <li>
                <a id="contact" href="<%=request.getContextPath()%>/admin/contact"><i class="fa fa-envelope fa-3x"></i> Quản lý liên hệ</a>
            </li>
             <li>
                <a id="review" href="<%=request.getContextPath()%>/admin/review"><i class="fa fa-music fa-3x"></i> Quản lý Đánh giá</a>
            </li>
             <li>
                <a id="payment" href="<%=request.getContextPath()%>/admin/payment"><i class="fa fa-list fa-3x"></i></i>Quản lý Payment</a>
            </li>
             <li>
                <a id="picture" href="<%=request.getContextPath()%>/admin/picture"><i class="fa fa-user fa-3x"></i>Quản lý PictureList</a>
            </li>
             <li>
                <a id="oderitem" href="<%=request.getContextPath()%>/admin/oderitem"><i class="fa fa-envelope fa-3x"></i>Quản lý OderItem</a>
            </li>
             <li>
                <a id="oder" href="<%=request.getContextPath()%>/admin/oder"><i class="fa fa-dashboard fa-3x"></i>Quản lý ShopOder</a>
            </li>
        </ul>
    </div>
</nav>
<!-- /. NAV SIDE  -->
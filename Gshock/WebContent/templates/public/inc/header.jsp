<%@page import="util.StringUtil"%>
<%@page import="model.bean.User"%>
<%@page import="model.dao.CatDAO"%>
<%@page import="model.bean.Category"%>
<%@page import="model.dao.OderitemDAO"%>
<%@page import="model.bean.Oderitem"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.2/css/all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/templates/public/css/style.css">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js" integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"crossorigin="anonymous"></script>             
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"crossorigin="anonymous"></script>         
    <script src="<%=request.getContextPath()%>/templates/admin/assets/js/jquery-3.2.1.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.5/jquery.validate.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/ckeditor/4.19.1/ckeditor.js"></script>
    <title>Gshock</title>
</head>

<body>
    <header >
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-light">
                <a class="navbar-brand" href="#"><img class="img-fluid img-logo "
                        src="<%=request.getContextPath()%>/templates/public/images/LOGO-GWACH-e1638010196607-1.png" alt="logo"></a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                    <img class="img_1" src="<%=request.getContextPath()%>/templates/public/images/menu-icon.png" alt="Menu Icon">
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/trang-chu">Trang chủ</a>
                        </li>
                        <li class="nav-item  sub-test" >
                            <a class="nav-link" href="<%=request.getContextPath()%>/cua-hang">Sản Phẩm&nbsp;<iclass="fa-solid fa-angle-down icon-down"></iclass=></a> 
                            <div class=" mask-header">
                                <div class="list-header container">
                                <%
                                	CatDAO catDAO = new CatDAO();
                                	ArrayList<Category> listCatitem = (ArrayList<Category>)catDAO.getItems();
                                	if(listCatitem!=null){
                                		for(Category category :listCatitem){
                                %>
                                    <div class="item item_1">                         
                                        <div >&nbsp;<a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(category.getName())%>-<%=category.getId()%>" class="title-cl"><%=category.getName()%></a></div>
                                    </div>
                               <%}} %>                        
                                </div>
                            </div>                                       
                        </li>
                        <li class="nav-item ">
                            <a class="nav-link" href="<%=request.getContextPath()%>/tin-tuc">Tin Tức</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<%=request.getContextPath()%>/lien-he">Liên Hệ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="">Giới Thiệu</a>
                        </li>

                    </ul>
                       <p style="margin-bottom:0;">
						  <button class="btn btn-search" type="button" data-bs-toggle="collapse" data-bs-target="#search" aria-expanded="false" aria-controls="search" style="border:hover :none;">
							 <img src="<%=request.getContextPath()%>/templates/public/images/search.png" alt="" style="width: 25px; ">
						  </button>
						</p>
						<div class="collapse" id="search">
						  <div class="card card-body " style="position: absolute;top:60px;right:0;left:0; background: #f8f8f8;border:none; z-index:1">
							<form id="form-search" action="<%=request.getContextPath()%>/cua-hang/tim-kiem" method="post">
							  <div class="">
							    <input style="width:50%;margin:0 auto" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="search" placeholder="Tên/Mã sản phẩm/Chức năng" name="search">
							  </div>
							</form>
						  </div>
						</div>
                   
                    <div>
                     
                      
                        <%
					              User userlogin = (User)session.getAttribute("userLogin") ; 			  	
								  if(userlogin!=null){				  		  
					            %>
					             <a href="<%= request.getContextPath()%>/logout"><img src="<%=request.getContextPath()%>/templates/public/images/gio-hang.png" alt="" style="width: 17px;" ></a>                 
					       		<%}else{ %>
					       		  <a href="<%= request.getContextPath()%>/dang-nhap"><img src="<%=request.getContextPath()%>/templates/public/images/gio-hang.png" alt="" style="width: 17px;" ></a>                 
					       		<%} %>
                        <a style="padding: 0 !important;" href="<%=request.getContextPath()%>/thanh-toan"><img src="<%=request.getContextPath()%>/templates/public/images/cart.png" alt=""style="width: 25px;">
                       	    
                       	 <span class="position-absolute  start-100 translate-middle badge rounded-pill bg-danger" id ="ajax-oderitem">
						   <%
						   		
						   		int result=0;		
						  		OderitemDAO oderitemDAO = new OderitemDAO(); 
								ArrayList<Oderitem> listOderitem = (ArrayList<Oderitem>)session.getAttribute("listOderitem");														   		
						   		if(listOderitem!=null){
						   			for(Oderitem oderitem:listOderitem){
						   				result = result+oderitem.getQualiti();
						   			}
						   		}
						   		out.print(result);
						   %>
						    
						    <span class="visually-hidden">unread messages</span>
						  </span>
                        </a>
                    </div>                
                </div>
            </nav>
        </div>
 
    </header>
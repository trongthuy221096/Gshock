 <%@page import="java.io.PrintWriter"%>
<%@page import="model.bean.Watch"%>
<%@page import="model.bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/templates/public/inc/header.jsp" %>   
	
	<%
		ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat");
		ArrayList<Watch> listWatch = (ArrayList<Watch>) request.getAttribute("listWatch"); 
		String err= request.getParameter("err");
	 	String msg= request.getParameter("msg");
	 	int catid = 0;
	 	int currentpage =0 ;
	 	int numberOfWatch =0 ;
	 	int numberOfPage=0;
	 	int  offset = 0;
	 	int search1 = 0;
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
			if(request.getParameter("search1")!=null){
				search1= Integer.parseInt(request.getParameter("search1"));
			}
			if(request.getParameter("catid")!=null){
				catid= Integer.parseInt(request.getParameter("catid"));
			}
			
	%>
	
    <div id="content">
        <div class="container">
            <div class="breadcum text-center">
                <a href="" style="font-size: 15px;color:#000000">Trang chủ</a> »
                <span style="font-size: 15px;color:#000000">   <%
            	if(listCat!=null && listCat.size()>0){
            		for(Category cat:listCat){
            			if(cat.getId()==catid){
            				out.print(cat.getName());
            			} 
            		}
            		if(catid==0){
        				out.print("Cửa Hàng");
        			}
            		}
            %></span>
            </div>
            <h2 class="content-header" style="font-size:30px">
            <%
            	if(listCat!=null && listCat.size()>0){
            		for(Category cat:listCat){
            			if(cat.getId()==catid){
            				out.print(cat.getName());
            			} 
            		}
            		if(catid==0){
        				out.print("Cửa Hàng");
        			}
            		}
            %>
            
            
            </h2>
            <div class="category row">            	
            <%
            	if(listCat!=null && listCat.size()>0){
            		for(Category cat:listCat){
            %>
            <div class="col-lg-2 col-sm-2 col-md-2 pd-0">
               <a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(cat.getName())%>-<%=cat.getId()%>">             		 
                    <img class="rounded mx-auto d-block img-fluid" style="max-width:36px"
                        src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=cat.getPicture()%>"
                        alt="">
                    <div class="type"><%=cat.getName() %></div>
                    <p class="text-center" style="font-size:13px ;">+100 sản phẩm</p>               
               </a>
                </div>
             <%}} %>   
            </div>
            	<h2 class="content-header" style="font-size:30px; margin-top:20px">
            	<%
            		if(search1==1){out.print("Sản phẩm mới nhất");}
            		if(search1==2){out.print("Đánh giá Cao");}
            		if(search1==3){out.print("Giá : thấp -> cao");}
            		if(search1==4){out.print("Giá : cao -> thấp");}            	           	
            	%></h2>
            <div class="d-flex cat-menu">             
                  <div class="dropdown p-2 w-100">
					  <a class="btn btn-secondary dropdown-toggle" style="border:none" href="#" onclick="return getList()" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					    Danh mục
					  </a>				
					  <ul class="dropdown-menu" id="getList">
						
					  </ul>
				</div>
                <div class="dropdown p-2 flex-shrink-1">
					  <a class="btn btn-secondary dropdown-toggle" style="border:none" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
					    Tìm theo
					  </a>				
					  <ul class="dropdown-menu">
					    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/cua-hang/tim-kiem/1">Sản phẩm mới</a></li>
					    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/cua-hang/tim-kiem/2">Đánh giá cao</a></li>
					    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/cua-hang/tim-kiem/3">Giá : thấp -> cao</a></li>
					    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/cua-hang/tim-kiem/4">Giá : cao -> thấp</a></li>
					  </ul>
				</div>
            </div>
            <div class="list-cat">
                <div class="row">
                	<%
                		if(listWatch!=null && listWatch.size()>0){
                			for(Watch watch:listWatch){
                				int giamphantram = 100-((watch.getSelloff()*100)/watch.getSell());
                	%>
                 	 <div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
                                    <div class="tab-item watch">
                            <a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName()) %>-<%=watch.getId()%>.html" class=""><img class="rounded mx-auto d-block img-fluid" style="max-height:268px"
                                    src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>" alt="ảnh" class="img-text"  ></a>
                            <a href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName()) %>-<%=watch.getId()%>.html" class="tab-xemnhanh"><img src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png" alt="ảnh"
                                    class="img-xemnhanh"></a>
                            <a href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"  class="tab-muangay"><img src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png" alt="ảnh"
                              class="img-xemnhanh"></a>
                            <p class="sale-off"><img src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png" alt="ảnh" class=""> Giảm
                                <%=String.format("%,.0f", (double)watch.getSell()-watch.getSelloff() )%><span class="bdbt"> đ<span></p>
                            <p class="item-title" ><a  href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName()) %>-<%=watch.getId()%>.html"><%=watch.getName()%></a></p>
                            <div class="section-text text-center">
                                <p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double)watch.getSelloff())%><span
                                        class="bdbt color"> đ<span></p>
                                <p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double)watch.getSell())%><span
                                        class="bdbt color"> đ<span></p>
                                <span class="vntp_sale">-<%=giamphantram%>%</span>
                            </div>
                            
                        </div> 
                                </div> 
                						
                  <% }}else{%>  
                  	<h3>Chưa có danh sách nào</h3>  
                  <%} %>                
                </div>
              	
            </div>
            <div class="d-flex justify-content-center">
                <nav aria-label="Page navigation example">
                    <ul class="pagination ">
                    	<%if(numberOfPage>0){ %>
                        <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cua-hang/<%=currentpage-1%>"><i class="fa-solid fa-angle-left"></i></a>
                        </li>
                        <%for(int i = 1; i<=numberOfPage;i++ ){%>
                        <li class="page-item <%if(currentpage==i){out.print(" active ");} %>"><a class="page-link" href="<%=request.getContextPath()%>/cua-hang/<%=i%>"><%=i%></a></li>
              
                        <%} %>	
                        <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/cua-hang/<%=currentpage+1%>"><i class="fa-solid fa-angle-right"></i></a>                        	
                        </li>
                        <%} %>
                    </ul>
                </nav>
            </div>
            <div class="section-item ">
                <div class="text">
                    <h2 class="content-header">BỘ SƯU TẬP</h2>
                    <p class="sub-header"></p>
                </div>
                <div id="carouselExampleDark2" class="carousel carousel-dark slide " data-bs-ride="carousel"
                    data-bs-ride="true">
                    <div class="carousel-indicators" style="bottom: -40px;">
                        <button type="button" data-bs-target="#carouselExampleDark2" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide"></button>
                        <button type="button" data-bs-target="#carouselExampleDark2" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>

                    </div>

                    <div class="carousel-inner">
                        <div class="carousel-item active " data-bs-interval="10000">
                            <div class="row ">
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/Picture12-370x250xc.png" alt="ảnh" class="img-text"></a>
                                        <a href="">G-Shock<span>-></span></a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/home_EQB-1000-1-370x250xc.jpeg" alt="ảnh"
                                                class="img-text"></a>
                                        <a href="">Edifice<span>-></span></a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/gshock-baby-g-370x250xc.jpeg" alt="ảnh"
                                                class="img-text"></a>
                                        <a href="">Baby-G<span>-></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="carousel-item  " data-bs-interval="10000">
                            <div class="row ">
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/Picture12-370x250xc.png" alt="ảnh" class="img-text"></a>
                                        <a href="">G-Shock<span>-></span></a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/home_EQB-1000-1-370x250xc.jpeg" alt="ảnh"
                                                class="img-text"></a>
                                        <a href="">Edifice<span>-></span></a>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-sm-4 col-md-4 ">
                                    <div class=" ">
                                        <a href="#" class=""><img style="padding:10px 0;"
                                                class="rounded mx-auto d-block img-fluid"
                                                src="<%=request.getContextPath()%>/templates/public/images/gshock-baby-g-370x250xc.jpeg" alt="ảnh"
                                                class="img-text"></a>
                                        <a href="">Baby-G<span>-></span></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="prev" style="display: none;">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                        data-bs-slide="next" style="display: none;">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
			
        </div>

        <div class="container-fluid" style="background: #fcf9f4;">
            <div class="content-section ">
                <div class="section-item ">
                    <div class="text">
                        <h2 class="content-header">Khác hàng của chúng tôi</h2>
                        <p class="sub-header"></p>
                    </div>

                    <div id="carouselExampleDark" class="carousel carousel-dark slide " data-bs-ride="carousel"
                        data-bs-ride="true">
                        <div class="carousel-indicators" style="bottom: -40px;">
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0"
                                class="active" aria-current="true" aria-label="Slide"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1"
                                aria-label="Slide 2"></button>
                            <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2"
                                aria-label="Slide 3"></button>
                        </div>

                        <div class="carousel-inner">
                            <div class="carousel-item active " data-bs-interval="10000">
                                <div class="row ">
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>                          
                                </div>

                            </div>

                            <div class="carousel-item" data-bs-interval="2000">
                                 <div class="row ">
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>                          
                                </div>
                            </div>
                            <div class="carousel-item">
                                <div class="row ">
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>
                                    <div class="col-lg-2-5 col-sm-2-5 col-md-2-5 ">
                                        <div class="tab-item ">
                                            <a href="#" class=""><img class="rounded mx-auto d-block img-fluid"
                                                    src="<%=request.getContextPath()%>/templates/public/images/eddc4f45d7b618e841a7-370x210xc.jpg" alt="ảnh"
                                                    class="img-text"></a>                                         
                                            <p class="item-title " style="font-weight: 700;">Sự hài lòng của quý khách hàng</p>
                                            <p class="item-title">Giá cả phải chăng tư vấn tận tâm</p>
                                        </div>
                                    </div>                          
                                </div>
                            </div>
                        </div>
                        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark"
                            data-bs-slide="prev" style="display: none;">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Previous</span>
                        </button>
                        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark"
                            data-bs-slide="next" style="display: none;">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="visually-hidden">Next</span>
                        </button>
                    </div>

                </div>
            </div>
        </div>

    </div>
     <script type="text/javascript">                     	
						 	function getList() {						 		
								$.ajax({
									url: '<%=request.getContextPath()%>/public/getList',
									type: 'POST',
									cache: false,
									data: {
										 
										},
									success: function(data){
										$("#getList").html(data);
									},
									error: function (){
										alert('Có lỗi xảy ra');
									}
								});
								return false;
							}
						 	
		</script>

  <%@include file="/templates/public/inc/footer.jsp" %>   
</body>

</html>
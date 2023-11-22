<%@page import="model.bean.Oderitem"%>
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
                <h2>Sửa Oder</h2>
            </div>
        </div>
        <!-- /. ROW  -->
        <hr />
                 <%
         		ArrayList<Category> listCat = (ArrayList<Category>) request.getAttribute("listCat"); 
                String name = request.getParameter("name");
		 	    String quality = request.getParameter("quality");
		 	    String sell = request.getParameter("sell");
		 	    String amount = request.getParameter("amount");
		 	    String wid = request.getParameter("wid");
			    String userid = request.getParameter("userid");
			    String oderid = request.getParameter("oderid");
			    String err= request.getParameter("err");
			    int catid=0;
	        	if(request.getParameter("category")!=null){
	        		catid = Integer.parseInt(request.getParameter("category"));
	        	}
	        	Oderitem oderitem = (Oderitem) request.getAttribute("oderitem");
	        	if(oderitem!=null){
	        		 name = oderitem.getName();
	 		 	     quality = Integer.toString(oderitem.getQualiti());
	 		 	     sell = Integer.toString(oderitem.getSell());
	 		 	     amount = Integer.toString(oderitem.getAmount());
	 		 	     wid = Integer.toString(oderitem.getWid());
	 			     userid = Integer.toString(oderitem.getUserid());
	 			     oderid = Integer.toString(oderitem.getOderid());
	        	}
	        	
	        	if("1".equals(err)){
	        		out.print("<p style='color:red;'>ID ko tồn tại</p>");
	        	}
	        	if("2".equals(err)){
	        		out.print("<p style='color:red;'>Có lỗi khi sửa</p>");
	        	}
        	
        %>
        <div class="row">
            <div class="col-md-12">
                <!-- Form Elements -->
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form action="" method="post" id="form">
                                    <div class="form-group">
                                        <label for="name">WName</label>
                                        <input type="text" id="name" value="<%if(name!=null){out.print(name);}%>" name="name" class="form-control" />
                                    </div>
                                      <div class="form-group">
                                        <label for="quality">Quality</label>
                                        <input type="text" id="quality" value="<%if(quality!=null){out.print(quality);}%>" name="quality" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="sell">Sell</label>
                                        <input type="text" id="sell" value="<%if(sell!=null){out.print(sell);}%>" name="sell" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="amount">Amount</label>
                                        <input type="text" id="amount" value="<%if(amount!=null){out.print(amount);}%>" name="amount" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="wid">Wid</label>
                                        <input type="text" id="wid" value="<%if(wid!=null){out.print(wid);}%>" name="wid" class="form-control" />
                                    </div>
                                     <div class="form-group">
                                        <label for="userid">Userid</label>
                                        <input type="text" id="userid" value="<%if(userid!=null){out.print(userid);}%>" name="userid" class="form-control" />
                                    </div>
                                       <div class="form-group">
                                        <label for="oderid">Oder_id</label>
                                        <input type="text" id="oderid" value="<%if(oderid!=null){out.print(oderid);}%>" name="oderid" class="form-control" />
                                    </div>                                   
                                    <button type="submit" name="submit" class="btn btn-success btn-md">Sửa</button>
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
				quality:{
					required:true,
					number:true,
				},
				sell:{
					required:true,
					number:true,
				},
				amount:{
					required:true,
					number:true,
				},
				wid:{
					required:true,
					number:true,
				},
				userid:{
					required:true,
					number:true,
				},
				oderid:{
					required:true,
					number:true,
				},
			},
			messages:{
				name:{
					required:"Bạn chưa nhập",
				},					
				quality:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
				sell:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
				amount:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
				wid:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
				userid:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
				oderid:{
					required:"Bạn chưa nhập",
					number:"Nhập số",
				},
			},
		});
	});
</script>
<script>
    document.getElementById("oderitem").classList.add('active-menu');
</script>
<!-- /. PAGE WRAPPER  -->
<%@ include file="/templates/admin/inc/footer.jsp" %>
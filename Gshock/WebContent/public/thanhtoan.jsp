 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@include file="/templates/public/inc/header.jsp" %>   
    <div id="content">    
 
        <div class="container">
            <div class="breadcum text-center">
                <a href="" style="font-size: 15px;color:#000000">Trang chủ</a> »
                <span style="font-size: 15px;color:#000000">Thanh toán</span>
            </div>
            <h1 class="" style="font-size: 30px; line-height: 36px;font-weight: 600;">Thanh toán</h1>

            <div class="checkout-code" style="margin-bottom: 20px;">
                Bạn có mã ưu đãi?
                <a class="" data-bs-toggle="collapse" href="#collapseExample2" role="button" aria-expanded="false"
                    aria-controls="collapseExample2">Ấn vào đây để nhập mã</a>
                <div class="collapse" id="collapseExample2">
                    <div class="card card-body">
                        <form>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Nếu bạn có mã giảm giá, vui lòng điền
                                    vào phía bên dưới.</label>
                            </div>
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="Mã ưu đãi"
                                    aria-label="Recipient's username" aria-describedby="button-addon2">
                                <button class="btn btn-success" type="button" id="button-addon2">Gửi mã</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
			<%
			String lastname = request.getParameter("lastname");
			String firstname = request.getParameter("firstname");
			String email = request.getParameter("email");
			String city = request.getParameter("city");
			String district = request.getParameter("district");
			String ward = request.getParameter("ward");
			String adress = request.getParameter("adress");
			String numberphone = request.getParameter("numberphone");
			
			%>
            <div class="customer-detail">
            	<form id="form-pay" action="" method="post">
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-md-6 ">
                        <div style="margin: 10px 0;"><p class="news-title">Thông tin thanh toán</p></div>
                          <%
						       String msg= request.getParameter("msg");
                         		 String err= request.getParameter("err");
		                          if("1".equals(msg)){
		                      		out.print("<h3 style='color:green;'>Đặt hàng thành công</h3>");
		                      	} if("1".equals(err)){
		                      		out.print("<h3 style='color:red;'>Bạn chưa nhập thông tin hoặc chưa chọn phương thức thanh toán</h3>");
		                      	}
						       %>
                        <div>
                            <div  class="row g-3">
                                <div class="col pd-tb20">
                                    <label for="lastname" class="form-label">Tên *</label>
                                    <input type="text" name="lastname" value="<%if(lastname!=null){out.print(lastname);}%>" class="form-control" placeholder="Tên" aria-label="lastname">
                                </div>
                                <div class="col pd-tb20">
                                    <label for="firstname" class="form-label">Họ</label>
                                    <input type="text" name="firstname" value="<%if(firstname!=null){out.print(firstname);}%>" class="form-control" placeholder="First name" aria-label="First name">
                                </div>                                    
                            </div>
                            <div  class="row g-3">
                                <div class="col pd-tb20">
                                    <label for="numberphone" class="form-label">Số điện thoại *</label>
                                    <input type="text" name="numberphone" value="<%if(numberphone!=null){out.print(numberphone);}%>" class="form-control" placeholder="Số điện thoại " aria-label="numberphone">
                                </div>
                                <div class="col pd-tb20">
                                    <label for="email" class="form-label">Địa chỉ email *</label>
                                    <input type="text" name="email" value="<%if(email!=null){out.print(email);}%>" class="form-control" placeholder="Địa chỉ email " aria-label="email">
                                </div>                                    
                            </div>
                            <div  class="row g-3">                            
                                <div class="col pd-tb20">
                                    <label for="city" class="form-label">Tỉnh/Thành phố *</label>
                                    <input type="text" name="city" value="<%if(city!=null){out.print(city);}%>" class="form-control" placeholder="Tỉnh/Thành phố " aria-label="city">
                                </div>
                                <div class="col pd-tb20">
                                    <label for="district" class="form-label">Quận/Huyện *</label>
                                    <input type="text" name="district" value="<%if(district!=null){out.print(district);}%>" class="form-control" placeholder="Quận/Huyện " aria-label="district">
                                </div>                                       
                            </div>
                            <div  class="row g-3">                            
                                <div class="col pd-tb20">
                                    <label for="ward" class="form-label">Xã/Phường *</label>
                                    <input type="text" name="ward" value="<%if(ward!=null){out.print(ward);}%>" class="form-control" placeholder="Xã/Phường " aria-label="ward">
                                </div>
                                <div class="col pd-tb20">
                                    <label for="adress" class="form-label">Địa chỉ *</label>
                                    <input type="text" name="adress" value="<%if(adress!=null){out.print(adress);}%>" class="form-control" placeholder="Địa chỉ " aria-label="adress">
                                </div>                                       
                            </div>                                                        
                            
                         </div>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-md-6 ">
                        <div style="margin: 10px 0;"><p class="news-title">Thông tin bổ sung</p></div>
                        
                            <div class="mb-3 pd-tb20">
                                <label for="exampleFormControlTextarea1" class="form-label">Ghi chú đơn hàng (tuỳ chọn)</label>
                                <textarea name="text" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                              </div>
                       
                    </div>
                    <div>
                        <table class="table table-hover border" >
                            <thead>
                              <tr>
                                <th scope="col">Sản phẩm</th>
                                <th scope="col"></th>
                                <th scope="col">Tạm tính</th>
                                <th scope="col"></th>
                              </tr>
                            </thead>
                             <%						   								
						   		if(listOderitem!=null && listOderitem.size()>0){
						   			int sum=0;
						   			for(Oderitem oderitem:listOderitem){
						   				sum +=(oderitem.getSell()*oderitem.getQualiti()) ;
						   %>
                            <tbody>
                              <tr>
                                <th scope="row"><%=oderitem.getName()%>  × <%=oderitem.getQualiti()%></th>
                                <td style="width:5%;">
                                <a href="<%=request.getContextPath()%>/xoa/san-pham/<%=oderitem.getWid()%>" style=""><i class="fa-solid fa-minus"></i></a>
                                <a href="<%=request.getContextPath()%>/them/san-pham/<%=oderitem.getWid()%>" style=""><i class="fa-solid fa-plus"></i></a>
                                </td>
                                <td style="width:15%"><%=String.format("%,.0f", (double)oderitem.getSell()*oderitem.getQualiti())%> ₫                              	
                                </td>
                                <td style="width:5%"><a href="<%=request.getContextPath()%>/public/oderitem/del?wid=<%=oderitem.getWid()%>"><i class="fa-solid fa-trash-can"></i></a></td>
                              </tr>
                              <%} %>
                              <tr>
                                <th scope="row">Tổng</th>
                                <td> </td>                             
                                <td style="width:15%" colspan="2"><%=String.format("%,.0f", (double)sum)%> ₫</td>    
                                 <td> </td>                            
                              </tr>
                              <%}else{ %>
                               <tr>
                                <th scope="row">Chưa có danh sách nào</th>
                               
                              </tr>
                              <%} %>
                            </tbody>
                            
                          </table>
                    </div>
                  <div style="margin: 40px 0; ">
                    <div class="payment">                
                        <p style="padding: 10px 10px 0 10px;">
                            <input class="" type="checkbox" data-bs-toggle="collapse" data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample" name="payment" value="1">
                            PayPal
                            </input>
                        </p >
                          <div class="collapse" id="collapseExample" style="padding: 10px 10px 0 10px;">
                            <div class="card card-body box-payment" >
								  <div class="mb-3">
								    <label for="NumberCar" class="form-label">NumberCar</label>
								    <input type="text" name="numbercard" class="form-control" id="NumberCar" aria-describedby="emailHelp">
								  </div>
								  <div class="mb-3">
								    <label for="exampleInputPassword1" class="form-label">Password</label>
								    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
								  </div>
                            </div>                           	
                          </div>
                          <p style="padding: 10px 10px 0 10px;">
                            <input class="" type="checkbox" data-bs-toggle="collapse" data-bs-target="#collapseExample1" aria-expanded="false" aria-controls="collapseExample"name="payment" value="2">
                            Thanh Toán tiền mặt
                            </input>
                        </p>
                          <div class="collapse" id="collapseExample1" style="padding: 10px 10px 10px 10px;">
                            <div class="card card-body box-payment">
                                Trả tiền mặt khi giao hàng
                            </div>
                          </div> 
                          <hr>
                          <div class="" style="padding-bottom: 20px; " >
                            <button type="submit" class="btn-dathang" >Đặt hàng</button>
                          </div>
                    </div>
                  </div>
                </div>
                </form>
            </div>

        </div>

    </div>
    <script>
$().ready(function(){
		var validator = $("#form-pay").validate({			
			rules:{
				lastname:{
					required:true,
				},
				firstname:{
					required:true,
				},	
				email:{
					required:true,
				},	
				city:{
					required:true,
				},	
				district:{
					required:true,
				},	
				ward:{
					required:true,
				},	
				adress:{
					required:true,
				},	
				numberphone:{
					required:true,
					number:true,
				},
				numbercard:{
					required:true,
					number:true,
				},
				password:{
					required:true,
				},
			},
			messages:{
				lastname:{
					required:"( không đc để trống)",
				},
				firstname:{
					required:"( không đc để trống)",
				},	
				email:{
					required:"( không đc để trống)",
				},	
				city:{
					required:"( không đc để trống)",
				},	
				district:{
					required:"( không đc để trống)",
				},	
				ward:{
					required:"( không đc để trống)",
				},	
				adress:{
					required:"( không đc để trống)",
				},	
				numberphone:{
					required:"( không đc để trống)",
					number:"(Nhập đúng định dạng)",
				},
				numbercard:{
					required:"( không đc để trống)",
					number:"(Nhập đúng định dạng)",
				},
				password:{
					required:"( không đc để trống)",
				},
			},
		});
	});
</script>
<style>

.error{
color:red;
}
</style>
  <%@include file="/templates/public/inc/footer.jsp" %>   

</body>

</html>
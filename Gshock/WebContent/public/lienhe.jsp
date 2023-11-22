 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@include file="/templates/public/inc/header.jsp" %>   

    <div id="content">
        <div class="container">
            <div class="breadcum text-center">
                <a href="" style="font-size: 15px;color:#000000">Trang chủ</a> »
                <span style="font-size: 15px;color:#000000">Liên hệ</span>
            </div>
            <h2 class="content-header" style="font-size:30px">Bản đồ cửa hàng</h2>
            <div id="map">
                <iframe
                    src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3919.2720661800795!2d106.64013325070164!3d10.79046229227429!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31752eb29326f203%3A0x94bce30297a79dfa!2zNTIgQsOgdSBDw6F0IDYsIFBoxrDhu51uZyAxMywgVMOibiBCw6xuaCwgVGjDoG5oIHBo4buRIEjhu5MgQ2jDrSBNaW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1659875841827!5m2!1svi!2s"
                    width="100%" height="450" style="border:0;" allowfullscreen="" loading="lazy"
                    referrerpolicy="no-referrer-when-downgrade"></iframe>
            </div>
            <div class="contact" style="padding: 30px 0;">
                <h2 class="content-header" style="font-size:30px">Liên hệ với chúng tôi</h2>
                 <%
		        	String err= request.getParameter("err");
                 	String msg= request.getParameter("msg");
                 	if("1".equals(msg)){
		        		out.print("<p style='color:red;'>Gửi liên hệ thành công</p>");
		        	}
		        	if("1".equals(err)){
		        		out.print("<p style='color:red;'>Bạn chưa nhập tên danh mục</p>");
		        	}
		        	if("2".equals(err)){
		        		out.print("<p style='color:red;'>Có lỗi khi thêm</p>");
		        	}
		        %>
                <div class="row">
                    <div class="col-lg-6 col-sm-6 col-md-6 ">
                        <h3 style="font-size: 17.55px;font-weight:bold;">THÔNG TIN LIÊN HỆ</h3>
                        <p style="font-size: 15px; color: #000000;">Bạn hãy điền nội dung tin nhắn vào form dưới đây và gửi cho chúng tôi. Chúng tôi sẽ trả lời
                            bạn sau khi nhận được.</p>
                        <form action="<%=request.getContextPath()%>/admin/contact/add" id="form">
                            <div class="mb-3">
                                <label for="name" class="form-label">Họ và tên</label>
                                <input name="name" type="text" class="form-control" id="name"aria-describedby="name">                                                       
                            </div>
                            <div class="mb-3">
                                <label for="numberphone" class="form-label">Số điện thoại</label>
                                <input name="numberphone" type="text" class="form-control" id="numberphone"aria-describedby="numberphone">                                                       
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" class="form-label">Email </label>
                                <input name="email" type="email" class="form-control" id="exampleInputEmail1"aria-describedby="emailHelp">                                                       
                            </div>
                            <div class="mb-3">
                                <label for="detailtext" class="form-label">Nội dung liên hệ</label>
                                <textarea name="detailtext" class="form-control" id="detailtext" rows="3"></textarea>
                              </div>                                               
                            <button type="submit" class="btn btn-primary" style="background-color: #333333;border: none;">Gửi liên hệ</button>
                        </form>
                    </div>
                    <div class="col-lg-6 col-sm-6 col-md-6 ">
                        <h3 style="font-size: 17.55px;font-weight:bold; padding: 20px 0;">Cửa hàng đồng hồ</h3>
                        <div class="row" style="margin-top:30px;margin-bottom:30px;">
                            <div class="col-lg-1 col-sm-1 col-md-1 ">
                                <span class="icon"><i class="fa-solid fa-location-dot"
                                        style="width:24px !important"></i></span>
                            </div>
                            <div class="col-lg-11 col-sm-11 col-md-11 ">
                                <p class="ft-des">156 Nguyễn Hồng Đào, Phường 14, Quận Tân Bình - HCM</p>
                            </div>
                        </div>
                        <div class="row" style="margin-top:30px;margin-bottom:30px;">
                            <div class="col-lg-1 col-sm-1 col-md-1 ">
                                <span class="icon"><i class="fa-solid fa-phone"></i></span>
                            </div>
                            <div class="col-lg-11 col-sm-11 col-md-11 ">
                                <p style="color:#EE1A26;font-size:24px;font-weight:700;">0907862323</p>
                            </div>
                        </div>
                        <div class="row" style="margin-top:30px;margin-bottom:30px;">
                            <div class="col-lg-1 col-sm-1 col-md-1 ">
                                <span class="icon"><i class="fa-solid fa-envelopes-bulk" style="width: 24px;"></i></span>
                            </div>
                            <div class="col-lg-11 col-sm-11 col-md-11 ">
                                <p class="ft-des">info@gshockvn.net</p>
                            </div>
                        </div>
                        <div class="row" style="margin-top:30px;margin-bottom:30px;">
                            <div class="col-lg-1 col-sm-1 col-md-1 ">
                                <span class="icon"><i class="fa-solid fa-globe"></i></span>
                            </div>
                            <div class="col-lg-11 col-sm-11 col-md-11 ">
                                <p class="ft-des">www.gshockvn.net</p>
                            </div>
                        </div>
                        <div class="row" style="margin-top:30px;margin-bottom:30px;">
                            <div class="col-lg-1 col-sm-1 col-md-1 ">
                                <span class="icon"><i class="fa-solid fa-clock"></i></span>
                            </div>
                            <div class="col-lg-11 col-sm-11 col-md-11 ">
                                <p class="ft-des">Giờ làm việc: Từ 9:00 đến 22:00 các ngày trong tuần từ Thứ 2 đến Chủ
                                    nhật</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
$().ready(function(){
		var validator = $("#form").validate({			
			rules:{
				name:{
					required:true,
				},
				numberphone:{
					required:true,
				},
				email:{
					required:true,
				},
				detailtext:{
					required:true,
				},
			},
			messages:{
				name:{
					required:" ( không dược trống)",
				},
				numberphone:{
					required:" ( không dược trống)",
				},
				email:{
					required:"(không dược trống)",
				},
				email:{
					required:"(không dược trống)",
				},				
			},
		});
	});
</script>
  <%@include file="/templates/public/inc/footer.jsp" %>   
</body>

</html>
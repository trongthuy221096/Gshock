<%@page import="model.bean.Comment"%>
<%@page import="model.bean.Picture"%>
<%@page import="model.bean.Contact"%>
<%@page import="model.bean.Watch"%>
<%@page import="model.bean.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/templates/public/inc/header.jsp"%>

<%
	Watch watch = new Watch();
	ArrayList<Review> listReview = (ArrayList<Review>) request.getAttribute("listReview");
	ArrayList<Picture> listPicture = (ArrayList<Picture>) request.getAttribute("listPicture");
	ArrayList<Comment> listCmt = (ArrayList<Comment>) request.getAttribute("listCmt");
	if (request.getAttribute("watch") != null) {
		watch = (Watch) request.getAttribute("watch");
	}
	User userLogin = (User)session.getAttribute("userLogin");
%>

<div id="content" style="margin: 50px 0;">
	<div class="container">
		<div class="row" style="margin: 50px 0;">
			<div class="col-lg-6 col-sm-6 col-md-6 ">

				<div id="carouselExampleDark" class="carousel carousel-dark slide "
					style="padding-bottom: 100px;">
					<div class="carousel-indicators list-btn">
						<button type="button" data-bs-target="#carouselExampleDark"
							data-bs-slide-to="0" class="active img-btn" aria-current="true"
							aria-label="Slide 0" style="background-color: #fff !important;">
							<img class="rounded mx-auto d-block img-fluid"
								src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
								alt="">
						</button>
						<%
							if (listPicture != null && listPicture.size() > 0) {
								int i = 0;
								for (Picture picture : listPicture) {
									i++;
						%>
						<button type="button" data-bs-target="#carouselExampleDark"
							data-bs-slide-to="<%=i%>" class="active img-btn"
							aria-current="true" aria-label="Slide <%=i%>"
							style="background-color: #fff !important;">
							<img class="rounded mx-auto d-block img-fluid"
								src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=picture.getPicture()%>"
								alt="">
						</button>
						<%
							}
							}
						%>
					</div>
					<div class="carousel-inner">
						<div class="carousel-item active " data-bs-interval="10000">
							<div class="row item-sale ">
								<div class="col">
									<div class="tab-item">
										<a href="#" class=""><img
											class="rounded mx-auto d-block img-fluid"
											src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
											alt="ảnh" class="img-text"></a>
									</div>
								</div>
							</div>
						</div>
						<%
							if (listPicture != null && listPicture.size() > 0) {
								int i = 0;
								for (Picture picture : listPicture) {
									i++;
						%>
						<div class="carousel-item" data-bs-interval="2000">
							<div class="row item-sale">
								<div class="col">
									<div class="tab-item ">
										<a href="#" class=""><img
											class="rounded mx-auto d-block img-fluid"
											src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=picture.getPicture()%>"
											alt="ảnh" class="img-text"></a>


									</div>
								</div>
							</div>
						</div>
						<%
							}
							}
						%>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="prev">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="next">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>
			</div>
			<div class="col-lg-6 col-sm-6 col-md-6 ">
				<div class="breadcum ">
					<a href="" style="font-size: 15px; color: #000000">Trang chủ</a> »
					<span style="font-size: 15px; color: #000000">Cửa hàng</span>
				</div>
				<h4 style="font-size: 24px; font-weight: 700;"><%=watch.getName()%></h4>
				<p class="section-des dp-ilbl mn-sale color pd-10"><%=watch.getSell()%><span
						class="bdbt color">đ</span>
				</p>
				<p class="section-des through-line dp-ilbl color"
					style="font-size: 24px; font-weight: 700;">
					<%=watch.getSelloff()%><span class="bdbt color">đ</span>
				</p>
				<h4 style="font-size: 24px; font-weight: 700;">Bộ sản phẩm gồm:</h4>
				<ul>
					<li>1 đồng hồ chính hãng.</li>
					<li>Thẻ bảo hành 5 năm tất cả các lỗi do nhà sản xuất.</li>
					<li>Thẻ thay pin miễn phí trọn đời.</li>
					<li>1 vòng đeo tay G-SHOCK.</li>
					<li>Thẻ giảm giá 200.000 ( cho lần mua tiếp theo).</li>
					<li>1 hộp giấy + 1 hộp thiếc (tùy sản phẩm).</li>
					<li>Miễn phí vận chuyển toàn quốc.</li>
					<li>Sách hướng dẫn sử dụng các thứ tiếng.</li>
					<li>Thông tin các đối tác bảo hành G-SHOCK & BABY-G trên toàn
						cầu.</li>
					<li>Hỗ trợ hướng dẫn sử dụng và tư vấn sản phẩm trọn đời.</li>
				</ul>
				<div class="list">

					<div class="item item_1">
						<div class="thumb">
							<img src="https://gshockvn.net/wp-content/uploads/giao-hang.png"
								alt="Giao hàng toàn quốc">
						</div>
						<div class="title">&nbsp;Giao hàng toàn quốc</div>
					</div>

					<div class="item item_2">
						<div class="thumb">
							<img src="https://gshockvn.net/wp-content/uploads/thanh-toan.png"
								alt="Thanh toán khi nhận hàng">
						</div>
						<div class="title">&nbsp;Thanh toán khi nhận hàng</div>
					</div>

					<div class="item item_3">
						<div class="thumb">
							<img
								src="https://gshockvn.net/wp-content/uploads/doi-tra-hang.png"
								alt="Cam kết đổi/trả hàng miễn phí">
						</div>
						<div class="title">&nbsp;Cam kết đổi/trả hàng miễn phí</div>
					</div>

					<div class="item item_4">
						<div class="thumb">
							<img src="https://gshockvn.net/wp-content/uploads/bao-hanh.png"
								alt="Hàng chính hãng/Bảo hành 10 năm">
						</div>
						<div class="title">&nbsp;Hàng chính hãng/Bảo hành 10 năm</div>
					</div>
				</div>
				<div>
					<!-- Button trigger modal -->
					<a
						href="<%=request.getContextPath()%>/public/oderitem/add?wid=<%=watch.getId()%>"
						class="btn dathang"
						style="background-color: #EE1A26; color: #fff; width: 49%; font-size: 14px; dathang: hover:color #fff;">
						Đặt Hàng <br> <span style="font-size: 12px;">Giao hàng
							tận nơi </span>
					</a>
				</div>
			</div>
		</div>
		<div>
			<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
				<li class="nav-item" role="presentation">
					<button class="nav-link active" id="pills-home-tab"
						data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
						role="tab" aria-controls="pills-home" aria-selected="true">Thông
						tin sản phẩm</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-profile-tab"
						data-bs-toggle="pill" data-bs-target="#pills-profile"
						type="button" role="tab" aria-controls="pills-profile"
						aria-selected="false">Chính sách vận chuyển</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-contact-tab"
						data-bs-toggle="pill" data-bs-target="#pills-contact"
						type="button" role="tab" aria-controls="pills-contact"
						aria-selected="false">Đổi trả & Bảo hành</button>
				</li>
				<li class="nav-item" role="presentation">
					<button class="nav-link" id="pills-contact-tab"
						data-bs-toggle="pill" data-bs-target="#pills-contact"
						type="button" role="tab" aria-controls="pills-contact"
						aria-selected="false">Hình thức thanh toán</button>
				</li>
			</ul>
			<div class="tab-content" id="pills-tabContent">
				<div class="tab-pane fade show active" id="pills-home"
					role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
					<div class="kc-elm vntabs_content">
						<div class="kc-elm kc-css-714457 vntabs_cont active">
							<div class="kc-elm kc-css-10501 woocommerce vnt_the_content"
								data-readmore="" aria-expanded="false" id="rmjs-1"
								style="max-height: none;">
								<div class="accordion_content_inner">
									<section id="feature" class="slots js-more-top">
										<div class="grid-1 grid--1 narrow-wrap">
											<div class="narrow-layout">
												<div class="narrow-contents">
													<div
														class="header-grid grid-1 grid-n--1 bg-ultra-light-grey bg--white frame">
														<div class="column bg-white">
															<h2 class="t-size-x-large underline printNomargin">Mô
																tả</h2>
															<ul class="no-style-list">
																<li><%=watch.getDetailtext()%></li>
														</div>
														</ul>
														<h2 class="t-size-x-large underline printNomargin">Tính
															Năng</h2>
														<ul class="no-style-list">
															<li><%=watch.getFeature()%></li>
													</div>
													</ul>
													<h2 class="t-size-x-large underline printNomargin">Đặc
														điểm Kỹ thuật</h2>
													<ul class="no-style-list">
														<li><%=watch.getParameters()%></li>
												</div>
												</ul>
												</article>
												<article class="column bg-white outer">
													<h3 class="t-size-large title-side">Kích thước vỏ /
														Tổng trọng lượng</h3>
													<ul class="outer">
														<li>Kích thước vỏ : 53,5×49,2×13,1mm</li>
														<li>Tổng trọng lượng : 199g</li>
													</ul>
												</article>
											</div>
									</section>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="tab-pane fade" id="pills-profile" role="tabpanel"
					aria-labelledby="pills-profile-tab" tabindex="0">
					<p>Bằng cách sử dụng dịch vụ vận chuyển được hỗ trợ trên sàn
						giao dịch TMĐT Shopee, bạn đã thừa nhận và đồng ý với các yêu cầu,
						và/hoặc các Chính Sách, thực tiễn áp dụng nêu trong Chính Sách Vận
						Chuyển này. Shopee bảo lưu quyền sửa đổi Chính Sách Vận Chuyển này
						vào bất cứ lúc nào.
					<p>
				</div>
				<div class="tab-pane fade" id="pills-contact" role="tabpanel"
					aria-labelledby="pills-contact-tab" tabindex="0">
					<p>Trong vòng 3 ngày đầu mua hàng Sản phẩm được đổi mới trong
						vòng 3 ngày từ ngày mua hàng nếu gặp lỗi do nhà sản xuất. Điều
						kiện đổi mới: - Sản phẩm nguyên vẹn, không bị trầy xước, rơi, vỡ,
						va đập, chèn đè,... - Sản phẩm còn đầy đủ chứng từ: phiếu giao
						hàng kiêm phiếu bảo hành Sau 3 ngày kể từ khi mua hàng Sản phẩm
						sau 7 ngày kể từ ngày mua hàng nếu gặp hỏng hóc sẽ được áp dụng
						chính sách bảo hành. Sản phẩm bị lỗi được bảo hành tại trung tâm
						bảo hành của Watch</p>
				</div>
				<div class="tab-pane fade" id="pills-contact" role="tabpanel"
					aria-labelledby="pills-contact-tab" tabindex="0">
					<p>Hình thức thanh toán là dạng tài sản được dùng để thanh
						toán. Hiện nay hình thức thanh toán gồm hai dạng sau: hình thức
						thanh toán bằng tiền mặt và hình thức thanh toán không dùng tiền
						mặt (chuyển khoản, tín dụng, ghi séc,…).</p>
				</div>
			</div>
		</div>

	</div>
	<div class="stars">

		<div class="container-fluid" style="background: #fcf9f4;">
			<div class="content-section container">
				<div class="section-item ">
					<div class="text">
						<h2 class="content-header">REVIEWS CỦA KHÁCH HÀNG</h2>
						<p class="sub-header"></p>
					</div>
					<%
						Review review = (Review) request.getAttribute("review");
						String fullname = fullname = request.getParameter("fullname");
						String email = request.getParameter("email");
						String comment = request.getParameter("comment");

						String err = request.getParameter("err");
						String msg = request.getParameter("msg");
						if ("1".equals(err)) {
							out.print("<p style='color:red;'>Bạn chưa nhập thông tin</p>");
						}
						if ("2".equals(err)) {
							out.print("<p style='color:red;'>Có lỗi khi gửi</p>");
						}if ("3".equals(err)) {
							out.print("<p style='color:red;' >Vui lòng Đăng nhập trước khi bình luận </p>");
						}
						if ("1".equals(msg)) {
							out.print("<p style='color:grenn;'>Gửi thành công</p>");
						}
					%>
					<%
						if (listReview == null || listReview.size() == 0) {
					%>
					<p class="text-center">Chưa có đánh giá nào</p>
					<span id="reply-title" class="comment-reply-title">Hãy là
						người đầu tiên nhận xét “<%=watch.getName()%>” <small><a
							rel="nofollow" id="cancel-comment-reply-link"
							href="/san-pham/eqb-800d-1adr/#respond" style="display: none;">Hủy</a></small>
					</span>
					<%
						}
					%>
					<p class="comment-notes">
						<span  id="email-notes">Email của bạn sẽ không được hiển thị
							công khai.</span> <span class="required-field-message"
							aria-hidden="true">Các trường bắt buộc được đánh dấu <span
							class="required" aria-hidden="true">*</span></span>
					</p>
					<div id="comment-list" class="">
						<ul style="list-style-type: none; padding: 0;">
							<%
								if (listReview != null && listReview.size() > 0) {
									for (Review reviews : listReview) {
							%>
							<li class="item-cmt"
								style="border: none; margin: 10px 0 10px 10px;">
								<div class="item-cmt">
									<img class="img-avatar img-thumbnail" alt=""
										src="<%=request.getContextPath()%>/templates/admin/assets/img/a181351bdfea7e975edc2c4a70d06be4.png">
									<div class="comment-text">
										<div style="float: right">
											<%
												for (int i = 1; i <= reviews.getVote(); i++) {
											%>
											<img
												src="<%=request.getContextPath()%>/templates/admin/assets/img/start.png"
												alt="" style="width: 25px;">
											<%
												}
											%>
										</div>
										<p class="meta">
											<strong class="woocommerce-review__author"><%=reviews.getFullname()%></strong>
											<span class="woocommerce-review__dash"></span>
										</p>
										<div class="description">
											<p><%=reviews.getComment()%></p>
										</div>
										<div class="accordion accordion-flush"
											id="accordionFlushExample">
											<div class="accordion-item" style="display: inline-block;">
												<h2 class="accordion-header" id="flush-headingOne">
													<button class="accordion-button collapsed"
														style="padding: 0; color: #65676b; background-color: #fcf9f4"
														type="button" data-bs-toggle="collapse"
														data-bs-target="#flush-collapseOne<%=reviews.getId()%>" aria-expanded="false"
														aria-controls="flush-collapseOne<%=reviews.getId()%>">Phản hồi</button>
												</h2>
											</div>
										</div>
									</div>
								</div>
								<ul style="list-style-type: none;">
									<%
										if (listCmt != null && listCmt.size() > 0) {
													for (Comment cmt : listCmt) {
														if (cmt.getReviewid() == reviews.getId()) {
									%>
									<li class="item-cmt" style="margin: 10px 0 10px 60px;"><img
										class="img-avatar img-thumbnail" alt=""
										src="<%=request.getContextPath()%>/templates/admin/assets/img/a181351bdfea7e975edc2c4a70d06be4.png">
										<div class="comment-text">
											<p class="meta">
												<strong class="woocommerce-review__author"><%=cmt.getName()%></strong>
												<span class="woocommerce-review__dash"></span>
											</p>
											<div class="description">
												<p><%=cmt.getComment()%></p>
											</div>
											<%
												if(userLogin!=null){
												if(userLogin.getRole()==1 ||userLogin.getId()==cmt.getUserid()){
											%>
                                        	<a href="#" onclick="return alert('bạn có chắc muốn xóa'),delCmt(<%=cmt.getId()%>)" class="delete">Xóa</a>                                       	
                                        <% }}%>
										</div></li>
									<%
										}
													}
												}
									%>
									<div id="flush-collapseOne<%=reviews.getId()%>" class="accordion-collapse collapse"
										aria-labelledby="flush-headingOne"
										data-bs-parent="#accordionFlushExample">
										<div class="accordion-body">
											<form id="form-cmt<%=reviews.getId()%>" action="#" method="post">
												<div class="mb-3">
													<label for="comment1" class="form-label">Bình luận</label> <input
														type="text" class="form-control" id="comment<%=reviews.getId()%>"
														aria-describedby="comment<%=reviews.getId()%>" name="comment<%=reviews.getId()%>" value=""
														placeholder="Nhập cmt">
														<input 
														type="text" class="form-control" id="reviewid<%=reviews.getId()%>"
														aria-describedby="reviewid<%=reviews.getId()%>" name="reviewid<%=reviews.getId()%>" value="<%=reviews.getId()%>"
														placeholder="Nhập cmt" style="display: none;">
												</div>
												<button type="submit" class="btn btn-primary">Gửi</button>
											</form>
										</div>
									</div>
<script type="text/javascript">
$('#form-cmt<%=reviews.getId()%>').validate({	
	rules:{
		"comment<%=reviews.getId()%>":{
			required:true,
		},
	},
	messages:{
		"comment<%=reviews.getId()%>":{
			required:"Mời nhập comment",	
		},
	},	
    submitHandler: function(form) {		        
    	getCmt<%=reviews.getId()%>();
    }
});
</script>
	<script type="text/javascript">
	function getCmt<%=reviews.getId()%>() {
		var comment = $("#comment<%=reviews.getId()%>").val();
		var wid = $("#wid").val();
		var reviewid = $("#reviewid<%=reviews.getId()%>").val();
		$.ajax({
			url: '<%=request.getContextPath()%>/detail',		
				type : 'POST',
				cache : false,
				data : {
					acomment : comment,
					awid:wid,
					areviewid:reviewid,
				},
				success : function(data) {
					$("#comment-list").html(data);
				},
				error : function() {
					alert('Mời bạn nhập đầy đủ thông tin');
				}
			});
			return false;
		}
</script>
								</ul>
							</li>
							<%
								}
								}
							%>
						</ul>
					</div>
					<div class="clearfix"></div>
					<h2>Đánh giá của bạn</h2>
					<div>
						<form id="form-coment" class="g-3">
							<%--							                       
		                      <div  class="stars" style="float: left">
								    <input class="star star-5" id="star-5" value="5" type="radio"  name="star"/>
								    <label class="star star-5" for="star-5"></label>
								    <input class="star star-4" id="star-4" value="4" type="radio"  name="star"/>
								    <label class="star star-4" for="star-4"></label>
								    <input class="star star-3" id="star-3" value="3" type="radio"  name="star"/>
								    <label class="star star-3" for="star-3"></label>
								    <input class="star star-2" id="star-2" value="2" type="radio"  name="star"/>
								    <label class="star star-2" for="star-2"></label>
								    <input class="star star-1" id="star-1" value="1" type="radio"  name="star"/>
								    <label class="star star-1" for="star-1"></label>
								 </div>						 	 
		                    <div class="clearfix"></div>
		                    --%>
							<div class="row">
								<div class="mb-3">
									<label for="comment" class="form-label">Nhận xét của
										bạn *</label>
									<textarea name="comment" class="form-control" id="comment"
										rows="3" value=""></textarea>
								</div>
								<div class="col-md-6">
									<label for="fullname" class="form-label">Tên *</label> <input
										type="text" name="fullname" class="form-control" id="fullname"
										value="">
								</div>
								<div class="col-md-6">
									<label for="email" class="form-label">Email *</label> <input
										type="email" name="email" class="form-control" id="email"
										value="">
								</div>
								<div class="col-12">
									<label for="vote" class="form-label">Đánh giá 1-5 *</label> <input
										id="vote" type="text" name="vote" class="form-control"
										value="">
								</div>
								<div class="col-12" style="display: none">
									<label for="vote" class="form-label"></label> <input id="wid"
										type="text" name="wid" class="form-control"
										value="<%=watch.getId()%>">
								</div>
								<div class="col-12">
									<button type="submit" class="btn btn-primary">Gửi đi</button>
								</div>
							</div>
						</form>
					</div>
					<div></div>
				</div>
			</div>
		</div>

	</div>
	<script type="text/javascript">
$('#form-coment').validate({	
	rules:{
		"comment":{
			required:true,
		},
		"fullname":{
			required:true,
		},
		"email":{
			required:true,
		},
		"vote":{
			required:true,
			digits:true,
			min:0,
			max:5,
		},
	},
	messages:{
		"comment":{
			required:"Mời nhập comment",	
		},
		"fullname":{
			required:"Mời nhập tên",
		},
		"email":{
			required:"Mời nhập Email",
		},
		"vote":{
			required:"Mời nhập",
			digits:"Mời nhập số",
			min:"Mời nhập từ 1 đến 5",
			max:"Mời nhập từ 1 đến 5",
		},
	
	},	
    submitHandler: function(form) {		        
    	getComment();
    }
});
</script>
	<script type="text/javascript">
	function getComment() {
		var comment = $("#comment").val();
		var fullname = $("#fullname").val();
		var email = $("#email").val();
		var vote = $("#vote").val();
		var wid = $("#wid").val();
		$.ajax({
			url: '<%=request.getContextPath()%>/admin/review/add',		
				type : 'POST',
				cache : false,
				data : {
					acomment : comment,
					afullname : fullname,
					aemail : email,
					avote : vote,
					awid : wid
				},
				success : function(data) {
					$("#comment-list").html(data);
				},
				error : function() {
					alert('Mời bạn nhập đầy đủ thông tin');
				}
			});
			return false;
		}
	</script>
		<script type="text/javascript">
		function delCmt(id) {
			var wid = $("#wid").val();
			$.ajax({
				url: '<%=request.getContextPath()%>/comment/del',		
					type : 'POST',
					cache : false,
					data : {
						awid : wid,
						aid:id,
					},
					success : function(data) {
						$("#comment-list").html(data);
					},
					error : function() {
						alert('Mời bạn nhập đầy đủ thông tin');
					}
				});
				return false;
			}
	</script>
	
	<style>
label.star {
	font-size: 24px;
}
li{
list-style-type: none;
}
.error {
	color: red;
}
.delete{
color: red;
font-weight: bold;
}
</style>
	<%@include file="/templates/public/inc/footer.jsp"%>
	</body>

	</html>
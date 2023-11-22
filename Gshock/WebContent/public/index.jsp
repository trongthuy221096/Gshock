
<%@page import="java.beans.Expression"%>
<%@page import="model.bean.Watch"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp"%>
<div id="slider">
	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="true">
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="img-slider"
					src="https://gshockvn.net/wp-content/uploads/hong-ho-casio-1-1_auto_x2-scaled.jpg"
					alt="">
			</div>
			<div class="carousel-item">
				<img class="img-slider"
					src="https://gshockvn.net/wp-content/uploads/gravitymaster-2_auto_x2-scaled.jpg"
					alt="">
			</div>
			<div class="carousel-item">
				<img class="img-slider"
					src="https://gshockvn.net/wp-content/uploads/gravitymaster1_auto_x2-scaled.jpg"
					alt="">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
</div>
<div id="home">
	<div class="content-section container">
		<div class="section-item row">

			<div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
				<div href="#" class="blog-item">
					<img
						src="<%=request.getContextPath()%>/templates/public/images/vanchuyen.png"
						alt="ảnh" class="rounded mx-auto d-block">
					<div class="blog-text">
						<h5 class="blog-header">Free ship toàn quốc</h5>
						<div class="is-divider"></div>
						<p class="opensans blog-des blog-sub">Chúng tôi miễn phí vận
							chuyển với tất cả các đơn hàng trị giá trên 2.000.000Đ</p>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
				<div href="#" class="blog-item">
					<img
						src="<%=request.getContextPath()%>/templates/public/images/dienthoai.png"
						alt="ảnh" class="rounded mx-auto d-block">
					<div class="blog-text">
						<h5 class="blog-header">HỖ TRỢ ONLINE 24/24</h5>
						<div class="is-divider"></div>
						<p class="opensans blog-des blog-sub">Chúng tôi luôn luôn hỗ
							trợ khách hàng 24/24 tất cả các ngày trong tuần</p>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
				<div href="#" class="blog-item">
					<img
						src="<%=request.getContextPath()%>/templates/public/images/hotro.png"
						alt="ảnh" class="rounded mx-auto d-block">
					<div class="blog-text">
						<h5 class="blog-header">MIỄN PHÍ ĐỔI TRẢ</h5>
						<div class="is-divider"></div>
						<p class="opensans blog-des blog-sub">Đổi mới trong vòng 1
							tháng, bảo hành 5 năm, thay pin trọn đời</p>
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-sm-3 col-md-3   section-blog section-left ">
				<div href="#" class="blog-item">
					<img
						src="<%=request.getContextPath()%>/templates/public/images/quatang.png"
						alt="ảnh" class="rounded mx-auto d-block">
					<div class="blog-text">
						<h5 class="blog-header">QUÀ TẶNG HẤP DẪN</h5>
						<div class="is-divider"></div>
						<p class="opensans blog-des blog-sub">Chương trình khuyễn mãi
							cực lớn và hấp dẫn vào mỗi chủ nhật hàng tuần</p>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>
<div class="clearfix"></div>
<div id="content">

	<div class="content-section container">

		<div class="section-item row ">
			<div class="text">
				<h2 class="content-header">DANH MỤC SẢN PHẨM</h2>
				<p class="sub-header"></p>
			</div>
			<div class="col-lg-6 col-sm-6 col-md-6 section-blog section-left ">
				<a href="<%=request.getContextPath()%>/g-shock-4">
					<div class="blog-item" style="margin: 20px 0;">
						<img
							src="<%=request.getContextPath()%>/templates/public/images/DỒNG-HỒ.jpeg"
							alt="ảnh" class="img-blog">
						<div class="blog-text">
							<h5 class="blog-header">G-Shock</h5>
							<div class="is-divider"></div>
						</div>
						<p class="opensans blog-des blog-sub">Xem thêm</p>
					</div>
				</a> <a href="<%=request.getContextPath()%>/g-shock-4">
					<div class="blog-item " style="margin-top: 50px;">
						<img
							src="<%=request.getContextPath()%>/templates/public/images/MA_Banner_Edifice_800x700_EFR-569_1.jpeg"
							alt="ảnh" class="img-blog">
						<div class="blog-text">
							<h5 class="blog-header">G-Shock</h5>
							<div class="is-divider"></div>
						</div>
						<p class="opensans blog-des blog-sub">Xem thêm</p>
					</div>
				</a>
			</div>
			<div class="col-lg-6 col-sm-6 col-md-6 section-blog section-left ">
				<a href="<%=request.getContextPath()%>/baby-g-3">
					<div class="blog-item" style="margin-bottom: 15px;">
						<img
							src="<%=request.getContextPath()%>/templates/public/images/gshock-baby-g.jpeg"
							alt="ảnh" class="img-blog">
						<div class="blog-text">
							<h5 class="blog-header">Baby-G</h5>
							<div class="is-divider"></div>

						</div>
						<p class="opensans blog-des blog-sub">Xem thêm</p>
					</div>
				</a> <a href="<%=request.getContextPath()%>/baby-g-3">
					<div class="blog-item">
						<img
							src="<%=request.getContextPath()%>/templates/public/images/Picture1-1.png"
							alt="ảnh" class="img-blog">
						<div class="blog-text">
							<h5 class="blog-header">Baby-G</h5>
							<div class="is-divider"></div>

						</div>
						<p class="opensans blog-des blog-sub">Xem thêm</p>
					</div>
				</a>
			</div>
		</div>

		<div class="section-item  ">
			<div class="text">
				<h2 class="content-header">TOP SẢN PHẨM BÁN CHẠY</h2>
				<p class="sub-header"></p>
			</div>
			<div class="">
				<ul class="nav nav-pills mb-3 tab" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-home-tab"
							data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
							role="tab" aria-controls="pills-home" aria-selected="true">G-Shock</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-profile-tab"
							data-bs-toggle="pill" data-bs-target="#pills-profile"
							type="button" role="tab" aria-controls="pills-profile"
							aria-selected="false">Casio Vintage</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-contact-tab"
							data-bs-toggle="pill" data-bs-target="#pills-contact"
							type="button" role="tab" aria-controls="pills-contact"
							aria-selected="false">Baby-G</button>
					</li>
				</ul>
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane  fade show active" id="pills-home"
						role="tabpanel" aria-labelledby="pills-home-tab" tabindex="0">
						<div class="row">
					
							<%
							ArrayList<Watch> listwatchgshock4 = (ArrayList<Watch>) request.getAttribute("listwatchgshock4");
							if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
								for (Watch watch : listwatchgshock4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>
						</div>

					</div>

					<div class="tab-pane fade" id="pills-profile" role="tabpanel"
						aria-labelledby="pills-profile-tab" tabindex="0">
						<div class="row">
							<%
							ArrayList<Watch> listwatchbabyg4 = (ArrayList<Watch>) request.getAttribute("listwatchbabyg4");
							if (listwatchbabyg4 != null && listwatchbabyg4.size() > 0) {
								for (Watch watch : listwatchbabyg4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>
						</div>
					</div>

					<div class="tab-pane fade" id="pills-contact" role="tabpanel"
						aria-labelledby="pills-contact-tab" tabindex="0">
						<div class="row">
							<%
							ArrayList<Watch> listwatchvintage4 = (ArrayList<Watch>) request.getAttribute("listwatchvintage4");
							if (listwatchvintage4 != null && listwatchvintage4.size() > 0) {
								for (Watch watch : listwatchvintage4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>


	</div>
	<div class="content-section container-fluid">
		<div class="section-item test">
			<div class="text">
				<h2 class="content-header">FLASH SALE HÀNG TUẦN</h2>
				<p class="sub-header"></p>
			</div>
			<div id="carouselExampleDark"
				class="carousel carousel-dark slide flash-sale "
				data-bs-ride="carousel" data-bs-ride="true">
				<div class="carousel-indicators" style="bottom: -40px;">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>

				<div class="carousel-inner">
					<div class="carousel-item active " data-bs-interval="10000">
						<div class="row item-sale ">
							<div class="col-lg-4 col-sm-4 col-md-4  "
								style="position: relative;">
								<div class="tab-item ">
									<a href="#" class=""><img style="position: relative;"
										class="rounded mx-auto d-block img-fluid"
										src="<%=request.getContextPath()%>/templates/public/images/ga-2100ap-355-1-300x300.jpg"
										alt="ảnh" class="img-text"></a> <a href="#"
										class="tab-xemnhanh" style="right: 16px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a href="#"
										class="tab-muangay" style="right: 15px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
								</div>
							</div>
							<div class="col-lg-8 col-sm-8 col-md-8 ">
								<div class="tab-item">
									<p class="">
										<a href="#">GA-2100-1A AP ROYAL OAK TITANIUM (BLACK &
											THUNDER PURPLE)</a>
									</p>
									<div class="section-text ">
										<p class="color">
											8.499.000<span class="bdbt color">đ<span>
										</p>
										<a href="#" class="dathang">Đặt hàng</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<div class="row item-sale">
							<div class="col-lg-4 col-sm-4 col-md-4">
								<div class="tab-item" style="position: relative;">
									<a href="#" class=""><img
										class="rounded mx-auto d-block img-fluid"
										src="<%=request.getContextPath()%>/templates/public/images/msg-s200-7adr_eda8e32c75d94e04ab551f22bda2049e_master-300x300.png"
										alt="ảnh" class="img-text"></a> <a href="#"
										class="tab-xemnhanh" style="right: 16px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a href="#"
										class="tab-muangay" style="right: 15px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off" style="bottom: 0;">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm 1.661.000<span class="bdbt">đ<span>
									</p>
								</div>
							</div>
							<div class="col-lg-8 col-sm-8 col-md-8">
								<div class="tab-item">
									<p class="">
										<a href="#">GA-2100-1A AP ROYAL OAK TITANIUM (BLACK &
											THUNDER PURPLE)</a>
									</p>
									<div class="section-text">
										<p class="section-des through-line dp-ilbl color">
											8.499.000<span class="bdbt color">đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10">
											10.879.000<span class="bdbt color">đ<span>
										</p>
										<span class="vntp_sale">-22%</span>
									</div>
									<a href="#" class="dathang" style="display: inline-block;">Đặt
										hàng</a>
								</div>
							</div>
						</div>
					</div>
					<div class="carousel-item">
						<div class="row item-sale">
							<div class="col-lg-4 col-sm-4 col-md-4">
								<div class="tab-item" style="position: relative;">
									<a href="#" class=""><img
										class="rounded mx-auto d-block img-fluid"
										src="<%=request.getContextPath()%>/templates/public/images/bsa-b100mf-7adr_9bbb4a96f36b453fb044d38a67e7603d_cfc524a7e2614aee98768f6a94f79e57_grande-300x300.png"
										alt="ảnh" class="img-text"></a> <a href="#"
										class="tab-xemnhanh" style="right: 16px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a href="#"
										class="tab-muangay" style="right: 15px;"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off" style="bottom: 0;">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm 1.661.000<span class="bdbt">đ<span>
									</p>
								</div>
							</div>
							<div class="col-lg-8 col-sm-8 col-md-8">
								<div class="tab-item">
									<p class="">
										<a href="#">GA-2100-1A AP ROYAL OAK TITANIUM (BLACK &
											THUNDER PURPLE)</a>
									</p>
									<div class="section-text">
										<p class="section-des through-line dp-ilbl color">
											8.499.000<span class="bdbt color">đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10">
											10.879.000<span class="bdbt color">đ<span>
										</p>
										<span class="vntp_sale">-22%</span>
									</div>
									<a href="#" class="dathang" style="display: inline-block;">Đặt
										hàng</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev"
					style="display: none;">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next"
					style="display: none;">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>

	<div class="content-section container">
		<div class="section-item ">
			<div class="text">
				<h2 class="content-header">Đồng hồ G-Shock</h2>
				<p class="sub-header"></p>
			</div>

			<div class="row">
				<%
				ArrayList<Watch> listwatchgshock2 = (ArrayList<Watch>) request.getAttribute("listwatchgshock2");
				if (listwatchgshock2 != null && listwatchgshock2.size() > 0) {
					for (Watch watch : listwatchgshock2) {
						int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
				%>
				<div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
					<div class="tab-item watch">
						<a
							href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
							class=""><img class="rounded mx-auto d-block img-fluid"
							style="max-height: 268px"
							src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
							alt="ảnh" class="img-text"></a> <a
							href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
							class="tab-xemnhanh"><img
							src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
							alt="ảnh" class="img-xemnhanh"></a> <a
							href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
							class="tab-muangay"><img
							src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
							alt="ảnh" class="img-xemnhanh"></a>
						<p class="sale-off">
							<img
								src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
								alt="ảnh" class=""> Giảm
							<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
								class="bdbt"> đ<span>
						</p>
						<p class="item-title">
							<a
								href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
						</p>
						<div class="section-text text-center">
							<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
									class="bdbt color"> đ<span>
							</p>
							<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
									class="bdbt color"> đ<span>
							</p>
							<span class="vntp_sale">-<%=giamphantram%>%
							</span>
						</div>

					</div>
				</div>
				<%
				}
				}
				%>
				<div class="col-lg-6 col-sm-6 col-md-6 section-blog ">
					<div class="tab-item ">
						<a href="#" class=""><img
							class="rounded mx-auto d-block img-fluid img-test"
							src="<%=request.getContextPath()%>/templates/public/images/DỒNG-HỒ.jpeg"
							alt="ảnh" class="img-text"></a>
					</div>
					<div></div>
				</div>
			</div>

			<div id="carouselExampleDark1" class="carousel carousel-dark slide "
				data-bs-ride="carousel" data-bs-ride="true">
				<div class="carousel-indicators" style="bottom: -40px;">
					<button type="button" data-bs-target="#carouselExampleDark1"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark1"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark1"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>

				<div class="carousel-inner">
					<div class="carousel-item active " data-bs-interval="10000">
						<div class="row item-sale ">
							<%
							if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
								for (Watch watch : listwatchgshock4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>

						</div>
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<div class="row item-sale">
							<%
							if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
								for (Watch watch : listwatchgshock4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>

						</div>
					</div>
					<div class="carousel-item">
						<div class="row item-sale">
							<%
							if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
								for (Watch watch : listwatchgshock4) {
									int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
							%>
							<div
								class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
								<div class="tab-item watch">
									<a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class=""><img class="rounded mx-auto d-block img-fluid"
										style="max-height: 268px"
										src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
										alt="ảnh" class="img-text"></a> <a
										href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
										class="tab-xemnhanh"><img
										src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
										alt="ảnh" class="img-xemnhanh"></a> <a
										href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
										class="tab-muangay"><img
										src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
										alt="ảnh" class="img-xemnhanh"></a>
									<p class="sale-off">
										<img
											src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
											alt="ảnh" class=""> Giảm
										<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
											class="bdbt"> đ<span>
									</p>
									<p class="item-title">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
									</p>
									<div class="section-text text-center">
										<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
												class="bdbt color"> đ<span>
										</p>
										<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
												class="bdbt color"> đ<span>
										</p>
										<span class="vntp_sale">-<%=giamphantram%>%
										</span>
									</div>

								</div>
							</div>
							<%
							}
							}
							%>

						</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev"
					style="display: none;">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next"
					style="display: none;">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>

		</div>

	</div>
	<div class="clearfix"></div>
	<div class="container-fluid" style="background: #fcf9f4;">
		<div class="content-section container">
			<div class="section-item ">
				<div class="text">
					<h2 class="content-header">Đồng hồ Baby-G</h2>
					<p class="sub-header"></p>
				</div>

				<div class="row">
					<div class="col-lg-6 col-sm-6 col-md-6 section-blog ">
						<div class="tab-item ">
							<a href="#" class=""><img
								class="rounded mx-auto d-block img-fluid img-test"
								src="<%=request.getContextPath()%>/templates/public/images/Picture1-2.png"
								alt="ảnh" class="img-text"></a>
						</div>
						<div></div>
					</div>
					<%
					ArrayList<Watch> listwatchbabyg2 = (ArrayList<Watch>) request.getAttribute("listwatchbabyg2");
					if (listwatchbabyg2 != null && listwatchbabyg2.size() > 0) {
						for (Watch watch : listwatchbabyg2) {
							int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
					%>
					<div class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
						<div class="tab-item watch">
							<a
								href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
								class=""><img class="rounded mx-auto d-block img-fluid"
								style="max-height: 268px"
								src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
								alt="ảnh" class="img-text"></a> <a
								href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
								class="tab-xemnhanh"><img
								src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
								alt="ảnh" class="img-xemnhanh"></a> <a
								href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
								class="tab-muangay"><img
								src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
								alt="ảnh" class="img-xemnhanh"></a>
							<p class="sale-off">
								<img
									src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
									alt="ảnh" class=""> Giảm
								<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
									class="bdbt"> đ<span>
							</p>
							<p class="item-title">
								<a
									href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
							</p>
							<div class="section-text text-center">
								<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
										class="bdbt color"> đ<span>
								</p>
								<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
										class="bdbt color"> đ<span>
								</p>
								<span class="vntp_sale">-<%=giamphantram%>%
								</span>
							</div>

						</div>
					</div>
					<%
					}
					}
					%>

				</div>

				<div id="carouselExampleDark2" class="carousel carousel-dark slide "
					data-bs-ride="carousel" data-bs-ride="true">
					<div class="carousel-indicators" style="bottom: -40px;">
						<button type="button" data-bs-target="#carouselExampleDark2"
							data-bs-slide-to="0" class="active" aria-current="true"
							aria-label="Slide"></button>
						<button type="button" data-bs-target="#carouselExampleDark2"
							data-bs-slide-to="1" aria-label="Slide 2"></button>
						<button type="button" data-bs-target="#carouselExampleDark2"
							data-bs-slide-to="2" aria-label="Slide 3"></button>
					</div>

					<div class="carousel-inner">
						<div class="carousel-item active " data-bs-interval="10000">
							<div class="row ">
								<%
								if (listwatchbabyg4 != null && listwatchbabyg4.size() > 0) {
									for (Watch watch : listwatchbabyg4) {
										int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
								%>
								<div
									class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
									<div class="tab-item watch">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class=""><img class="rounded mx-auto d-block img-fluid"
											style="max-height: 268px"
											src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
											alt="ảnh" class="img-text"></a> <a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class="tab-xemnhanh"><img
											src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
											alt="ảnh" class="img-xemnhanh"></a> <a
											href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
											class="tab-muangay"><img
											src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
											alt="ảnh" class="img-xemnhanh"></a>
										<p class="sale-off">
											<img
												src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
												alt="ảnh" class=""> Giảm
											<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
												class="bdbt"> đ<span>
										</p>
										<p class="item-title">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
										</p>
										<div class="section-text text-center">
											<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
													class="bdbt color"> đ<span>
											</p>
											<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
													class="bdbt color"> đ<span>
											</p>
											<span class="vntp_sale">-<%=giamphantram%>%
											</span>
										</div>

									</div>
								</div>
								<%
								}
								}
								%>

							</div>
						</div>

						<div class="carousel-item" data-bs-interval="2000">
							<div class="row">
								<%
								if (listwatchbabyg4 != null && listwatchbabyg4.size() > 0) {
									for (Watch watch : listwatchbabyg4) {
										int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
								%>
								<div
									class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
									<div class="tab-item watch">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class=""><img class="rounded mx-auto d-block img-fluid"
											style="max-height: 268px"
											src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
											alt="ảnh" class="img-text"></a> <a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class="tab-xemnhanh"><img
											src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
											alt="ảnh" class="img-xemnhanh"></a> <a
											href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
											class="tab-muangay"><img
											src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
											alt="ảnh" class="img-xemnhanh"></a>
										<p class="sale-off">
											<img
												src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
												alt="ảnh" class=""> Giảm
											<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
												class="bdbt"> đ<span>
										</p>
										<p class="item-title">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
										</p>
										<div class="section-text text-center">
											<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
													class="bdbt color"> đ<span>
											</p>
											<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
													class="bdbt color"> đ<span>
											</p>
											<span class="vntp_sale">-<%=giamphantram%>%
											</span>
										</div>

									</div>
								</div>
								<%
								}
								}
								%>
							</div>
						</div>
						<div class="carousel-item">
							<div class="row">
								<%
								if (listwatchbabyg4 != null && listwatchbabyg4.size() > 0) {
									for (Watch watch : listwatchbabyg4) {
										int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
								%>
								<div
									class="col-lg-3 col-sm-3 col-md-3 section-blog section-left ">
									<div class="tab-item watch">
										<a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class=""><img class="rounded mx-auto d-block img-fluid"
											style="max-height: 268px"
											src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
											alt="ảnh" class="img-text"></a> <a
											href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
											class="tab-xemnhanh"><img
											src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
											alt="ảnh" class="img-xemnhanh"></a> <a
											href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
											class="tab-muangay"><img
											src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
											alt="ảnh" class="img-xemnhanh"></a>
										<p class="sale-off">
											<img
												src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
												alt="ảnh" class=""> Giảm
											<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
												class="bdbt"> đ<span>
										</p>
										<p class="item-title">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
										</p>
										<div class="section-text text-center">
											<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
													class="bdbt color"> đ<span>
											</p>
											<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
													class="bdbt color"> đ<span>
											</p>
											<span class="vntp_sale">-<%=giamphantram%>%
											</span>
										</div>

									</div>
								</div>
								<%
								}
								}
								%>
							</div>
						</div>
					</div>
					<button class="carousel-control-prev" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="prev"
						style="display: none;">
						<span class="carousel-control-prev-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Previous</span>
					</button>
					<button class="carousel-control-next" type="button"
						data-bs-target="#carouselExampleDark" data-bs-slide="next"
						style="display: none;">
						<span class="carousel-control-next-icon" aria-hidden="true"></span>
						<span class="visually-hidden">Next</span>
					</button>
				</div>

			</div>
		</div>
	</div>
	<div class="clearfix"></div>

	<div class="content-section container">
		<div class="section-item ">
			<div class="text">
				<h2 class="content-header">Đồng hồ mới về</h2>
				<p class="sub-header"></p>
			</div>
			<div class="row">
				<div class="col-lg-6 col-sm-6 col-md-6 section-blog ">
					<div id="carouselExampleDark3"
						class="carousel carousel-dark slide " data-bs-ride="carousel"
						data-bs-ride="true">
						<div class="carousel-indicators" style="bottom: -40px;">
							<button type="button" data-bs-target="#carouselExampleDark3"
								data-bs-slide-to="0" class="active" aria-current="true"
								aria-label="Slide"></button>
							<button type="button" data-bs-target="#carouselExampleDark3"
								data-bs-slide-to="1" aria-label="Slide 2"></button>
							<button type="button" data-bs-target="#carouselExampleDark3"
								data-bs-slide-to="2" aria-label="Slide 3"></button>
						</div>

						<div class="carousel-inner">
							<div class="carousel-item active " data-bs-interval="10000">
								<div class="row ">
									<%
									if (listwatchbabyg4 != null && listwatchbabyg4.size() > 0) {
										for (Watch watch : listwatchbabyg4) {
											int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
									%>
									<div class="col-lg-6 col-sm-6 col-md-6 ">
										<div class="tab-item watch">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class=""><img class="rounded mx-auto d-block img-fluid"
												style="max-height: 268px"
												src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
												alt="ảnh" class="img-text"></a> <a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class="tab-xemnhanh"><img
												src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
												alt="ảnh" class="img-xemnhanh"></a> <a
												href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
												class="tab-muangay"><img
												src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
												alt="ảnh" class="img-xemnhanh"></a>
											<p class="sale-off">
												<img
													src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
													alt="ảnh" class=""> Giảm
												<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
													class="bdbt"> đ<span>
											</p>
											<p class="item-title">
												<a
													href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
											</p>
											<div class="section-text text-center">
												<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
														class="bdbt color"> đ<span>
												</p>
												<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
														class="bdbt color"> đ<span>
												</p>
												<span class="vntp_sale">-<%=giamphantram%>%
												</span>
											</div>

										</div>
									</div>
									<%
									}
									}
									%>
								</div>
							</div>

							<div class="carousel-item" data-bs-interval="2000">
								<div class="row">
									<%
									if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
										for (Watch watch : listwatchgshock4) {
											int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
									%>
									<div class="col-lg-6 col-sm-6 col-md-6 ">
										<div class="tab-item watch">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class=""><img class="rounded mx-auto d-block img-fluid"
												style="max-height: 268px"
												src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
												alt="ảnh" class="img-text"></a> <a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class="tab-xemnhanh"><img
												src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
												alt="ảnh" class="img-xemnhanh"></a> <a
												href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
												class="tab-muangay"><img
												src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
												alt="ảnh" class="img-xemnhanh"></a>
											<p class="sale-off">
												<img
													src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
													alt="ảnh" class=""> Giảm
												<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
													class="bdbt"> đ<span>
											</p>
											<p class="item-title">
												<a
													href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
											</p>
											<div class="section-text text-center">
												<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
														class="bdbt color"> đ<span>
												</p>
												<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
														class="bdbt color"> đ<span>
												</p>
												<span class="vntp_sale">-<%=giamphantram%>%
												</span>
											</div>

										</div>
									</div>
									<%
									}
									}
									%>
								</div>
							</div>
							<div class="carousel-item">
								<div class="row">
									<%
									if (listwatchgshock4 != null && listwatchgshock4.size() > 0) {
										for (Watch watch : listwatchgshock4) {
											int giamphantram = 100 - ((watch.getSelloff() * 100) / watch.getSell());
									%>
									<div class="col-lg-6 col-sm-6 col-md-6 ">
										<div class="tab-item watch">
											<a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class=""><img class="rounded mx-auto d-block img-fluid"
												style="max-height: 268px"
												src="<%=request.getContextPath()%>/templates/admin/assets/img/<%=watch.getPicture()%>"
												alt="ảnh" class="img-text"></a> <a
												href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"
												class="tab-xemnhanh"><img
												src="<%=request.getContextPath()%>/templates/public/images/xem-nhanh.png"
												alt="ảnh" class="img-xemnhanh"></a> <a
												href="<%=request.getContextPath()%>/them/san-pham/<%=watch.getId()%>"
												class="tab-muangay"><img
												src="<%=request.getContextPath()%>/templates/public/images/mua-ngay.png"
												alt="ảnh" class="img-xemnhanh"></a>
											<p class="sale-off">
												<img
													src="<%=request.getContextPath()%>/templates/public/images/giam-gia.png"
													alt="ảnh" class=""> Giảm
												<%=String.format("%,.0f", (double) watch.getSell() - watch.getSelloff())%><span
													class="bdbt"> đ<span>
											</p>
											<p class="item-title">
												<a
													href="<%=request.getContextPath()%>/<%=StringUtil.makeSlug(watch.getName())%>-<%=watch.getId()%>.html"><%=watch.getName()%></a>
											</p>
											<div class="section-text text-center">
												<p class="section-des through-line dp-ilbl color"><%=String.format("%,.0f", (double) watch.getSelloff())%><span
														class="bdbt color"> đ<span>
												</p>
												<p class="section-des dp-ilbl mn-sale color pd-10"><%=String.format("%,.0f", (double) watch.getSell())%><span
														class="bdbt color"> đ<span>
												</p>
												<span class="vntp_sale">-<%=giamphantram%>%
												</span>
											</div>

										</div>
									</div>
									<%
									}
									}
									%>
								</div>
							</div>
						</div>
						<button class="carousel-control-prev" type="button"
							data-bs-target="#carouselExampleDark" data-bs-slide="prev"
							style="display: none;">
							<span class="carousel-control-prev-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Previous</span>
						</button>
						<button class="carousel-control-next" type="button"
							data-bs-target="#carouselExampleDark" data-bs-slide="next"
							style="display: none;">
							<span class="carousel-control-next-icon" aria-hidden="true"></span>
							<span class="visually-hidden">Next</span>
						</button>
					</div>
				</div>
				<div class="col-lg-6 col-sm-6 col-md-6 section-blog ">
					<div class="tab-item ">
						<a href="#" class=""><img
							class="rounded mx-auto d-block img-fluid img-test"
							src="<%=request.getContextPath()%>/templates/public/images/Picture1-2.png"
							alt="ảnh" class="img-text"></a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="content-section container">
		<div class="section-item ">
			<div class="text">
				<h2 class="content-header">Tin tức</h2>
				<p class="sub-header"></p>
			</div>
			<div class="row news">
				<div class="col-lg-4 col-sm-4 col-md-4 ">
					<div class="tab-item ">
						<a href="#" class=""><img
							class="rounded mx-auto d-block img-fluid"
							src="<%=request.getContextPath()%>/templates/public/images/Picture1-2.png"
							alt="ảnh" class="img-text"></a>
						<div style="margin: 10px 0;">
							<a href="#" class="news-title">Cách phối dây da đơn giản mà
								cực kỳ hiệu quả</a>
						</div>
						<a href="#" class="news-cat">Tin Tức</a> <span class="date">25/11/2021</span>
						<p class="news-section">Phối màu đồng bộ với mặt đồng hồ hoặc
							phù hợp với một chi tiết nhỏ của đồng hồ Hiện…</p>
						<a href="" style="font-size: 12px; color: #EE1A26;">Xem thêm
							&nbsp;</a><span style="font-size: 12px;"><i
							class="fa-solid fa-arrow-right-long"></i></span>
					</div>
				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 ">
					<div class="tab-item ">
						<a href="#" class=""><img
							class="rounded mx-auto d-block img-fluid"
							src="<%=request.getContextPath()%>/templates/public/images/Picture1-2.png"
							alt="ảnh" class="img-text"></a>
						<div style="margin: 10px 0;">
							<a href="#" class="news-title">Cách phối dây da đơn giản mà
								cực kỳ hiệu quả</a>
						</div>
						<a href="#" class="news-cat">Tin Tức</a> <span class="date">25/11/2021</span>
						<p class="news-section">Phối màu đồng bộ với mặt đồng hồ hoặc
							phù hợp với một chi tiết nhỏ của đồng hồ Hiện…</p>
						<a href="" style="font-size: 12px; color: #EE1A26;">Xem thêm
							&nbsp;</a><span style="font-size: 12px;"><i
							class="fa-solid fa-arrow-right-long"></i></span>
					</div>
				</div>
				<div class="col-lg-4 col-sm-4 col-md-4 ">
					<div class="tab-item ">
						<a href="#" class=""><img
							class="rounded mx-auto d-block img-fluid"
							src="<%=request.getContextPath()%>/templates/public/images/Picture1-2.png"
							alt="ảnh" class="img-text"></a>
						<div style="margin: 10px 0;">
							<a href="#" class="news-title">Cách phối dây da đơn giản mà
								cực kỳ hiệu quả</a>
						</div>
						<a href="#" class="news-cat">Tin Tức</a> <span class="date">25/11/2021</span>
						<p class="news-section">Phối màu đồng bộ với mặt đồng hồ hoặc
							phù hợp với một chi tiết nhỏ của đồng hồ Hiện…</p>
						<a href="" style="font-size: 12px; color: #EE1A26;">Xem thêm
							&nbsp;</a><span style="font-size: 12px;"><i
							class="fa-solid fa-arrow-right-long"></i></span>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<style>
.tab-item {
	overflow: hidden;
}

.img-test:hover {
	transform: scale(1.1);
	transition: all 0.5s;
}
</style>
<%@include file="/templates/public/inc/footer.jsp"%>
</body>

</html>
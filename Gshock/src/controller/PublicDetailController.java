package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Category;
import model.bean.Comment;
import model.bean.Contact;
import model.bean.Picture;
import model.bean.Review;
import model.bean.User;
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.CommentDAO;
import model.dao.ContactDAO;
import model.dao.PictureDAO;
import model.dao.ReviewDAO;
import model.dao.WatchDAO;
import util.AuthUtil;
import util.DefineUtil;
import util.StringUtil;


public class PublicDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;   
    WatchDAO watchDAO = new WatchDAO();
    ContactDAO contactDAO = new ContactDAO();
    ReviewDAO reviewDAO = new ReviewDAO();
    PictureDAO pictureDAO = new PictureDAO();
    CommentDAO cmtDAO = new CommentDAO();
    public PublicDetailController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
		
		}
		Watch watch = watchDAO.getItemByID(id);
		ArrayList<Picture> listPicture = pictureDAO.getItemByWid(id);
		ArrayList<Review> listReview= reviewDAO.getItemsByWid(id);
		ArrayList<Comment> listCmt = cmtDAO.getItems();
		request.setAttribute("listCmt", listCmt);
		request.setAttribute("watch", watch);
		request.setAttribute("listReview", listReview);
		request.setAttribute("listPicture", listPicture);
		RequestDispatcher rd = request.getRequestDispatcher("/public/chitiet.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		HttpSession session = request.getSession();
		String comment = request.getParameter("acomment");
		int wid = Integer.parseInt(request.getParameter("awid"));
		String name = "ẩn danh";
		int userid=0;
		int reviewid = Integer.parseInt(request.getParameter("areviewid"));		
		Watch watch = watchDAO.getItemByID(wid);
		User userLogin = (User)session.getAttribute("userLogin");
		if(userLogin!=null ) {
			userid = userLogin.getId();
			name = userLogin.getFullname();
		}
		System.out.println(name+comment+userid+"reviewid"+reviewid);
		Comment iteam = new Comment(0, name, comment, userid, reviewid);
		cmtDAO.addItem(iteam);
		ArrayList<Comment> listCmt = cmtDAO.getItems();
		ArrayList<Review> listReview = reviewDAO.getItemsByWid(wid) ;
		response.getWriter().print("<ul style=\" list-style-type:none;\">");
		if(listReview!=null) {
			for(Review item:listReview) {				
		response.getWriter().print(
				"<li class=\"item-cmt\"\r\n" + 
				"								style=\"border: none; margin: 10px 0 10px 10px;\">"
				+"<div class=\"item-cmt\">"
				+"<img class=\"img-avatar img-thumbnail\" alt=\"\" src=\""+ request.getContextPath()+"/templates/admin/assets/img/a181351bdfea7e975edc2c4a70d06be4.png"+"\">"
				+"<div class=\"comment-text\">"
				+"<div style=\"float:right\">"
				);
				for(int i = 1 ; i<=item.getVote();i++) {
					response.getWriter().print(
				"<img src=\""+request.getContextPath()+"/templates/admin/assets/img/start.png"+"\" alt=\"\" style=\"width: 25px; \">	"
					);
				}
		response.getWriter().print("</div>"
				+"<p class=\"meta\">"
				+"<strong class=\"woocommerce-review__author\">"+item.getFullname()+"</strong>"
				+"<span class=\"woocommerce-review__dash\"></span> "
				+"</p>"
				+"<div class=\"description\"><p>"+item.getComment()+"</p>"
				+"</div>"
				+"<div class=\"accordion accordion-flush\"\r\n" + 
				"											id=\"accordionFlushExample\">\r\n" + 
				"											<div class=\"accordion-item\" style=\"display: inline-block;\">\r\n" + 
				"												<h2 class=\"accordion-header\" id=\"flush-headingOne\">\r\n" + 
				"													<button class=\"accordion-button collapsed\"\r\n" + 
				"														style=\"padding: 0; color: #65676b; background-color: #fcf9f4\"\r\n" + 
				"														type=\"button\" data-bs-toggle=\"collapse\"\r\n" + 
				"														data-bs-target=\"#flush-collapseOne"+item.getId()+"\" aria-expanded=\"false\"\r\n" + 
				"														aria-controls=\"flush-collapseOne"+item.getId()+"\">Phản hồi</button>\r\n" + 
				"												</h2>\r\n" + 
				"											</div>\r\n" + 
				"										</div>"
				+"</div>"
				+"</div>"
				);
		
		response.getWriter().print("<ul style=\" list-style-type:none;\">");
		if (listCmt != null && listCmt.size() > 0) {
			for (Comment cmt : listCmt) {
				if (cmt.getReviewid() == item.getId()) {
		response.getWriter().print("<li class=\"item-cmt\" style=\"margin: 10px 0 10px 60px;\"><img\r\n" + 
				"										class=\"img-avatar img-thumbnail\" alt=\"\"\r\n" + 
				"										src=\""+request.getContextPath()+"/templates/admin/assets/img/a181351bdfea7e975edc2c4a70d06be4.png\">\r\n" + 
				"										<div class=\"comment-text\">\r\n" + 
				"											<p class=\"meta\">\r\n" + 
				"												<strong class=\"woocommerce-review__author\">"+cmt.getName()+"</strong>\r\n" + 
				"												<span class=\"woocommerce-review__dash\"></span>\r\n" + 
				"											</p>\r\n" + 
				"											<div class=\"description\">\r\n" + 
				"												<p>"+cmt.getComment()+"</p>\r\n" + 
				"											</div>\r\n");
		
		if(userLogin!=null){
		if(userLogin.getRole()==1 ||userLogin.getId()==cmt.getUserid()){
			response.getWriter().print("<a href=\"#\" onclick=\"return alert('bạn có chắc muốn xóa'),delCmt("+cmt.getId()+")\" class=\"delete\">Xóa</a>");
	                                    	
 }}
		response.getWriter().print("</div></li>");
		}}}
		response.getWriter().print("	<div id=\"flush-collapseOne"+item.getId()+"\" class=\"accordion-collapse collapse\"\r\n" + 
				"										aria-labelledby=\"flush-headingOne\"\r\n" + 
				"										data-bs-parent=\"#accordionFlushExample\">\r\n" + 
				"										<div class=\"accordion-body\">\r\n" + 
				"											<form id=\"form-cmt"+item.getId()+"\" action=\"#\" method=\"post\">\r\n" + 
				"												<div class=\"mb-3\">\r\n" + 
				"													<label for=\"comment1\" class=\"form-label\">Bình luận</label> <input\r\n" + 
				"														type=\"text\" class=\"form-control\" id=\"comment"+item.getId()+"\"\r\n" + 
				"														aria-describedby=\"comment"+item.getId()+"\" name=\"comment"+item.getId()+"\" value=\"\"\r\n" + 
				"														placeholder=\"Nhập cmt\">\r\n" + 
				"														<input \r\n" + 
				"														type=\"text\" class=\"form-control\" id=\"reviewid"+item.getId()+"\"\r\n" + 
				"														aria-describedby=\"reviewid"+item.getId()+"\" name=\"reviewid+"+item.getId()+"\" value=\""+item.getId()+"\"\r\n" + 
				"														placeholder=\"Nhập cmt\" style=\"display: none;\">\r\n" + 
				"												</div>\r\n" + 
				"												<button type=\"submit\" class=\"btn btn-primary\">Gửi</button>\r\n" + 
				"											</form>\r\n" + 
				"										</div>\r\n" + 
				"									</div>");
		response.getWriter().print("<script type=\"text/javascript\">\r\n" + 
				"$('#form-cmt"+item.getId()+"').validate({	\r\n" + 
				"	rules:{\r\n" + 
				"		\"comment"+item.getId()+"\":{\r\n" + 
				"			required:true,\r\n" + 
				"		},\r\n" + 
				"	},\r\n" + 
				"	messages:{\r\n" + 
				"		\"commen"+item.getId()+"\":{\r\n" + 
				"			required:\"Mời nhập comment\",	\r\n" + 
				"		},\r\n" + 
				"	},	\r\n" + 
				"    submitHandler: function(form) {		        \r\n" + 
				"    	getCmt"+item.getId()+"();\r\n" + 
				"    }\r\n" + 
				"});\r\n" + 
				"</script>\r\n" + 
				"	<script type=\"text/javascript\">\r\n" + 
				"	function getCmt"+item.getId()+"() {\r\n" + 
				"		var comment = $(\"#comment"+item.getId()+"\").val();\r\n" + 
				"		var wid = $(\"#wid\").val();\r\n" + 
				"		var reviewid = $(\"#reviewid"+item.getId()+"\").val();\r\n" + 
				"		$.ajax({\r\n" + 
				"			url: '"+request.getContextPath()+"/detail',		\r\n" + 
				"				type : 'POST',\r\n" + 
				"				cache : false,\r\n" + 
				"				data : {\r\n" + 
				"					acomment : comment,\r\n" + 
				"					awid:wid,\r\n" + 
				"					areviewid:reviewid,\r\n" + 
				"				},\r\n" + 
				"				success : function(data) {\r\n" + 
				"					$(\"#comment-list\").html(data);\r\n" + 
				"				},\r\n" + 
				"				error : function() {\r\n" + 
				"					alert('Mời bạn nhập đầy đủ thông tin');\r\n" + 
				"				}\r\n" + 
				"			});\r\n" + 
				"			return false;\r\n" + 
				"		}\r\n" + 
				"</script>");
		response.getWriter().print("</ul>");
		response.getWriter().print("</li>");			
		}}
		response.getWriter().print("</ul>");
	}

}

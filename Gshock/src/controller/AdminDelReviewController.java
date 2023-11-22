package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReviewDAO;
import util.AuthUtil;


public class AdminDelReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ReviewDAO reviewDAO;   

    public AdminDelReviewController() {
        super();
        reviewDAO = new ReviewDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/review?err=1");
			return;
		}
		if(reviewDAO.dellItem(id)>0) {
			response.sendRedirect(request.getContextPath()+"/admin/review?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/review?err=2");
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

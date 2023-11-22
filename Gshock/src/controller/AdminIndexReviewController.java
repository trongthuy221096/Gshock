package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Review;
import model.dao.ReviewDAO;
import util.AuthUtil;
import util.DefineUtil;
	

public class AdminIndexReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReviewDAO reviewDAO ;
    public AdminIndexReviewController() {
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
		int currentpage=1;
		try {
			currentpage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfReview=0;
		int numberOfPage = 0;
		int offset = 0;
		try {
			 numberOfReview = reviewDAO.numberOfReview();
			 numberOfPage = (int)Math.ceil((float)numberOfReview/DefineUtil.NUMBER_PER_PAGE);	
			if(currentpage < 1 || currentpage > numberOfPage) {
				currentpage=1;
			}
			 offset =(currentpage-1)*DefineUtil.NUMBER_PER_PAGE ;
		} catch (NullPointerException e) {
			response.sendRedirect(request.getContextPath()+"/admin/review");
			return;
		}
		
		ArrayList<Review> listReview = reviewDAO.getPagination(offset);
		request.setAttribute("listReview", listReview);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfReview", numberOfReview);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/review/indexreview.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		String name = request.getParameter("name-search");
		System.out.println(name);
		if("".equals(name)) {
			response.sendRedirect(request.getContextPath()+"/admin/review?err=3");
		}else {
			ArrayList<Review> listReview = reviewDAO.getItemsSearch(name);
			request.setAttribute("listReview", listReview);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/review/indexreview.jsp");
			rd.forward(request, response);
		}
	}

}

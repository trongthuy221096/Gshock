package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;

    public AdminIndexCatController() {
        super();
        catDAO = new CatDAO();
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
		int numberOfCat=0;
		int numberOfPage = 0;
		int offset = 0;
		try {
			 numberOfCat = catDAO.numberOfCat();
			 numberOfPage = (int)Math.ceil((float)numberOfCat/DefineUtil.NUMBER_PER_PAGE);	
			if(currentpage < 1 || currentpage > numberOfPage) {
				currentpage=1;
			}
			 offset =(currentpage-1)*DefineUtil.NUMBER_PER_PAGE ;
		} catch (NullPointerException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cat");
			return;
		}
		
		ArrayList<Category> listCat = catDAO.getPagination(offset);
		request.setAttribute("listCat", listCat);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfCat", numberOfCat);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/indexcat.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.dao.CatDAO;
import util.AuthUtil;


@WebServlet("/AdminSearchCatController")
public class AdminSearchCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CatDAO catDAO;   
    public AdminSearchCatController() {
        super();
        catDAO = new CatDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
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
		if("".equals(name)) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=3");
		}else {
			ArrayList<Category> listCat = catDAO.getItemsSearch(name);
			request.setAttribute("listCat", listCat);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/indexcat.jsp");
			rd.forward(request, response);
		}
	}

}

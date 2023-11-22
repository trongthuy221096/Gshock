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
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.WatchDAO;
import util.AuthUtil;


public class PublicSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     WatchDAO watchDAO = new WatchDAO();  
     CatDAO catDAO = new CatDAO();  
    public PublicSearchController() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		

		String search = request.getParameter("search");
		if("".equals(search)) {
			response.sendRedirect(request.getContextPath()+"/cua-hang");
			return;
		}
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfWatch = watchDAO.getnumberOfWatch(search);
	
		ArrayList<Watch> listWatch = watchDAO.getItemSearch(search);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfWatch", numberOfWatch);				
		request.setAttribute("listWatch", listWatch);
		ArrayList<Category> listCat = catDAO.getItem6();
		request.setAttribute("listCat", listCat);		
		RequestDispatcher rd = request.getRequestDispatcher("/public/sanpham.jsp");
		rd.forward(request, response);
		
	}

}

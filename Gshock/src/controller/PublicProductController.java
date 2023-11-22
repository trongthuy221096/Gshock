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
import util.DefineUtil;


public class PublicProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CatDAO catDAO = new CatDAO();
    WatchDAO watchDAO = new WatchDAO();
    public PublicProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int catid = Integer.parseInt(request.getParameter("catid"));
		int currentpage = 0;
		
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));	
		} catch (NumberFormatException e) {			
		}
		
		int numberOfWatch = watchDAO.getnumberOfWatch(catid);
		int numberOfPage = (int)Math.ceil((float)numberOfWatch/DefineUtil.NUMBER_PER_PAGE8);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE8;
		
		ArrayList<Watch> listWatch = watchDAO.getPagination8(catid,offset);
		
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfWatch", numberOfWatch);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listWatch", listWatch);
		ArrayList<Category> listCat = catDAO.getItem6();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/public/sanpham.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

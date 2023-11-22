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


public class PublicSearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CatDAO catDAO = new CatDAO();
    WatchDAO watchDAO = new WatchDAO();
    ArrayList<Watch> listWatch = new ArrayList<>();
    public PublicSearchProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		int search1 = Integer.parseInt(request.getParameter("search1"));
		

		System.out.println(search1);
		if(search1==1) {		
			 listWatch = watchDAO.getNewItemByDesc();
		}
		if(search1==2) {		
			 listWatch = watchDAO.getItemResultVote();
		}		
		if(search1==3) {		
			 listWatch = watchDAO.getItemBySellAsc();
		}
		if(search1==4) {		
			 listWatch = watchDAO.getItemBySellDesc();
		}
				
		request.setAttribute("listWatch", listWatch);
		ArrayList<Category> listCat = catDAO.getItem6();
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/public/sanpham.jsp");
		rd.forward(request, response);
		
	}

}

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


public class PublicIndexlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CatDAO catDAO = new CatDAO();
    WatchDAO watchDAO = new WatchDAO();
    ArrayList<Watch> listWatch = new ArrayList<>();
    public PublicIndexlController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Watch> listwatchgshock4 = watchDAO.getItems4Gshock();
		request.setAttribute("listwatchgshock4", listwatchgshock4);
		ArrayList<Watch> listwatchgshock2 = watchDAO.getItems2Gshock();
		request.setAttribute("listwatchgshock2", listwatchgshock2);
		ArrayList<Watch> listwatchbabyg4 = watchDAO.getItemsBabyg4();
		request.setAttribute("listwatchbabyg4", listwatchbabyg4);
		ArrayList<Watch> listwatchbabyg2 = watchDAO.listwatchbabyg2();
		request.setAttribute("listwatchbabyg2", listwatchbabyg2);
		ArrayList<Watch> listwatchvintage4 = watchDAO.getItemsVintage4();
		request.setAttribute("listwatchvintage4", listwatchvintage4);
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

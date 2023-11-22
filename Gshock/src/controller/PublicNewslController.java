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


public class PublicNewslController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CatDAO catDAO = new CatDAO();
    WatchDAO watchDAO = new WatchDAO();
    ArrayList<Watch> listWatch = new ArrayList<>();
    public PublicNewslController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/public/tintuc.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}

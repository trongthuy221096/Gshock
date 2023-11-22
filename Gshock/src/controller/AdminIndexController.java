package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.dao.CatDAO;
import model.dao.UserDAO;
import model.dao.WatchDAO;
import util.AuthUtil;
import util.FileUtil;


public class AdminIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDAO catDAO;
	private WatchDAO watchDAO = new WatchDAO();
	private UserDAO userDAO = new UserDAO();
    public AdminIndexController() {
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
		int numberOfCat = catDAO.numberOfCat();
		int numberOfWatch = watchDAO.getnumberOfWatch();
		int numberOfUser = userDAO.getnumberOfUser();
		
		request.setAttribute("numberOfCat", numberOfCat);
		request.setAttribute("numberOfWatch", numberOfWatch);
		request.setAttribute("numberOfUser", numberOfUser);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}

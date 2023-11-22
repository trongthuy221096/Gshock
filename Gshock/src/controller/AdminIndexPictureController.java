package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Picture;
import model.dao.PictureDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexPictureController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PictureDAO pictureDAO;   

    public AdminIndexPictureController() {
        super();
        pictureDAO = new PictureDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfPicture = pictureDAO.getnumberOfPicture();
		int numberOfPage = (int)Math.ceil((float)numberOfPicture/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Picture> listPicture = pictureDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfPicture", numberOfPicture);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listPicture", listPicture);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/indexpicture.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		String search = request.getParameter("search");
		if("".equals(search)) {
			response.sendRedirect(request.getContextPath()+"/admin/picture?err=3");
			return;
		}
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfPicture = pictureDAO.getnumberOfPicture(search);
	
		ArrayList<Picture> listPicture = pictureDAO.getItemSearch(search);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfPicture", numberOfPicture);
		
		
		request.setAttribute("listPicture", listPicture);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/picture/indexpicture.jsp");
		rd.forward(request, response);
		return;
	}

}

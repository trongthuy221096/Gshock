package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.bean.Watch;
import model.dao.WatchDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexWatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private WatchDAO watchDAO;   

    public AdminIndexWatchController() {
        super();
        watchDAO = new WatchDAO();
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
		int numberOfWatch = watchDAO.getnumberOfWatch();
		int numberOfPage = (int)Math.ceil((float)numberOfWatch/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Watch> listWatch = watchDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfWatch", numberOfWatch);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listWatch", listWatch);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/indexwatch.jsp");
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
			response.sendRedirect(request.getContextPath()+"/admin/watch?err=3");
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/watch/indexwatch.jsp");
		rd.forward(request, response);
		return;
	}

}

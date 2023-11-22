package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   

    public AdminIndexUserController() {
        super();
        userDAO = new UserDAO();
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
			currentpage =Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfUser = userDAO.getnumberOfUser();
		int numberOfPage = (int)Math.ceil((float)numberOfUser/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<User> listUser = userDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfUser", numberOfUser);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listUser", listUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/indexuser.jsp");
		rd.forward(request, response);
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
			response.sendRedirect(request.getContextPath()+"/admin/user?err=7");
			return;
		}
		System.out.println(search);
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfUser = userDAO.getnumberOfWatch(search);
	
		ArrayList<User> listUser = userDAO.getItemSearch(search);
		
		request.setAttribute("currentpage", currentpage);				
		request.setAttribute("listUser", listUser);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfUser", numberOfUser);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/indexuser.jsp");
		rd.forward(request, response);
		return;
	}

}

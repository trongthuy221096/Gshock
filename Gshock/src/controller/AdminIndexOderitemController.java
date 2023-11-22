package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.bean.Oderitem;
import model.bean.Watch;
import model.dao.OderitemDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OderitemDAO oderitemDAO;   
    public AdminIndexOderitemController() {
        super();
        oderitemDAO = new OderitemDAO();
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
		int numberOfOderitem = oderitemDAO.getnumberOfOderitem();
		int numberOfPage = (int)Math.ceil((float)numberOfOderitem/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Oderitem> listOderitem = oderitemDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfOderitem", numberOfOderitem);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listOderitem", listOderitem);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/indexoderitem.jsp");
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
			response.sendRedirect(request.getContextPath()+"/admin/oderitem?err=3");
			return;
		}
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt( request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfOderitem = oderitemDAO.getnumberOfOderitem(search);
	
		ArrayList<Oderitem> listOderitem = oderitemDAO.getItemSearch(search);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfOderitem", numberOfOderitem);				
		request.setAttribute("listOderitem", listOderitem);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/indexoderitem.jsp");
		rd.forward(request, response);
		return;
	}

}

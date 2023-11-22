package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.bean.Oder;
import model.bean.Oderitem;
import model.dao.OderDAO;
import model.dao.OderitemDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexOderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OderDAO oderDAO = new OderDAO();   
    public AdminIndexOderController() {
        super();
        
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
		int numberOfOder = oderDAO.getnumberOfOder();
		int numberOfPage = (int)Math.ceil((float)numberOfOder/DefineUtil.NUMBER_PER_PAGE);
		System.out.println(numberOfPage);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Oder> listOder = oderDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfOder", numberOfOder);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listOder", listOder);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/oder/indexoder.jsp");
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
		String name = request.getParameter("name-search");
		if("".equals(name)) {
			response.sendRedirect(request.getContextPath()+"/admin/oder?err=3");
		}else {
			ArrayList<Oder> listOder = oderDAO.getItemsSearch(name);
			request.setAttribute("listOder", listOder);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/oder/indexoder.jsp");
			rd.forward(request, response);
		}
	}

}

package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   
    public AdminIndexContactController() {
        super();
        contactDAO = new ContactDAO();
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
		int numberOfContact = contactDAO.getnumberOfContact();
		int numberOfPage = (int)Math.ceil((float)numberOfContact/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Contact> listContact = contactDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfContact", numberOfContact);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listContact", listContact);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/indexcontact.jsp");
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
			response.sendRedirect(request.getContextPath()+"/admin/contact?err=3");
		}else {
			ArrayList<Contact> listContact = contactDAO.getItemsSearch(name);
			request.setAttribute("listContact", listContact);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/contact/indexcontact.jsp");
			rd.forward(request, response);
		}
	}

}

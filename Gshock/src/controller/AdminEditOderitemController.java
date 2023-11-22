package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.bean.Category;
import model.bean.Oderitem;
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.OderitemDAO;
import model.dao.WatchDAO;
import util.AuthUtil;
import util.FileUtil;


public class AdminEditOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderitemDAO oderitemDAO = new OderitemDAO();
    public AdminEditOderitemController() {
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
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/editoderitem.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	
		Oderitem oderitem = oderitemDAO.getItemByID(id);
		request.setAttribute("oderitem", oderitem);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/editoderitem.jsp");
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
		int id=0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/editoderitem.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		  	String name = request.getParameter("name");
	 	    int quality = Integer.parseInt(request.getParameter("quality"));
	 	    int sell = Integer.parseInt(request.getParameter("sell"));
	 	    int amount = Integer.parseInt(request.getParameter("amount"));
	 	    int wid = Integer.parseInt(request.getParameter("wid"));
	 	    int userid = Integer.parseInt(request.getParameter("userid"));
	 	    int oderid = Integer.parseInt(request.getParameter("oderid"));
		    
		    Oderitem oderitem = new Oderitem(id, name, quality, sell, amount, wid, userid, oderid);
		    if(oderitemDAO.editItem(oderitem)>0) {
		    	RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem");
				rd.forward(request, response);
				return;
		    }else{
		    	RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem/editoderitem.jsp?err=2");
				rd.forward(request, response);
			
		    }
		    RequestDispatcher rd = request.getRequestDispatcher("/admin/oderitem");
			rd.forward(request, response);
			return;
	}

}

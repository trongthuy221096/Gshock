package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Watch;
import model.dao.OderitemDAO;
import model.dao.WatchDAO;
import util.AuthUtil;



public class AdminDelOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OderitemDAO oderitemDAO = new OderitemDAO();   

    public AdminDelOderitemController() {
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
			System.out.println(id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/oderitem?err=1");
			return;
		}

		
		
		if(oderitemDAO.dellItem(id)>0) {			
			response.sendRedirect(request.getContextPath()+"/admin/oderitem?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/oderitem?err=2");
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

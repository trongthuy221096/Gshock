package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;


public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   

    public AdminDelUserController() {
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
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=1");
			return;
		}
		HttpSession session = request.getSession();
		User userLogin = (User)session.getAttribute("userLogin");
		if(userLogin.getRole()==1) {
		if(userDAO.delItem(id)>0) {
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=2");
			return;
		}
		}else {
			// ko dc phep
			response.sendRedirect(request.getContextPath()+"/admin/user?err=6");
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

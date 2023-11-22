package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringUtil;


public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
    public AdminEditUserController() {
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
		HttpSession session = request.getSession();
		User userLogin = (User)session.getAttribute("userLogin");				
		int id = 0;
		try {
			 id =Integer.parseInt(request.getParameter("id")) ;
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=1");
			return;
		}
		if(userLogin.getRole()==1 || id ==userLogin.getId()) {				
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=5");
			return;
		}
		User user = userDAO.getItemById(id);
		request.setAttribute("user", user);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edituser.jsp");
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
		HttpSession session = request.getSession();
		User userLogin = (User)session.getAttribute("userLogin");		
		if(userLogin.getRole()!=1) {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=4");
			return;
		}
		int id = 0;
		try {
			 id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=1");
			return;
		}
		if(userLogin.getRole()==1 || id ==userLogin.getId()) {		
			User user = userDAO.getItemById(id);
			if(user==null) {
				response.sendRedirect(request.getContextPath()+"/admin/user?err=1");
			}
			String password = request.getParameter("password");
			if("".equals(password) || password == null) {
				password = user.getPassword();
			}else {
				password = StringUtil.md5(password);
			}
			String fullname = request.getParameter("fullname");
			String email = request.getParameter("email");		
			int numberphone = Integer.parseInt(request.getParameter("numberphone"));
			int role = Integer.parseInt(request.getParameter("role"));
				user.setPassword(password);
				user.setFullname(fullname);
				user.setEmail(email);
				user.setNumberphone(numberphone);
				user.setRole(role);
			
			if(userDAO.editItem(user) >0) {
				response.sendRedirect(request.getContextPath()+"/admin/user?msg=2");
				return;
			}else {
				RequestDispatcher rd =  request.getRequestDispatcher("/admin/user/edit.jsp?err=1");
				rd.forward(request, response);
				return;
			}
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=5");
			return;
		}
		
	}

}

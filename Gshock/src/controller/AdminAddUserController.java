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
import model.dao.WatchDAO;
import util.AuthUtil;
import util.StringUtil;


public class AdminAddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private WatchDAO watchDAO = new WatchDAO();
    public AdminAddUserController() {
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
		

		if(userLogin.getRole()!=1) {
			response.sendRedirect(request.getContextPath()+"/admin/user?err=4");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/adduser.jsp");
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
		String username ="";
		String password ="";
		String fullname ="";
		String email ="";
		int numberphone =0;
		int role =0;
		
		try {
			username = request.getParameter("username");
			password = request.getParameter("password");
			fullname = request.getParameter("fullname");
			email = request.getParameter("email");
			numberphone = Integer.parseInt(request.getParameter("numberphone"));
			role = Integer.parseInt(request.getParameter("role"));
		} catch (NumberFormatException e) {
			
		} catch (NullPointerException e) {
			
		}
		if(userDAO.hasUsername(username)) {
			RequestDispatcher rd =  request.getRequestDispatcher("/admin/user/adduser.jsp?err=2");
			rd.forward(request, response);
			return;
		}
		password = StringUtil.md5(password);
		User user = new User(0, username, password, fullname, email, numberphone, role);
		if(userDAO.addItem(user) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/user?msg=1");
			return;
		}else {
			RequestDispatcher rd =  request.getRequestDispatcher("/admin/user/adduser.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}

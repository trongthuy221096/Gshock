package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;
import util.AuthUtil;
import util.StringUtil;

public class PublicIndexLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO = new UserDAO();   

    public PublicIndexLoginController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		User userLogin = (User)session.getAttribute("userLogin");
		if(AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if("".equals(username) || "".equals(password) ) {
			response.sendRedirect(request.getContextPath()+"/login?err=1");
		}
		password = StringUtil.md5(password);
		
		User user = userDAO.existUser(username,password);
		
		if(user!=null ) {
			session.setAttribute("userLogin", user);
			response.sendRedirect(request.getContextPath()+"/index");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/login?err=1");
			return;
		}
	
	}

}

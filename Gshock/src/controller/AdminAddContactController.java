package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;
import util.AuthUtil;


public class AdminAddContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ContactDAO contactDAO;
    public AdminAddContactController() {
        super();
        contactDAO = new ContactDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		if(!AuthUtil.checkLogin(request, response)) {
			response.sendRedirect(request.getContextPath()+"/admin/login");
			return;
		}
		String name = "";
		int numberphone = 0;
		String email = "";
		String detailtext ="";
		try {
			name = request.getParameter("name");
			try {
				numberphone = Integer.parseInt(request.getParameter("numberphone"));
			} catch (NumberFormatException e) {				
			}			
			email = request.getParameter("email");
			detailtext = request.getParameter("detailtext");
			if("".equals(name) || numberphone==0 || "".equals(email) || "".equals(detailtext)  ) {
				response.sendRedirect(request.getContextPath()+"/contact?err=1");
				return;
			}else {
				Contact cat = new Contact(0, name, numberphone, email, detailtext);
				if(contactDAO.addItem(cat) > 0) {
					response.sendRedirect(request.getContextPath()+"/contact?msg=1");
					return;
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/contact?err=2");
					rd.forward(request, response);
					return;
				}
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/public/lienhe.jsp?err=1");
			rd.forward(request, response);
			
		}
		
		
	}

}

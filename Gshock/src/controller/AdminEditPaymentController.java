package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Category;
import model.bean.Payment;
import model.dao.CatDAO;
import model.dao.PaymentDAO;
import util.AuthUtil;
import util.StringUtil;


public class AdminEditPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PaymentDAO payDAO;
    public AdminEditPaymentController() {
        super();
        payDAO = new PaymentDAO(); 
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
			 id =Integer.parseInt(request.getParameter("id")) ;
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?err=1");
			return;
		}
		Payment pay = payDAO.getItemById(id);
		request.setAttribute("pay", pay);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/payment/editpayment.jsp");
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
		int id = 0;
		try {
			 id =Integer.parseInt(request.getParameter("id")) ;
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/payment?err=1");
			return;
		}
		Payment item = payDAO.getItemById(id);
		String name = request.getParameter("name");
		int numbercard = Integer.parseInt(request.getParameter("numbercard"));
		String password = request.getParameter("password");
		password = StringUtil.md5(password);
		if("".equals(password)) {
			password = item.getPassword();
		}
		int userid = Integer.parseInt(request.getParameter("userid"));
		
		try {
			if("".equals(name)) {
				response.sendRedirect(request.getContextPath()+"/admin/payment/edit?err=1");
			}else {
				Payment pay = new Payment(id, name, numbercard, password, userid);
				if(payDAO.editItem(pay) > 0) {
					response.sendRedirect(request.getContextPath()+"/admin/payment?msg=2");
					return;
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/admin/payment/editpayment.jsp?err=2");
					rd.forward(request, response);
					return;
				}
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/payment/addpayment.jsp?err=1");
			rd.forward(request, response);
		}			
	}

}

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.PaymentDAO;
import util.AuthUtil;


public class AdminDelPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PaymentDAO payDAO;   

    public AdminDelPaymentController() {
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
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath()+"/admin/payment?err=1");
			return;
		}
		if(payDAO.dellItem(id)>0) {
			response.sendRedirect(request.getContextPath()+"/admin/payment?msg=3");
			return;
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/payment?err=2");
			return;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

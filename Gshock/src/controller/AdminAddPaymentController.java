package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Payment;
import model.bean.User;
import model.dao.PaymentDAO;
import model.dao.UserDAO;
import util.StringUtil;


public class AdminAddPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PaymentDAO payDAO;
    public AdminAddPaymentController() {
        super();
     payDAO = new PaymentDAO();   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/payment/addpayment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String name ="";
		int numbercard =0;
		String password ="";
		int userid = 0;

		
		try {
			name = request.getParameter("name");
			numbercard = Integer.parseInt(request.getParameter("numbercard"));
			password = request.getParameter("password");
			userid = Integer.parseInt(request.getParameter("userid"));
		} catch (NumberFormatException e) {
			
		} catch (NullPointerException e) {
			
		}
		password = StringUtil.md5(password);
		Payment pay = new Payment(0, name, numbercard, password, userid);
		if(payDAO.addItem(pay) > 0) {
			response.sendRedirect(request.getContextPath()+"/admin/payment?msg=1");
			return;
		}else {
			RequestDispatcher rd =  request.getRequestDispatcher("/admin/payment/addpayment.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}

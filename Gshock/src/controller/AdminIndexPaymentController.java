package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Payment;
import model.dao.PaymentDAO;
import util.AuthUtil;
import util.DefineUtil;


public class AdminIndexPaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		PaymentDAO payDAO;

    public AdminIndexPaymentController() {
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
		int currentpage = 0;
		try {
			currentpage =Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {			
		}
		int numberOfPay = payDAO.getnumberOfPay();
		int numberOfPage = (int)Math.ceil((float)numberOfPay/DefineUtil.NUMBER_PER_PAGE);
		if(currentpage <1 || currentpage > numberOfPage) {
			currentpage=1;
		}
		int offset = (currentpage-1)* DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Payment> listPay = payDAO.getPagination(offset);
		request.setAttribute("currentpage", currentpage);
		request.setAttribute("numberOfPay", numberOfPay);
		request.setAttribute("numberOfPage", numberOfPage);
		request.setAttribute("offset", offset);
		request.setAttribute("listPay", listPay);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/payment/indexpayment.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}

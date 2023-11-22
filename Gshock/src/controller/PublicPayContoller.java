package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Contact;
import model.bean.Oderitem;
import model.bean.Payment;
import model.bean.Review;
import model.bean.ShopOder;
import model.bean.User;
import model.dao.OderitemDAO;
import model.dao.PaymentDAO;
import model.dao.ShopOderDAO;
import util.DefineUtil;
import util.StringUtil;


public class PublicPayContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private OderitemDAO oderitemDAO;   
    private ShopOderDAO shopoderDAO = new ShopOderDAO();
    private PaymentDAO payDAO = new PaymentDAO();
    public PublicPayContoller() {
        super();
        oderitemDAO = new OderitemDAO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/public/thanhtoan.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmssddMMyyyy");
		Date date = new Date();
		String code =sdf.format(date);
		String fullname = "a";
		int numberphone = 0;
		String email = "a";
		String adress = "a";
		String coderoder="BA".concat(code);
		int userid=0;
		User userLogin = (User)session.getAttribute("userLogin");
		if(userLogin!=null ) {
			userid = userLogin.getId();
		}
		int payment=0;
		String text="";
		int numbercard=0;
		String password="";
		try {
			fullname = request.getParameter("firstname")+""+request.getParameter("lastname");
			numberphone = Integer.parseInt(request.getParameter("numberphone"));
			email = request.getParameter("email");
			adress = request.getParameter("adress")+","+request.getParameter("ward")+","+request.getParameter("district")+","+request.getParameter("city");
			payment = Integer.parseInt(request.getParameter("payment"));
			if(payment==1) {
				 String name = "Momo";
				 numbercard = Integer.parseInt(request.getParameter("numbercard"));
				 password = request.getParameter("password");
				 password = StringUtil.md5(password);
				 Payment pay = new Payment(0, name, numbercard, password, userid);
				 payDAO.addItem(pay);
			}
			text = request.getParameter("text");
			
		} catch (Exception e) {
			RequestDispatcher rd = request.getRequestDispatcher("/public/thanhtoan.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		ShopOder shopoder = new ShopOder(0, fullname, numberphone, email, adress, coderoder, userid, payment, text) ; 
		ArrayList<Oderitem> listOderitem = (ArrayList<Oderitem>) session.getAttribute("listOderitem");
		if(listOderitem==null||listOderitem.size()==0) {
			RequestDispatcher rd = request.getRequestDispatcher("/public/thanhtoan.jsp?err=1");
			rd.forward(request, response);
			return;
		}
		if(shopoderDAO.additem(shopoder)>0) {
		ShopOder itemshopoder = shopoderDAO.getItemByCode(coderoder);		
		if(itemshopoder!=null) {
			int oderid = itemshopoder.getId();
			
			if(listOderitem!=null && listOderitem.size()>0) {
				for(Oderitem oderitem:listOderitem) {
					Oderitem item = new Oderitem(oderitem.getId(), oderitem.getName(), oderitem.getQualiti(), oderitem.getSell(), oderitem.getAmount(), oderitem.getWid(), oderitem.getUserid(),oderid);
					oderitemDAO.addItem(item);
				}
			}
		}
		 listOderitem = (ArrayList<Oderitem>) session.getAttribute("listOderitem");
		listOderitem.removeAll(listOderitem);
		RequestDispatcher rd = request.getRequestDispatcher("/public/thanhtoan.jsp?msg=1");
		rd.forward(request, response);
		}
		}

}

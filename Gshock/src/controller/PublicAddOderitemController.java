package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bean.Category;

import model.bean.Oderitem;
import model.bean.User;
import model.bean.Watch;
import model.dao.CatDAO;
import model.dao.OderitemDAO;
import model.dao.WatchDAO;
import util.FileUtil;

@MultipartConfig
public class PublicAddOderitemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OderitemDAO oderitemDAO;
	private WatchDAO watchDAO = new WatchDAO();
	private ArrayList<Oderitem> listOderitem = new ArrayList<>(); 
    public PublicAddOderitemController() {
        super();
        oderitemDAO = new OderitemDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		int wid = 0;
		try {
			wid =Integer.parseInt(request.getParameter("wid"));
		} catch (Exception e) {		
		}
		Watch watch = watchDAO.getItemByID(wid);
		
		String name = "";
		int quality =1;
		int sell=0;
		int amount=0;
		int userid=0;	
		User userLogin = (User)session.getAttribute("userLogin");
		if(userLogin!=null ) {
			userid = userLogin.getId();
		}
		if(watch!=null) {
			name = watch.getName();
			sell = watch.getSelloff();
			amount= watch.getSelloff()*quality;
			System.out.println(amount);
		}
		String a = request.getParameter("afullname");
		boolean check = true;
		Oderitem oderitem = new Oderitem(0, name, quality, sell, amount, wid, userid);
	
		if(listOderitem.size()>0) {
			for(Oderitem item:listOderitem) {
				if(item.getWid()==wid) {
					item.setQualiti(item.getQualiti()+quality);
					item.setAmount(item.getQualiti()*watch.getSelloff());
					check = true;
					break;
				}else {
					check = false;
				}
			}
			
		}
		if(check == false || listOderitem.size()==0) {
			listOderitem.add(oderitem);
		}
		session.setAttribute("listOderitem", listOderitem);		
		RequestDispatcher rd = request.getRequestDispatcher("/pay");
		rd.forward(request, response);
		

		
		}


}
